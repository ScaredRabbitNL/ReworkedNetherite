package io.github.scaredsmods.reworkednetherite.world.feature;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class RNConfiguredFeatures {


;

    public static final RegistryKey<ConfiguredFeature<?,?>> NETHERITE_ORE_KEY = registerKey("netherite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_NETHERITE_ORE_KEY = registerKey("end_stone_netherite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> OVERWORLD_NETHERITE_ORE_KEY = registerKey("overworld_netherite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {



        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldNetheriteOres = List.of(OreFeatureConfig.createTarget(stoneReplaceable,
                        RNBlocks.STONE_NETHERITE_ORE.get().getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, RNBlocks.DEEPSLATE_NETHERITE_ORE.get().getDefaultState()));


        register(context, OVERWORLD_NETHERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldNetheriteOres, 10));
        register(context, NETHERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherrackReplacables,
                RNBlocks.NETHERITE_ORE.get().getDefaultState(), 12));
        register(context, END_NETHERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endReplaceables,
                RNBlocks.END_STONE_NETHERITE_ORE.get().getDefaultState(), 10));



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ReworkedNetherite.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
