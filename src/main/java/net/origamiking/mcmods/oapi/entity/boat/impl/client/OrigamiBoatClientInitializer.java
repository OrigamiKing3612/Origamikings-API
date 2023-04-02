package net.origamiking.mcmods.oapi.entity.boat.impl.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.origamiking.mcmods.oapi.entity.boat.impl.OrigamiBoatInitializer;

@Environment(EnvType.CLIENT)
public final class OrigamiBoatClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(OrigamiBoatInitializer.BOAT, context -> new OrigamiBoatEntityRenderer(context, false));
        EntityRendererRegistry.register(OrigamiBoatInitializer.CHEST_BOAT, context -> new OrigamiBoatEntityRenderer(context, true));
    }
}
