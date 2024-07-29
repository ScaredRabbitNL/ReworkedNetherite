package io.github.scaredsmods.reworkednetherite.datagen.server;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;


import java.util.concurrent.CompletableFuture;

public class RNBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public RNBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }




    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(RNBlocks.RAW_NETHERITE_BLOCK.get())
                .add(RNBlocks.STONE_NETHERITE_ORE.get())
                .add(RNBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(RNBlocks.NETHERITE_ORE.get())
                .add(RNBlocks.END_STONE_NETHERITE_ORE.get());



        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(RNBlocks.RAW_NETHERITE_BLOCK.get())
                .add(RNBlocks.STONE_NETHERITE_ORE.get())
                .add(RNBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(RNBlocks.NETHERITE_ORE.get())
                .add(RNBlocks.END_STONE_NETHERITE_ORE.get());



    }



}
