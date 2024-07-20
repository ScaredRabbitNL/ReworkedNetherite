package io.github.scaredsmods.reworkednetherite.fluid;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class MoltenNetherite extends FlowingFluid {


    @Override
    public Fluid getFlowing() {
        return RNLiquids.FLOWING_NETHERITE.get();
    }

    @Override
    public Fluid getSource() {
        return RNLiquids.SOURCE_MOLTEN_NETHERITE.get();
    }



    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources(state, level, pos, blockEntity);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader level) {

        if (level.dimensionType().equals(BuiltinDimensionTypes.NETHER)) {
            return 6;
        }else {
            return 4;
        }

    }

    @Override
    protected int getDropOff(LevelReader level) {
        return 1;
    }

    @Override
    public Item getBucket() {
        return RNItems.MOLTEN_NETHERITE_BUCKET.get();
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100f;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return RNBlocks.MOLTEN_NETHERITE_BLOCK.get().defaultBlockState().setValue(BlockStateProperties.LEVEL, getLegacyLevel(state));
    }

    @Override
    public boolean isSource(FluidState state) {
        return false;
    }

    @Override
    public int getAmount(FluidState state) {
        return 0;
    }


    public static class Flowing extends MoltenNetherite {

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }


        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }


    }

    public static class Still extends MoltenNetherite {


        @Override
        public int getAmount(FluidState state) {
            return 8;
        }



        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }




}
