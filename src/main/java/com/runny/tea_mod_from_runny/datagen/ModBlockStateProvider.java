package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        // Decor
        stairsBlock((StairBlock) ModBlock.TEA_PLANKS_STAIRS.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));
        slabBlock((SlabBlock) ModBlock.TEA_PLANKS_SLAB.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));

        // Redstone
        buttonBlock((ButtonBlock) ModBlock.TEA_BUTTON.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlock.TEA_PRESSURE_PLATE.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));

        // Fence
        fenceBlock((FenceBlock) ModBlock.TEA_PLANKS_FENCE.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlock.TEA_PLANKS_GATE_FENCE.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));
        wallBlock((WallBlock) ModBlock.TEA_PLANKS_WALL.get(), blockTexture(ModBlock.TEA_TREE_PLANKS.get()));

        // Doors
        doorBlockWithRenderType((DoorBlock) ModBlock.TEA_PLANKS_DOOR.get(), modLoc("block/tea_planks_door_bottom"),
                modLoc("block/tea_planks_door_top"),"cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlock.TEA_TRAPDOOR.get(), modLoc("block/tea_trapdoor"), true, "cutout");

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
