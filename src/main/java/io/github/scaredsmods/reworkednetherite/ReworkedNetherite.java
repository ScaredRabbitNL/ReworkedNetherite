package io.github.scaredsmods.reworkednetherite;

import io.github.scaredsmods.reworkednetherite.block.RNBlocks;
import io.github.scaredsmods.reworkednetherite.enchantment.RNEnchantments;
import io.github.scaredsmods.reworkednetherite.fluid.RNLiquids;
import io.github.scaredsmods.reworkednetherite.item.RNItems;
import io.github.scaredsmods.reworkednetherite.world.gen.RNWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReworkedNetherite implements ModInitializer {

	public static final String MOD_ID = "reworked_netherite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		RNBlocks.BLOCKS.init();
		RNBlocks.LIQUIDS.init();
		RNItems.ITEMS.init();
		RNItems.BUCKETS.init();
		RNItems.TABS.init();
		RNEnchantments.ENCHANTMENTS.init();
		RNLiquids.FLUIDS.init();
		RNWorldGeneration.generateWorldGeneration();




	}
}