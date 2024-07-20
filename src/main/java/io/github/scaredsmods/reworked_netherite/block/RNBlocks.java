package io.github.scaredsmods.reworked_netherite.block;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.fluid.RNFluids;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class RNBlocks {



    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, ReworkedNetherite.MOD_ID);
    public static final ResourcefulRegistry<Block> MACHINES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> ORES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> LIQUIDS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, ReworkedNetherite.MOD_ID);


    public static final RegistryEntry<Block> STONE_NETHERITE_ORE = ORES.register("stone_netherite_ore", () -> new DropExperienceBlock(UniformInt.of(3,7), BlockBehaviour.Properties.of().strength(6.5F).requiresCorrectToolForDrops()));
    public static final RegistryEntry<Block> DEEPSLATE_NETHERITE_ORE = ORES.register("deepslate_netherite_ore", () -> new DropExperienceBlock(UniformInt.of(3,7), BlockBehaviour.Properties.of().strength(6.5F).requiresCorrectToolForDrops()));
    public static final RegistryEntry<Block> NETHERITE_ORE = ORES.register("netherite_ore", () -> new DropExperienceBlock(UniformInt.of(3,7), BlockBehaviour.Properties.of().strength(6.5F).requiresCorrectToolForDrops()));
    public static final RegistryEntry<Block> END_STONE_NETHERITE_ORE = ORES.register("end_stone_netherite_ore", () -> new DropExperienceBlock(UniformInt.of(3,7), BlockBehaviour.Properties.of().strength(6.5F).requiresCorrectToolForDrops()));

    public static final RegistryEntry<Block> RAW_NETHERITE_BLOCK = BLOCKS.register("raw_netherite_block", () -> new Block(BlockBehaviour.Properties.of().strength(6.5F).requiresCorrectToolForDrops()));

    public static final RegistryEntry<LiquidBlock> MOLTEN_NETHERITE_BLOCK = LIQUIDS.register("molten_netherite_block",
            () -> new LiquidBlock(RNFluids.SOURCE_MOLTEN_NETHERITE, BlockBehaviour.Properties.of().liquid().mapColor(MapColor.COLOR_BLACK).noLootTable()));


}
