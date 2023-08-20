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
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.data.DataProvider;
import net.minecraft.data.server.loottable.LootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;
import net.origamiking.mcmods.oapi.oapi_datagen.impl.OrigamiDataGenHelper;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.BiConsumer;

/**
 * A base interface for Loot table providers. You should not implement this class directly.
 *
 * <p>{@link OrigamiBlockLootTableProvider} provides additional features specific to block drop loot tables.
 *
 * <p>Use {@link SimpleOrigamiLootTableProvider} for a simple abstract class that you can implement to handle standard loot table functions.
 */
@ApiStatus.NonExtendable
public interface OrigamiLootTableProvider extends LootTableGenerator, DataProvider {
	/**
	 * Return a new exporter that applies the specified conditions to any loot table it receives.
	 *
	 * <p>For block loot tables, use {@link net.origamiking.mcmods.oapi.oapi_datagen.api.loot.OrigamiBlockLootTableGenerator#withConditions} instead.
	 */
	default BiConsumer<Identifier, LootTable.Builder> withConditions(BiConsumer<Identifier, LootTable.Builder> exporter, ConditionJsonProvider... conditions) {
		Preconditions.checkArgument(conditions.length > 0, "Must add at least one condition.");
		return (id, table) -> {
			OrigamiDataGenHelper.addConditions(table, conditions);
			exporter.accept(id, table);
		};
	}
}
