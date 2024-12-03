package net.kris.nuclearage.datagen;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NuclearAge.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.END_URANIUM_ORE.get())
                .add(ModBlocks.NETHER_URANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_URANIUM_ORE.get())
                .add(ModBlocks.URANIUM_ORE.get())
                .add(ModBlocks.PLUTONIUM_BLOCK.get())
                .add(ModBlocks.NUCLEAR_WASTE_BLOCK.get())
                .add(ModBlocks.RAW_URANIUM_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.RAW_ZIRCONIUM_BLOCK.get())
                .add(ModBlocks.ZIRCONIUM_ORE.get())
                .add(ModBlocks.ZIRCONIUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.INDIUM_BLOCK.get())
                .add(ModBlocks.INDIUM_ORE.get())
                .add(ModBlocks.CADMIUM_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.NETHER_URANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_URANIUM_ORE.get())
                .add(ModBlocks.URANIUM_ORE.get())
                .add(ModBlocks.RAW_URANIUM_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.RAW_ZIRCONIUM_BLOCK.get())
                .add(ModBlocks.ZIRCONIUM_ORE.get())
                .add(ModBlocks.ZIRCONIUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.INDIUM_BLOCK.get())
                .add(ModBlocks.INDIUM_ORE.get())
                .add(ModBlocks.NUCLEAR_WASTE_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_URANIUM_ORE.get())
                .add(ModBlocks.PLUTONIUM_BLOCK.get())
                .add(ModBlocks.CADMIUM_ORE.get());
    }
}
