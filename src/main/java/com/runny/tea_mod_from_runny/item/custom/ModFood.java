package com.runny.tea_mod_from_runny.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties CLASSIC_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 1f).build();
    public static final FoodProperties TEA_STONE_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f).build();
    public static final FoodProperties GLOW_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 900), 1f).build();
    public static final FoodProperties SWEET_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 900), 1f).build();
    public static final FoodProperties MINER_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200), 1f)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200), 1f).build();
    public static final FoodProperties WATER_CUP = new FoodProperties.Builder().alwaysEat().build();
}
