package net.origamiking.mcmods.oapi.groups;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ItemGroupUtils {
    public static void itemGroup(String modid, String id) {
        RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(modid, id));
    }
}
