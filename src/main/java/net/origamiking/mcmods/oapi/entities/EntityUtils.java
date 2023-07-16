package net.origamiking.mcmods.oapi.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class EntityUtils {
    public static<I extends LivingEntity> EntityType<I> registerEntity(String id, String name, EntityType<I> entity) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(id, name), entity);
    }
    public static <T extends MobEntity> EntityType<T> registerEntity(String id, String name, EntityType.EntityFactory<T> entity, float width, float height, SpawnGroup spawnGroup) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(id, name), FabricEntityTypeBuilder.create(spawnGroup, entity).dimensions(EntityDimensions.changing(width, height)).build());
    }

}
