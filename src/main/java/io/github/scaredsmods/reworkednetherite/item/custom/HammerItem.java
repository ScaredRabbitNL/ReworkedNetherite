package io.github.scaredsmods.reworkednetherite.item.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class HammerItem extends MiningToolItem {

    public HammerItem(ToolMaterial toolMaterial, Float damage) {
        super(damage, -2.8f, toolMaterial, BlockTags.PICKAXE_MINEABLE, new Settings().maxCount(1).fireproof());


    }

    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Shovel.getFlattenables();
    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = Axe.getStrippables();


    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return 12.5F;
    }




    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World level = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState blockState = level.getBlockState(pos);

        BlockState resultToSet = null;

        final var strippedResult = BLOCK_STRIPPING_MAP.get(blockState.getBlock());
        if (strippedResult != null) {
            level.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            resultToSet = strippedResult.getDefaultState().with(PillarBlock.AXIS,
                    blockState.get(PillarBlock.AXIS));
        } else if (context.getSide() != Direction.DOWN) {
            final var foundResult = SHOVEL_LOOKUP.get(blockState.getBlock());
            if (foundResult != null && level.getBlockState(pos.up()).isAir()) {
                level.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                resultToSet = foundResult;
            } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT))
                resultToSet = blockState.with(CampfireBlock.LIT, false);
        }
        if (resultToSet == null) return ActionResult.PASS;
        if (!level.isClient()) {
            level.setBlockState(pos, resultToSet, 11);
            if (player != null) context.getPlayer().getInventory().getMainHandStack().damage(1, (LivingEntity) player,
                    (Consumer<LivingEntity>) p -> p.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return ActionResult.SUCCESS;


    }



    private static final class Shovel extends ShovelItem {

        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.PATH_STATES;
        }

        private Shovel(ToolMaterial tier, float f, float g, Settings properties) {
            super(tier, f, g, properties);
        }
    }


    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPED_BLOCKS;
        }

        private Axe(ToolMaterial tier, float f, float g, Settings properties) {
            super(tier, f, g, properties);
        }
    }

}
