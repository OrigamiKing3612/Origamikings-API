package net.origamiking.mcmods.oapi.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentUtils {
    /**
     * To use
     * <p>public static Enchantment ENCHANTMENT = registerEnchantment(ID, "name", new OrigamiEnchantment(Enchantment.Rarity.RARITY, EnchantmentTarget.ENCHANTMENTTARGET, EquipmentSlot.EQUIPMENTSLOT, minpower, maxlevel, effectLevel, StatusEffects.STATUSEFFECTS));</p>
     */
    public static Enchantment registerEnchantment(String id, String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(id, name), enchantment);
    }
}
