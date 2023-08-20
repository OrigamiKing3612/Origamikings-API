/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 * Copyright (c) 2023 OrigamiKing3612
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.origamiking.mcmods.oapi.oapi_datagen.api.provider;

import net.minecraft.block.Block;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.event.GameEvent;
import net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataOutput;
import net.origamiking.mcmods.oapi.oapi_datagen.impl.ForcedTagEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Implement this class (or one of the inner classes) to generate a tag list.
 *
 * <p>Register your implementation using {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGenerator.Pack#addProvider} in a {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGeneratorEntrypoint}.
 *
 * <p>When generating tags for modded dynamic registry entries (such as biomes), either the entry
 * must be added to the registry using {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGeneratorEntrypoint#buildRegistry(RegistryBuilder)}
 * or {@link TagBuilder#addOptional(Identifier)} must be used. Otherwise, the data generator cannot
 * find the entry and crashes.
 *
 * <p>Commonly used implementations of this class are provided:
 *
 * @see BlockTagProvider
 * @see ItemTagProvider
 * @see FluidTagProvider
 * @see EntityTypeTagProvider
 * @see GameEventTagProvider
 */
public abstract class OrigamiTagProvider<T> extends TagProvider<T> {
	/**
	 * Constructs a new {@link OrigamiTagProvider} with the default computed path.
	 *
	 * <p>Common implementations of this class are provided.
	 *
	 * @param output        the {@link OrigamiDataOutput} instance
	 * @param registriesFuture      the backing registry for the tag type
	 */
	public OrigamiTagProvider(OrigamiDataOutput output, RegistryKey<? extends Registry<T>> registryKey, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registryKey, registriesFuture);
	}

	/**
	 * Implement this method and then use {@link OrigamiTagProvider#getOrCreateTagBuilder} to get and register new tag builders.
	 */
	protected abstract void configure(RegistryWrapper.WrapperLookup arg);

	/**
	 * Override to enable adding objects to the tag builder directly.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected RegistryKey<T> reverseLookup(T element) {
		Registry registry = Registries.REGISTRIES.get((RegistryKey) registryRef);

		if (registry != null) {
			Optional<RegistryEntry<T>> key = registry.getKey(element);

			if (key.isPresent()) {
				return (RegistryKey<T>) key.get();
			}
		}

		throw new UnsupportedOperationException("Adding objects is not supported by " + getClass());
	}

	/**
	 * Creates a new instance of {@link OrigamiTagBuilder} for the given {@link TagKey} tag.
	 *
	 * @param tag The {@link TagKey} tag to create the builder for
	 * @return The {@link OrigamiTagBuilder} instance
	 */
	@Override
	protected OrigamiTagBuilder getOrCreateTagBuilder(TagKey<T> tag) {
		return new OrigamiTagBuilder(super.getOrCreateTagBuilder(tag));
	}

	/**
	 * Extend this class to create {@link Block} tags in the "/blocks" tag directory.
	 */
	public abstract static class BlockTagProvider extends OrigamiTagProvider<Block> {
		public BlockTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, RegistryKeys.BLOCK, registriesFuture);
		}

		@Override
		protected RegistryKey<Block> reverseLookup(Block element) {
			return element.getRegistryEntry().registryKey();
		}
	}

	/**
	 * Extend this class to create {@link Item} tags in the "/items" tag directory.
	 */
	public abstract static class ItemTagProvider extends OrigamiTagProvider<Item> {
		@Nullable
		private final Function<TagKey<Block>, TagBuilder> blockTagBuilderProvider;

		/**
		 * Construct an {@link ItemTagProvider} tag provider <b>with</b> an associated {@link BlockTagProvider} tag provider.
		 *
		 * @param output The {@link OrigamiDataOutput} instance
		 */
		public ItemTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable OrigamiTagProvider.BlockTagProvider blockTagProvider) {
			super(output, RegistryKeys.ITEM, completableFuture);

			this.blockTagBuilderProvider = blockTagProvider == null ? null : blockTagProvider::getTagBuilder;
		}

		/**
		 * Construct an {@link ItemTagProvider} tag provider <b>without</b> an associated {@link BlockTagProvider} tag provider.
		 *
		 * @param output The {@link OrigamiDataOutput} instance
		 */
		public ItemTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			this(output, completableFuture, null);
		}

		/**
		 * Copy the entries from a tag with the {@link Block} type into this item tag.
		 *
		 * <p>The {@link ItemTagProvider} tag provider must be constructed with an associated {@link BlockTagProvider} tag provider to use this method.
		 *
		 * @param blockTag The block tag to copy from.
		 * @param itemTag  The item tag to copy to.
		 */
		public void copy(TagKey<Block> blockTag, TagKey<Item> itemTag) {
			TagBuilder blockTagBuilder = Objects.requireNonNull(this.blockTagBuilderProvider, "Pass Block tag provider via constructor to use copy").apply(blockTag);
			TagBuilder itemTagBuilder = this.getTagBuilder(itemTag);
			blockTagBuilder.build().forEach(itemTagBuilder::add);
		}

		@Override
		protected RegistryKey<Item> reverseLookup(Item element) {
			return element.getRegistryEntry().registryKey();
		}
	}

	/**
	 * Extend this class to create {@link Fluid} tags in the "/fluids" tag directory.
	 */
	public abstract static class FluidTagProvider extends OrigamiTagProvider<Fluid> {
		public FluidTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, RegistryKeys.FLUID, completableFuture);
		}

		@Override
		protected RegistryKey<Fluid> reverseLookup(Fluid element) {
			return element.getRegistryEntry().registryKey();
		}
	}

	/**
	 * Extend this class to create {@link Enchantment} tags in the "/enchantments" tag directory.
	 */
	public abstract static class EnchantmentTagProvider extends OrigamiTagProvider<Enchantment> {
		public EnchantmentTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, RegistryKeys.ENCHANTMENT, completableFuture);
		}

		@Override
		protected RegistryKey<Enchantment> reverseLookup(Enchantment element) {
			return Registries.ENCHANTMENT.getKey(element)
					.orElseThrow(() -> new IllegalArgumentException("Enchantment " + element + " is not registered"));
		}
	}

	/**
	 * Extend this class to create {@link EntityType} tags in the "/entity_types" tag directory.
	 */
	public abstract static class EntityTypeTagProvider extends OrigamiTagProvider<EntityType<?>> {
		public EntityTypeTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, RegistryKeys.ENTITY_TYPE, completableFuture);
		}

		@Override
		protected RegistryKey<EntityType<?>> reverseLookup(EntityType<?> element) {
			return element.getRegistryEntry().registryKey();
		}
	}

	/**
	 * Extend this class to create {@link GameEvent} tags in the "/game_events" tag directory.
	 */
	public abstract static class GameEventTagProvider extends OrigamiTagProvider<GameEvent> {
		public GameEventTagProvider(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, RegistryKeys.GAME_EVENT, completableFuture);
		}

		@Override
		protected RegistryKey<GameEvent> reverseLookup(GameEvent element) {
			return element.getRegistryEntry().registryKey();
		}
	}

	/**
	 * An extension to {@link ProvidedTagBuilder} that provides additional functionality.
	 */
	public final class OrigamiTagBuilder extends ProvidedTagBuilder<T> {
		private final TagProvider.ProvidedTagBuilder<T> parent;

		private OrigamiTagBuilder(ProvidedTagBuilder<T> parent) {
			super(parent.builder);
			this.parent = parent;
		}

		/**
		 * Set the value of the `replace` flag in a Tag.
		 *
		 * <p>When set to true the tag will replace any existing tag entries.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder setReplace(boolean replace) {
			((net.origamiking.mcmods.oapi.oapi_datagen.impl.OrigamiTagBuilder) builder).origami_setReplace(replace);
			return this;
		}

		/**
		 * Add an element to the tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder add(T element) {
			add(reverseLookup(element));
			return this;
		}

		/**
		 * Add multiple elements to the tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		@SafeVarargs
		public final OrigamiTagBuilder add(T... element) {
			Stream.of(element).map(OrigamiTagProvider.this::reverseLookup).forEach(this::add);
			return this;
		}

//		/**
//		 * Add an element to the tag.
//		 *
//		 * @return the {@link OrigamiTagBuilder} instance
//		 * @see #add(Identifier)
//		 */
//		@Override
//		public OrigamiTagBuilder add(RegistryKey<T> registryKey) {
//			parent.add(registryKey);
//			return this;
//		}

		/**
		 * Add a single element to the tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder add(Identifier id) {
			builder.add(id);
			return this;
		}

		/**
		 * Add an optional {@link Identifier} to the tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		@Override
		public OrigamiTagBuilder addOptional(Identifier id) {
			parent.addOptional(id);
			return this;
		}

		/**
		 * Add an optional {@link RegistryKey} to the tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder addOptional(RegistryKey<? extends T> registryKey) {
			return addOptional(registryKey.getValue());
		}

		/**
		 * Add another tag to this tag.
		 *
		 * <p><b>Note:</b> any vanilla tags can be added to the builder,
		 * but other tags can only be added if it has a builder registered in the same provider.
		 *
		 * <p>Use {@link #forceAddTag(TagKey)} to force add any tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 * @see BlockTags
		 * @see EntityTypeTags
		 * @see FluidTags
		 * @see GameEventTags
		 * @see ItemTags
		 */
		@Override
		public OrigamiTagBuilder addTag(TagKey<T> tag) {
			builder.addTag(tag.id());
			return this;
		}

		/**
		 * Add another optional tag to this tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		@Override
		public OrigamiTagBuilder addOptionalTag(Identifier id) {
			parent.addOptionalTag(id);
			return this;
		}

		/**
		 * Add another optional tag to this tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder addOptionalTag(TagKey<T> tag) {
			return addOptionalTag(tag.id());
		}

		/**
		 * Add another tag to this tag, ignoring any warning.
		 *
		 * <p><b>Note:</b> only use this method if you sure that the tag will be always available at runtime.
		 * If not, use {@link #addOptionalTag(Identifier)} instead.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder forceAddTag(TagKey<T> tag) {
			builder.add(new ForcedTagEntry(TagEntry.create(tag.id())));
			return this;
		}

		/**
		 * Add multiple elements to this tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		public OrigamiTagBuilder add(Identifier... ids) {
			for (Identifier id : ids) {
				add(id);
			}

			return this;
		}

		/**
		 * Add multiple elements to this tag.
		 *
		 * @return the {@link OrigamiTagBuilder} instance
		 */
		@SafeVarargs
		@Override
		public final OrigamiTagBuilder add(RegistryKey<T>... registryKeys) {
			for (RegistryKey<T> registryKey : registryKeys) {
				add(registryKey);
			}

			return this;
		}
	}
}
