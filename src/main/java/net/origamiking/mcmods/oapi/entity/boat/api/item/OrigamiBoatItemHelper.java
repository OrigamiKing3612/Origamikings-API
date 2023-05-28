package net.origamiking.mcmods.oapi.entity.boat.api.item;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.entity.boat.impl.item.OrigamiBoatDispenserBehavior;
import net.origamiking.mcmods.oapi.entity.boat.impl.item.OrigamiBoatItem;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiBoatEntity;

/**
 * This class provides utilities for the {@linkplain OrigamiBoatItem item forms} of {@linkplain OrigamiBoatType Origami boats},
 * such as {@linkplain #registerBoatItem(Identifier, RegistryKey, boolean, Item.Settings) registering them and their dispenser behavior}.
 */
public final class OrigamiBoatItemHelper {
    private OrigamiBoatItemHelper() {
        return;
    }

    /**
     * Registers a {@linkplain OrigamiBoatItem boat item}
     * and its corresponding {@link #registerBoatDispenserBehavior dispenser behavior}.
     *
     * <p>To register a boat item and its dispenser behavior:
     *
     * <pre>{@code
     *     OrigamiBoatItemHelper.registerBoatItem(new Identifier("examplemod", "azalea_boat"), MAHOGANY_BOAT_KEY, false);
     * }</pre>
     *
     * <p>This method should be called twice for a given boat type for both boats and chest boats.
     *
     * <p>This method does not define item groups for the item.
     *
     * @see #registerBoatItem(Identifier, RegistryKey, boolean, Item.Settings) Helper that allows specifying a custom item settings
     *
     * @param id the {@linkplain Identifier identifier} to register the item with
     * @param boatKey a {@linkplain RegistryKey registry key} for the {@linkplain OrigamiBoatType Origami boat type} that should be spawned by this item and dispenser behavior
     * @param chest whether the boat contains a chest
     */
    public static Item registerBoatItem(Identifier id, RegistryKey<OrigamiBoatType> boatKey, boolean chest) {
        return registerBoatItem(id, boatKey, chest, new Item.Settings().maxCount(1));
    }

    /**
     * Registers a {@linkplain OrigamiBoatItem boat item} and its corresponding {@link #registerBoatDispenserBehavior dispenser behavior}.
     *
     * <p>To register a boat item and its dispenser behavior:
     *
     * <pre>{@code
     *     OrigamiBoatItemHelper.registerBoatItem(new Identifier("examplemod", "azalea_boat"), MAHOGANY_BOAT_KEY, false, new Item.Settings().maxCount(1));
     * }</pre>
     *
     * <p>This method should be called twice for a given boat type for both boats and chest boats.
     *
     * <p>This method does not define item groups for the item.
     *
     * @param id the {@linkplain Identifier identifier} to register the item with
     * @param boatKey a {@linkplain RegistryKey registry key} for the {@linkplain OrigamiBoatType Origami boat type} that should be spawned by this item and dispenser behavior
     * @param chest whether the boat contains a chest
     */
    public static Item registerBoatItem(Identifier id, RegistryKey<OrigamiBoatType> boatKey, boolean chest, Item.Settings settings) {
        Item item = new OrigamiBoatItem(boatKey, chest, settings);
        Registry.register(Registries.ITEM, id, item);

        registerBoatDispenserBehavior(item, boatKey, chest);
        return item;
    }

    /**
     * Registers a {@linkplain net.minecraft.block.dispenser.DispenserBehavior dispenser behavior} that spawns a {@linkplain OrigamiBoatEntity boat entity} with a given {@linkplain OrigamiBoatEntity Origami boat type}.
     *
     * <p>To register a boat dispenser behavior:
     *
     * <pre>{@code
     *     OrigamiBoatItemHelper.registerBoatDispenserBehavior(AZALEA_BOAT_ITEM, AZALEA_BOAT_KEY, false);
     * }</pre>
     *
     * <p>This method should be called twice for a given boat type for both boats and chest boats.
     *
     * @param item the item that should be assigned to this dispenser behavior
     * @param boatKey a {@linkplain RegistryKey registry key} for the {@linkplain OrigamiBoatType Origami boat type} that should be spawned by this dispenser behavior
     * @param chest whether the boat contains a chest
     */
    public static void registerBoatDispenserBehavior(ItemConvertible item, RegistryKey<OrigamiBoatType> boatKey, boolean chest) {
        DispenserBlock.registerBehavior(item, new OrigamiBoatDispenserBehavior(boatKey, chest));
    }
}

