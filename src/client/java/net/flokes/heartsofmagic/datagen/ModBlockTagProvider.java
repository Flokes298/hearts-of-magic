package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.CUSTOM_END_PORTAL_FRAME);
        valueLookupBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.CUSTOM_END_PORTAL_FRAME);

        valueLookupBuilder(BlockTags.FEATURES_CANNOT_REPLACE)
                .add(ModBlocks.CUSTOM_END_PORTAL_FRAME);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MARBLE)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.GILDED_MARBLE)
                .add(ModBlocks.GILDED_MARBLE_SLAB)
                .add(ModBlocks.GILDED_MARBLE_STAIRS);

        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.GILDED_MARBLE_SLAB);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.GILDED_MARBLE_STAIRS);
    }
}
