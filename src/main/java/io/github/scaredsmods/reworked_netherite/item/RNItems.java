package io.github.scaredsmods.reworked_netherite.item;


import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeModeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import io.github.scaredsmods.reworked_netherite.fluid.RNFluids;
import io.github.scaredsmods.reworked_netherite.item.custom.HammerItem;
import io.github.scaredsmods.reworked_netherite.item.custom.NetheriteBowItem;
import io.github.scaredsmods.reworked_netherite.item.custom.SoulCrystalItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class RNItems {



    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, ReworkedNetherite.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEM = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BLOCK_ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, ReworkedNetherite.MOD_ID);
    public static final ResourcefulRegistry<Item> MODEL_ITEM = ResourcefulRegistries.create(ITEMS);



    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, ReworkedNetherite.MOD_ID);
    public static final RegistryEntry<CreativeModeTab> ITEMS_TAB = TABS.register("items", () -> new ResourcefulCreativeModeTab(new ResourceLocation(ReworkedNetherite.MOD_ID, "items"))
            .setItemIcon(() -> RNItems.RAW_NETHERITE.get())
            .addRegistry(ITEMS)
            .build());

    public static final RegistryEntry<CreativeModeTab> BLOCK_TAB = TABS.register("blocks", () -> new ResourcefulCreativeModeTab(new ResourceLocation(ReworkedNetherite.MOD_ID, "blocks"))
            .setItemIcon(() -> RNBlocks.RAW_NETHERITE_BLOCK.get())
            .addRegistry(BLOCK_ITEMS)
            .build());



    //Actual Items
    public static final RegistryEntry<Item> RAW_NETHERITE = BASIC_ITEM.register("raw_netherite", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryEntry<Item> NETHERITE_HAMMER = MODEL_ITEM.register("netherite_hammer", () -> new HammerItem(Tiers.NETHERITE, 5F));
    public static final RegistryEntry<Item> NETHERITE_BOW = MODEL_ITEM.register("netherite_bow",() -> new NetheriteBowItem(new Item.Properties().stacksTo(1)));
    public static final RegistryEntry<Item> NETHERITE_CORE = MODEL_ITEM.register("netherite_core", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryEntry<Item> FLAT_NETHERITE_INGOT = BASIC_ITEM.register("flatten_netherite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryEntry<Item> WITHER_BONE = BASIC_ITEM.register("wither_bone", () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> SOUL_CRYSTAL = BASIC_ITEM.register("soul_crystal", () -> new SoulCrystalItem(new Item.Properties()));

    public static final RegistryEntry<Item> MOLTEN_NETHERITE_BUCKET = ITEMS.register("molten_netherite_bucket", () -> new BucketItem(RNFluids.SOURCE_MOLTEN_NETHERITE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    // Block Items
    public static final RegistryEntry<Item> STONE_NETHERITE_ORE = BLOCK_ITEMS.register("stone_netherite_ore", () -> new BlockItem(RNBlocks.STONE_NETHERITE_ORE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DEEPSLATE_NETHERITE_ORE = BLOCK_ITEMS.register("deepslate_netherite_ore", () -> new BlockItem(RNBlocks.DEEPSLATE_NETHERITE_ORE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> NETHERITE_ORE = BLOCK_ITEMS.register("netherite_ore", () -> new BlockItem(RNBlocks.NETHERITE_ORE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> END_STONE_NETHERITE_ORE = BLOCK_ITEMS.register("end_stone_netherite_ore", () -> new BlockItem(RNBlocks.END_STONE_NETHERITE_ORE.get(), new Item.Properties()));

    public static final RegistryEntry<Item> RAW_NETHERITE_BLOCK = BLOCK_ITEMS.register("raw_netherite_block", () -> new BlockItem(RNBlocks.RAW_NETHERITE_BLOCK.get(), new Item.Properties()));






}
