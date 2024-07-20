package io.github.scaredsmods.reworkednetherite.datagen.server;

import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;

import java.util.concurrent.CompletableFuture;

public class RNFluidTagProvider extends FabricTagProvider.FluidTagProvider {


    public RNFluidTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {


        this.getOrCreateTagBuilder(FluidTags.WATER)
                .add(RNLiquids.SOURCE_MOLTEN_NETHERITE.get())
                .add(RNLiquids.FLOWING_NETHERITE.get());


    }

}
