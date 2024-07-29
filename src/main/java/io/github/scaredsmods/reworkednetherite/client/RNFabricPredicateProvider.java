package io.github.scaredsmods.reworkednetherite.client;

import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class RNFabricPredicateProvider {

    public static void registerModModels() {
        registerBow(RNItems.NETHERITE_BOW.get());
    }



    private static void registerBow(Item bow) {
        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getMainHandStack() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
                });

        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getMainHandStack() == stack ? 1.0f : 0.0f);
    }
}
