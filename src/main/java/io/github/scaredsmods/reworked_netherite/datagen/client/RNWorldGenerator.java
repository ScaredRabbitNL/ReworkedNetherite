package io.github.scaredsmods.reworked_netherite.datagen.client;


import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.world.feature.RNConfiguredFeatures;
import io.github.scaredsmods.reworked_netherite.world.feature.RNPlacedFeatures;
import io.github.scaredsmods.reworked_netherite.world.gen.RNBiomeModifiers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RNWorldGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, RNConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, RNPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RNBiomeModifiers::bootstrap);


    public RNWorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ReworkedNetherite.MOD_ID));
    }
}
