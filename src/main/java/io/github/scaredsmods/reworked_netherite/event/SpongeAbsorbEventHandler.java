package io.github.scaredsmods.reworked_netherite.event;


import io.github.scaredsmods.reworked_netherite.fluid.RNFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;

public class SpongeAbsorbEventHandler {



    public static void absorbCustomFluid(Level world, BlockPos pos) {
        boolean flag = false;
        AABB aabb = new AABB(pos).inflate(6.0D);

        for (BlockPos blockpos : BlockPos.betweenClosed((int) aabb.minX, (int) aabb.minY, (int) aabb.minZ, (int) aabb.maxX, (int) aabb.maxY, (int) aabb.maxZ)) {
            FluidState fluidState = world.getFluidState(blockpos);
            if (fluidState.isSource() && (fluidState.getType() == Fluids.WATER || fluidState.getType() == RNFluids.SOURCE_MOLTEN_NETHERITE.get())) {
                world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 3);
                flag = true;
            }
        }

        if (flag) {
            world.setBlock(pos, Blocks.WET_SPONGE.defaultBlockState(), 2);
            world.levelEvent(2001, pos, Block.getId(world.getBlockState(pos)));
        }
    }
}
