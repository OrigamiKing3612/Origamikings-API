package net.origamiking.mcmods.oapi.advancement;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class AdvancementUtils {
    static class DataGenAdvancement {
        public static void advancement(Consumer<Advancement> advancementConsumer, String MOD_ID, Advancement mainParent, Item icon, String translatableTitle, String translatableDescription, @Nullable Identifier background, AdvancementFrame advancementFrame, boolean showToast, boolean announceToChat, boolean hidden, String fileName, ItemPredicate... items) {
            Advancement advancement = Advancement.Builder.create().parent(mainParent)
                    .display(icon, Text.translatable(translatableTitle), Text.translatable(translatableDescription), background, advancementFrame, showToast, announceToChat, hidden)
                    .criterion("criteria", InventoryChangedCriterion.Conditions.items(items))
                    .build(advancementConsumer, MOD_ID + fileName);
        }
    }
}
