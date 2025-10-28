package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE)
                .slab(ModBlocks.MARBLE_SLAB)
                .stairs(ModBlocks.MARBLE_STAIRS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GILDED_MARBLE)
                .slab(ModBlocks.GILDED_MARBLE_SLAB)
                .stairs(ModBlocks.GILDED_MARBLE_STAIRS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SPELLHEART, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEART_OF_THE_NETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_MOUNTAIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_STORM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_FOREST, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_DESERT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_SWAMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_ICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_DEEP, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_MACHINE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BAG_OF_HOLDING, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "ModModelProvider";
    }
}
