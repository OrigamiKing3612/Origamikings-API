package net.origamiking.mcmods.oapi.groups;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ItemGroupUtils {
    public static RegistryKey<ItemGroup> itemGroup(String modid, String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(modid, id));
    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, ItemGroupEvents.ModifyEntries item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(item);
    }
    public static void addToItemGroup(RegistryKey<ItemGroup> group, ItemGroupEvents.ModifyEntries ... items) {
        for (ItemGroupEvents.ModifyEntries item : items) {
            ItemGroupEvents.modifyEntriesEvent(group).register(item);
        }
    }
}
