package io.github.scaredsmods.reworked_netherite.datagen.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.block.RNBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class RNBlockStateGenerator extends BlockStateProvider {

    public RNBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ReworkedNetherite.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        RNBlocks.ORES.stream().forEach(this::basicBlock);

        basicBlock(RNBlocks.RAW_NETHERITE_BLOCK);



    }

    public void basicBlock(RegistryEntry<Block> block) {
        simpleBlockItem(block.get(), models().getBuilder(name(block.get())));
        simpleBlock(block);
    }

    public void basicBlock(RegistryEntry<Block> block, ModelFile model) {
        simpleBlockItem(block.get(), models().getBuilder(name(block.get())));
        simpleBlock(block.get(), model);
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }


    public void simpleBlock(RegistryEntry<Block> block) {
        simpleBlock(block.get(), cubeAll(block.get()));
    }


}
