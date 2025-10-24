package net.flokes.heartsofmagic.mixin;

import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EnderChestInventory.class)
public class EnderChestInventoryMixin extends SimpleInventory {
    @Shadow
    private EnderChestBlockEntity activeBlockEntity;

    @Override
    public void setStack(int slot, ItemStack stack) {
        if (stack.isOf(ModItems.BAG_OF_HOLDING)) {
            explode();
        } else {
            super.setStack(slot, stack);
        }
    }

    @Unique
    private void explode() {
        if (activeBlockEntity.getWorld() instanceof ServerWorld serverWorld) {
            BlockPos blockPos = activeBlockEntity.getPos();
            serverWorld.removeBlockEntity(blockPos);

            serverWorld.createExplosion(
                    null,
                    Explosion.createDamageSource(serverWorld, null),
                    null,
                    activeBlockEntity.getPos().toCenterPos().add(0f, 1f, 0f),
                    4.0f,
                    false,
                    World.ExplosionSourceType.BLOCK);
            serverWorld.createExplosion(
                    null,
                    Explosion.createDamageSource(serverWorld, null),
                    null,
                    activeBlockEntity.getPos().toCenterPos().add(0f, -1f, 0f),
                    4.0f,
                    false,
                    World.ExplosionSourceType.BLOCK);

            serverWorld.breakBlock(blockPos, true);
        }
    }
}
