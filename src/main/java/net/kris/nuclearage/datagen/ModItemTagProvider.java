package net.kris.nuclearage.datagen;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.item.ModItems;
import net.kris.nuclearage.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, NuclearAge.MODID, existingFileHelper);
    }

    // Add your tag entries here.
    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        this.tag(Tags.Items.INGOTS)
                .add(ModItems.URANIUM_INGOT.get())
                .add(ModItems.SILVER_INGOT.get())
                .add(ModItems.ZIRCONIUM_INGOT.get())
                .add(ModItems.PLUTONIUM_INGOT.get());

        this.tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_URANIUM.get())
                .add(ModItems.RAW_CADMIUM.get())
                .add(ModItems.RAW_ZIRCONIUM.get())
                .add(ModItems.RAW_SILVER.get());

        this.tag(ModTags.Items.URANIUM)
                .add(ModItems.URANIUM_INGOT.get());
        this.tag(ModTags.Items.ZIRCONIUM)
                .add(ModItems.ZIRCONIUM_INGOT.get());
        this.tag(ModTags.Items.INDIUM)
                .add(ModItems.INDIUM_DUST.get());
        this.tag(ModTags.Items.CADMIUM)
                .add(ModItems.CADMIUM.get());
        this.tag(ModTags.Items.SILVER)
                .add(ModItems.SILVER_INGOT.get());
        this.tag(ModTags.Items.PLUTONIUM)
                .add(ModItems.PLUTONIUM_INGOT.get());
        this.tag(ModTags.Items.RAW_URANIUM)
                .add(ModItems.RAW_URANIUM.get());
        this.tag(ModTags.Items.RAW_ZIRCONIUM)
                .add(ModItems.RAW_ZIRCONIUM.get());
        this.tag(ModTags.Items.RAW_SILVER)
                .add(ModItems.RAW_SILVER.get());
        this.tag(ModTags.Items.RAW_CADMIUM)
                .add(ModItems.RAW_CADMIUM.get());
    }
}
