package io.github.scaredsmods.reworkednetherite.world.feature;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class RNPlacedFeatures {



    public static final ResourceKey<PlacedFeature> OVERWORLD_NETHERITE_ORE_PLACED_KEY = registerKey("overworld_netherite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHERITE_ORE_PLACED_KEY = registerKey("netherite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NETHERITE_ORE_PLACED_KEY = registerKey("end_netherite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        /*
        register(context, OVERWORLD_NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SNConfiguredFeatures.OVERWORLD_NETHERITE_ORE_KEY),
                modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

        register(context, NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SNConfiguredFeatures.NETHERITE_ORE_KEY),
                    modifiersWithCount(8, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(8), VerticalAnchor.aboveBottom(16))));

        register(context, END_NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SNConfiguredFeatures.END_NETHERITE_ORE_KEY),
                    modifiersWithCount(9, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

         */



        register(context, OVERWORLD_NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.OVERWORLD_NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.END_NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(10, // Veins Per Chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ReworkedNetherite.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilter.onAverageOnceEvery(chance), heightModifier);
    }
}
