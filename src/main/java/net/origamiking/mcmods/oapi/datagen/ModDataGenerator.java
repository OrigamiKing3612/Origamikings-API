package net.origamiking.mcmods.oapi.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataOutput) {
        FabricDataGenerator.Pack pack = dataOutput.createPack();
//		pack.addProvider(ModModelGenerator::new);
//		pack.addProvider(ModRecipeGenerator::new);
//		pack.addProvider(ModBlockLootTableGenerator::new);
//		pack.addProvider(ModBlockTagGenerator::new);
//		pack.addProvider(ModLanguageDatagen::new);
    }
}
