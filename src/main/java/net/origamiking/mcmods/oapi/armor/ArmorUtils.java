package net.origamiking.mcmods.oapi.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ArmorUtils {
    /**
     * To use
     * <p>public static final Item EXAMPLE = ArmorUtils.registerArmor(id, "name", new ArmorItem(ARMOR_MATERIAL, ArmorItem.Type.ARMOR_TYPE, new OrigamiItemSettings()));</p>
     */
    public static <I extends Item> I registerArmor(String id, String name, I item) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), item);
    }

    public static <P extends PlayerEntity> Item getHelmetItem(P player) {
        return player.getEquippedStack(EquipmentSlot.HEAD).getItem();
    }

    public static <P extends PlayerEntity> Item getChestplateItem(P player) {
        return player.getEquippedStack(EquipmentSlot.CHEST).getItem();
    }

    public static <P extends PlayerEntity> Item getLeggingsItem(P player) {
        return player.getEquippedStack(EquipmentSlot.LEGS).getItem();
    }

    public static <P extends PlayerEntity> Item getBootsItem(P player) {
        return player.getEquippedStack(EquipmentSlot.FEET).getItem();
    }

    public static <P extends PlayerEntity> boolean isArmorSetOfType(P player, Class<? extends ArmorItem> armorItem) {
        return isInstanceOf(getHelmetItem(player), armorItem) && isInstanceOf(getChestplateItem(player), armorItem) && isInstanceOf(getLeggingsItem(player), armorItem) && isInstanceOf(getBootsItem(player), armorItem);
    }

    public static boolean isInstanceOf(Item item, Class<? extends ArmorItem> armorItem) {
        return armorItem.isInstance(item);
    }
}
