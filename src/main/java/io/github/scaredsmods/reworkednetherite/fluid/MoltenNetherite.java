package io.github.scaredsmods.reworkednetherite.fluid;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.state.property.Properties;

public class MoltenNetherite extends FlowableFluid {


    @Override
    public Fluid getFlowing() {
        return RNLiquids.FLOWING_NETHERITE.get();
    }

    @Override
    public Fluid getStill() {
        return RNLiquids.SOURCE_MOLTEN_NETHERITE.get();
    }



    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }


    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        if (world.getDimension().equals(DimensionTypes.THE_NETHER_ID)) {
            return 6;
        }else {
            return 4;
        }
    }



    @Override
    protected int getLevelDecreasePerBlock(WorldView level) {
        return 1;
    }



    @Override
    public Item getBucketItem() {
        return RNItems.MOLTEN_NETHERITE_BUCKET.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView level, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView level) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }



    @Override
    protected BlockState toBlockState(FluidState state) {
        return RNBlocks.MOLTEN_NETHERITE_BLOCK.get().getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }



    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }


    public static class Flowing extends MoltenNetherite {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }



        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }


    }

    public static class Still extends MoltenNetherite {


        @Override
        public int getLevel(FluidState state) {
            return 8;
        }



        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }




}
