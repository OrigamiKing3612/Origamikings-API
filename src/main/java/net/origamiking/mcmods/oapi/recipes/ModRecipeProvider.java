package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.block.Blocks;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

import java.util.function.Consumer;

public class ModRecipeProvider  {
    private static ShapelessRecipeJsonBuilder createButtonRecipe(ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(output, 1).input(input);
    }
    public static void offerButtonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createButtonRecipe(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createBarRecipe(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 16).input('#', input).pattern("   ").pattern("###").pattern("###");
    }
    private static void offerBarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createBarRecipe(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createVerticalSlab(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 6).input('#', input).pattern("#  ").pattern("#  ").pattern("#  ");
    }
    public static void offerVerticalSlabRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createDoor(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 3).input('#', input).pattern("## ").pattern("## ").pattern("## ");
    }
    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createDoor(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createChest(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 1).input('#', input).pattern("###").pattern("# #").pattern("###");
    }
    public static void offerChestRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createChest(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createTrappedChest(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 1).input('#', input).input('T', Items.TRIPWIRE_HOOK).pattern("###").pattern("#T#").pattern("###");
    }
    public static void offerTrappedChestRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createTrappedChest(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static ShapelessRecipeJsonBuilder createWaxable(ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(output, 1).input(input).input(Items.HONEYCOMB);
    }
    public static void offerWaxableRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createWaxable(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    private static CraftingRecipeJsonBuilder createLantern(ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(output, 6).input('#', input).input('T', Blocks.TORCH).pattern("###").pattern("#T#").pattern("###");
    }
    public static void offerLanternRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createLantern(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
}
