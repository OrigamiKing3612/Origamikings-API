package net.origamiking.mcmods.oapi.items;

import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

/**
 * My version of {@code Item.Settings} and {@code FabricItemSettings}.
 *
 * <p>To use it, simply replace {@code new Item.Settings()} or {@code new FabricItemSettings()} with
 * {@code new OrigamiItemSettings()}.
 */

public class OrigamiItemSettings extends FabricItemSettings {
    private int fuelTime;
    private float compostingChance;

    public OrigamiItemSettings() {
        super();
    }

    public int getFuelTime() {
        return fuelTime;
    }

    public float getCompostingChance() {
        return compostingChance;
    }

    /**
     * Sets the fuel time of this item. This is used by furnace-like blocks.
     */
    public OrigamiItemSettings fuelTime(int fuelTime) {
        this.fuelTime = fuelTime;
        return this;
    }

    /**
     * Sets the composting chance of this item. This is used by the composter block.
     */
    public OrigamiItemSettings compostingChance(float compostingChance) {
        this.compostingChance = compostingChance;
        return this;
    }

    @Override
    public OrigamiItemSettings food(FoodComponent foodComponent) {
        super.food(foodComponent);
        return this;
    }

    @Override
    public OrigamiItemSettings maxCount(int maxCount) {
        super.maxCount(maxCount);
        return this;
    }

    @Override
    public OrigamiItemSettings maxDamageIfAbsent(int maxDamage) {
        super.maxDamageIfAbsent(maxDamage);
        return this;
    }

    @Override
    public OrigamiItemSettings maxDamage(int maxDamage) {
        super.maxDamage(maxDamage);
        return this;
    }

    @Override
    public OrigamiItemSettings recipeRemainder(Item recipeRemainder) {
        super.recipeRemainder(recipeRemainder);
        return this;
    }

    @Override
    public OrigamiItemSettings rarity(Rarity rarity) {
        super.rarity(rarity);
        return this;
    }

    @Override
    public OrigamiItemSettings fireproof() {
        super.fireproof();
        return this;
    }

    @Override
    public OrigamiItemSettings equipmentSlot(EquipmentSlotProvider equipmentSlotProvider) {
        super.equipmentSlot(equipmentSlotProvider);
        return this;
    }

    @Override
    public OrigamiItemSettings customDamage(CustomDamageHandler handler) {
        super.customDamage(handler);
        return this;
    }
}
