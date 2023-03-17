package net.origamiking.mcmods.oapi.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsUtils {
    /**
     * How to use. Just extend and use the methods or import `import static net.origamiking.mcmods.oapi.blocks.ItemUtils.registerItem;`and use the methods
     */
    public static Item registerItem(String id, String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), item);
    }
}
