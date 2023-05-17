package net.origamiking.mcmods.oapi.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityUtils {
    public static <B extends Block> B registerBlock(String id, String name, B block) {
        return register(block, new Identifier(id, name));
    }
    private static <B extends Block> B register(B block, Identifier name) {
        Registry.register(Registries.BLOCK, name, block);
        BlockItem item = new BlockItem(block, (new Item.Settings()));

        item.appendBlocks(Item.BLOCK_ITEMS, item);
        Registry.register(Registries.ITEM, name, item);
        return block;
    }
}
