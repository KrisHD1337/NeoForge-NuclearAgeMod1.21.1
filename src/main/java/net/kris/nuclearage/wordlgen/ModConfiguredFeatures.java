package net.kris.nuclearage.wordlgen;

import net.kris.nuclearage.NuclearAge;
import net.kris.nuclearage.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_URANIUM_ORE_KEY = registerKey("uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_URANIUM_ORE_KEY = registerKey("nether_uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_URANIUM_ORE_KEY = registerKey("end_uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIUM_ORE_KEY = registerKey("indium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CADMIUM_ORE_KEY = registerKey("cadmium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCONIUM_ORE_KEY = registerKey("zirconium_ore");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldUraniumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.URANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUraniumOres, 9));
        register(context, NETHER_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_URANIUM_ORE.get().defaultBlockState(), 9));
        register(context, END_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.END_URANIUM_ORE.get().defaultBlockState(), 9));
        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.SILVER_ORE.get().defaultBlockState(), 9));
        register(context, INDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.INDIUM_ORE.get().defaultBlockState(), 9));
        register(context, CADMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.CADMIUM_ORE.get().defaultBlockState(), 9));
        register(context, ZIRCONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.ZIRCONIUM_ORE.get().defaultBlockState(), 9));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NuclearAge.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
