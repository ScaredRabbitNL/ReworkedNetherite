package io.github.scaredsmods.reworkednetherite.enchantment;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;


public class RNEnchantments {


    public static final ResourcefulRegistry<Enchantment> ENCHANTMENTS = ResourcefulRegistries.create(Registries.ENCHANTMENT, ReworkedNetherite.MOD_ID);


    public static final RegistryEntry<Enchantment> POLISHED = ENCHANTMENTS.register("polished", () -> new PolishedEnchantment(Enchantment.Rarity.COMMON, 5, EquipmentSlot.MAINHAND));
}
