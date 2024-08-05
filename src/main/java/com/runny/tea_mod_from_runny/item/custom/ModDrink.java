package com.runny.tea_mod_from_runny.item.custom;

import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ModDrink extends Item {


    public ModDrink(Properties pProperties) {
        super(pProperties);
    }

    public static final FoodProperties WATER = new FoodProperties.Builder().alwaysEat().build();
    public static final FoodProperties CLASSIC_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f).build();
    public static final FoodProperties TEA_STONE_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f).build();
    public static final FoodProperties SWEET_BERRIES_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200), 1f).build();
    public static final FoodProperties GLOW_BERRIES_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200), 1f).build();
    public static final FoodProperties MINER_TEA = new FoodProperties.Builder().alwaysEat().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1800), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800), 1f).build();

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);

        if (pStack.isEmpty()) {
            return new ItemStack(ModItems.CUP.get());
        } else {
            if (pEntityLiving instanceof Player && !((Player) pEntityLiving).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(ModItems.CUP.get());
                Player $$5 = (Player) pEntityLiving;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return pStack;
        }
    }
}