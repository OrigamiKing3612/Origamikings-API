package net.origamiking.mcmods.oapi.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class EntityUtils {
    public static EntityType registerEntity(String id, String name, EntityType entity) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(id, name), entity);
    }
}
