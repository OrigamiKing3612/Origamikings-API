package net.origamiking.mcmods.oapi.recipes;

import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeProvider /* extends RecipeProvider extends FabricRecipeProvider*/ {
//    public ModRecipeProvider(FabricDataOutput output) {super(output);}
    public static ShapelessRecipeJsonBuilder createButtonRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input);
    }
    public static void offerButtonRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createButtonRecipe(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static CraftingRecipeJsonBuilder createBarRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 16).input('#', input).pattern("   ").pattern("###").pattern("###");
    }
    public static void offerBarRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createBarRecipe(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static CraftingRecipeJsonBuilder createVerticalSlab(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 6).input('#', input).pattern("#  ").pattern("#  ").pattern("#  ");
    }
    public static void offerVerticalSlabRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static CraftingRecipeJsonBuilder createDoor(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3).input('#', input).pattern("## ").pattern("## ").pattern("## ");
    }
    public static void offerDoorRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createDoor(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static CraftingRecipeJsonBuilder createChest(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).pattern("###").pattern("# #").pattern("###");
    }
    public static void offerChestRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createChest(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static CraftingRecipeJsonBuilder createTrappedChest(RecipeCategory category, ItemConvertible output, Ingredient input) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input('#', input).input('T', Items.TRIPWIRE_HOOK).pattern("###").pattern("#T#").pattern("###");
    }
    public static void offerTrappedChestRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
        createTrappedChest(category, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    public static ShapelessRecipeJsonBuilder createWaxable(ItemConvertible output, Ingredient input) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1).input(input).input(Items.HONEYCOMB);
    }
    public static void offerWaxableRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createVerticalSlab(RecipeCategory.BUILDING_BLOCKS, output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
//    @Override
//    public void generate(Consumer<RecipeJsonProvider> exporter) {}
}
