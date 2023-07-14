package net.origamiking.mcmods.oapi.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantmentUtils {
    /**
     * To use
     * <p>public static Enchantment ENCHANTMENT = registerEnchantment(ID, "name", new OrigamiEnchantment(Enchantment.Rarity.RARITY, EnchantmentTarget.ENCHANTMENTTARGET, EquipmentSlot.EQUIPMENTSLOT, minpower, maxlevel, effectLevel, StatusEffects.STATUSEFFECTS));</p>
     */

    public static <E extends Enchantment> E registerCustomEnchantment(String id, String name, E enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(id, name), enchantment);
    }
}
