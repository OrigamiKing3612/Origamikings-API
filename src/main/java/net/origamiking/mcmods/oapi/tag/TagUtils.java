package net.origamiking.mcmods.oapi.tag;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class TagUtils {
    public static TagKey<Block> blockTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(id, tagId));
    }

    public static TagKey<Block> commonBlockTagKey(String tagId) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", tagId));
    }

    public static TagKey<Item> itemTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id, tagId));
    }

    public static TagKey<Item> commonItemTagKey(String tagId) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier("c", tagId));
    }

    public static TagKey<EntityType<?>> entityTypeTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(id, tagId));
    }

    public static TagKey<EntityType<?>> commonEntityTypeTagKey(String tagId) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("c", tagId));
    }

    public static TagKey<Biome> biomeTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(id, tagId));
    }

    public static TagKey<Biome> commonBiomeTagKey(String tagId) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier("c", tagId));
    }

    public static TagKey<Fluid> fluidTagKey(String id, String tagId) {
        return TagKey.of(RegistryKeys.FLUID, new Identifier(id, tagId));
    }

    public static TagKey<Fluid> commonFluidTagKey(String tagId) {
        return TagKey.of(RegistryKeys.FLUID, new Identifier("c", tagId));
    }
}
