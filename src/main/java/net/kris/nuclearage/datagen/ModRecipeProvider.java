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
                ModBlocks.END_URANIUM_ORE);

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK)
                .unlockedBy("has_uranium_block", has(ModBlocks.URANIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLUTONIUM_INGOT.get(), 9)
                .requires(ModBlocks.PLUTONIUM_BLOCK)
                .unlockedBy("has_uranium_block", has(ModBlocks.PLUTONIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 200, "uranium");
        oreBlasting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 100, "uranium");

    }
}
