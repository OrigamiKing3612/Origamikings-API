package net.origamiking.mcmods.oapi.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class OrigamiEnchantment extends Enchantment {
    public int minPower;
    public int maxLevel;
    public int effectLevel;
    public StatusEffect statusEffect;

    public OrigamiEnchantment(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot equipmentSlot, int minpower, int maxLevel, int effectLevel, StatusEffect statusEffect) {
        super(rarity, enchantmentTarget, new EquipmentSlot[]{equipmentSlot});
        this.minPower = minpower;
        this.maxLevel = maxLevel;
        this.effectLevel = effectLevel;
        this.statusEffect = statusEffect;
    }

    public OrigamiEnchantment(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot equipmentSlot, int minpower, int maxLevel) {
        super(rarity, enchantmentTarget, new EquipmentSlot[]{equipmentSlot});
        this.minPower = minpower;
        this.maxLevel = maxLevel;
    }

    @Override
    public int getMinPower(int level) {
        return this.minPower;
    }

    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void onTargetDamaged(LivingEntity user, Entity target) {
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(this.statusEffect, 20 * 2 * this.effectLevel, this.effectLevel - 1));
        }

        super.onTargetDamaged(user, target, this.effectLevel);
    }
}
