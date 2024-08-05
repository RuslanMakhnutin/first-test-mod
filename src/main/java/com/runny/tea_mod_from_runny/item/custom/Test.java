package com.runny.tea_mod_from_runny.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class Test extends HoneyBottleItem {
    public Test(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}
