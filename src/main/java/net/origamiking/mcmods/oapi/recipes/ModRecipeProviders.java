package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;

import static net.origamiking.mcmods.oapi.recipes.ModRecipeProvider.*;

public class ModRecipeProviders {
    public static void offerSlabs(RecipeExporter exporter, Block slab, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab, block, 2);
        offerSlab(exporter, slab, block);
    }

    public static void offerVerticalSlabs(RecipeExporter exporter, Block vertical_slab, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, vertical_slab, block, 2);
        offerVerticalSlab(exporter, vertical_slab, block);
    }

    public static void offerCarpets(RecipeExporter exporter, Block carpet, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, carpet, block, 8);
        RecipeProvider.offerCarpetRecipe(exporter, carpet, block);
    }

    public static void offerStairs(RecipeExporter exporter, Block stair, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, stair, block);
        offerStair(exporter, stair, block);
    }

    public static void offerWalls(RecipeExporter exporter, Block wall, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, block);
        RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, block);
    }

    public static void offerBlocks(RecipeExporter exporter, Block block, Item item, boolean compress3x3, boolean uncompress) {
        if (uncompress) {
            if (compress3x3) {
                offer3x3CompressAndUncompress(exporter, block, item);
            } else {
                offer2x2CompressAndUncompress(exporter, block, item);
            }
        } else {
            if (compress3x3) {
                offer3x3Compress(exporter, block, item);
            } else {
                offer2x2Compress(exporter, block, item);
            }
        }
    }

    public static void offerBlockSet(RecipeExporter exporter, Block block, Block slab, Block stair, Block wall) {
        offerSlabs(exporter, slab, block);
        offerStairs(exporter, stair, block);
        offerWalls(exporter, wall, block);
    }

    public static void offerBlockSet(RecipeExporter exporter, Block block, Block slab, Block stair) {
        offerSlabs(exporter, slab, block);
        offerStairs(exporter, stair, block);
    }

    public static void offerBlockSet(RecipeExporter exporter, Block block, Block slab, Block stair, Block wall, Item item, boolean is2x2) {
        offerSlabs(exporter, slab, block);
        offerStairs(exporter, stair, block);
        offerWalls(exporter, wall, block);
        offerBlocks(exporter, block, item, !is2x2, true);
    }

    public static void offerBlockSet(RecipeExporter exporter, Block block, Block slab, Block stair, Item item, boolean is2x2) {
        offerSlabs(exporter, slab, block);
        offerStairs(exporter, stair, block);
        offerBlocks(exporter, block, item, !is2x2, true);
    }

    public static void offerChests(RecipeExporter exporter, Block chest, Block trapped_chest, Block planks) {
        offerChestRecipe(exporter, chest, planks);
        offerTrappedChestRecipe(exporter, trapped_chest, planks);
    }

    public static void offerArmorSet(RecipeExporter exporter, Item input, Item helmet, Item chestplate, Item leggings, Item boots) {
        offerHelmet(exporter, helmet, input);
        offerChestplate(exporter, chestplate, input);
        offerLeggings(exporter, leggings, input);
        offerBoots(exporter, boots, input);
    }
}
