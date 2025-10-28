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

                createShapeless(RecipeCategory.MISC, Items.GLOWSTONE_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.GLOW_BERRIES)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.AMETHYST_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.DIAMOND_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.DIAMOND)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.EMERALD_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.EMERALD)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.GOLD_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.GOLD_INGOT)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.LAPIS_LAZULI_DUST)
                        .input(ModItems.MORTAR_AND_PESTLE)
                        .input(Items.LAPIS_LAZULI)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.MAGIC_DUST)
                        .input(ModItems.AMETHYST_DUST)
                        .input(ModItems.DIAMOND_DUST)
                        .input(ModItems.EMERALD_DUST)
                        .input(ModItems.GOLD_DUST)
                        .input(ModItems.LAPIS_LAZULI_DUST)
                        .input(Items.REDSTONE)
                        .input(Items.GLOWSTONE_DUST)
                        .input(Items.BLAZE_POWDER)
                        .input(Items.BONE_MEAL)
                        .criterion(hasItem(ModItems.MORTAR_AND_PESTLE), conditionsFromItem(ModItems.MORTAR_AND_PESTLE))
                        .offerTo(exporter);


                createShaped(RecipeCategory.TOOLS, ModItems.MORTAR_AND_PESTLE)
                        .pattern("  #")
                        .pattern("###")
                        .pattern(" # ")
                        .input('#', ModBlocks.MARBLE)
                        .criterion(hasItem(ModBlocks.MARBLE), conditionsFromItem(ModBlocks.MARBLE))
                        .offerTo(exporter);
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
