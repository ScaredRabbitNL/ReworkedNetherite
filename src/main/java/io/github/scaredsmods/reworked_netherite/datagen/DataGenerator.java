package io.github.scaredsmods.reworked_netherite.datagen;

import io.github.scaredsmods.reworked_netherite.ReworkedNetherite;
import io.github.scaredsmods.reworked_netherite.datagen.client.RNBlockStateGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.client.RNItemStateGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.client.RNWorldGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.server.RNBlockTagGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.server.RNFluidTagGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.server.RNLootTableGenerator;
import io.github.scaredsmods.reworked_netherite.datagen.server.RNRecipeGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ReworkedNetherite.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new RNLootTableGenerator(packOutput));

        RNBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new RNBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new RNWorldGenerator(packOutput, lookupProvider));
        generator.addProvider(true, new RNBlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new RNItemStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new RNRecipeGenerator(packOutput));
        generator.addProvider(event.includeClient(), new RNFluidTagGenerator(packOutput, lookupProvider, existingFileHelper));
    }


}
