package net.origamiking.mcmods.oapi;

import net.fabricmc.api.ModInitializer;

import net.origamiking.mcmods.oapi.commands.ModCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrigamiKingsApi implements ModInitializer {
	public static final String MOD_ID = "origamikings-api";
	public static final Logger LOGGER = LoggerFactory.getLogger("origamikings-api");
	public static final String VERSION ="0.1.6-1.19.4";

	@Override
	public void onInitialize() {
		OrigamiKingsApi.LOGGER.info("Starting OrigamiKing's API");
		ModCommands.registerCommands();
	}
}