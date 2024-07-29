package io.github.scaredsmods.reworkednetherite.item.custom;


import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class NetheriteBowItem extends BowItem {

    public NetheriteBowItem(Settings properties) {
        super(properties);
        properties.maxCount(1);
    }



    @Override
    public boolean isFireproof() {
        return true;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 40;
    }
}
