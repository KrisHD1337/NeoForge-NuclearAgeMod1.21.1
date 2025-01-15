package net.kris.nuclearage.block.entities;

import net.kris.nuclearage.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;

public class ReactorCoreBlockEntity extends BlockEntity implements MenuProvider {
    private final EnergyStorage energy;
    private final ItemStackHandler inventory;
    private int uraniumLevel;
    private int wasteLevel;
    private boolean isMultiblockFormed = false;

    public ReactorCoreBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.REACTOR_CORE.get(), pos, state);
        this.energy = new EnergyStorage(100000); // 100k FE storage
        this.inventory = new ItemStackHandler(2); // Slot 0 for uranium, Slot 1 for waste
    }

    public void tick() {
        if (!level.isClientSide && isMultiblockFormed) {
            if (hasUranium() && energy.getEnergyStored() < energy.getMaxEnergyStored()) {
                // Generate energy and waste
                energy.receiveEnergy(100, false); // Generate 100 FE/t
                uraniumLevel--;
                wasteLevel++;

                // Convert uranium to waste periodically
                if (uraniumLevel <= 0) {
                    consumeUranium();
                }

                // Try to output waste when full
                if (wasteLevel >= 1000) {
                    outputWaste();
                }
            }
        }
    }

    private boolean hasUranium() {
        return !inventory.getStackInSlot(0).isEmpty();
    }

    private void consumeUranium() {
        inventory.extractItem(0, 1, false);
        uraniumLevel = 1000; // Each uranium item provides 1000 ticks of power
    }

    private void outputWaste() {
        ItemStack waste = new ItemStack(ModItems.NUCLEAR_WASTE.get());
        if (inventory.insertItem(1, waste, true).isEmpty()) {
            inventory.insertItem(1, waste, false);
            wasteLevel = 0;
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.yourmodid.reactor_core");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ReactorMenu(containerId, inventory, this);
    }

    // Energy capability implementation
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return LazyOptional.of(() -> this.energy).cast();
        }
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return LazyOptional.of(() -> this.inventory).cast();
        }
        return super.getCapability(cap, side);
    }

    // Check multiblock structure
    public boolean checkMultiblock() {
        // Simple 3x3x3 cube check
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos checkPos = worldPosition.offset(x, y, z);
                    Block block = level.getBlockState(checkPos).getBlock();
                    if (x == 0 && y == 0 && z == 0) {
                        if (!(block instanceof ReactorCoreBlock)) {
                            return false;
                        }
                    } else {
                        if (!(block instanceof ReactorCasingBlock)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
