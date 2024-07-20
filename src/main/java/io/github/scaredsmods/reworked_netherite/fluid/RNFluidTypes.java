package io.github.scaredsmods.reworked_netherite.fluid;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

public class RNFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final ResourcefulRegistry<FluidType> FLUID_TYPES =
            ResourcefulRegistries.create(NeoForgeRegistries.FLUID_TYPES, ReworkedNetherite.MOD_ID);

    public static final RegistryEntry<FluidType> MOLTEN_NETHERITE_FLUID_TYPE = FLUID_TYPES.register("molten_netherite_fluid", () ->
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xff3f3138,
                    new Vector3f(224f / 255f, 56f / 255f, 208f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15)));




}
