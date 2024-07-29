package io.github.scaredsmods.reworked_netherite;

import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import io.github.scaredsmods.reworked_netherite.enchantment.RNEnchantments;
import io.github.scaredsmods.reworked_netherite.event.SpongeAbsorbEventHandler;
import io.github.scaredsmods.reworked_netherite.fluid.RNFluidTypes;
import io.github.scaredsmods.reworked_netherite.fluid.RNFluids;
import io.github.scaredsmods.reworked_netherite.item.RNItems;
import io.github.scaredsmods.reworked_netherite.util.RNItemProperties;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Objects;




@Mod(ReworkedNetherite.MOD_ID)
public final class ReworkedNetherite {

    public static final String MOD_ID = "reworked_netherite";

    public ReworkedNetherite() {


        RNBlocks.BLOCKS.init();
        RNBlocks.LIQUIDS.init();
        RNItems.ITEMS.init();
        RNItems.TABS.init();
        RNItems.BLOCK_ITEMS.init();
        RNEnchantments.ENCHANTMENTS.init();
        RNFluids.FLUIDS.init();
        RNFluidTypes.FLUID_TYPES.init();




    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class CommonModEvents {
        @SubscribeEvent(priority = EventPriority.HIGH)
        public static void onSpongePlace(BlockEvent.EntityPlaceEvent event) {
            BlockState state = event.getPlacedBlock();
            if (state.getBlock() == Blocks.SPONGE) {
                BlockPos pos = event.getPos();
                SpongeAbsorbEventHandler.absorbCustomFluid(Objects.requireNonNull(event.getEntity()).level(), pos);
            }
        }
    }



    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                RNItemProperties.addCustomItemProperties();

                ItemBlockRenderTypes.setRenderLayer(RNFluids.SOURCE_MOLTEN_NETHERITE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(RNFluids.FLOWING_MOLTEN_NETHERITE.get(), RenderType.translucent());

            });
        }


    }

}
