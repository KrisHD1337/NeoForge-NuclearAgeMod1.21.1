package net.kris.nuclearage.multiblock;

import net.kris.nuclearage.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class RBMKReactorMultiblock {
    private RBMKReactorInventory reactorInventory;

    private static final Block[][][] STRUCTURE = {
        {
            {Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.AIR, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.DIAMOND_BLOCK, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.AIR, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE}
        },
        {
            {Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.AIR, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.DIAMOND_BLOCK, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.AIR, Blocks.AIR, Blocks.AIR, Blocks.STONE},
            {Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE}
        }
    };

    private static final Block START_BLOCK = Blocks.STONE;
    private static final int MAX_ENERGY = 100000000;  // Example max capacity
    private static final int MAX_INPUT = 10000000;    // Example max input per tick
    private static final int MAX_OUTPUT = 10000000;   // Example max output per tick
    private EnergyStorage energyStorage;

    private int uraniumConsumed = 0;  // Track the number of uranium ingots consumed

    public RBMKReactorMultiblock() {
        this.energyStorage = new EnergyStorage(MAX_ENERGY, MAX_INPUT, MAX_OUTPUT);
        this.reactorInventory = new RBMKReactorInventory();
    }

    public static BlockPos findOrigin(ServerLevel level, BlockPos clickedPos) {
        for (int y = -4; y <= 0; y++) {
            for (int x = -4; x <= 0; x++) {
                for (int z = -4; z <= 0; z++) {
                    BlockPos potentialOrigin = clickedPos.offset(x, y, z);
                    if (isValidOrigin(level, potentialOrigin)) {
                        return potentialOrigin;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isValidOrigin(ServerLevel level, BlockPos pos) {
        return level.getBlockState(pos).getBlock() == START_BLOCK;
    }

    public static boolean validateStructure(Level level, BlockPos origin) {
        for (int y = 0; y < STRUCTURE.length; y++) {
            for (int x = 0; x < STRUCTURE[y].length; x++) {
                for (int z = 0; z < STRUCTURE[y][x].length; z++) {
                    Block expectedBlock = STRUCTURE[y][x][z];
                    if (expectedBlock != Blocks.AIR) {
                        BlockPos checkPos = origin.offset(x, y, z);
                        BlockState actualState = level.getBlockState(checkPos);
                        if (actualState.getBlock() != expectedBlock) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public IEnergyStorage getEnergyStorage() {
        return this.energyStorage;
    }

    public void generateEnergyFromUranium(Level level, BlockPos reactorPos) {
        // Check if there's uranium in the inventory
        ItemStack uranium = reactorInventory.getItemHandler().getStackInSlot(0);
        if (!uranium.isEmpty()) {
            // Consume uranium and generate energy
            reactorInventory.generateEnergy();  // Consume 1 uranium ingot and generate energy
            reactorInventory.outputNuclearWaste();  // Output nuclear waste every 10 ingots
        }
    }

    // Method to simulate generating energy (e.g., from uranium or another fuel)
    public void generateEnergy(int amount) {
        if (amount <= MAX_ENERGY - energyStorage.getEnergyStored()) {
            energyStorage.receiveEnergy(amount, false);  // Add energy to storage
        }
    }

    public ItemStack getUraniumInReactor(Level level, BlockPos reactorPos) {
        // Simulating checking for uranium ingot near the reactor (could be in a chest, inventory, etc.)
        // In this example, we assume a uranium ingot is present at the given position
        return new ItemStack(ModItems.URANIUM_INGOT.get());  // Placeholder for actual uranium ingot check
    }

    // Method to output nuclear waste every 10 uranium ingots consumed
    public void outputNuclearWaste(Level level, BlockPos reactorPos) {
    // For simplicity, we place the nuclear waste item directly in the world
    BlockPos wastePos = reactorPos.offset(0, 1, 0);  // Just above the reactor position

    // Create an ItemEntity to represent the nuclear waste in the world
    ItemStack wasteStack = new ItemStack(ModItems.NUCLEAR_WASTE.get(), 1);  // Create a stack of nuclear waste
    ItemEntity itemEntity = new ItemEntity(level, wastePos.getX(), wastePos.getY(), wastePos.getZ(), wasteStack);

    // Add the ItemEntity to the world
    level.addFreshEntity(itemEntity);
}


    // Method to use energy (e.g., for powering machines or systems)
    public void useEnergy(int amount) {
        if (energyStorage.extractEnergy(amount, false) > 0) {
            // Energy used successfully
        } else {
            // Not enough energy
        }
    }
}
