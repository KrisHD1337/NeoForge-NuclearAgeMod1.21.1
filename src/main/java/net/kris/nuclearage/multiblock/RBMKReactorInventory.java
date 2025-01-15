package net.kris.nuclearage.multiblock;

import net.kris.nuclearage.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;


public class RBMKReactorInventory implements IItemHandler {

    private final ItemStackHandler itemHandler;
    private final EnergyStorage energyStorage;

    // Create a custom inventory with 2 slots: one for uranium and one for nuclear waste
    public RBMKReactorInventory() {
        this.itemHandler = new ItemStackHandler(2); // 2 slots
        this.energyStorage = new EnergyStorage(100000000, 10000000, 10000000);  // Max energy, max input/output
    }

    // Method to get the item handler (for accessing slots)
    public IItemHandler getItemHandler() {
        return itemHandler;
    }

    // Add uranium ingot to the reactor's inventory
    public void addUranium(ItemStack uranium) {
        if (uranium.getItem() == ModItems.URANIUM_INGOT.get()) {
            this.itemHandler.insertItem(0, uranium, false);  // Slot 0 for uranium
        }
    }

    // Add nuclear waste to the reactor's output slot
    public void addNuclearWaste(ItemStack nuclearWaste) {
        if (nuclearWaste.getItem() == ModItems.NUCLEAR_WASTE.get()) {
            this.itemHandler.insertItem(1, nuclearWaste, false);  // Slot 1 for nuclear waste
        }
    }

    // Simulate the reactor consuming uranium to generate energy
    public void generateEnergy() {
        ItemStack uranium = this.itemHandler.getStackInSlot(0);  // Get the uranium from slot 0
        if (!uranium.isEmpty() && uranium.getItem() == ModItems.URANIUM_INGOT.get()) {
            uranium.shrink(1);  // Consume 1 uranium ingot
            this.itemHandler.setStackInSlot(0, uranium);  // Update slot with reduced uranium count
            energyStorage.receiveEnergy(1000000, false);  // Generate 1 million FE from one uranium ingot
        }
    }

    // Simulate the reactor outputting nuclear waste after consuming uranium
    public void outputNuclearWaste() {
        // Output 1 nuclear waste item every 10 uranium ingots consumed
        if (this.itemHandler.getStackInSlot(0).getCount() % 10 == 0) {  // Every 10 ingots
            this.addNuclearWaste(new ItemStack(ModItems.NUCLEAR_WASTE.get(), 1));
        }
    }

    // Get the energy storage object
    public IEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    // Extract energy from the reactor's storage
    public int extractEnergy(int amount) {
        return energyStorage.extractEnergy(amount, false);
    }

    // Implementing IItemHandler methods
    @Override
    public int getSlots() {
        return 2;  // We have 2 slots: 1 for uranium, 1 for nuclear waste
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        return itemHandler.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return itemHandler.extractItem(slot, amount, simulate);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        // Only uranium can go into slot 0, only nuclear waste in slot 1
        if (slot == 0) {
            return stack.getItem() == ModItems.URANIUM_INGOT.get();
        } else if (slot == 1) {
            return stack.getItem() == ModItems.NUCLEAR_WASTE.get();
        }
        return false;
    }

    @Override
    public int getSlotLimit(int slot) {
        // You can set different limits for each slot. We'll set a default limit of 64 for both slots.
        return 64;  // Default stack size limit (64) for both uranium and nuclear waste
    }
}
