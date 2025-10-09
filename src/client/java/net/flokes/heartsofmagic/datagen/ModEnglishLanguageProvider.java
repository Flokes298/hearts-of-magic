package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLanguageProvider extends FabricLanguageProvider {
    public ModEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.HEARTS_OF_MAGIC_ITEM_GROUP_KEY, "Hearts of Magic");

        translationBuilder.add(ModItems.SPELLHEART, "Spellheart");
        translationBuilder.add(ModItems.HEART_OF_THE_NETHER, "Heart of the Nether");
        translationBuilder.add(ModItems.HEART_OF_THE_MOUNTAIN, "Heart of the Mountain");
        translationBuilder.add(ModItems.HEART_OF_THE_STORM, "Heart of the Storm");
        translationBuilder.add(ModItems.HEART_OF_THE_FOREST, "Heart of the Forest");
        translationBuilder.add(ModItems.HEART_OF_THE_DESERT, "Heart of the Desert");
        translationBuilder.add(ModItems.HEART_OF_THE_SWAMP, "Heart of the Swamp");
        translationBuilder.add(ModItems.HEART_OF_ICE, "Heart of Ice");
        translationBuilder.add(ModItems.HEART_OF_THE_DEEP, "Heart of the Deep");
        translationBuilder.add(ModItems.HEART_OF_LIGHT, "Heart of Light");
        translationBuilder.add(ModItems.HEART_OF_GOLD, "Heart of Gold");
        translationBuilder.add(ModItems.HEART_OF_THE_MACHINE, "Heart of the Machine");

        translationBuilder.add(ModBlocks.CUSTOM_END_PORTAL_FRAME, "Heart End Portal Frame");

        translationBuilder.add("block.hearts-of-magic.custom_end_portal_frame.message", "Requires a %s");
    }
}
