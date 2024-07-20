package io.github.scaredsmods.reworked_netherite.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NetheriteBowItem extends BowItem {

    public NetheriteBowItem(Properties properties) {
        super(properties);
        properties.stacksTo(1);
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }


}
