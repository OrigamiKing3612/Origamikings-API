package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

import static net.origamiking.mcmods.oapi.recipes.ModRecipeProvider.*;

public class ModRecipeHelpers {
    public static void offerSlabs(Consumer<RecipeJsonProvider> exporter, Block slab, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, slab, block, 2);
        offerSlab(exporter, slab, block);
    }
    public static void offerStairs(Consumer<RecipeJsonProvider> exporter, Block stair, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, stair, block);
        offerStair(exporter, stair, block);
    }
    public static void offerWalls(Consumer<RecipeJsonProvider> exporter, Block wall, Block block) {
        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, block);
        RecipeProvider.offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, wall, block);
    }
    public static void offerBlocks(Consumer<RecipeJsonProvider> exporter, Block block, Item item, boolean compress3x3, boolean uncompress) {
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
}
