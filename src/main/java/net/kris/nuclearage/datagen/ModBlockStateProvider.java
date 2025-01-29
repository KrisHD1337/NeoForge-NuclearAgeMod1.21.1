package net.kris.nuclearage.datagen;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NuclearAge.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.URANIUM_BLOCK);
        blockWithItem(ModBlocks.END_URANIUM_ORE);
        blockWithItem(ModBlocks.NETHER_URANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.PLUTONIUM_BLOCK);
        blockWithItem(ModBlocks.NUCLEAR_WASTE_BLOCK);
        blockWithItem(ModBlocks.ZIRCONIUM_BLOCK);
        blockWithItem(ModBlocks.ZIRCONIUM_ORE);
        blockWithItem(ModBlocks.RAW_ZIRCONIUM_BLOCK);
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
        blockWithItem(ModBlocks.INDIUM_BLOCK);
        blockWithItem(ModBlocks.INDIUM_ORE);
        blockWithItem(ModBlocks.CADMIUM_ORE);
        blockWithItem(ModBlocks.RAW_URANIUM_BLOCK);
        blockWithItem(ModBlocks.GRAPHITE_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.SILVER_INDIUM_CADMIUM_ALLOY_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
