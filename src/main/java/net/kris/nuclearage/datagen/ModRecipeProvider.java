package net.kris.nuclearage.datagen;

import net.kris.nuclearage.block.ModBlocks;
import net.kris.nuclearage.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> URANIUM_SMELTABLES = List.of(ModItems.RAW_URANIUM,
                ModBlocks.END_URANIUM_ORE, ModBlocks.NETHER_URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE, ModBlocks.URANIUM_ORE);

        List<ItemLike> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER,
                ModBlocks.SILVER_ORE);

        List<ItemLike> CADMIUM_SMELTABLES = List.of(ModItems.RAW_CADMIUM,
                ModBlocks.CADMIUM_ORE);

        List<ItemLike> ZIRCONIUM_SMELTABLES = List.of(ModItems.RAW_ZIRCONIUM,
                ModBlocks.ZIRCONIUM_ORE);
        List<ItemLike> INDIUM_SMELTABLES = List.of(
                ModBlocks.INDIUM_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.URANIUM_INGOT.get())
                .unlockedBy("has_uranium", has(ModItems.URANIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLUTONIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.PLUTONIUM_INGOT.get())
                .unlockedBy("has_plutonium", has(ModItems.PLUTONIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NUCLEAR_WASTE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.NUCLEAR_WASTE.get())
                .unlockedBy("has_nuclear_waste", has(ModItems.NUCLEAR_WASTE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ZIRCONIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_ZIRCONIUM.get())
                .unlockedBy("has_raw_zirconium", has(ModItems.RAW_ZIRCONIUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_SILVER.get())
                .unlockedBy("has_raw_silver", has(ModItems.RAW_SILVER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_URANIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_URANIUM.get())
                .unlockedBy("has_raw_uranium", has(ModItems.RAW_URANIUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZIRCONIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ZIRCONIUM_INGOT.get())
                .unlockedBy("has_zirconium_ingot", has(ModItems.ZIRCONIUM_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INDIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.INDIUM_DUST.get())
                .unlockedBy("has_indium_dust", has(ModItems.INDIUM_DUST)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_DIAMOND_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_DIAMOND.get())
                .unlockedBy("has_black_diamond", has(ModItems.BLACK_DIAMOND)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAPHITE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.GRAPHITE.get())
                .unlockedBy("has_graphite", has(ModItems.GRAPHITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK)
                .unlockedBy("has_uranium_block", has(ModBlocks.URANIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_DIAMOND.get(), 9)
                .requires(ModBlocks.BLACK_DIAMOND_BLOCK)
                .unlockedBy("has_black_diamond_block", has(ModBlocks.BLACK_DIAMOND_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK)
                .unlockedBy("has_silver_block", has(ModBlocks.SILVER_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZIRCONIUM_INGOT.get(), 9)
                .requires(ModBlocks.ZIRCONIUM_BLOCK)
                .unlockedBy("has_zirconium_block", has(ModBlocks.ZIRCONIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INDIUM_DUST.get(), 9)
                .requires(ModBlocks.INDIUM_BLOCK)
                .unlockedBy("has_indium_block", has(ModBlocks.INDIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), 9)
                .requires(ModBlocks.RAW_SILVER_BLOCK)
                .unlockedBy("has_raw_silver_block", has(ModBlocks.RAW_SILVER_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ZIRCONIUM.get(), 9)
                .requires(ModBlocks.RAW_ZIRCONIUM_BLOCK)
                .unlockedBy("has_raw_zirconium_block", has(ModBlocks.RAW_ZIRCONIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_URANIUM.get(), 9)
                .requires(ModBlocks.RAW_URANIUM_BLOCK)
                .unlockedBy("has_raw_uranium_block", has(ModBlocks.RAW_URANIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLUTONIUM_INGOT.get(), 9)
                .requires(ModBlocks.PLUTONIUM_BLOCK)
                .unlockedBy("has_plutonium_block", has(ModBlocks.PLUTONIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NUCLEAR_WASTE.get(), 9)
                .requires(ModBlocks.NUCLEAR_WASTE_BLOCK)
                .unlockedBy("has_nuclear_waste", has(ModBlocks.NUCLEAR_WASTE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRAPHITE.get(), 9)
                .requires(ModBlocks.GRAPHITE_BLOCK)
                .unlockedBy("has_graphite_block", has(ModBlocks.GRAPHITE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 200, "uranium");
        oreBlasting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 100, "uranium");
        oreSmelting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 200, "silver");
        oreBlasting(recipeOutput, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 100, "silver");
        oreSmelting(recipeOutput, CADMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CADMIUM.get(), 0.25f, 200, "cadmium");
        oreBlasting(recipeOutput, CADMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CADMIUM.get(), 0.25f, 100, "cadmium");
        oreSmelting(recipeOutput, ZIRCONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZIRCONIUM_INGOT.get(), 0.25f, 200, "zirconium");
        oreBlasting(recipeOutput, ZIRCONIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZIRCONIUM_INGOT.get(), 0.25f, 100, "zirconium");
        oreSmelting(recipeOutput, INDIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INDIUM_DUST.get(), 0.25f, 200, "indium");
        oreBlasting(recipeOutput, INDIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INDIUM_DUST.get(), 0.25f, 100, "indium");


    }
}
