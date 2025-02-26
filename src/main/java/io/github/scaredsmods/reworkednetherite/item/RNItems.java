package io.github.scaredsmods.reworkednetherite.item;


import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeModeTab;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import io.github.scaredsmods.reworkednetherite.item.custom.HammerItem;
import io.github.scaredsmods.reworkednetherite.item.custom.NetheriteBowItem;
import io.github.scaredsmods.reworkednetherite.item.custom.SoulCrystalItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;


public class RNItems {



    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registries.ITEM, ReworkedNetherite.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEM = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> BLOCK_ITEMS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> MODEL_ITEM = ResourcefulRegistries.create(ITEMS);

    public static final ResourcefulRegistry<Item> BUCKETS = ResourcefulRegistries.create(Registries.ITEM, ReworkedNetherite.MOD_ID);

    public static final ResourcefulRegistry<ItemGroup> TABS = ResourcefulRegistries.create(Registries.ITEM_GROUP, ReworkedNetherite.MOD_ID);
    public static final RegistryEntry<ItemGroup> ITEMS_TAB = TABS.register("items", () -> new ResourcefulCreativeModeTab(new Identifier(ReworkedNetherite.MOD_ID, "items"))
            .setItemIcon(() -> RNItems.RAW_NETHERITE.get())
            .addRegistry(BASIC_ITEM)
            .addRegistry(BUCKETS)
            .addRegistry(MODEL_ITEM)
            .build());

    public static final RegistryEntry<ItemGroup> BLOCK_TAB = TABS.register("blocks", () -> new ResourcefulCreativeModeTab(new Identifier(ReworkedNetherite.MOD_ID, "blocks"))
            .setItemIcon(() -> RNBlocks.RAW_NETHERITE_BLOCK.get())
            .addRegistry(BLOCK_ITEMS)
            .build());



    //Actual Items
    public static final RegistryEntry<Item> RAW_NETHERITE = BASIC_ITEM.register("raw_netherite", () -> new Item(new Item.Settings().fireproof()));
    public static final RegistryEntry<Item> NETHERITE_HAMMER = MODEL_ITEM.register("netherite_hammer", () -> new HammerItem(ToolMaterials.NETHERITE, 5F));
    public static final RegistryEntry<Item> NETHERITE_BOW = MODEL_ITEM.register("netherite_bow",() -> new NetheriteBowItem(new Item.Settings().maxCount(1)));
    public static final RegistryEntry<Item> NETHERITE_CORE = MODEL_ITEM.register("netherite_core", () -> new Item(new Item.Settings().fireproof()));
    public static final RegistryEntry<Item> FLAT_NETHERITE_INGOT = BASIC_ITEM.register("flatten_netherite_ingot", () -> new Item(new Item.Settings().fireproof()));
    public static final RegistryEntry<Item> WITHER_BONE = BASIC_ITEM.register("wither_bone", () -> new Item(new Item.Settings()));
    public static final RegistryEntry<Item> SOUL_CRYSTAL = BASIC_ITEM.register("soul_crystal", () -> new SoulCrystalItem(new Item.Settings()));


    // Block Items

    public static final RegistryEntry<Item> STONE_NETHERITE_ORE = BLOCK_ITEMS.register("stone_netherite_ore", () -> new BlockItem(RNBlocks.STONE_NETHERITE_ORE.get(), new Item.Settings()));
    public static final RegistryEntry<Item> DEEPSLATE_NETHERITE_ORE = BLOCK_ITEMS.register("deepslate_netherite_ore", () -> new BlockItem(RNBlocks.DEEPSLATE_NETHERITE_ORE.get(), new Item.Settings()));
    public static final RegistryEntry<Item> NETHERITE_ORE = BLOCK_ITEMS.register("netherite_ore", () -> new BlockItem(RNBlocks.NETHERITE_ORE.get(), new Item.Settings()));
    public static final RegistryEntry<Item> END_STONE_NETHERITE_ORE = BLOCK_ITEMS.register("end_stone_netherite_ore", () -> new BlockItem(RNBlocks.END_STONE_NETHERITE_ORE.get(), new Item.Settings()));

    public static final RegistryEntry<Item> RAW_NETHERITE_BLOCK = BLOCK_ITEMS.register("raw_netherite_block", () -> new BlockItem(RNBlocks.RAW_NETHERITE_BLOCK.get(), new Item.Settings()));






    public static final RegistryEntry<Item> MOLTEN_NETHERITE_BUCKET = BUCKETS.register("molten_netherite_bucket",
            () -> new BucketItem(RNLiquids.SOURCE_MOLTEN_NETHERITE.get(), new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));





}
