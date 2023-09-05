package net.origamiking.mcmods.oapi.advancement;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.advancement.criterion.Criteria;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public class ModAdvancements {
    public static final WelcomeCriteria WELCOME = Criteria.register(OrigamiKingsApi.MOD_ID + ":welcome", new WelcomeCriteria());

    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, origin, destination) -> WELCOME.trigger(handler.player));
    }
}
