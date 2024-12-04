package net.kris.nuclearage.util;

import net.kris.nuclearage.NuclearAge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> commonTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }

        public static final TagKey<Block> URANIUM = commonTag("storage_blocks/uranium");
        public static final TagKey<Block> ZIRCONIUM = commonTag("storage_blocks/zirconium");
        public static final TagKey<Block> INDIUM = commonTag("storage_blocks/indium");
        public static final TagKey<Block> SILVER = commonTag("storage_blocks/silver");
        public static final TagKey<Block> PLUTONIUM = commonTag("storage_blocks/plutonium");
        public static final TagKey<Block> RAW_URANIUM = commonTag("storage_blocks/raw_uranium");
        public static final TagKey<Block> RAW_ZIRCONIUM = commonTag("storage_blocks/raw_zirconium");
        public static final TagKey<Block> RAW_SILVER = commonTag("storage_blocks/raw_silver");
        public static final TagKey<Block> URANIUM_ORE = commonTag("ores/uranium");
        public static final TagKey<Block> ZIRCONIUM_ORE = commonTag("ores/zirconium");
        public static final TagKey<Block> INDIUM_ORE = commonTag("ores/indium");
        public static final TagKey<Block> SILVER_ORE = commonTag("ores/silver");
        public static final TagKey<Block> CADMIUM_ORE = commonTag("ores/cadmium");
    }

    public static class Items {
        private static TagKey<Item> commonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
        public static final TagKey<Item> URANIUM = commonTag("ingots/uranium");
        public static final TagKey<Item> ZIRCONIUM = commonTag("ingots/zirconium");
        public static final TagKey<Item> INDIUM = commonTag("ingots/indium");
        public static final TagKey<Item> CADMIUM = commonTag("ingots/cadmium");
        public static final TagKey<Item> SILVER = commonTag("ingots/silver");
        public static final TagKey<Item> PLUTONIUM = commonTag("ingots/plutonium");

        public static final TagKey<Item> RAW_URANIUM = commonTag("raw_materials/uranium");
        public static final TagKey<Item> RAW_ZIRCONIUM = commonTag("raw_materials/zirconium");
        public static final TagKey<Item> RAW_CADMIUM = commonTag("raw_materials/cadmium");
        public static final TagKey<Item> RAW_SILVER = commonTag("raw_materials/silver");
        }

}
