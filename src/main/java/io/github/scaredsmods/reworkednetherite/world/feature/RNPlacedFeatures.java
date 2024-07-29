package io.github.scaredsmods.reworkednetherite.world.feature;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;


import java.util.List;

import static io.github.scaredsmods.reworkednetherite.world.feature.RNOrePlacement.modifiersWithCount;

public class RNPlacedFeatures {



    public static final RegistryKey<PlacedFeature> OVERWORLD_NETHERITE_ORE_PLACED_KEY = registerKey("overworld_netherite_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHERITE_ORE_PLACED_KEY = registerKey("netherite_ore_placed");
    public static final RegistryKey<PlacedFeature> END_NETHERITE_ORE_PLACED_KEY = registerKey("end_netherite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);



        register(context, OVERWORLD_NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(RNConfiguredFeatures.OVERWORLD_NETHERITE_ORE_KEY),
                modifiersWithCount(12, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(80))));

        register(context, NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(RNConfiguredFeatures.NETHERITE_ORE_KEY),
                    modifiersWithCount(12, // VeinsPerChunk
                            HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(16))));

        register(context, END_NETHERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(RNConfiguredFeatures.END_NETHERITE_ORE_KEY),
                    modifiersWithCount(10, // VeinsPerChunk
                            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(80))));





        /*
        register(context, OVERWORLD_NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.OVERWORLD_NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NETHERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(RNConfiguredFeatures.END_NETHERITE_ORE_KEY),
                RNOrePlacement.commonOrePlacement(10, // Veins Per Chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

         */
    }



    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ReworkedNetherite.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
