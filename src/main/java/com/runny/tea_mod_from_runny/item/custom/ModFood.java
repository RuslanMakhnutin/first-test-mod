package com.runny.tea_mod_from_runny.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties FRESH_TEA_LEAF = new FoodProperties.Builder().fast().nutrition(1).saturationMod(0).build();
    public static final FoodProperties DRY_TEA_LEAF = new FoodProperties.Builder().fast().nutrition(1).saturationMod(0).build();
}
