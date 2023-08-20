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

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataOutput;
import net.origamiking.mcmods.oapi.oapi_datagen.impl.OrigamiDataGenHelper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Extend this class and implement {@link OrigamiAdvancementProvider#generateAdvancement}.
 *
 * <p>Register an instance of the class with {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGenerator.Pack#addProvider} in a {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGeneratorEntrypoint}.
 */
public abstract class OrigamiAdvancementProvider implements DataProvider {
	protected final OrigamiDataOutput output;
	private final DataOutput.PathResolver pathResolver;

	protected OrigamiAdvancementProvider(OrigamiDataOutput output) {
		this.output = output;
		this.pathResolver = output.getResolver(DataOutput.OutputType.DATA_PACK, "advancements");
	}

	/**
	 * Implement this method to register advancements to generate use the consumer callback to register advancements.
	 *
	 * <p>Use {@link Advancement.Builder#build(Consumer, String)} to help build advancements.
	 */
	public abstract void generateAdvancement(Consumer<Advancement> consumer);

	/**
	 * Return a new exporter that applies the specified conditions to any advancement it receives.
	 */
	protected Consumer<Advancement> withConditions(Consumer<Advancement> exporter, ConditionJsonProvider... conditions) {
		Preconditions.checkArgument(conditions.length > 0, "Must add at least one condition.");
		return advancement -> {
			OrigamiDataGenHelper.addConditions(advancement, conditions);
			exporter.accept(advancement);
		};
	}

	@Override
	public CompletableFuture<?> run(DataWriter writer) {
		final Set<Identifier> identifiers = Sets.newHashSet();
		final Set<Advancement> advancements = Sets.newHashSet();

		generateAdvancement(advancements::add);

		final List<CompletableFuture<?>> futures = new ArrayList<>();

		for (Advancement advancement : advancements) {
			if (!identifiers.add(advancement.getId())) {
				throw new IllegalStateException("Duplicate advancement " + advancement.getId());
			}

			JsonObject advancementJson = advancement.createTask().toJson();
			ConditionJsonProvider.write(advancementJson, OrigamiDataGenHelper.consumeConditions(advancement));

			futures.add(DataProvider.writeToPath(writer, advancementJson, getOutputPath(advancement)));
		}

		return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
	}

	private Path getOutputPath(Advancement advancement) {
		return pathResolver.resolveJson(advancement.getId());
	}

	@Override
	public String getName() {
		return "Advancements";
	}
}
