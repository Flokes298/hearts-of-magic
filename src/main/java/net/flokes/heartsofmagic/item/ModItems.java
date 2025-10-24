package net.flokes.heartsofmagic.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flokes.heartsofmagic.HeartsOfMagic;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final RegistryKey<ItemGroup> HEARTS_OF_MAGIC_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(HeartsOfMagic.MOD_ID, "item_group"));
    public static final ItemGroup HEARTS_OF_MAGIC_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SPELLHEART))
            .displayName(Text.translatable("itemGroup.hearts_of_magic"))
            .build();


    public static final Item SPELLHEART = register("spellheart", HeartItem::new, new Item.Settings());

    // Elemental Hearts (required for end portal):
    public static final Item HEART_OF_THE_NETHER = register("heart_of_the_nether", HeartItem::new, new Item.Settings());
    // HEART_OF_THE_SEA
    public static final Item HEART_OF_THE_MOUNTAIN = register("heart_of_the_mountain", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_STORM = register("heart_of_the_storm", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_FOREST = register("heart_of_the_forest", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_DESERT = register("heart_of_the_desert", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_SWAMP = register("heart_of_the_swamp", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_ICE = register("heart_of_ice", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_DEEP = register("heart_of_the_deep", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_LIGHT = register("heart_of_light", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_GOLD = register("heart_of_gold", HeartItem::new, new Item.Settings());
    public static final Item HEART_OF_THE_MACHINE = register("heart_of_the_machine", HeartItem::new, new Item.Settings());

    public static final Item BAG_OF_HOLDING = register("bag_of_holding", BagOfHoldingItem::new,
            new Item.Settings()
                    .maxCount(1)
                    .component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT)
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HeartsOfMagic.MOD_ID, name));

        // Create the item instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        HeartsOfMagic.LOGGER.info("Registering Items...");

        Registry.register(Registries.ITEM_GROUP, HEARTS_OF_MAGIC_ITEM_GROUP_KEY, HEARTS_OF_MAGIC_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ModItems.HEARTS_OF_MAGIC_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModItems.SPELLHEART);
            itemGroup.add(ModItems.HEART_OF_THE_NETHER);
            itemGroup.add(Items.HEART_OF_THE_SEA);
            itemGroup.add(ModItems.HEART_OF_THE_MOUNTAIN);
            itemGroup.add(ModItems.HEART_OF_THE_STORM);
            itemGroup.add(ModItems.HEART_OF_THE_FOREST);
            itemGroup.add(ModItems.HEART_OF_THE_DESERT);
            itemGroup.add(ModItems.HEART_OF_THE_SWAMP);
            itemGroup.add(ModItems.HEART_OF_ICE);
            itemGroup.add(ModItems.HEART_OF_THE_DEEP);
            itemGroup.add(ModItems.HEART_OF_LIGHT);
            itemGroup.add(ModItems.HEART_OF_GOLD);
            itemGroup.add(ModItems.HEART_OF_THE_MACHINE);
            itemGroup.add(ModItems.BAG_OF_HOLDING);
        });
    }
}
