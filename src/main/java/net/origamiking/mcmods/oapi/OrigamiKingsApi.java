package net.origamiking.mcmods.oapi;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrigamiKingsApi implements ModInitializer {
	public static final String MOD_ID = "origamikings-api";
	public static final Logger LOGGER = LoggerFactory.getLogger("origamikings-api");

	@Override
	public void onInitialize() {

		OrigamiKingsApi.LOGGER.info("Starting OrigamiKing's API");
	}
}