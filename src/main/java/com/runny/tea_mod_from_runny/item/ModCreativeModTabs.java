package com.runny.tea_mod_from_runny.item;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public  static  final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TeaModFromRunny.mod_id);

    public  static  final RegistryObject<CreativeModeTab> TEA_MOD_FROM_RUNNY_TAB = CREATIVE_MODE_TAB.register("tea_mod_from_runny_tab", // Add creative-mode tab for Mod
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EMPTY_TEA_POT.get()))
                    .title(Component.translatable("creativetab.tea_mod_from_runny"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //// Items
                        // Ingredients
                        output.accept(ModItems.FRESH_TEA_LEAF.get());
                        output.accept(ModItems.DRY_TEA_LEAF.get());
                        output.accept(ModItems.TEA_STONE.get());
                        output.accept(ModItems.TEA_SLAG.get());

                        // Cups
                        output.accept(ModItems.CUP.get());
                        output.accept(ModItems.CUP_WATER.get());
                        output.accept(ModItems.CUP_CLASSIC_TEA.get());
                        output.accept(ModItems.CUP_TEA_STONE_TEA.get());
                        output.accept(ModItems.CUP_GLOW_BERRIES_TEA.get());
                        output.accept(ModItems.CUP_SWEET_BERRIES_TEA.get());
                        output.accept(ModItems.CUP_MINER_TEA.get());

                        // Tea-pots
                        output.accept(ModItems.UNFIRED_TEA_POT.get());
                        output.accept(ModItems.EMPTY_TEA_POT.get());
                        output.accept(ModItems.WATER_TEA_POT.get());
                        output.accept(ModItems.TEA_POT_CLASSIC_TEA.get());
                        output.accept(ModItems.TEA_POT_TEA_STONE_TEA.get());
                        output.accept(ModItems.TEA_POT_GLOW_BERRIES_TEA.get());
                        output.accept(ModItems.TEA_POT_SWEET_BERRIES_TEA.get());
                        output.accept(ModItems.TEA_POT_MINER_TEA.get());

                        //// Blocks
                        // Wood
                        output.accept(ModBlock.TEA_TREE_LOG.get());
                        output.accept(ModBlock.TEA_TREE_WOOD.get());
                        output.accept(ModBlock.STRIPPED_TEA_TREE_LOG.get());
                        output.accept(ModBlock.STRIPPED_TEA_TREE_WOOD.get());
                        output.accept(ModBlock.TEA_TREE_PLANKS.get());

                        // Leaves
                        output.accept(ModBlock.TEA_LEAVES.get());
                        output.accept(ModBlock.DRY_TEA_LEAVES.get());

                        // Ore
                        output.accept(ModBlock.TEA_STONE_ORE.get());

                        // Solid blocks
                        output.accept(ModBlock.TEA_STONE_BLOCK.get());
                        output.accept(ModBlock.TEA_SLAG_BLOCK.get());

                        // Saplings
                        output.accept(ModBlock.TEA_TREE_SAPLING.get());

                        // Tools
                        output.accept(ModItems.WOODEN_TEA_CUTTER.get());
                        output.accept(ModItems.STONE_TEA_CUTTER.get());
                        output.accept(ModItems.IRON_TEA_CUTTER.get());
                        output.accept(ModItems.GOLDEN_TEA_CUTTER.get());
                        output.accept(ModItems.DIAMOND_TEA_CUTTER.get());
                        output.accept(ModItems.NETHERITE_TEA_CUTTER.get());
                        output.accept(ModItems.MANGANITE_TEA_CUUTER.get());

                        // Decor
                        output.accept(ModBlock.TEA_PLANKS_STAIRS.get());
                        output.accept(ModBlock.TEA_PLANKS_DOOR.get());
                        output.accept(ModBlock.TEA_TRAPDOOR.get());
                        output.accept(ModBlock.TEA_BUTTON.get());
                        output.accept(ModBlock.TEA_PLANKS_FENCE.get());
                        output.accept(ModBlock.TEA_PLANKS_GATE_FENCE.get());
                        output.accept(ModBlock.TEA_LOG_WALL.get());
                        output.accept(ModBlock.TEA_PLANKS_SLAB.get());
                        output.accept(ModBlock.TEA_PRESSURE_PLATE.get());

                        // Manganite
                        output.accept(ModBlock.MANGANITE_BLOCK.get());
                        output.accept(ModBlock.STONE_MANGANITE_ORE.get());
                        output.accept(ModBlock.DEEPSLATE_MANGANITE_ORE.get());
                        output.accept(ModBlock.NETHERRACK_MANGANITE_ORE.get());
                        output.accept(ModBlock.END_MANGANITE_ORE.get());
                        output.accept(ModItems.MANGANITE.get());
                        output.accept(ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE.get());

                        // Manganite-Tools
                        output.accept(ModItems.MANGANITE_SWORD.get());
                        output.accept(ModItems.MANGANITE_HOE.get());
                        output.accept(ModItems.MANGANITE_AXE.get());
                        output.accept(ModItems.MANGANITE_PICKAXE.get());
                        output.accept(ModItems.MANGANITE_SHOVEL.get());

                        // Manganite-Armor
                        output.accept(ModItems.MANGANITE_HELMET.get());
                        output.accept(ModItems.MANGANITE_CHESTPLATE.get());
                        output.accept(ModItems.MANGANITE_LEGGINGS.get());
                        output.accept(ModItems.MANGANITE_BOOTS.get());

                        // Test
                        output.accept(ModItems.TEST_TOOL.get());
                        output.accept(ModBlock.TEST_BLOCK.get());
                        output.accept(ModBlock.SOUND_BLOCK.get());

                    })
                    .build());

    public  static  void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
