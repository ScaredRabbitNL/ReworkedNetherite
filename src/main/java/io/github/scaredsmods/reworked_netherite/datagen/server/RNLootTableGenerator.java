package io.github.scaredsmods.reworked_netherite.datagen.server;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class RNLootTableGenerator extends LootTableProvider{


    public RNLootTableGenerator(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(RNBlockLootTableGenerator::new, LootContextParamSets.BLOCK)));
    }


}
