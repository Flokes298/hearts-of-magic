package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.item.ModItems;
import net.flokes.heartsofmagic.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB.asItem())
                .add(ModBlocks.GILDED_MARBLE_SLAB.asItem());
        valueLookupBuilder(ItemTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS.asItem())
                .add(ModBlocks.GILDED_MARBLE_STAIRS.asItem());


        valueLookupBuilder(ModTags.Items.PORTAL_HEARTS)
                .add(ModItems.HEART_OF_THE_NETHER)
                .add(Items.HEART_OF_THE_SEA)
                .add(ModItems.HEART_OF_THE_MOUNTAIN)
                .add(ModItems.HEART_OF_THE_STORM)
                .add(ModItems.HEART_OF_THE_FOREST)
                .add(ModItems.HEART_OF_THE_DESERT)
                .add(ModItems.HEART_OF_THE_SWAMP)
                .add(ModItems.HEART_OF_ICE)
                .add(ModItems.HEART_OF_THE_DEEP)
                .add(ModItems.HEART_OF_LIGHT)
                .add(ModItems.HEART_OF_GOLD)
                .add(ModItems.HEART_OF_THE_MACHINE);

        valueLookupBuilder(ModTags.Items.MAGIC_HEARTS)
                .addOptionalTag(ModTags.Items.PORTAL_HEARTS);

        valueLookupBuilder(ItemTags.PIGLIN_LOVED)
                .add(ModItems.HEART_OF_GOLD);
    }
}
