package io.github.scaredsmods.reworkednetherite.datagen.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class RNLootTableProvider extends FabricBlockLootTableProvider {

    public RNLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        add(RNBlocks.STONE_NETHERITE_ORE, createNetheriteOreDrops(RNBlocks.STONE_NETHERITE_ORE.get()));
        add(RNBlocks.DEEPSLATE_NETHERITE_ORE, createNetheriteOreDrops(RNBlocks.DEEPSLATE_NETHERITE_ORE.get()));
        add(RNBlocks.NETHERITE_ORE, createNetheriteOreDrops(RNBlocks.NETHERITE_ORE.get()));
        add(RNBlocks.END_STONE_NETHERITE_ORE, createNetheriteOreDrops(RNBlocks.END_STONE_NETHERITE_ORE.get()));

        dropSelf(RNBlocks.RAW_NETHERITE_BLOCK.get());
    }

    protected LootTable.Builder createNetheriteOreDrops(Block block) {
        return BlockLootSubProvider.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        ((LootPoolSingletonContainer.Builder<?>)
                                LootItem.lootTableItem(RNItems.RAW_NETHERITE.get()).
                                        apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

     void add(RegistryEntry<Block> block, LootTable.Builder builder) {
        this.map.put(block.get().getLootTable(), builder);
    }



}
