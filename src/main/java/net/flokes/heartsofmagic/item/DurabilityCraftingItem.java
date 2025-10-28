package net.flokes.heartsofmagic.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DurabilityCraftingItem extends Item {
    public DurabilityCraftingItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getDamage() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setCount(1);
            moreDamaged.setDamage(stack.getDamage() + 1);
            return moreDamaged;
        }

        return ItemStack.EMPTY;
    }
}
