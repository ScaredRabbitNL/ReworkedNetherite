package io.github.scaredsmods.reworked_netherite.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoulCrystalItem extends Item {

    public SoulCrystalItem(Properties properties) {
        super(properties.stacksTo(1));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        CompoundTag tag = itemStack.getOrCreateTag();

        if (player.isShiftKeyDown()) {
            // Handle teleportation
            if (tag.contains("MarkedPos")) {
                // Teleport player to marked position
                CompoundTag posTag = tag.getCompound("MarkedPos");
                player.teleportTo(posTag.getDouble("x"), posTag.getDouble("y"), posTag.getDouble("z"));
                player.displayClientMessage(Component.literal("Teleported to previously saved position!"), true);
                // Add cooldown handling
            }
        } else {
            // Mark current position
            CompoundTag posTag = new CompoundTag();
            posTag.putDouble("x", player.getX());
            posTag.putDouble("y", player.getY());
            posTag.putDouble("z", player.getZ());
            tag.put("MarkedPos", posTag);
            player.displayClientMessage(Component.literal("Location marked!"), true);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
    }



    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {

        tooltipComponents.add(Component.literal("A mystical crystal with teleporting powers").withStyle(ChatFormatting.AQUA));






    }



}