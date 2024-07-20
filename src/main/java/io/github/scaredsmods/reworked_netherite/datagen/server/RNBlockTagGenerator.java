package io.github.scaredsmods.reworked_netherite.datagen.server;


import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RNBlockTagGenerator extends BlockTagsProvider {

    public RNBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ReworkedNetherite.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {



        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RNBlocks.STONE_NETHERITE_ORE.get())
                .add(RNBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(RNBlocks.NETHERITE_ORE.get())
                .add(RNBlocks.END_STONE_NETHERITE_ORE.get())
                .add(RNBlocks.RAW_NETHERITE_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(RNBlocks.STONE_NETHERITE_ORE.get())
                .add(RNBlocks.DEEPSLATE_NETHERITE_ORE.get())
                .add(RNBlocks.NETHERITE_ORE.get())
                .add(RNBlocks.END_STONE_NETHERITE_ORE.get())
                .add(RNBlocks.RAW_NETHERITE_BLOCK.get());


    }
}
