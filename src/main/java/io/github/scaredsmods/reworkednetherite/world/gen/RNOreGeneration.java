package io.github.scaredsmods.reworkednetherite.world.gen;

import io.github.scaredsmods.reworkednetherite.world.feature.RNPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RNOreGeneration {


    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, RNPlacedFeatures.OVERWORLD_NETHERITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES, RNPlacedFeatures.NETHERITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES, RNPlacedFeatures.END_NETHERITE_ORE_PLACED_KEY);
    }

}
