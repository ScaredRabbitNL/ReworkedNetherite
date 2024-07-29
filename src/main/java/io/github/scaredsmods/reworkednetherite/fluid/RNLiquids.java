package io.github.scaredsmods.reworkednetherite.fluid;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;


public class RNLiquids {


    public static final ResourcefulRegistry<Fluid> FLUIDS = ResourcefulRegistries.create(Registries.FLUID, ReworkedNetherite.MOD_ID);

    public static RegistryEntry<FlowableFluid> SOURCE_MOLTEN_NETHERITE = FLUIDS.register("source_molten_netherite_fluid", MoltenNetherite.Still::new);
    public static RegistryEntry<FlowableFluid> FLOWING_NETHERITE = FLUIDS.register("flowing_molten_netherite_fluid", MoltenNetherite.Flowing::new);


}
