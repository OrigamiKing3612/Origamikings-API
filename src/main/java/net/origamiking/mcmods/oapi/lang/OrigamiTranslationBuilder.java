package net.origamiking.mcmods.oapi.lang;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.origamiking.mcmods.oapi.armor.OrigamiArmorItem;

import static net.origamiking.mcmods.oapi.utils.OrigamiUtils.getName;

public class OrigamiTranslationBuilder {
    public void add(FabricLanguageProvider.TranslationBuilder translationBuilder, Item item) {
        translationBuilder.add(item, getName(item));
    }
    public void add(FabricLanguageProvider.TranslationBuilder translationBuilder, Block block) {
        translationBuilder.add(block, getName(block));
    }
    public <A extends ArmorItem> void add(FabricLanguageProvider.TranslationBuilder translationBuilder, A armorItem) {
        translationBuilder.add(armorItem, getName(armorItem));
    }
    public <A extends OrigamiArmorItem> void add(FabricLanguageProvider.TranslationBuilder translationBuilder, A armorItem) {
        translationBuilder.add(armorItem, getName(armorItem));
    }
}
