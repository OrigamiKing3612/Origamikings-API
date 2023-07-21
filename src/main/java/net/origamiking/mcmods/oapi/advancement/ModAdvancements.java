package net.origamiking.mcmods.oapi.advancement;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.advancement.criterion.Criteria;

public class ModAdvancements {
    public static WelcomeCriteria WELCOME = Criteria.register(new WelcomeCriteria());

    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, origin, destination) -> WELCOME.trigger(handler.player));
    }
}
