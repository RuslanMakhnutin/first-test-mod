package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TeaModFromRunny.mod_id, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Stone
        blockWithItem(ModBlock.TEA_STONE_BLOCK);
        blockWithItem(ModBlock.TEA_STONE_ORE);

        // Wood
        blockWithItem(ModBlock.TEA_TREE_LOG);
        blockWithItem(ModBlock.STRIPPED_TEA_TREE_LOG);
        blockWithItem(ModBlock.TEA_TREE_WOOD);
        blockWithItem(ModBlock.STRIPPED_TEA_TREE_WOOD);

        // Planks
        blockWithItem(ModBlock.TEA_TREE_PLANKS);

        // Leaves
        blockOfLeaves(ModBlock.TEA_LEAVES);
        blockOfLeaves(ModBlock.DRY_TEA_LEAVES);
        blockWithItem(ModBlock.TEA_TREE_SAPLING);

        // Sand
        blockWithItem(ModBlock.TEA_SLAG_BLOCK);

        // Test
        blockWithItem(ModBlock.SOUND_BLOCK);
        blockWithItem(ModBlock.TEST_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockOfLeaves(RegistryObject<LeavesBlock> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockOfSapling(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
