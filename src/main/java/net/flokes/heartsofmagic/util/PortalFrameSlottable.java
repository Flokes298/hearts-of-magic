package net.flokes.heartsofmagic.util;

import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.StringIdentifiable;

public enum PortalFrameSlottable implements StringIdentifiable {
    HEART_OF_THE_SEA(0, "heart_of_the_sea", Items.HEART_OF_THE_SEA),
    HEART_OF_THE_NETHER(1, "heart_of_the_nether", ModItems.HEART_OF_THE_NETHER),
    HEART_OF_THE_STORM(2, "heart_of_the_storm", ModItems.HEART_OF_THE_STORM);

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
