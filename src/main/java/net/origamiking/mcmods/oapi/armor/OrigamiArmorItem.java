package net.origamiking.mcmods.oapi.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class OrigamiArmorItem extends ArmorItem implements IOrigamiArmorItem {

    protected OrigamiArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    public static String armorItemName() {
        return "armorItemName";
    }

    public static String armorItemId() {
        return "armor_item_id";
    }

    @Override
    public String armorName() {
        return "armorName";
    }

    @Override
    public String armorId() {
        return "armor_id";
    }
}
