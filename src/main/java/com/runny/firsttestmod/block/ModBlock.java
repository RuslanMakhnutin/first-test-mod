package com.runny.firsttestmod.block;

import com.runny.firsttestmod.FirstTestMod;
import com.runny.firsttestmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstTestMod.mod_id);

    public static final RegistryObject<Block> FRESHTEA_BLOCK = registryBlock("freshtea_block", // Создал блок свежей чайной листвы
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DRYTEA_BLOCK = registryBlock("drytea_block", // Создал блок высушенной чайной листвы
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));
    public static final RegistryObject<Block> TEATREE_LOG = registryBlock("teatree_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEATREE_LOG = registryBlock("stripped_teatree_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> TEATREE_WOOD = registryBlock("teatree_wood",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEATREE_WOOD = registryBlock("stripped_teatree_wood",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));


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
