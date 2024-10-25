package net.fox.kompistoservermod;

import net.fabricmc.api.ModInitializer;
import net.fox.kompistoservermod.block.ModBlocks;
import net.fox.kompistoservermod.entity.ModEntities;
import net.fox.kompistoservermod.item.ModItemGroups;
import net.fox.kompistoservermod.item.ModItems;
import net.fox.kompistoservermod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KompistoServerMod implements ModInitializer {
	public static final String MOD_ID = "kompisto-server-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void LOGGER(String s) {

	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + MOD_ID);
		ModEntities.registerEntities();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
	}
}