package io.github.scaredsmods.reworked_netherite.datagen.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import io.github.scaredsmods.reworked_netherite.item.RNItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Supplier;

public class RNBlockLootTableGenerator extends BlockLootSubProvider {

    private static final Set<Supplier<Block>> DOESNT_DROP_SELF = Set.of(
            RNBlocks.STONE_NETHERITE_ORE,
            RNBlocks.DEEPSLATE_NETHERITE_ORE,
            RNBlocks.NETHERITE_ORE,
            RNBlocks.END_STONE_NETHERITE_ORE
    );

    public RNBlockLootTableGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {

        RNBlocks.BLOCKS.stream()
                .filter(b -> !DOESNT_DROP_SELF.contains(b))
                .map(RegistryEntry::get)
                .forEach(this::dropSelf);

        RNBlocks.ORES.stream()
                .map(RegistryEntry::get)
                .forEach(block -> add(block, createNetheriteOreDrops(block)));
    }

    protected LootTable.Builder createNetheriteOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(RNItems.RAW_NETHERITE.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                )
        );
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RNBlocks.BLOCKS.getEntries().stream().map(RegistryEntry::get)::iterator;
    }




}
