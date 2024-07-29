package io.github.scaredsmods.reworkednetherite.block;


import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class RNBlocks {


    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(Registries.BLOCK, ReworkedNetherite.MOD_ID);
    public static final ResourcefulRegistry<Block> MACHINES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> ORES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> LIQUIDS = ResourcefulRegistries.create(Registries.BLOCK, ReworkedNetherite.MOD_ID);


    public static final RegistryEntry<Block> STONE_NETHERITE_ORE = ORES.register("stone_netherite_ore", () -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), AbstractBlock.Settings.create().strength(6.5F).requiresTool()));
    public static final RegistryEntry<Block> DEEPSLATE_NETHERITE_ORE = ORES.register("deepslate_netherite_ore", () -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), AbstractBlock.Settings.create().strength(6.5F).requiresTool()));
    public static final RegistryEntry<Block> NETHERITE_ORE = ORES.register("netherite_ore", () -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), AbstractBlock.Settings.create().strength(6.5F).requiresTool()));
    public static final RegistryEntry<Block> END_STONE_NETHERITE_ORE = ORES.register("end_stone_netherite_ore", () -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), AbstractBlock.Settings.create().strength(6.5F).requiresTool()));

    public static final RegistryEntry<Block> RAW_NETHERITE_BLOCK = BLOCKS.register("raw_netherite_block", () -> new Block(AbstractBlock.Settings.create().strength(6.5F).requiresTool()));

    //public static final RegistryEntry<Block> MELTER = MACHINES.register("melter", () ->  new MelterBlock(AbstractBlock.Settings.create().noCollision()));

    public static final RegistryEntry<FluidBlock> MOLTEN_NETHERITE_BLOCK = LIQUIDS.register("molten_netherite", () -> new FluidBlock(RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), AbstractBlock.Settings.copy(Blocks.WATER)));


}
