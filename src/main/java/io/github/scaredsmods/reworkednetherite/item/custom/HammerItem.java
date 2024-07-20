package io.github.scaredsmods.reworkednetherite.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.function.Consumer;

public class HammerItem extends DiggerItem {

    public HammerItem(Tier tier, Float damage) {
        super(damage, -2.8f, tier, BlockTags.MINEABLE_WITH_PICKAXE, new Properties().stacksTo(1).fireResistant());


    }

    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();


    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 12.5F;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(pos);

        BlockState resultToSet = null;

        final var strippedResult = BLOCK_STRIPPING_MAP.get(blockState.getBlock());
        if (strippedResult != null) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS,
                    blockState.getValue(RotatedPillarBlock.AXIS));
        } else if (context.getClickedFace() != Direction.DOWN) {
            final var foundResult = SHOVEL_LOOKUP.get(blockState.getBlock());
            if (foundResult != null && level.getBlockState(pos.above()).isAir()) {
                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockState.getBlock() instanceof CampfireBlock && blockState.getValue(CampfireBlock.LIT))
                resultToSet = blockState.setValue(CampfireBlock.LIT, false);
        }
        if (resultToSet == null) return InteractionResult.PASS;
        if (!level.isClientSide()) {
            level.setBlock(pos, resultToSet, 11);
            if (player != null) context.getItemInHand().hurtAndBreak(1, (LivingEntity) player,
                    (Consumer<LivingEntity>) p -> p.broadcastBreakEvent(context.getHand()));
        }
        return InteractionResult.SUCCESS;


    }



    private static final class Shovel extends ShovelItem {

        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.FLATTENABLES;
        }

        private Shovel(Tier tier, float f, float g, Properties properties) {
            super(tier, f, g, properties);
        }
    }


    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPABLES;
        }

        private Axe(Tier tier, float f, float g, Properties properties) {
            super(tier, f, g, properties);
        }
    }

}
