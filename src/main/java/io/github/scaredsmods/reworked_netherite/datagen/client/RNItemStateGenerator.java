package io.github.scaredsmods.reworked_netherite.datagen.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.item.RNItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class RNItemStateGenerator extends ItemModelProvider {


    public RNItemStateGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ReworkedNetherite.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

       basicItemRN(RNItems.RAW_NETHERITE);
       basicItemRN(RNItems.SOUL_CRYSTAL);
       basicItemRN(RNItems.WITHER_BONE);
       basicItemRN(RNItems.FLAT_NETHERITE_INGOT);
       basicItemRN(RNItems.MOLTEN_NETHERITE_BUCKET);

    }
    public ItemModelBuilder basicItemRN(RegistryEntry<Item> item) {
        return basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item.get())));
    }



}
