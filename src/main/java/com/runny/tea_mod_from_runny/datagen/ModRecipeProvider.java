package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import com.runny.tea_mod_from_runny.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
   private static final List<ItemLike> TEA_STONE_SMELTABLES = List.of(ModItems.TEA_STONE.get(),
           ModBlock.TEA_STONE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, TEA_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.TEA_STONE.get(), 0.25f,200,"tea-stone");
        oreBlasting(pWriter, TEA_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.TEA_STONE.get(), 0.25f,100,"tea-stone");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_STONE_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TEA_STONE.get())
                .unlockedBy(getHasName(ModItems.TEA_STONE.get()),has(ModItems.TEA_STONE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.MANGANITE_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.MANGANITE.get())
                .unlockedBy(getHasName(ModItems.MANGANITE.get()),has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_LEAVES.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.FRESH_TEA_LEAF.get())
                .unlockedBy(getHasName(ModItems.FRESH_TEA_LEAF.get()),has(ModItems.FRESH_TEA_LEAF.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.DRY_TEA_LEAVES.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.DRY_TEA_LEAF.get())
                .unlockedBy(getHasName(ModItems.DRY_TEA_LEAF.get()),has(ModItems.DRY_TEA_LEAF.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNFIRED_TEA_POT.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("CCC")
                .define('C', Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.CLAY_BALL),has(Items.CLAY_BALL))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_POT_CLASSIC_TEA.get())
                .pattern("L#")
                .define('L', ModItems.DRY_TEA_LEAF.get())
                .define('#', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(ModItems.DRY_TEA_LEAF.get()),has(ModItems.DRY_TEA_LEAF.get()))
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()),has(ModItems.WATER_TEA_POT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_POT_TEA_STONE_TEA.get())
                .pattern("L#")
                .define('L', ModItems.TEA_STONE.get())
                .define('#', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(ModItems.TEA_STONE.get()),has(ModItems.TEA_STONE.get()))
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()),has(ModItems.WATER_TEA_POT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_POT_SWEET_BERRIES_TEA.get())
                .pattern("L#B")
                .define('L', ModTags.Items.TEA_BASE_INGREDIENT)
                .define('B', Items.SWEET_BERRIES)
                .define('#', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(Items.SWEET_BERRIES),has(Items.SWEET_BERRIES))
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()),has(ModItems.WATER_TEA_POT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_POT_GLOW_BERRIES_TEA.get())
                .pattern("L#B")
                .define('L', ModTags.Items.TEA_BASE_INGREDIENT)
                .define('B', Items.GLOW_BERRIES)
                .define('#', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(Items.GLOW_BERRIES),has(Items.GLOW_BERRIES))
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()),has(ModItems.WATER_TEA_POT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_POT_MINER_TEA.get())
                .pattern("L#G")
                .pattern(" S ")
                .define('L', ModTags.Items.TEA_BASE_INGREDIENT)
                .define('G', Items.GLOW_BERRIES)
                .define('S', Items.SWEET_BERRIES)
                .define('#', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(Items.GLOW_BERRIES),has(Items.GLOW_BERRIES))
                .unlockedBy(getHasName(Items.SWEET_BERRIES),has(Items.SWEET_BERRIES))
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()),has(ModItems.WATER_TEA_POT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_CLASSIC_TEA.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.TEA_POT_CLASSIC_TEA.get())
                .unlockedBy(getHasName(ModItems.TEA_POT_CLASSIC_TEA.get()), has(ModItems.WATER_TEA_POT.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_TEA_STONE_TEA.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.TEA_POT_TEA_STONE_TEA.get())
                .unlockedBy(getHasName(ModItems.TEA_POT_TEA_STONE_TEA.get()), has(ModItems.TEA_POT_TEA_STONE_TEA.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_GLOW_BERRIES_TEA.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.TEA_POT_GLOW_BERRIES_TEA.get())
                .unlockedBy(getHasName(ModItems.TEA_POT_GLOW_BERRIES_TEA.get()), has(ModItems.TEA_POT_GLOW_BERRIES_TEA.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_SWEET_BERRIES_TEA.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.TEA_POT_SWEET_BERRIES_TEA.get())
                .unlockedBy(getHasName(ModItems.TEA_POT_SWEET_BERRIES_TEA.get()), has(ModItems.TEA_POT_SWEET_BERRIES_TEA.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_MINER_TEA.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.TEA_POT_MINER_TEA.get())
                .unlockedBy(getHasName(ModItems.TEA_POT_MINER_TEA.get()), has(ModItems.TEA_POT_MINER_TEA.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP_WATER.get(), 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', ModItems.CUP.get())
                .define('T', ModItems.WATER_TEA_POT.get())
                .unlockedBy(getHasName(ModItems.WATER_TEA_POT.get()), has(ModItems.WATER_TEA_POT.get()))
                .unlockedBy(getHasName(ModItems.CUP.get()), has(ModItems.CUP.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP.get(), 4)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PLANKS_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PLANKS_DOOR.get(), 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_TRAPDOOR.get(), 2)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PLANKS_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PLANKS_FENCE.get(), 3)
                .pattern("#/#")
                .pattern("#/#")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.TEA_PLANKS_GATE_FENCE.get(), 1)
                .pattern("/#/")
                .pattern("/#/")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_SWORD.get())
                .pattern("#")
                .pattern("#")
                .pattern("/")
                .define('#', ModItems.MANGANITE.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MANGANITE.get()), has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_AXE.get())
                .pattern("##")
                .pattern("#/")
                .pattern(" /")
                .define('#', ModItems.MANGANITE.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MANGANITE.get()), has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_PICKAXE.get())
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', ModItems.MANGANITE.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MANGANITE.get()), has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_SHOVEL.get())
                .pattern("#")
                .pattern("/")
                .pattern("/")
                .define('#', ModItems.MANGANITE.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MANGANITE.get()), has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_HOE.get())
                .pattern("##")
                .pattern("/ ")
                .pattern("/ ")
                .define('#', ModItems.MANGANITE.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(ModItems.MANGANITE.get()), has(ModItems.MANGANITE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOODEN_TEA_CUTTER.get())
                .pattern("#/")
                .pattern("#/")
                .pattern("#/")
                .define('#', ModBlock.TEA_TREE_PLANKS.get())
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_TEA_CUTTER.get())
                .pattern("#/")
                .pattern("#/")
                .pattern("#/")
                .define('#', Blocks.COBBLESTONE)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_TEA_CUTTER.get())
                .pattern("#/")
                .pattern("#/")
                .pattern("#/")
                .define('#', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_TEA_CUTTER.get())
                .pattern("#/")
                .pattern("#/")
                .pattern("#/")
                .define('#', Items.GOLD_INGOT)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_TEA_CUTTER.get())
                .pattern("#/")
                .pattern("#/")
                .pattern("#/")
                .define('#', Items.DIAMOND)
                .define('/', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE.get(), 2)
                .pattern("#T#")
                .pattern("#B#")
                .pattern("###")
                .define('#', Items.DIAMOND)
                .define('T', ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Blocks.END_STONE)
                .unlockedBy(getHasName(ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        has(ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TEA_STONE.get(), 9)
                .requires(ModBlock.TEA_STONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlock.TEA_STONE_BLOCK.get()), has(ModBlock.TEA_STONE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlock.TEA_BUTTON.get())
                .requires(ModBlock.TEA_TREE_PLANKS.get())
                .unlockedBy(getHasName(ModBlock.TEA_TREE_PLANKS.get()), has(ModBlock.TEA_TREE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DRY_TEA_LEAF.get(), 9)
                .requires(ModBlock.DRY_TEA_LEAVES.get())
                .unlockedBy(getHasName(ModBlock.DRY_TEA_LEAVES.get()), has(ModBlock.DRY_TEA_LEAVES.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MANGANITE.get(), 9)
                .requires(ModBlock.MANGANITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlock.MANGANITE_BLOCK.get()), has(ModBlock.MANGANITE_BLOCK.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TeaModFromRunny.mod_id + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
