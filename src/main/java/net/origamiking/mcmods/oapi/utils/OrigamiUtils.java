package net.origamiking.mcmods.oapi.utils;

import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.armor.OrigamiArmorItem;

import static net.origamiking.mcmods.oapi.utils.OrigamiStringUtils.capitalize;

public class OrigamiUtils {
    public static String getId(String name) {
        return name.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public static String getName(Identifier id) {
        return capitalize(id.getPath().replace("_", " "));
    }

    public static String getName(String id) {
        return capitalize(id.replace("_", " "));
    }

    public static String getName(Item item) {
        return capitalize(Registries.ITEM.getId(item).getPath().replace("_", " "));
    }
    public static String getName(Block block) {
        return capitalize(Registries.BLOCK.getId(block).getPath().replace("_", " "));
    }
    public static <A extends ArmorItem> String getName(A armorItem) {
        return capitalize(Registries.ITEM.getId(armorItem).getPath().replace("_", " "));
    }
    public static <A extends OrigamiArmorItem> String getName(A armorItem) {
        return capitalize(Registries.ITEM.getId(armorItem).getPath().replace("_", " "));
    }
}
