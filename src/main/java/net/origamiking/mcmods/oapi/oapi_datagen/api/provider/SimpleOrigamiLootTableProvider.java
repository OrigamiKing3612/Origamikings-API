///*
// * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
// * Copyright (c) 2023 OrigamiKing3612
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package net.origamiking.mcmods.oapi.oapi_datagen.api.provider;
//
//import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
//import net.fabricmc.fabric.api.datagen.v1.OrigamiDataOutput;
//import net.fabricmc.fabric.impl.datagen.loot.FabricLootTableProviderImpl;
//import net.minecraft.data.DataWriter;
//import net.minecraft.loot.context.LootContextType;
//import net.minecraft.loot.context.LootContextTypes;
//import net.origamiking.mcmods.oapi.oapi_datagen.impl.loot.OrigamiLootTableProviderImpl;
//
//import java.util.Objects;
//import java.util.concurrent.CompletableFuture;
//
///**
// * Extend this class and implement {@link #accept}. Register an instance of the class with {@link FabricDataGenerator.Pack#addProvider} in a {@link net.origamiking.mcmods.oapi.oapi_datagen.api.OrigamiDataGeneratorEntrypoint}.
// */
//public abstract class SimpleOrigamiLootTableProvider implements OrigamiLootTableProvider {
//	protected final FabricDataOutput output;
//	protected final LootContextType lootContextType;
//
//	public SimpleOrigamiLootTableProvider(FabricDataOutput output, LootContextType lootContextType) {
//		this.output = output;
//		this.lootContextType = lootContextType;
//	}
//
//	@Override
//	public CompletableFuture<?> run(DataWriter writer) {
//		return OrigamiLootTableProviderImpl.run(writer, this, lootContextType, output);
//	}
//
//	@Override
//	public String getName() {
//		return Objects.requireNonNull(LootContextTypes.getId(lootContextType), "Could not get id for loot context type") + " Loot Table";
//	}
//}
