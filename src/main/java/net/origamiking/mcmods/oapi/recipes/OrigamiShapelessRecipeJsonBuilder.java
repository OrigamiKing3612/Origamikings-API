//package net.origamiking.mcmods.oapi.recipes;
//
//import com.google.common.collect.Lists;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import net.minecraft.advancement.Advancement;
//import net.minecraft.advancement.AdvancementRewards;
//import net.minecraft.advancement.criterion.CriterionConditions;
//import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
//import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
//import net.minecraft.data.server.recipe.RecipeJsonBuilder;
//import net.minecraft.data.server.recipe.RecipeJsonProvider;
//import net.minecraft.data.server.recipe.RecipeProvider;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemConvertible;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.recipe.RecipeSerializer;
//import net.minecraft.recipe.book.CraftingRecipeCategory;
//import net.minecraft.recipe.book.RecipeCategory;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.tag.TagKey;
//import net.minecraft.util.Identifier;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//import java.util.function.Consumer;
//
//public class OrigamiShapelessRecipeJsonBuilder extends RecipeJsonBuilder implements CraftingRecipeJsonBuilder {
//    private final RecipeCategory category;
//    private final Item output;
//    private final int count;
//    private final List<Ingredient> inputs = Lists.newArrayList();
//    private final Advancement.Builder advancementBuilder = Advancement.Builder.createUntelemetered();
//    @Nullable
//    private String group;
//
//    public OrigamiShapelessRecipeJsonBuilder(RecipeCategory category, ItemConvertible output, int count) {
//        this.category = category;
//        this.output = output.asItem();
//        this.count = count;
//    }
//
//    public static OrigamiShapelessRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output) {
//        return new OrigamiShapelessRecipeJsonBuilder(category, output, 1);
//    }
//
//    public static OrigamiShapelessRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count) {
//        return new OrigamiShapelessRecipeJsonBuilder(category, output, count);
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder input(TagKey<Item> tag) {
//        return this.input(Ingredient.fromTag(tag));
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder input(ItemConvertible itemProvider) {
//        return this.input(itemProvider, 1);
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder inputWithCriterion(ItemConvertible itemProvider) {
//        criterion(RecipeProvider.hasItem(itemProvider), RecipeProvider.conditionsFromItem(itemProvider));
//        return this.input(itemProvider, 1);
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
//        for (int i = 0; i < size; ++i) {
//            this.input(Ingredient.ofItems(itemProvider));
//        }
//        return this;
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder input(Ingredient ingredient) {
//        return this.input(ingredient, 1);
//    }
//
//    public OrigamiShapelessRecipeJsonBuilder input(Ingredient ingredient, int size) {
//        for (int i = 0; i < size; ++i) {
//            this.inputs.add(ingredient);
//        }
//        return this;
//    }
//
//    @Override
//    public OrigamiShapelessRecipeJsonBuilder criterion(String string, CriterionConditions criterionConditions) {
//        this.advancementBuilder.criterion(string, criterionConditions);
//        return this;
//    }
//
//    @Override
//    public OrigamiShapelessRecipeJsonBuilder group(@Nullable String string) {
//        this.group = string;
//        return this;
//    }
//
//    @Override
//    public Item getOutputItem() {
//        return this.output;
//    }
//
//    @Override
//    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
//        this.validate(recipeId);
//        this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(CriterionMerger.OR);
//        exporter.accept(new OrigamiShapelessRecipeJsonProvider(recipeId, this.output, this.count, this.group == null ? "" : this.group, OrigamiShapelessRecipeJsonBuilder.getCraftingCategory(this.category), this.inputs, this.advancementBuilder, recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
//    }
//
//    private void validate(Identifier recipeId) {
//        if (this.advancementBuilder.getCriteria().isEmpty()) {
//            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
//        }
//    }
//
//    public static class OrigamiShapelessRecipeJsonProvider extends CraftingRecipeJsonProvider {
//        private final Identifier recipeId;
//        private final Item output;
//        private final int count;
//        private final String group;
//        private final List<Ingredient> inputs;
//        private final Advancement.Builder advancementBuilder;
//        private final Identifier advancementId;
//
//        public OrigamiShapelessRecipeJsonProvider(Identifier recipeId, Item output, int outputCount, String group, CraftingRecipeCategory craftingCategory, List<Ingredient> inputs, Advancement.Builder advancementBuilder, Identifier advancementId) {
//            super(craftingCategory);
//            this.recipeId = recipeId;
//            this.output = output;
//            this.count = outputCount;
//            this.group = group;
//            this.inputs = inputs;
//            this.advancementBuilder = advancementBuilder;
//            this.advancementId = advancementId;
//        }
//
//        @Override
//        public void serialize(JsonObject json) {
//            super.serialize(json);
//            if (!this.group.isEmpty()) {
//                json.addProperty("group", this.group);
//            }
//            JsonArray jsonArray = new JsonArray();
//            for (Ingredient ingredient : this.inputs) {
//                jsonArray.add(ingredient.toJson());
//            }
//            json.add("ingredients", jsonArray);
//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("item", Registries.ITEM.getId(this.output).toString());
//            if (this.count > 1) {
//                jsonObject.addProperty("count", this.count);
//            }
//            json.add("result", jsonObject);
//        }
//
//        @Override
//        public RecipeSerializer<?> getSerializer() {
//            return RecipeSerializer.SHAPELESS;
//        }
//
//        @Override
//        public Identifier getRecipeId() {
//            return this.recipeId;
//        }
//
//        @Override
//        @Nullable
//        public JsonObject toAdvancementJson() {
//            return this.advancementBuilder.toJson();
//        }
//
//        @Override
//        @Nullable
//        public Identifier getAdvancementId() {
//            return this.advancementId;
//        }
//    }
//}
//
