package net.flokes.heartsofmagic.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.flokes.heartsofmagic.block.ModBlocks;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShapeless(RecipeCategory.TOOLS, ModItems.BAG_OF_HOLDING)
                        .input(ItemTags.BUNDLES)
                        .input(Items.ENDER_EYE)
                        .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                        .offerTo(exporter);


                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, ModBlocks.MARBLE);
                createStairsRecipe(ModBlocks.MARBLE_STAIRS, Ingredient.ofItem(ModBlocks.MARBLE))
                        .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_MARBLE)
                        .pattern("ggg")
                        .pattern("gmg")
                        .pattern("ggg")
                        .input('g', Items.GOLD_NUGGET)
                        .input('m', ModBlocks.MARBLE)
                        .group("gilded_marble")
                        .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_MARBLE_SLAB, ModBlocks.GILDED_MARBLE);
                createStairsRecipe(ModBlocks.GILDED_MARBLE_STAIRS, Ingredient.ofItem(ModBlocks.GILDED_MARBLE))
                        .criterion(hasItem(ModBlocks.GILDED_MARBLE), conditionsFromItem(ModBlocks.GILDED_MARBLE))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB, ModBlocks.MARBLE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_STAIRS, ModBlocks.MARBLE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_MARBLE_SLAB, ModBlocks.GILDED_MARBLE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_MARBLE_STAIRS, ModBlocks.GILDED_MARBLE);

                offerSmelting(List.of(Items.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE, 0.1f, 200, "marble");
                offerBlasting(List.of(Items.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE, 0.1f, 100, "marble");
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
