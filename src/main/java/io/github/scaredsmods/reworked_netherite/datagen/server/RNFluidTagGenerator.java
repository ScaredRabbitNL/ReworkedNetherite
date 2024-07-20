package io.github.scaredsmods.reworked_netherite.datagen.server;


import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.fluid.RNFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RNFluidTagGenerator extends FluidTagsProvider {

    public RNFluidTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, ReworkedNetherite.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(FluidTags.WATER)
                .add(RNFluids.SOURCE_MOLTEN_NETHERITE.get())
                .add(RNFluids.FLOWING_MOLTEN_NETHERITE.get());


    }
}
