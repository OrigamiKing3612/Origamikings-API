package net.origamiking.mcmods.oapi.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlocksUtils {
    /**
     * How to use. Just extend and use the methods or import `import static net.origamiking.mcmods.oapi.blocks.BlocksUtils.*;`and use the methods
     */
    public static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), new BlockItem(block, new Item.Settings()));
    }
    public static <B extends Block> B registerBlock(String id, String name, B block) {
        BlocksUtils.registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }
    public static <B extends Block> B registerBlockWithOutBlockItem(String id, String name, B block) {
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }
}
