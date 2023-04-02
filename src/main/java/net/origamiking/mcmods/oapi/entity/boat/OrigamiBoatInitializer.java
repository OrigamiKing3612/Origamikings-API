package net.origamiking.mcmods.oapi.entity.boat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public final class OrigamiBoatInitializer implements ModInitializer {
    private static final EntityDimensions DIMENSIONS = EntityDimensions.fixed(1.375f, 0.5625f);
    private static final Registry<OrigamiBoatType> registryInstance = OrigamiBoatTypeRegistry.INSTANCE;

    private static final Identifier BOAT_ID = new Identifier(OrigamiKingsApi.MOD_ID, "boat");
    public static final EntityType<OrigamiBoatEntity> BOAT = FabricEntityTypeBuilder.<OrigamiBoatEntity>create(SpawnGroup.MISC, OrigamiBoatEntity::new)
            .dimensions(DIMENSIONS)
            .build();

    private static final Identifier CHEST_BOAT_ID = new Identifier(OrigamiKingsApi.MOD_ID, "chest_boat");
    public static final EntityType<OrigamiChestBoatEntity> CHEST_BOAT = FabricEntityTypeBuilder.<OrigamiChestBoatEntity>create(SpawnGroup.MISC, OrigamiChestBoatEntity::new)
            .dimensions(DIMENSIONS)
            .build();

    @Override
    public void onInitialize() {
        OrigamiBoatTrackedData.register();
        Registry.register(Registries.ENTITY_TYPE, BOAT_ID, BOAT);
        Registry.register(Registries.ENTITY_TYPE, CHEST_BOAT_ID, CHEST_BOAT);
    }
}
