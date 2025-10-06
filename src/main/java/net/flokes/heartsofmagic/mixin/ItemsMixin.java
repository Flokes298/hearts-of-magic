package net.flokes.heartsofmagic.mixin;

import net.flokes.heartsofmagic.component.ModComponents;
import net.flokes.heartsofmagic.item.HeartItem;
import net.flokes.heartsofmagic.util.PortalFrameSlottable;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;", at = @At( "HEAD" ), cancellable = true)
    private static void registerHeart(String id, Item.Settings settings, CallbackInfoReturnable<Item> cir) {
        if (id.equals("heart_of_the_sea")) {
            cir.setReturnValue(Items.register(
                    id,
                    HeartItem::new,
                    settings.component(ModComponents.PORTAL_FRAME_SLOTTABLE_COMPONENT, PortalFrameSlottable.HEART_OF_THE_SEA)));
        }
    }
}
