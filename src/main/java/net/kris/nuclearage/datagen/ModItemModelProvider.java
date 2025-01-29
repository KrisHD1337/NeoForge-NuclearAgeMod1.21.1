package net.kris.nuclearage.datagen;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NuclearAge.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.URANIUM_INGOT.get());
        basicItem(ModItems.RAW_URANIUM.get());
        basicItem(ModItems.PLUTONIUM_INGOT.get());
        basicItem(ModItems.RAW_CADMIUM.get());
        basicItem(ModItems.RAW_ZIRCONIUM.get());
        basicItem(ModItems.RAW_SILVER.get());
        basicItem(ModItems.INDIUM_DUST.get());
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.ZIRCONIUM_INGOT.get());
        basicItem(ModItems.CADMIUM.get());
        basicItem(ModItems.NUCLEAR_WASTE.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.GRAPHITE.get());
    }
}
