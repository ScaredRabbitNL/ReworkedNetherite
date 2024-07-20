package io.github.scaredsmods.reworkednetherite.datagen.server;

import io.github.scaredsmods.reworkednetherite.ReworkedNetherite;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Supplier;

public class RNRecipeGenerator extends FabricRecipeProvider {

    private RecipeOutput output;

    public static final List<ItemLike> NETHERITE_SMELTABLES = List.of(RNBlocks.STONE_NETHERITE_ORE.get(), RNBlocks.DEEPSLATE_NETHERITE_ORE.get(), RNBlocks.END_STONE_NETHERITE_ORE.get());



    public RNRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        this.output = exporter;


        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.RAW_NETHERITE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.STONE_NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.DEEPSLATE_NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.END_STONE_NETHERITE_ORE);



        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, RNItems.RAW_NETHERITE.get(), RecipeCategory.MISC, RNBlocks.RAW_NETHERITE_BLOCK.get());

    }

    private void oreSmelt(Supplier<Item> result, Supplier<Item> mainItem) {
        smelt(result, mainItem);
        blast(result, mainItem);
    }




    private void smelt(Supplier<Item> result, Supplier<Item> mainItem) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(mainItem.get()), RecipeCategory.MISC, result.get(), 1.5f, 200)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_smelting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), BuiltInRegistries.ITEM.getKey(mainItem.get()).getPath())));
    }

    private void smelt(Supplier<Item> result, TagKey<Item> mainItem) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(mainItem), RecipeCategory.MISC, result.get(), 1.5f, 200)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_smelting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), mainItem.location().getPath())));
    }

    private void blast(Supplier<Item> result, Supplier<Item> mainItem) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(mainItem.get()), RecipeCategory.MISC, result.get(), 1.5f, 100)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_blasting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), BuiltInRegistries.ITEM.getKey(mainItem.get()).getPath())));
    }

    private void blast(Supplier<Item> result, TagKey<Item> mainItem) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(mainItem), RecipeCategory.MISC, result.get(), 1.5f, 100)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_blasting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), mainItem.location().getPath())));
    }
}
