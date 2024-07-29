package io.github.scaredsmods.reworkednetherite.datagen.server.recipe;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class RNRecipeGenerator extends FabricRecipeProvider {



    public static final List<ItemConvertible> NETHERITE_SMELTABLES = List.of(RNBlocks.STONE_NETHERITE_ORE.get(), RNBlocks.DEEPSLATE_NETHERITE_ORE.get(), RNBlocks.NETHERITE_ORE.get(), RNBlocks.END_STONE_NETHERITE_ORE.get());



    public RNRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter, NETHERITE_SMELTABLES, RecipeCategory.MISC, Items.NETHERITE_INGOT,
                1.5F, 200, "netherite");
        offerBlasting(exporter, NETHERITE_SMELTABLES, RecipeCategory.MISC, Items.NETHERITE_INGOT,
                3.0F, 100, "netherite");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, RNItems.RAW_NETHERITE.get(), RecipeCategory.MISC, RNBlocks.RAW_NETHERITE_BLOCK.get());


        offerStonecuttingRecipe(exporter, RecipeCategory.TOOLS, RNItems.FLAT_NETHERITE_INGOT.get(), Items.NETHERITE_INGOT, 4);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RNItems.NETHERITE_HAMMER.get(), 1)
                .pattern("EFS")
                .pattern("FCF")
                .pattern("WFM")
                .input('E', Items.ENDER_PEARL)
                .input('F', RNItems.FLAT_NETHERITE_INGOT.get())
                .input('C', RNItems.NETHERITE_CORE.get())
                .input('W', RNItems.WITHER_BONE.get())
                .input('M', Items.MAGMA_CREAM)
                .input('S', RNItems.SOUL_CRYSTAL.get())
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(RNItems.FLAT_NETHERITE_INGOT.get()), conditionsFromItem(RNItems.FLAT_NETHERITE_INGOT.get()))
                .criterion(hasItem(RNItems.NETHERITE_CORE.get()), conditionsFromItem(RNItems.NETHERITE_CORE.get()))
                .criterion(hasItem(RNItems.WITHER_BONE.get()), conditionsFromItem(RNItems.WITHER_BONE.get()))
                .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                .criterion(hasItem(RNItems.SOUL_CRYSTAL.get()), conditionsFromItem(RNItems.SOUL_CRYSTAL.get()))
                .offerTo(exporter, new Identifier(getRecipeName(RNItems.NETHERITE_HAMMER.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RNItems.NETHERITE_CORE.get(), 1)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .input('B', Blocks.NETHERITE_BLOCK)
                .criterion(hasItem(Blocks.NETHERITE_BLOCK), conditionsFromItem(Blocks.NETHERITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(RNItems.NETHERITE_CORE.get())));


        registerSoulCrystalRecipe(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RNItems.NETHERITE_BOW.get(), 1)
                .pattern(" SN")
                .pattern("S N")
                .pattern(" SN")
                .input('S', Items.STICK)
                .input('N', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(RNItems.NETHERITE_BOW.get())));










    }
    @Deprecated(forRemoval = true)
    public static void registerSoulCrystalRecipe(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RNItems.SOUL_CRYSTAL.get(), 1)
                .pattern("SAS")
                .pattern("APA")
                .pattern("SAS")
                .input('S', Blocks.SOUL_SAND)
                .input('A', Items.AMETHYST_SHARD)
                .input('P', Blocks.PLAYER_HEAD)
                .criterion(hasItem(Blocks.SOUL_SAND), conditionsFromItem(Blocks.SOUL_SAND))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Blocks.PLAYER_HEAD), conditionsFromItem(Blocks.PLAYER_HEAD))
                .offerTo(exporter, new Identifier(getRecipeName(RNItems.SOUL_CRYSTAL.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.PLAYER_HEAD, 1)
                .pattern("LLL")
                .pattern("RCR")
                .pattern("LLL")
                .input('L', Items.LEATHER)
                .input('R', Items.REDSTONE)
                .input('C', RNItems.NETHERITE_CORE.get())
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(RNItems.NETHERITE_CORE.get()), conditionsFromItem(RNItems.NETHERITE_CORE.get()))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks.PLAYER_HEAD)));





    }


}


