package net.origamiking.mcmods.oapi.items;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    public static Item registerBucketItem(String id, String name, FlowableFluid still) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), new BucketItem(still, new OrigamiItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
