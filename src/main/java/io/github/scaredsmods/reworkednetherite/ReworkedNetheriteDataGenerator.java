package io.github.scaredsmods.reworkednetherite;

import io.github.scaredsmods.reworkednetherite.datagen.client.RNModelProvider;
import io.github.scaredsmods.reworkednetherite.datagen.client.RNWorldGenProvider;
import io.github.scaredsmods.reworkednetherite.datagen.server.RNBlockTagProvider;
import io.github.scaredsmods.reworkednetherite.datagen.server.RNFluidTagProvider;
import io.github.scaredsmods.reworkednetherite.datagen.server.RNLootTableProvider;
import io.github.scaredsmods.reworkednetherite.datagen.server.recipe.RNRecipeGenerator;
import io.github.scaredsmods.reworkednetherite.world.feature.RNConfiguredFeatures;
import io.github.scaredsmods.reworkednetherite.world.feature.RNPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ReworkedNetheriteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		//Client
		pack.addProvider(RNModelProvider::new);
		pack.addProvider(RNWorldGenProvider::new);



		//Server
		pack.addProvider(RNBlockTagProvider::new);
		pack.addProvider(RNLootTableProvider::new);
		pack.addProvider(RNFluidTagProvider::new);
		pack.addProvider(RNRecipeGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, RNConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, RNPlacedFeatures::bootstrap);
	}
}
