package net.origamiking.mcmods.oapi.dimension;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;

public class DimensionUtils {
    public static String getCurrentDimension() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();

        if (minecraftClient != null && minecraftClient.world != null && minecraftClient.player != null) {
            ClientWorld clientWorld = minecraftClient.world;
            return clientWorld.getDimension().toString();
        }

        return null;
    }
}
