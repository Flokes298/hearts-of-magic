package net.flokes.heartsofmagic.screen;

import net.flokes.heartsofmagic.component.ModComponents;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class BagOfHoldingSlot extends Slot {
    public BagOfHoldingSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (stack.getItem().equals(ModItems.BAG_OF_HOLDING)) {
            return Boolean.FALSE.equals(stack.get(ModComponents.OPEN_BAG_COMPONENT));
        }
        return true;
    }
}
