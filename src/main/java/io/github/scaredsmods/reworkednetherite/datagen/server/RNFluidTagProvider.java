package io.github.scaredsmods.reworkednetherite.datagen.server;

import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class RNFluidTagProvider extends FabricTagProvider.FluidTagProvider {


    public RNFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        this.getOrCreateTagBuilder(FluidTags.WATER)
                .add(RNLiquids.SOURCE_MOLTEN_NETHERITE.get())
                .add(RNLiquids.FLOWING_NETHERITE.get());
    }
}
