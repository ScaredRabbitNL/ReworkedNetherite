package io.github.scaredsmods.reworkednetherite.datagen.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;


public class RNModelProvider extends FabricModelProvider {

    public RNModelProvider(FabricDataOutput output) {
        super(output);

    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        RNBlocks.BLOCKS.stream().map(RegistryEntry::get).forEach(blockStateModelGenerator::registerSimpleCubeAll);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        RNItems.BASIC_ITEM.stream().map(RegistryEntry::get).forEach(item -> itemModelGenerator.register(item, Models.GENERATED));
        RNItems.BUCKETS.stream().map(RegistryEntry::get).forEach(item -> itemModelGenerator.register(item, Models.GENERATED));

    }


}
