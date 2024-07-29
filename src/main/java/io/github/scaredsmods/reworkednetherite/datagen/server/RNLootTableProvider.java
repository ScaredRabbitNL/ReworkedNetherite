package io.github.scaredsmods.reworkednetherite.datagen.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;


public class RNLootTableProvider extends FabricBlockLootTableProvider {

    public RNLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        RNBlocks.ORES.stream().map(RegistryEntry::get).forEach(block -> addDrop(block, createNetheriteOreDrops(block)));
        drops(RNBlocks.RAW_NETHERITE_BLOCK.get());
    }


    public LootTable.Builder createNetheriteOreDrops(Block drop) {
        return dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(RNItems.RAW_NETHERITE.get())
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }






}
