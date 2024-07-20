package io.github.scaredsmods.reworkednetherite.client;

import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;

public class RNFabricPredicateProvider {

    public static void registerModModels() {
        registerBow(RNItems.NETHERITE_BOW.get());
    }



    private static void registerBow(Item bow) {
        FabricModelPredicateProviderRegistry.register(bow, new ResourceLocation("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getItemInHand(InteractionHand.MAIN_HAND) != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0f;
                });

        FabricModelPredicateProviderRegistry.register(bow, new ResourceLocation("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getItemInHand(InteractionHand.MAIN_HAND) == stack ? 1.0f : 0.0f);
    }
}
