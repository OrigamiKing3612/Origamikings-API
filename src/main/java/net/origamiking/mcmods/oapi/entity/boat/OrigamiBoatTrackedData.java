package net.origamiking.mcmods.oapi.entity.boat;

import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.network.PacketByteBuf;

import java.util.Optional;

public final class OrigamiBoatTrackedData {
    private OrigamiBoatTrackedData() {
        return;
    }

    public static final TrackedDataHandler<Optional<OrigamiBoatType>> HANDLER = TrackedDataHandler.ofOptional(OrigamiBoatTrackedData::write, OrigamiBoatTrackedData::read);

    private static void write(PacketByteBuf buf, OrigamiBoatType boat) {
        buf.writeRegistryValue(OrigamiBoatTypeRegistry.INSTANCE, boat);
    }

    private static OrigamiBoatType read(PacketByteBuf buf) {
        return buf.readRegistryValue(OrigamiBoatTypeRegistry.INSTANCE);
    }

    protected static void register() {
        TrackedDataHandlerRegistry.register(HANDLER);
    }
}