package net.kris.nuclearage.datagen;

import net.kris.nuclearage.block.ModBlocks;
import net.kris.nuclearage.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.URANIUM_BLOCK.get());
        dropSelf(ModBlocks.PLUTONIUM_BLOCK.get());
        dropSelf(ModBlocks.NUCLEAR_WASTE_BLOCK.get());
        dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(ModBlocks.RAW_ZIRCONIUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_URANIUM_BLOCK.get());
        dropSelf(ModBlocks.ZIRCONIUM_BLOCK.get());
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.INDIUM_BLOCK.get());
        dropSelf(ModBlocks.GRAPHITE_BLOCK.get());
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.SILVER_INDIUM_CADMIUM_ALLOY_BLOCK.get());


        add(ModBlocks.ZIRCONIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ZIRCONIUM_ORE.get(), ModItems.RAW_ZIRCONIUM.get()));
        add(ModBlocks.CADMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CADMIUM_ORE.get(), ModItems.RAW_CADMIUM.get()));
        add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.INDIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.INDIUM_ORE.get(), ModItems.INDIUM_DUST.get(), 2, 4));
        add(ModBlocks.END_URANIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.END_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get(), 3, 10));
        add(ModBlocks.URANIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.URANIUM_ORE.get(), ModItems.RAW_URANIUM.get()));
        add(ModBlocks.NETHER_URANIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NETHER_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get(), 1, 1));
        add(ModBlocks.DEEPSLATE_URANIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get(), 1, 2));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
