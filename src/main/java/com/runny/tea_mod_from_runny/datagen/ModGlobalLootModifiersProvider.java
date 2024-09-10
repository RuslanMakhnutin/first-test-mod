package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.ModItems;
import com.runny.tea_mod_from_runny.loot.AddItemModifier;
import com.runny.tea_mod_from_runny.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, TeaModFromRunny.mod_id);
    }

    @Override
    protected void start() {
        add("fresh_tea_leaf_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.FRESH_TEA_LEAF.get())); // Add drop fresh tea leaf from grass

        add("manganite_from_sus_sand", new AddSusSandItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build(), // Add drop manganite from sus sand
        }, ModItems.MANGANITE.get()));
//
//        add("tea_slag_from_creeper", new AddItemModifier(new LootItemCondition[] {
//                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
//                LootItemRandomChanceCondition.randomChance(0.1f).build(),
//        }, ModItems.TEA_SLAG.get()));
    }
}
