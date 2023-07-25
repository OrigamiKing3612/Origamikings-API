package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;

import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;
import static net.origamiking.mcmods.oapi.recipes.OrigamiRecipes.*;

public class ModRecipeProvider {
    public static void offerButtonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createButtonRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerBarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createBarRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerVerticalSlab(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createDoor(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerChestRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createChest(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerTrappedChestRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createTrappedChest(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerWaxableRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createWaxable(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerLanternRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createLantern(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offer3x3CompressAndUncompress(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCompress3x3(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncompress(input, Ingredient.ofItems(output), 9).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }

    public static void offer2x2CompressAndUncompress(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCompress2x2(output, Ingredient.ofItems(input)).criterion(hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        createUncompress(input, Ingredient.ofItems(output), 4).criterion(hasItem(output), RecipeProvider.conditionsFromItem(output)).offerTo(exporter);
    }

    public static void offer2x2Compress(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCompress2x2(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offer3x3Compress(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createCompress3x3(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerStair(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStair(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerSlab(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createSlab(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerHelmet(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createHelmet(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerChestplate(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createChestplate(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerLeggings(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createLeggings(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerBoots(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createBoots(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }


}
