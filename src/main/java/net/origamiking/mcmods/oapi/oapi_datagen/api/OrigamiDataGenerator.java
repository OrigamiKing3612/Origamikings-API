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

package net.origamiking.mcmods.oapi.oapi_datagen.api;

import net.fabricmc.loader.api.ModContainer;
import net.minecraft.SharedConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * An extension to fabric's {@link OrigamiDataGenerator} providing mod specific data, and helper functions.
 */

public class OrigamiDataGenerator extends DataGenerator {

    private final ModContainer modContainer;
    private final boolean strictValidation;
    private final OrigamiDataOutput origamiOutput;
    private final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture;

    @ApiStatus.Internal
    public OrigamiDataGenerator(Path output, ModContainer mod, boolean strictValidation, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, SharedConstants.getGameVersion(), true);
        this.modContainer = Objects.requireNonNull(mod);
        this.strictValidation = strictValidation;
        this.origamiOutput = new OrigamiDataOutput(mod, output, strictValidation);
        this.registriesFuture = registriesFuture;
    }

    /**
     * Create a default {@link OrigamiDataGenerator.Pack} instance for generating a mod's data.
     */
    public OrigamiDataGenerator.Pack createPack() {
        return new OrigamiDataGenerator.Pack(true, modContainer.getMetadata().getName(), this.origamiOutput);
    }

    /**
     * Create a new {@link OrigamiDataGenerator.Pack} instance for generating a builtin resource pack.
     *
     * <p>To be used in conjunction with {@link net.fabricmc.fabric.api.resource.ResourceManagerHelper#registerBuiltinResourcePack}
     *
     * <p>The path in which the resource pack is generated is {@code "resourcepacks/<id path>"}. {@code id path} being the path specified
     * in the identifier.
     */
    public OrigamiDataGenerator.Pack createBuiltinResourcePack(Identifier id) {
        Path path = this.output.getPath().resolve("resourcepacks").resolve(id.getPath());
        return new OrigamiDataGenerator.Pack(true, id.toString(), new OrigamiDataOutput(modContainer, path, strictValidation));
    }

    /**
     * Returns the {@link ModContainer} for the mod that this data generator has been created for.
     *
     * @return a {@link ModContainer} instance
     */
    public ModContainer getModContainer() {
        return modContainer;
    }

    /**
     * Returns the mod ID for the mod that this data generator has been created for.
     *
     * @return a mod ID
     */
    public String getModId() {
        return getModContainer().getMetadata().getId();
    }

    /**
     * When enabled data providers can do strict validation to ensure that all entries have data generated for them.
     *
     * @return if strict validation should be enabled
     */
    public boolean isStrictValidationEnabled() {
        return strictValidation;
    }

    /**
     * @deprecated Please use {@link OrigamiDataGenerator#createPack()}
     */
    @Override
    @Deprecated
    public DataGenerator.Pack createVanillaPack(boolean shouldRun) {
        throw new UnsupportedOperationException();
    }

    /**
     * @deprecated Please use {@link OrigamiDataGenerator#createBuiltinResourcePack(Identifier)}
     */
    @Override
    @Deprecated
    public DataGenerator.Pack createVanillaSubPack(boolean shouldRun, String packName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Represents a pack of generated data (i.e. data pack or resource pack). Providers are added to a pack.
     */
    public final class Pack extends DataGenerator.Pack {
        private Pack(boolean shouldRun, String name, OrigamiDataOutput output) {
            super(shouldRun, name, output);
        }

        /**
         * Registers a constructor of {@link DataProvider} which takes a {@link OrigamiDataOutput}.
         *
         * @return the {@link DataProvider}
         */
        public <T extends DataProvider> T addProvider(OrigamiDataGenerator.Pack.Factory<T> factory) {
            return super.addProvider(output -> factory.create((OrigamiDataOutput) output));
        }

        /**
         * Registers a constructor of {@link DataProvider} which takes a {@link OrigamiDataOutput} and the registries.
         * This is used, for example, with {@link net.origamiking.mcmods.oapi.oapi_datagen.api.provider.OrigamiTagProvider}.
         *
         * @return the {@link DataProvider}
         */
        public <T extends DataProvider> T addProvider(OrigamiDataGenerator.Pack.RegistryDependentFactory<T> factory) {
            return super.addProvider(output -> factory.create((OrigamiDataOutput) output, registriesFuture));
        }

        /**
         * A factory of a data provider. This is usually the constructor.
         */
        @FunctionalInterface
        public interface Factory<T extends DataProvider> {
            T create(OrigamiDataOutput output);
        }

        /**
         * A factory of a data provider. This is usually the constructor.
         * The provider has access to the registries.
         */
        @FunctionalInterface
        public interface RegistryDependentFactory<T extends DataProvider> {
            T create(OrigamiDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture);
        }
    }
}
