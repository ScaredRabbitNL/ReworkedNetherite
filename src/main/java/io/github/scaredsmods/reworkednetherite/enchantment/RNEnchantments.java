package io.github.scaredsmods.reworkednetherite.enchantment;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;


public class RNEnchantments {


    public static final ResourcefulRegistry<Enchantment> ENCHANTMENTS = ResourcefulRegistries.create(BuiltInRegistries.ENCHANTMENT, ReworkedNetherite.MOD_ID);


    public static final RegistryEntry<Enchantment> POLISHED = ENCHANTMENTS.register("polished", () -> new PolishedEnchantment(Enchantment.Rarity.COMMON, 5,EquipmentSlot.MAINHAND));
}
