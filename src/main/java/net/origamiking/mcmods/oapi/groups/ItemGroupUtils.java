package net.origamiking.mcmods.oapi.groups;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ItemGroupUtils {
    public static RegistryKey<ItemGroup> itemGroup(String modid, String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(modid, id));
    }
}
