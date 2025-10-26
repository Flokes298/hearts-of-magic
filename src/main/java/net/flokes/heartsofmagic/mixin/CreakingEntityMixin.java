package net.flokes.heartsofmagic.mixin;

import net.minecraft.entity.mob.CreakingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CreakingEntity.class)
public class CreakingEntityMixin {

    @ModifyArg(method = "createCreakingAttributes",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;add(Lnet/minecraft/registry/entry/RegistryEntry;D)Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
                    ordinal = 2),
            index = 1)
    private static double setAttackDamage(double baseValue) {
        return 30.0;
    }
}
