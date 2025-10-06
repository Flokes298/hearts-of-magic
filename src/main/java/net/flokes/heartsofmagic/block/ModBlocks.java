package net.flokes.heartsofmagic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flokes.heartsofmagic.HeartsOfMagic;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
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
        });
    }
}
