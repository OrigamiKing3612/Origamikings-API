package net.origamiking.mcmods.oapi.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EffectUtils {
    public static StatusEffect registerEffect(String id, String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(id, name), effect);
    }
}
