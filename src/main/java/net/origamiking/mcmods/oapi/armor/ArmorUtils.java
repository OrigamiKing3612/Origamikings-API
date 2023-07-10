package net.origamiking.mcmods.oapi.armor;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ArmorUtils {
    /**To use
     * <p>public static final Item EXAMPLE = ArmorUtils.registerArmor(id, "name", new ArmorItem(ARMOR_MATERIAL, ArmorItem.Type.ARMOR_TYPE, new OrigamiItemSettings()));</p>
     */
    public static <I extends Item> I registerArmor(String id, String name, I item) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), item);
    }
}
