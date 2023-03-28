package net.origamiking.mcmods.oapi.armor;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorUtils {
    /**To use
     * <p>public static final Item EXAMPLE = ArmorUtils.registerArmor(id, "name", new ArmorItem(ARMOR_MATERIAL, ArmorItem.Type.ARMOR_TYPE, new Item.Settings()));</p>
     */

    public static Item registerArmor(String id, String name, Item armor) {
        return Registry.register(Registry.ITEM, new Identifier(id, name), armor);
    }
}
