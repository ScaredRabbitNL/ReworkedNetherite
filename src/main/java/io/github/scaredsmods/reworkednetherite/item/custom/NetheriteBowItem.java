package io.github.scaredsmods.reworkednetherite.item.custom;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

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
