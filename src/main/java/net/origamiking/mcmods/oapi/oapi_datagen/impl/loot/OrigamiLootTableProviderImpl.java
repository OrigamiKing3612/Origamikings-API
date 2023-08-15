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

package net.origamiking.mcmods.oapi.oapi_datagen.impl.loot;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataOutput;
import net.origamiking.mcmods.oapi.oapi_datagen.api.provider.OrigamiBlockLootTableProvider;
import net.origamiking.mcmods.oapi.oapi_datagen.impl.OrigamiDataGenHelper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class OrigamiLootTableProviderImpl {
	/**
	 * Shared run logic for {@link net.origamiking.mcmods.oapi.oapi_datagen.api.provider.OrigamiBlockLootTableProvider} and {@link net.origamiking.mcmods.oapi.oapi_datagen.api.provider.SimpleOrigamiLootTableProvider}.
	 */
	public static CompletableFuture<?> run(DataWriter writer, OrigamiBlockLootTableProvider provider, LootContextType lootContextType, OrigamiDataOutput origamiDataOutput) {
		HashMap<Identifier, LootTable> builders = Maps.newHashMap();
		HashMap<Identifier, ConditionJsonProvider[]> conditionMap = new HashMap<>();

		provider.accept((identifier, builder) -> {
			ConditionJsonProvider[] conditions = OrigamiDataGenHelper.consumeConditions(builder);
			conditionMap.put(identifier, conditions);

			if (builders.put(identifier, builder.type(lootContextType).build()) != null) {
				throw new IllegalStateException("Duplicate loot table " + identifier);
			}
		});

		final List<CompletableFuture<?>> futures = new ArrayList<>();

		for (Map.Entry<Identifier, LootTable> entry : builders.entrySet()) {
			JsonObject tableJson = (JsonObject) LootDataType.LOOT_TABLES.getGson().toJsonTree(entry.getValue());
			ConditionJsonProvider.write(tableJson, conditionMap.remove(entry.getKey()));

			futures.add(DataProvider.writeToPath(writer, tableJson, getOutputPath(origamiDataOutput, entry.getKey())));
		}

		return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
	}

	private static Path getOutputPath(OrigamiDataOutput dataOutput, Identifier lootTableId) {
		return dataOutput.getResolver(DataOutput.OutputType.DATA_PACK, "loot_tables").resolveJson(lootTableId);
	}

	private OrigamiLootTableProviderImpl() {
	}
}
