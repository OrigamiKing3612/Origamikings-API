package net.origamiking.mcmods.oapi.stats;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;

import static net.minecraft.stat.Stats.CUSTOM;

public class StatUtils {
    public static Identifier registerStat(String modid, String id, StatFormatter formatter) {
        Identifier identifier = new Identifier(modid, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }
}
