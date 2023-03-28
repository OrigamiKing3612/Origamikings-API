package net.origamiking.mcmods.oapi.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class EntityUtils {
    public static EntityType registerEntity(String id, String name, EntityType entity) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(id, name), entity);
    }
}
