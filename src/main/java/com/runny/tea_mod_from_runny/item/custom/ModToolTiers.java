package com.runny.tea_mod_from_runny.item.custom;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.ModItems;
import com.runny.tea_mod_from_runny.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier MANGANITE = TierSortingRegistry.registerTier(
            new ForgeTier(5,2539,11.5f,6f,20,
                    ModTags.Blocks.NEEDS_MANGANITE_TOOL, () -> Ingredient.of(ModItems.MANGANITE.get())),
            new ResourceLocation(TeaModFromRunny.mod_id,"manganite"), List.of(Tiers.NETHERITE), List.of());
}
