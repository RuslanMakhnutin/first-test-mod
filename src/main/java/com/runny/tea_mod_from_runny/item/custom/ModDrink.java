package com.runny.tea_mod_from_runny.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class ModDrink extends Item {


    public ModDrink(Properties pProperties) {
        super(pProperties);
    }

    //    public UseAnim getUseAnimation(ItemStack pStack) {
//        return UseAnim.DRINK;
//    }
//    public SoundEvent getDrinkingSound() {
//        return SoundEvents.GENERIC_DRINK;
//    }
//    public SoundEvent getEatingSound() {
//        return SoundEvents.GENERIC_DRINK;
//    }

    public static final FoodProperties WATER_CUP = new FoodProperties.Builder().alwaysEat().build();

    @Override
        public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}