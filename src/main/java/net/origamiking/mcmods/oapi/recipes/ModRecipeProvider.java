package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;

import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;
import static net.origamiking.mcmods.oapi.recipes.OrigamiRecipes.*;

public class ModRecipeProvider {
    public static void offerButtonRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createButtonRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerBarRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createBarRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerVerticalSlab(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerDoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createDoor(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerChestRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createChest(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerTrappedChestRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createTrappedChest(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerWaxableRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createWaxable(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerLanternRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createLantern(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offer3x3CompressAndUncompress(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createCompress3x3(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncompress(input, Ingredient.ofItems(output), 9).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }

    public static void offer2x2CompressAndUncompress(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createCompress2x2(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncompress(input, Ingredient.ofItems(output), 4).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }

    public static void offer2x2Compress(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createCompress2x2(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offer3x3Compress(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createCompress3x3(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerStair(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStair(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerSlab(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createSlab(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerHelmet(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createHelmet(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerChestplate(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createChestplate(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerLeggings(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createLeggings(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerBoots(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createBoots(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }


}
