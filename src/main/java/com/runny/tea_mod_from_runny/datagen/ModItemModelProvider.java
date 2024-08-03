package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TeaModFromRunny.mod_id, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TEA_STONE);
        simpleItem(ModItems.TEA_SLUG);
        simpleItem(ModItems.DRY_TEA_LEAF);
        simpleItem(ModItems.FRESH_TEA_LEAF);

//        simpleItem(ModItems.CUP);
//        simpleItem(ModItems.CUP_WATER);
//        simpleItem(ModItems.CUP_CLASSIC_TEA);
//        simpleItem(ModItems.CUP_TEA_STONE_TEA);
//        simpleItem(ModItems.CUP_GLOW_BERRIES_TEA);
//        simpleItem(ModItems.CUP_SWEET_BERRIES_TEA);
//        simpleItem(ModItems.CUP_MINER_TEA);

        simpleItem(ModItems.UNFIRED_TEA_POT);
        simpleItem(ModItems.EMPTY_TEA_POT);
        simpleItem(ModItems.WATER_TEA_POT);
        simpleItem(ModItems.TEA_POT_CLASSIC_TEA);
        simpleItem(ModItems.TEA_POT_TEA_STONE_TEA);
        simpleItem(ModItems.TEA_POT_GLOW_BERRIES_TEA);
        simpleItem(ModItems.TEA_POT_SWEET_BERRIES_TEA);
        simpleItem(ModItems.TEA_POT_MINER_TEA);

        simpleItem(ModItems.WOODEN_TEA_CUTTER);
        simpleItem(ModItems.STONE_TEA_CUTTER);
        simpleItem(ModItems.IRON_TEA_CUTTER);
        simpleItem(ModItems.GOLDEN_TEA_CUTTER);
        simpleItem(ModItems.DIAMOND_TEA_CUTTER);
        simpleItem(ModItems.NETHERITE_TEA_CUTTER);

        simpleItem(ModItems.TEST_TOOL);

        simpleBlockItem(ModBlock.TEA_PLANKS_DOOR);

        fenceItem(ModBlock.TEA_PLANKS_FENCE, ModBlock.TEA_TREE_PLANKS);
        buttonItem(ModBlock.TEA_BUTTON, ModBlock.TEA_TREE_PLANKS);
        wallItem(ModBlock.TEA_PLANKS_WALL, ModBlock.TEA_TREE_PLANKS);

        evenSimplerBlockItem(ModBlock.TEA_PLANKS_STAIRS);
        evenSimplerBlockItem(ModBlock.TEA_PLANKS_SLAB);
        evenSimplerBlockItem(ModBlock.TEA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlock.TEA_PLANKS_GATE_FENCE);

        trapdoorItem(ModBlock.TEA_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id, "item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TeaModFromRunny.mod_id + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));

    }
}