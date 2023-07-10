package net.origamiking.mcmods.oapi.tag;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagUtils {
    public static TagKey<Block> blockTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id, tagId));
    }
    public static TagKey<Item> itemTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id, tagId));
    }
    public static TagKey<EntityType<?>> entityTypeTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(id, tagId));
    }
}
