package net.flokes.heartsofmagic;

import net.fabricmc.api.ClientModInitializer;
import net.flokes.heartsofmagic.screen.BagOfHoldingScreen;
import net.flokes.heartsofmagic.screen.ModScreenHandlerTypes;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class HeartsOfMagicClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

        HandledScreens.register(ModScreenHandlerTypes.BAG_OF_HOLDING, BagOfHoldingScreen::new);
	}
}