package io.github.scaredsmods.reworkednetherite.client;

import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public final class ReworkedNetheriteClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        RNFabricPredicateProvider.registerModModels();

        FluidRenderHandlerRegistry.INSTANCE.register(RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), RNLiquids.FLOWING_NETHERITE.get(),
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0x3f3138
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(),
                RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), RNLiquids.FLOWING_NETHERITE.get());
    }
}
