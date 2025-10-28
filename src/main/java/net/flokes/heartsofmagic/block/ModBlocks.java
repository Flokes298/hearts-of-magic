package net.flokes.heartsofmagic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flokes.heartsofmagic.HeartsOfMagic;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CUSTOM_END_PORTAL_FRAME = register(
            "custom_end_portal_frame",
            CustomEndPortalFrameBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sounds(BlockSoundGroup.GLASS)
                    .luminance(state -> 1)
                    .strength(-1.0F, 3600000.0F)
                    .dropsNothing(),
            true
    );
    public static final Block MARBLE = register(
            "marble",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
                    .strength(1.5f, 6f),
            true
    );
    public static final Block MARBLE_SLAB = register(
            "marble_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(MARBLE),
            true
    );
    public static final Block MARBLE_STAIRS = register(
            "marble_stairs",
            settings -> new StairsBlock(MARBLE.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MARBLE),
            true
    );
    public static final Block GILDED_MARBLE = register(
            "gilded_marble",
            Block::new,
            AbstractBlock.Settings.copy(MARBLE),
            true
    );
    public static final Block GILDED_MARBLE_SLAB = register(
            "gilded_marble_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(GILDED_MARBLE),
            true
    );
    public static final Block GILDED_MARBLE_STAIRS = register(
            "gilded_marble_stairs",
            settings -> new StairsBlock(GILDED_MARBLE.getDefaultState(), settings),
            AbstractBlock.Settings.copy(GILDED_MARBLE),
            true
    );


    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(HeartsOfMagic.MOD_ID, name));
        // Create block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartsOfMagic.MOD_ID, name));

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.HEARTS_OF_MAGIC_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CUSTOM_END_PORTAL_FRAME.asItem());
            itemGroup.add(ModBlocks.MARBLE.asItem());
            itemGroup.add(ModBlocks.MARBLE_SLAB.asItem());
            itemGroup.add(ModBlocks.MARBLE_STAIRS.asItem());
            itemGroup.add(ModBlocks.GILDED_MARBLE.asItem());
            itemGroup.add(ModBlocks.GILDED_MARBLE_SLAB.asItem());
            itemGroup.add(ModBlocks.GILDED_MARBLE_STAIRS.asItem());
        });
    }
}
