package io.github.scaredsmods.reworked_netherite.fluid;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import io.github.scaredsmods.reworked_netherite.item.RNItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;



public class RNFluids {

    public static final ResourcefulRegistry<Fluid> FLUIDS =
            ResourcefulRegistries.create(BuiltInRegistries.FLUID, ReworkedNetherite.MOD_ID);

    public static final RegistryEntry<FlowingFluid> SOURCE_MOLTEN_NETHERITE = FLUIDS.register("source_molten_netherite_fluid",
            () -> new BaseFlowingFluid.Source(RNFluids.MOLTEN_NETHERITE_FLUID_PROPERTIES));
    public static final RegistryEntry<FlowingFluid> FLOWING_MOLTEN_NETHERITE = FLUIDS.register("flowing_molten_netherite_fluid",
            () -> new BaseFlowingFluid.Flowing(RNFluids.MOLTEN_NETHERITE_FLUID_PROPERTIES));


    public static final BaseFlowingFluid.Properties MOLTEN_NETHERITE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            RNFluidTypes.MOLTEN_NETHERITE_FLUID_TYPE, SOURCE_MOLTEN_NETHERITE, FLOWING_MOLTEN_NETHERITE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(RNBlocks.MOLTEN_NETHERITE_BLOCK)
            .bucket(RNItems.MOLTEN_NETHERITE_BUCKET);
}
