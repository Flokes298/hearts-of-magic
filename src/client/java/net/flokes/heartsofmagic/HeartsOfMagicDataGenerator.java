package net.flokes.heartsofmagic;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.flokes.heartsofmagic.datagen.*;

public class HeartsOfMagicDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModAdvancementProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModChestLootTableProvider::new);
        pack.addProvider(ModEnglishLanguageProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
	}
}
