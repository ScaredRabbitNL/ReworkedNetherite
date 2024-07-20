package io.github.scaredsmods.reworkednetherite.datagen.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class RNModelProvider extends FabricModelProvider {

    public RNModelProvider(FabricDataOutput output) {
        super(output);

    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        RNBlocks.BLOCKS.stream().map(RegistryEntry::get).forEach(blockStateModelGenerator::createTrivialCube);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

        RNItems.BASIC_ITEM.stream().map(RegistryEntry::get).forEach(item -> itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
        RNItems.BUCKETS.stream().map(RegistryEntry::get).forEach(item -> itemModelGenerator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));



    }



}
