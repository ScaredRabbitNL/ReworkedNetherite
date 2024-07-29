package io.github.scaredsmods.reworked_netherite.datagen.server;


import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import io.github.scaredsmods.reworked_netherite.item.RNItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class RNRecipeGenerator extends RecipeProvider   {

    private RecipeOutput output;


    public RNRecipeGenerator(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        this.output = recipeOutput;

        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.RAW_NETHERITE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.STONE_NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.DEEPSLATE_NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.NETHERITE_ORE);
        oreSmelt(() -> Items.NETHERITE_INGOT, RNItems.END_STONE_NETHERITE_ORE);


        offerReversibleCompactingRecipes(output, RecipeCategory.MISC, RNItems.RAW_NETHERITE.get(), RecipeCategory.MISC, RNBlocks.RAW_NETHERITE_BLOCK.get());




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RNItems.NETHERITE_HAMMER.get(), 1)
                .pattern("EFS")
                .pattern("FCF")
                .pattern("WFM")
                .define('E', Items.ENDER_PEARL)
                .define('F', RNItems.FLAT_NETHERITE_INGOT.get())
                .define('C', RNItems.NETHERITE_CORE.get())
                .define('W', RNItems.WITHER_BONE.get())
                .define('M', Items.MAGMA_CREAM)
                .define('S', RNItems.SOUL_CRYSTAL.get())
                .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                .unlockedBy(getHasName(RNItems.FLAT_NETHERITE_INGOT.get()), has(RNItems.FLAT_NETHERITE_INGOT.get()))
                .unlockedBy(getHasName(RNItems.NETHERITE_CORE.get()), has(RNItems.NETHERITE_CORE.get()))
                .unlockedBy(getHasName(RNItems.WITHER_BONE.get()), has(RNItems.WITHER_BONE.get()))
                .unlockedBy(getHasName(Items.MAGMA_CREAM), has(Items.MAGMA_CREAM))
                .unlockedBy(getHasName(RNItems.SOUL_CRYSTAL.get()), has(RNItems.SOUL_CRYSTAL.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, getSimpleRecipeName(RNItems.NETHERITE_HAMMER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RNItems.NETHERITE_CORE.get(), 1)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Blocks.NETHERITE_BLOCK)
                .unlockedBy(getHasName(Blocks.NETHERITE_BLOCK), has(Blocks.NETHERITE_BLOCK))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, getSimpleRecipeName(RNItems.NETHERITE_CORE.get())));


        registerSoulCrystalRecipe(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RNItems.NETHERITE_BOW.get(), 1)
                .pattern(" SN")
                .pattern("S N")
                .pattern(" SN")
                .define('S', Items.STICK)
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, getSimpleRecipeName(RNItems.NETHERITE_BOW.get())));

        stoneCutting(RNItems.FLAT_NETHERITE_INGOT, 4, () -> Items.NETHERITE_INGOT);



    }




    @Deprecated(forRemoval = true)
    public void registerSoulCrystalRecipe(RecipeOutput exporter) {



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RNItems.SOUL_CRYSTAL.get(), 1)
                .pattern("SAS")
                .pattern("APA")
                .pattern("SAS")
                .define('S', Blocks.SOUL_SAND)
                .define('A', Items.AMETHYST_SHARD)
                .define('P', Blocks.PLAYER_HEAD)
                .unlockedBy(getHasName(Blocks.SOUL_SAND), has(Blocks.SOUL_SAND))
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .unlockedBy(getHasName(Blocks.PLAYER_HEAD), has(Blocks.PLAYER_HEAD))
                .save(exporter, new ResourceLocation(ReworkedNetherite.MOD_ID, getSimpleRecipeName(RNItems.SOUL_CRYSTAL.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.PLAYER_HEAD, 1)
                .pattern("LLL")
                .pattern("RCR")
                .pattern("LLL")
                .define('L', Items.LEATHER)
                .define('R', Items.REDSTONE)
                .define('C', RNItems.NETHERITE_CORE.get())
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(RNItems.NETHERITE_CORE.get()), has(RNItems.NETHERITE_CORE.get()))
                .save(exporter, new ResourceLocation(ReworkedNetherite.MOD_ID, getSimpleRecipeName(Blocks.PLAYER_HEAD)));


    }


    private void oreSmelt(Supplier<Item> result, Supplier<Item> mainItem) {
        smelt(result, mainItem);
        blast(result, mainItem);
    }

    private void oreSmelt(Supplier<Item> result, TagKey<Item> mainItem) {
        smelt(result, mainItem);
        blast(result, mainItem);
    }

    private void smelt(Supplier<Item> result, Supplier<Item> mainItem) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(mainItem.get()), RecipeCategory.MISC, result.get(), 0.1f, 200)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_smelting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), BuiltInRegistries.ITEM.getKey(mainItem.get()).getPath())));
    }

    private void smelt(Supplier<Item> result, TagKey<Item> mainItem) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(mainItem), RecipeCategory.MISC, result.get(), 0.1f, 200)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_smelting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), mainItem.location().getPath())));
    }

    private void blast(Supplier<Item> result, Supplier<Item> mainItem) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(mainItem.get()), RecipeCategory.MISC, result.get(), 0.1f, 100)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_blasting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), BuiltInRegistries.ITEM.getKey(mainItem.get()).getPath())));
    }

    private void blast(Supplier<Item> result, TagKey<Item> mainItem) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(mainItem), RecipeCategory.MISC, result.get(), 0.1f, 100)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_blasting_%s"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), mainItem.location().getPath())));
    }


    private void stoneCutting(Supplier<Item> result, int count, Supplier<Item> mainItem) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(mainItem.get()), RecipeCategory.MISC, result.get(), count)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem.get()))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_%s_stonecutting"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), BuiltInRegistries.ITEM.getKey(mainItem.get()).getPath())));
    }

    private void stoneCutting(Supplier<Item> result, int count, TagKey<Item> mainItem) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(mainItem), RecipeCategory.MISC, result.get(), count)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(result.get()).getPath(), has(mainItem))
                .save(output, new ResourceLocation(ReworkedNetherite.MOD_ID, "%s_from_%s_stonecutting"
                        .formatted(BuiltInRegistries.ITEM.getKey(result.get()).getPath(), mainItem.location().getPath())));
    }

    protected static void offerReversibleCompactingRecipes(
            RecipeOutput pRecipeOutput, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked
    ) {
        offerReversibleCompactingRecipes(
                pRecipeOutput, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), null, getSimpleRecipeName(pUnpacked), null
        );
    }



    protected static void offerReversibleCompactingRecipes(
            RecipeOutput pRecipeOutput,
            RecipeCategory pUnpackedCategory,
            ItemLike pUnpacked,
            RecipeCategory pPackedCategory,
            ItemLike pPacked,
            String pPackedName,
            @Nullable String pPackedGroup,
            String pUnpackedName,
            @Nullable String pUnpackedGroup
    ) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked)
                .group(pUnpackedGroup)
                .unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pRecipeOutput, new ResourceLocation(ReworkedNetherite.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked)
                .define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pPackedGroup)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pRecipeOutput, new ResourceLocation(ReworkedNetherite.MOD_ID, pPackedName));
    }





}
