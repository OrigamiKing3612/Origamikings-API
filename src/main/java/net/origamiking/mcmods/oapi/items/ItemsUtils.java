package net.origamiking.mcmods.oapi.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsUtils {
    /**
     * How to use. Just extend and use the methods or import `import static net.origamiking.mcmods.oapi.blocks.ItemUtils.*;`and use the methods
     */

    public static <I extends Item> I registerItem(String id, String name, I item) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), item);
    }
}
