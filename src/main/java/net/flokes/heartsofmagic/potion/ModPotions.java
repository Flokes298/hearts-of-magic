package net.flokes.heartsofmagic.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.flokes.heartsofmagic.HeartsOfMagic;
import net.flokes.heartsofmagic.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion HASTE = register("haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 3600, 0)));
    public static final Potion LONG_HASTE = register("long_haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 9600, 0)));
    public static final Potion STRONG_HASTE = register("strong_haste", new Potion("haste", new StatusEffectInstance(StatusEffects.HASTE, 1800, 1)));

    public static final Potion VITALITY = register("vitality", new Potion("vitality", new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1800, 0)));
    public static final Potion LONG_VITALITY = register("long_vitality", new Potion("vitality", new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 3600, 0)));
    public static final Potion STRONG_VITALITY = register("strong_vitality", new Potion("vitality", new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 900, 1)));

    public static final Potion ENFEEBLEMENT = register("enfeeblement", new Potion("enfeeblement", new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200, 4)));

    public static final Potion SICKNESS = register("sickness", new Potion("sickness",
            new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 0),
            new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0)
    ));


    private static Potion register(String name, Potion potion) {
        return Registry.register(
                Registries.POTION,
                Identifier.of(HeartsOfMagic.MOD_ID, name),
                potion
        );
    }

    public static void initialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            // LUCK recipe
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.EMERALD_DUST,
                    Potions.LUCK
            );

            // HASTE recipes
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.GOLD_DUST,
                    Registries.POTION.getEntry(HASTE)
            );
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(HASTE),
                    Items.REDSTONE,
                    Registries.POTION.getEntry(LONG_HASTE)
            );
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(HASTE),
                    Items.GLOWSTONE_DUST,
                    Registries.POTION.getEntry(STRONG_HASTE)
            );

            // VITALITY recipes
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.DIAMOND_DUST,
                    Registries.POTION.getEntry(VITALITY)
            );
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(VITALITY),
                    Items.REDSTONE,
                    Registries.POTION.getEntry(LONG_VITALITY)
            );
            builder.registerPotionRecipe(
                    Registries.POTION.getEntry(VITALITY),
                    Items.GLOWSTONE_DUST,
                    Registries.POTION.getEntry(STRONG_VITALITY)
            );

            // ENFEEBLEMENT recipe
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.AMETHYST_DUST,
                    Registries.POTION.getEntry(ENFEEBLEMENT)
            );

            // SICKNESS recipe
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.LAPIS_LAZULI_DUST,
                    Registries.POTION.getEntry(SICKNESS)
            );
        });
    }
}
