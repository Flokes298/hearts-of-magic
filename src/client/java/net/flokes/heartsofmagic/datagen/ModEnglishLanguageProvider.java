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

        translationBuilder.add(ModItems.AMETHYST_DUST, "Amethyst Dust");
        translationBuilder.add(ModItems.DIAMOND_DUST, "Diamond Dust");
        translationBuilder.add(ModItems.EMERALD_DUST, "Emerald Dust");
        translationBuilder.add(ModItems.GOLD_DUST, "Gold Dust");
        translationBuilder.add(ModItems.LAPIS_LAZULI_DUST, "Lapis Lazuli Dust");
        translationBuilder.add(ModItems.MAGIC_DUST, "Magic Dust");

        translationBuilder.add(ModItems.MORTAR_AND_PESTLE, "Mortar & Pestle");
        translationBuilder.add(ModItems.BAG_OF_HOLDING, "Bag of Holding");

        translationBuilder.add(ModBlocks.CUSTOM_END_PORTAL_FRAME, "Heart End Portal Frame");
        translationBuilder.add(ModBlocks.MARBLE, "Marble");
        translationBuilder.add(ModBlocks.MARBLE_SLAB, "Marble Slab");
        translationBuilder.add(ModBlocks.MARBLE_STAIRS, "Marble Stairs");
        translationBuilder.add(ModBlocks.GILDED_MARBLE, "Gilded Marble");
        translationBuilder.add(ModBlocks.GILDED_MARBLE_SLAB, "Gilded Marble Slab");
        translationBuilder.add(ModBlocks.GILDED_MARBLE_STAIRS, "Gilded Marble Stairs");


        translationBuilder.add("item.minecraft.potion.effect.haste", "Potion of Haste");
        translationBuilder.add("item.minecraft.potion.effect.vitality", "Potion of Vitality");
        translationBuilder.add("item.minecraft.potion.effect.enfeeblement", "Potion of Enfeeblement");
        translationBuilder.add("item.minecraft.potion.effect.sickness", "Potion of Sickness");
        translationBuilder.add("item.minecraft.splash_potion.effect.haste", "Splash Potion of Haste");
        translationBuilder.add("item.minecraft.splash_potion.effect.vitality", "Splash Potion of Vitality");
        translationBuilder.add("item.minecraft.splash_potion.effect.enfeeblement", "Splash Potion of Enfeeblement");
        translationBuilder.add("item.minecraft.splash_potion.effect.sickness", "Splash Potion of Sickness");
        translationBuilder.add("item.minecraft.lingering_potion.effect.haste", "Lingering Potion of Haste");
        translationBuilder.add("item.minecraft.lingering_potion.effect.vitality", "Lingering Potion of Vitality");
        translationBuilder.add("item.minecraft.lingering_potion.effect.enfeeblement", "Lingering Potion of Enfeeblement");
        translationBuilder.add("item.minecraft.lingering_potion.effect.sickness", "Lingering Potion of Sickness");

        translationBuilder.add("container.bag_of_holding", "Bag of Holding");

        translationBuilder.add("block.hearts-of-magic.custom_end_portal_frame.message", "Requires a %s");
    }
}
