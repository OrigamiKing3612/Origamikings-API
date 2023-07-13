package net.origamiking.mcmods.oapi.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class EntityUtils {
    public static<I extends LivingEntity> EntityType<I> registerEntity(String id, String name, EntityType<I> entity) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(id, name), entity);
    }
}
