package net.origamiking.mcmods.oapi.entity.boat.api;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;

public class OrigamiBoatTypeRegistry {
        private static final Identifier REGISTRY_ID = new Identifier(OrigamiKingsApi.MOD_ID);

        /**
         * The registry for {@linkplain OrigamiBoatType boats}.
         *
         *
         * <p>To register a boat type:
         *
         * <pre>{@code
         *     Registry.register(OrigamiBoatType.REGISTRY, new Identifier("examplemod", "azalea"), boat);
         * }</pre>
         *
         * @see OrigamiBoatType.Builder The builder for boat types
         */
        public static final Registry<OrigamiBoatType> INSTANCE = FabricRegistryBuilder.createSimple(OrigamiBoatType.class, REGISTRY_ID).buildAndRegister();

        public static RegistryKey<OrigamiBoatType> createKey(Identifier id) {
            return RegistryKey.of(INSTANCE.getKey(), id);
        }
}
