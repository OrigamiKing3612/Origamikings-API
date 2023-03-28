package net.origamiking.mcmods.oapi.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksUtils {
    /**
     * How to use. Just extend and use the methods or import `import static net.origamiking.mcmods.oapi.blocks.BlocksUtils.registerBlock;`and use the methods
     */

    private static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(id, name), new BlockItem(block, new Item.Settings()));
    }
    public static Block registerBlock(String id, String name, Block block) {
        registerBlockItem(id, name, block);
        return Registry.register(Registry.BLOCK, new Identifier(id, name), block);
    }
}
