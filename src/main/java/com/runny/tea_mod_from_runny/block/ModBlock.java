package com.runny.tea_mod_from_runny.block;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.custom.SoundBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TeaModFromRunny.mod_id);

    public static final RegistryObject<LeavesBlock> TEA_LEAVES = registryBlock("tea_leaves", // Add - Fresh tea leaves
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()));
    public static final RegistryObject<LeavesBlock> DRY_TEA_LEAVES = registryBlock("dry_tea_leaves", // Add - Dry tea leaves
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> TEA_TREE_LOG = registryBlock("tea_tree_log", // Add - Tea tree log
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEA_TREE_LOG = registryBlock("stripped_tea_tree_log", // Add - Stripped tea tree log
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> TEA_TREE_WOOD = registryBlock("tea_tree_wood", // Add - Tea tree wood
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TEA_TREE_WOOD = registryBlock("stripped_tea_tree_wood", // Add - Stripped tea tree wood
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> TEA_STONE_BLOCK = registryBlock("tea_stone_block", // Add - Tea-stone solid block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TEA_STONE_ORE = registryBlock("tea_stone_ore", // Add - Tea-stone ore
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(2,5)));
    public static final RegistryObject<Block> TEA_TREE_SAPLING = registryBlock("tea_tree_sapling", // Add - Tea tree sapling
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));
    public static final RegistryObject<Block> TEA_TREE_PLANKS = registryBlock("tea_tree_planks", // Add - Tea tree planks
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> TEA_SLAG_BLOCK = registryBlock("tea_slag_block", // Add - Tea slag block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> TEST_BLOCK = registryBlock("test_block", // Add - Test block
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().noLootTable()));

    public static final RegistryObject<Block> SOUND_BLOCK = registryBlock("sound_block", // Add - Test block
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).noLootTable()));

    public static final RegistryObject<Block> TEA_PLANKS_STAIRS = registryBlock("tea_planks_stairs", // Add - stairs from tea planks
            () -> new StairBlock(() -> ModBlock.TEA_TREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> TEA_PLANKS_SLAB = registryBlock("tea_planks_slab", // Add - slab of tea planks
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> TEA_BUTTON = registryBlock("tea_button", // Add - button from tea planks
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> TEA_PRESSURE_PLATE = registryBlock("tea_pressure_plate", // Add - pressure plate from tea planks
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> TEA_PLANKS_FENCE = registryBlock("tea_planks_fence", // Add - Fence of tea planks
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> TEA_PLANKS_GATE_FENCE = registryBlock("tea_planks_gate_fence", // Add - Gate-Fence of tea planks
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> TEA_PLANKS_WALL = registryBlock("tea_planks_wall", // Add - Wall of tea planks
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> TEA_PLANKS_DOOR = registryBlock("tea_planks_door", // Add - Door of tea planks
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(),BlockSetType.OAK));

    public static final RegistryObject<Block> TEA_TRAPDOOR = registryBlock("tea_trapdoor", // Add - Trapdoor of tea planks
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(),BlockSetType.OAK));

    public static final RegistryObject<Block> MANGANITE_BLOCK = registryBlock("manganite_block", // Add - manganite block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> STONE_MANGANITE_ORE = registryBlock("stone_manganite_ore", // Add - manganite block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_MANGANITE_ORE = registryBlock("deepslate_manganite_ore", // Add - manganite block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> NETHERRACK_MANGANITE_ORE = registryBlock("netherrack_manganite_ore", // Add - manganite block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> END_MANGANITE_ORE = registryBlock("end_manganite_ore", // Add - manganite block
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));


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
