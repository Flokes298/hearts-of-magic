package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MARBLE);
        addDrop(ModBlocks.MARBLE_SLAB);
        addDrop(ModBlocks.MARBLE_STAIRS);
        addDrop(ModBlocks.GILDED_MARBLE);
        addDrop(ModBlocks.GILDED_MARBLE_SLAB);
        addDrop(ModBlocks.GILDED_MARBLE_STAIRS);
    }
}
