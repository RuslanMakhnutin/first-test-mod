package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        simpleItem(ModItems.CUP);
        simpleItem(ModItems.CUP_WATER);
        simpleItem(ModItems.CUP_CLASSIC_TEA);
        simpleItem(ModItems.CUP_TEA_STONE_TEA);
        simpleItem(ModItems.CUP_GLOW_BERRIES_TEA);
        simpleItem(ModItems.CUP_SWEET_BERRIES_TEA);
        simpleItem(ModItems.CUP_MINER_TEA);

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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id, "item/"+item.getId().getPath()));
    }
}