package net.origamiking.mcmods.oapi.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsUtils {
    /**
     * How to use. Just extend and use the methods or import `import static net.origamiking.mcmods.oapi.blocks.ItemUtils.registerItem;`and use the methods
     */
    public static Item registerItem(String id, String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(id, name), item);
    }
}
