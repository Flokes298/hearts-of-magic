package net.flokes.heartsofmagic.util;

import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.StringIdentifiable;

public enum PortalFrameSlottable implements StringIdentifiable {
    HEART_OF_THE_NETHER(0, "heart_of_the_nether", ModItems.HEART_OF_THE_NETHER),
    HEART_OF_THE_SEA(1, "heart_of_the_sea", Items.HEART_OF_THE_SEA),
    HEART_OF_THE_MOUNTAIN(2, "heart_of_the_mountain", ModItems.HEART_OF_THE_MOUNTAIN),
    HEART_OF_THE_STORM(3, "heart_of_the_storm", ModItems.HEART_OF_THE_STORM),
    HEART_OF_THE_FOREST(4, "heart_of_the_forest", ModItems.HEART_OF_THE_FOREST),
    HEART_OF_THE_DESERT(5, "heart_of_the_desert", ModItems.HEART_OF_THE_DESERT),
    HEART_OF_THE_SWAMP(6, "heart_of_the_swamp", ModItems.HEART_OF_THE_SWAMP),
    HEART_OF_ICE(7, "heart_of_ice", ModItems.HEART_OF_ICE),
    HEART_OF_THE_DEEP(8, "heart_of_the_deep", ModItems.HEART_OF_THE_DEEP),
    HEART_OF_LIGHT(9, "heart_of_light", ModItems.HEART_OF_LIGHT),
    HEART_OF_GOLD(10, "heart_of_gold", ModItems.HEART_OF_GOLD),
    HEART_OF_THE_MACHINE(11, "heart_of_the_machine", ModItems.HEART_OF_THE_MACHINE);

    public static final StringIdentifiable.EnumCodec<PortalFrameSlottable> CODEC = StringIdentifiable.createCodec(PortalFrameSlottable::values);
    private final int index;
    private final String id;
    private final Item item;

    PortalFrameSlottable(
            int index,
            String id,
            Item item
    ) {
        this.index = index;
        this.id = id;
        this.item = item;
    }

    public Item item() {
        return this.item;
    }

    @Override
    public String asString() {
        return this.id;
    }
}
