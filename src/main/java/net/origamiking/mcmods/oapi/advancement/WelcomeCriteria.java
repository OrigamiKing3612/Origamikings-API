package net.origamiking.mcmods.oapi.advancement;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

public class WelcomeCriteria extends AbstractCriterion<WelcomeCriteria.Condition> {
    public static final Identifier ID = new Identifier(OrigamiKingsApi.MOD_ID, "welcome");

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, condition -> true);
    }

    @Override
    protected Condition conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Condition();
    }

    public static class Condition extends AbstractCriterionConditions {

        public Condition() {
            super(ID, LootContextPredicate.EMPTY);
        }
    }
}