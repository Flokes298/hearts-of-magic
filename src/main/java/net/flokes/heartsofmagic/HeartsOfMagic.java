package net.flokes.heartsofmagic;

import net.fabricmc.api.ModInitializer;

import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.component.ModComponents;
import net.flokes.heartsofmagic.item.ModItems;
import net.flokes.heartsofmagic.screen.ModScreenHandlerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeartsOfMagic implements ModInitializer {
	public static final String MOD_ID = "hearts-of-magic";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading Hearts of Magic Mod");

        ModComponents.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
        ModScreenHandlerTypes.initialize();
	}
}