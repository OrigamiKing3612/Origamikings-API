package net.origamiking.mcmods.oapi.registry;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class OrigamiBlockRegistries {
    public static void registerStrippable(Block log, Block stripped_log) {
        StrippableBlockRegistry.register(log, stripped_log);
    }

    public static void registerFlammableBlocks(Block flameableBlock, int burn, int spread) {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(flameableBlock, burn, spread);
    }

    public static void registerFlammableBlocks(Block flameableBlock) {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(flameableBlock, 5, 5);
    }

    public static void registerCompostableBlocks(Item compostableItem, float chance) {
        CompostingChanceRegistry.INSTANCE.add(compostableItem, chance);
    }
}

