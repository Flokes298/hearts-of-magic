package net.flokes.heartsofmagic.util;

import net.flokes.heartsofmagic.component.ModComponents;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BagOfHoldingInventory extends SimpleInventory {
    private final ItemStack bagOfHoldingStack;
    private final PlayerEntity owner;

    public BagOfHoldingInventory(int size, ItemStack bagOfHoldingStack, PlayerEntity owner) {
        super(size);
        this.bagOfHoldingStack = bagOfHoldingStack;
        this.owner = owner;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        // Save changes
        bagOfHoldingStack.set(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(this.heldStacks));
    }

    @Override
    public void onOpen(PlayerEntity player) {
        World world = player.getWorld();
        if (!world.isClient()) {
            bagOfHoldingStack.set(ModComponents.OPEN_BAG_COMPONENT, true);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BUNDLE_REMOVE_ONE, SoundCategory.PLAYERS, 1f, 1f);
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        World world = player.getWorld();
        if (!world.isClient()) {
            bagOfHoldingStack.set(ModComponents.OPEN_BAG_COMPONENT, false);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BUNDLE_INSERT, SoundCategory.PLAYERS, 1f, 1f);
        }
    }

    private void createExplosion() {
        if (owner instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.closeHandledScreen();
            serverPlayer.getWorld().createExplosion(
                    null,
                    Explosion.createDamageSource(serverPlayer.getWorld(), null),
                    null,
                    serverPlayer.getPos(),
                    4.0f,
                    false,
                    World.ExplosionSourceType.BLOCK);
        }
        bagOfHoldingStack.decrement(1);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        super.setStack(slot, stack);
        if (stack.isOf(ModItems.BAG_OF_HOLDING)) {
            createExplosion();
        }
    }
}
