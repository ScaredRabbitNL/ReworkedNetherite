package io.github.scaredsmods.reworkednetherite.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class SoulCrystalItem extends Item {

    public SoulCrystalItem(Settings properties) {
        super(properties.maxCount(1));
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        NbtCompound tag = itemStack.getOrCreateNbt();

        if (player.isSneaking()) {
            // Handle teleportation
            if (tag.contains("MarkedPos")) {
                // Teleport player to marked position
                NbtCompound posTag = tag.getCompound("MarkedPos");
                player.teleport(posTag.getDouble("x"), posTag.getDouble("y"), posTag.getDouble("z"));
                player.sendMessage(Text.literal("Teleported to previously saved position!"), true);
                // Add cooldown handling
            }
        } else {
            // Mark current position
            NbtCompound posTag = new NbtCompound();
            posTag.putDouble("x", player.getX());
            posTag.putDouble("y", player.getY());
            posTag.putDouble("z", player.getZ());
            tag.put("MarkedPos", posTag);
            player.sendMessage(Text.literal("Location marked!"), true);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("A mystical crystal with teleporting powers").formatted(Formatting.AQUA));
    }



}