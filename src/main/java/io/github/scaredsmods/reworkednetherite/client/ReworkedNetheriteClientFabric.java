package io.github.scaredsmods.reworkednetherite.client;

import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public final class ReworkedNetheriteClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        RNFabricPredicateProvider.registerModModels();

        FluidRenderHandlerRegistry.INSTANCE.register(RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), RNLiquids.FLOWING_NETHERITE.get(),
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0x3f3138
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), RNLiquids.FLOWING_NETHERITE.get());
    }
}
