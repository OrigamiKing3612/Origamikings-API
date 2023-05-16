package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class ModRecipeProvider {
    private static ShapelessRecipeJsonBuilder createButtonRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input);
    }
    public static void offerButtonRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createButtonRecipe(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createBarRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 16).input('#', input).pattern("   ").pattern("###").pattern("###");
    }
    public static void offerBarRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createBarRecipe(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createVerticalSlab(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).pattern("#  ").pattern("#  ").pattern("#  ");
    }
    public static void offerVerticalSlabRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createDoor(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3).input('#', input).pattern("## ").pattern("## ").pattern("## ");
    }
    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createDoor(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createChest(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("###").pattern("# #").pattern("###");
    }
    public static void offerChestRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createChest(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createTrappedChest(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).input('T', Items.TRIPWIRE_HOOK).pattern("###").pattern("#T#").pattern("###");
    }
    public static void offerTrappedChestRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createTrappedChest(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static ShapelessRecipeJsonBuilder createWaxable(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input).input(Items.HONEYCOMB);
    }
    public static void offerWaxableRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createWaxable(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createLantern(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).input('T', Blocks.TORCH).pattern("###").pattern("#T#").pattern("###");
    }
    public static void offerLanternRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createLantern(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createCommpress3x3(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("###").pattern("###").pattern("###");
    }
    private static CraftingRecipeJsonBuilder createCommpress2x2(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("##").pattern("##");
    }
    private static ShapelessRecipeJsonBuilder createUncommpress(RecipeCategory category, ItemConvertible output, Ingredient input, int count) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, count).input(input);
    }
    public static void offer3x3CommpressandUncommpress(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createCommpress3x3(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncommpress(category, input, Ingredient.ofItems(output), 9).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }
    public static void offer2x2CommpressandUncommpress(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createCommpress2x2(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncommpress(category, input, Ingredient.ofItems(output), 4).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }
}
