package com.runny.tea_mod_from_runny.block;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TeaModFromRunny.mod_id);

    public static final RegistryObject<Block> FRESH_TEA_BLOCK = registryBlock("tea_leaves", // Add - Fresh tea leaves
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DRY_TEA_BLOCK = registryBlock("dry_tea_leaves", // Add - Dry tea leaves
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));
    public static final RegistryObject<Block> TEA_TREE_LOG = registryBlock("tea_tree_log", // Add - Tea tree log
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEA_TREE_LOG = registryBlock("stripped_tea_tree_log", // Add - Stripped tea tree log
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> TEA_TREE_WOOD = registryBlock("tea_tree_wood", // Add - Tea tree wood
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEA_TREE_WOOD = registryBlock("stripped_tea_tree_wood", // Add - Stripped tea tree wood
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> TEA_STONE_ORE = registryBlock("tea_stone_ore", // Add - Tea-stone ore
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));
    public static final RegistryObject<Block> TEA_STONE_BLOCK = registryBlock("tea_stone_block", // Add - Tea-stone solid block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));
    public static final RegistryObject<Block> TEA_TREE_SAPLING = registryBlock("tea_tree_sapling", // Add - Tea tree sapling
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    private  static  <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
