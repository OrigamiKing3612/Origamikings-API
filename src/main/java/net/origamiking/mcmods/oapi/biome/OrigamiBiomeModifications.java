package net.origamiking.mcmods.oapi.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class OrigamiBiomeModifications {
    public static void addOverworldFeature(GenerationStep.Feature feature, RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), feature, key);
    }

    public static void addOverworldUndergroundOre(RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, key);
    }

    public static void addNetherFeature(GenerationStep.Feature feature, RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), feature, key);
    }

    public static void addNetherUndergroundOre(RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, key);
    }

    public static void addEndFeature(GenerationStep.Feature feature, RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), feature, key);
    }

    public static void addEndUndergroundOre(RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, key);
    }

    public static void addFeature(Predicate<BiomeSelectionContext> biomeSelectors, GenerationStep.Feature feature, RegistryKey<PlacedFeature> key) {
        BiomeModifications.addFeature(biomeSelectors, feature, key);
    }
}
