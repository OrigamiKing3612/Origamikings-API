package net.origamiking.mcmods.oapi.armor;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ArmorUtils {
    /**To use
     * <p>public static final Item EXAMPLE = ArmorUtils.registerArmor(id, "name", new ArmorItem(ARMOR_MATERIAL, ArmorItem.Type.ARMOR_TYPE, new OrigamiItemSettings()));</p>
     */
    public static <I extends Item> I registerArmor(String id, String name, I item) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), item);
    }
    public static Item getHelmetItem(ServerPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.HEAD).getItem();
    }
    public static Item getChestplateItem(ServerPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.CHEST).getItem();
    }
    public static Item getLeggingsItem(ServerPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.LEGS).getItem();
    }
    public static Item getBootsItem(ServerPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.FEET).getItem();
    }
    public static Item getHelmetItem(ClientPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.HEAD).getItem();
    }
    public static Item getChestplateItem(ClientPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.CHEST).getItem();
    }
    public static Item getLeggingsItem(ClientPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.LEGS).getItem();
    }
    public static Item getBootsItem(ClientPlayerEntity player) {
        return player.getEquippedStack(EquipmentSlot.FEET).getItem();
    }
}
