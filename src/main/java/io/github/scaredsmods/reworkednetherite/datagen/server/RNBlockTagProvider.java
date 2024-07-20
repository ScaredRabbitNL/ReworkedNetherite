package io.github.scaredsmods.reworkednetherite.datagen.server;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class RNBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public RNBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {


        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
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
