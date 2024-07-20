package io.github.scaredsmods.reworkednetherite.fluid;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class RNLiquids {


    public static final ResourcefulRegistry<Fluid> FLUIDS = ResourcefulRegistries.create(BuiltInRegistries.FLUID, ReworkedNetherite.MOD_ID);

    public static RegistryEntry<FlowingFluid> SOURCE_MOLTEN_NETHERITE = FLUIDS.register("source_molten_netherite_fluid", MoltenNetherite.Still::new);
    public static RegistryEntry<FlowingFluid> FLOWING_NETHERITE = FLUIDS.register("flowing_molten_netherite_fluid", MoltenNetherite.Flowing::new);


}
