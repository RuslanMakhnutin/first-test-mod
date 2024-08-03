package com.runny.tea_mod_from_runny.datagen.loot;

import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        this.dropSelf(ModBlock.TEA_STONE_BLOCK.get());
        this.dropSelf(ModBlock.DRY_TEA_LEAVES.get());
        this.dropSelf(ModBlock.TEA_SLAG_BLOCK.get());
        this.dropSelf(ModBlock.TEA_TREE_PLANKS.get());
        this.dropSelf(ModBlock.TEA_TREE_LOG.get());
        this.dropSelf(ModBlock.STRIPPED_TEA_TREE_LOG.get());
        this.dropSelf(ModBlock.TEA_TREE_WOOD.get());
        this.dropSelf(ModBlock.STRIPPED_TEA_TREE_WOOD.get());
        this.dropSelf(ModBlock.TEA_STONE_BLOCK.get());
        this.dropSelf(ModBlock.TEA_TREE_SAPLING.get());
        this.dropSelf(ModBlock.TEA_SLAG_BLOCK.get());

        this.add(ModBlock.TEA_STONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlock.TEA_STONE_ORE.get(), ModItems.TEA_STONE.get(),2.0f,6.0f));
        this.add(ModBlock.TEA_LEAVES.get(),
                block -> createCopperLikeOreDrops(ModBlock.TEA_LEAVES.get(), ModItems.FRESH_TEA_LEAF.get(), 0.0f,3.0f));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item, float dropsMin, float dropsMax) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item).
                                apply(SetItemCountFunction.setCount(UniformGenerator.between(dropsMin, dropsMax))).
                                apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}