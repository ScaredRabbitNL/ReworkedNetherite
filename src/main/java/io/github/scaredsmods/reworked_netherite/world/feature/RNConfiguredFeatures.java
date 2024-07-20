package io.github.scaredsmods.reworked_netherite.world.feature;


import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
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

public class RNConfiguredFeatures {


;

    public static final ResourceKey<ConfiguredFeature<?,?>> NETHERITE_ORE_KEY = registerKey("netherite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_NETHERITE_ORE_KEY = registerKey("end_stone_netherite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_NETHERITE_ORE_KEY = registerKey("overworld_netherite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {



        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        RNBlocks.STONE_NETHERITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, RNBlocks.DEEPSLATE_NETHERITE_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_NETHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, 10));
        register(context, NETHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                RNBlocks.NETHERITE_ORE.get().defaultBlockState(), 12));
        register(context, END_NETHERITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                RNBlocks.END_STONE_NETHERITE_ORE.get().defaultBlockState(), 10));



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ReworkedNetherite.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
