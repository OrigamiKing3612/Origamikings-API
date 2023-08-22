package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

public class OrigamiRecipes {
    protected static OrigamiShapelessRecipeJsonBuilder createButtonRecipe(ItemConvertible output, Ingredient input) {
        return OrigamiShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input);
    }

    protected static CraftingRecipeJsonBuilder createBarRecipe(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 16).input('#', input).pattern("   ").pattern("###").pattern("###");
    }

    protected static CraftingRecipeJsonBuilder createVerticalSlab(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).pattern("#  ").pattern("#  ").pattern("#  ");
    }

    protected static CraftingRecipeJsonBuilder createDoor(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3).input('#', input).pattern("## ").pattern("## ").pattern("## ");
    }

    protected static CraftingRecipeJsonBuilder createChest(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("###").pattern("# #").pattern("###");
    }

    protected static CraftingRecipeJsonBuilder createTrappedChest(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).input('T', Items.TRIPWIRE_HOOK).pattern("###").pattern("#T#").pattern("###");
    }

    protected static OrigamiShapelessRecipeJsonBuilder createWaxable(ItemConvertible output, Ingredient input) {
        return OrigamiShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input).input(Items.HONEYCOMB);
    }

    protected static CraftingRecipeJsonBuilder createLantern(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).input('T', Blocks.TORCH).pattern("###").pattern("#T#").pattern("###");
    }

    protected static CraftingRecipeJsonBuilder createCompress3x3(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("###").pattern("###").pattern("###");
    }

    protected static CraftingRecipeJsonBuilder createCompress2x2(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("##").pattern("##");
    }

    protected static OrigamiShapelessRecipeJsonBuilder createUncompress(ItemConvertible output, Ingredient input, int count) {
        return OrigamiShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, count).input(input);
    }

    protected static CraftingRecipeJsonBuilder createStair(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('I', input).pattern("I  ").pattern("II ").pattern("III");
    }

    protected static CraftingRecipeJsonBuilder createSlab(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('I', input).pattern("III");
    }

    protected static CraftingRecipeJsonBuilder createHelmet(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('I', input).pattern("III").pattern("I I");
    }

    protected static CraftingRecipeJsonBuilder createChestplate(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('I', input).pattern("I I").pattern("III").pattern("III");
    }

    protected static CraftingRecipeJsonBuilder createLeggings(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('I', input).pattern("III").pattern("I I").pattern("I I");
    }

    protected static CraftingRecipeJsonBuilder createBoots(ItemConvertible output, Ingredient input) {
        return OrigamiShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1).input('I', input).pattern("I I");
    }
}
