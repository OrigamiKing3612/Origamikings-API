package net.origamiking.mcmods.oapi.advancement;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.OrigamiKingsApi;

import java.util.Optional;

public class WelcomeCriteria extends AbstractCriterion<WelcomeCriteria.Condition> {
    public static final Identifier ID = new Identifier(OrigamiKingsApi.MOD_ID, "welcome");

    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, condition -> true);
    }

    @Override
    protected Condition conditionsFromJson(JsonObject obj, Optional<LootContextPredicate> predicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Condition(predicate);
    }

    public static class Condition extends AbstractCriterionConditions {

        public Condition(Optional<LootContextPredicate> playerPredicate) {
            super(playerPredicate);
        }
    }
}