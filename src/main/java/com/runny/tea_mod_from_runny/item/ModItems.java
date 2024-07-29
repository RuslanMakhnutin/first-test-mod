package com.runny.tea_mod_from_runny.item;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.custom.TeaCutterItem;
import com.runny.tea_mod_from_runny.item.custom.TestToolItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public  static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TeaModFromRunny.mod_id);

    // Ingredients
    public  static  final  RegistryObject<Item> FRESH_TEA_LEAF = ITEMS.register("fresh_tea_leaf", // Add - Fresh tea-leaf
            () ->new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> DRY_TEA_LEAF = ITEMS.register("dry_tea_leaf", // Add - Dry tea-leaf
            () ->new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> TEA_STONE = ITEMS.register("tea_stone", // Add - Tea-stone
            () ->new Item(new Item.Properties()));

    // Cups
    public  static  final RegistryObject<Item> CUP = ITEMS.register("cup", // Add - cup
            () ->new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> CUP_WATER = ITEMS.register("cup_water", // Add - cup with water
            () ->new Item(new Item.Properties().stacksTo(16)));
    public  static  final  RegistryObject<Item> CUP_CLASSIC_TEA = ITEMS.register("cup_classic_tea", // Add - cup with classic tea
            () ->new Item(new Item.Properties().stacksTo(16)));
    public  static  final  RegistryObject<Item> CUP_TEA_STONE_TEA = ITEMS.register("cup_tea_stone_tea", // Add - cup with tea-stone tea
            () ->new Item(new Item.Properties().stacksTo(16)));
    public  static  final  RegistryObject<Item> CUP_GLOW_BERRIES_TEA = ITEMS.register("cup_glow_berries_tea", // Add - cup with glow berries tea
            () ->new Item(new Item.Properties().stacksTo(16)));
    public  static  final  RegistryObject<Item> CUP_SWEET_BERRIES_TEA = ITEMS.register("cup_sweet_berries_tea", // Add - cup with sweet berries tea
            () ->new Item(new Item.Properties().stacksTo(16)));
    public  static  final  RegistryObject<Item> CUP_MINER_TEA = ITEMS.register("cup_miner_tea", // Add - cup with miner tea
            () ->new Item(new Item.Properties().stacksTo(16)));

    // Tea-pots
    public  static  final  RegistryObject<Item> UNFIRED_TEA_POT = ITEMS.register("unfired_tea_pot", // Add - Unfired tea pot
            () ->new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> EMPTY_TEA_POT = ITEMS.register("empty_tea_pot", // Add - Empty tea-pot
            () ->new Item(new Item.Properties()));
    public  static  final  RegistryObject<Item> WATER_TEA_POT = ITEMS.register("water_tea_pot", // Add tea-pot with water
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));
    public  static  final  RegistryObject<Item> TEA_POT_CLASSIC_TEA = ITEMS.register("tea_pot_classic_tea", // Add tea-pot with classic tea
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));
    public  static  final  RegistryObject<Item> TEA_POT_TEA_STONE_TEA = ITEMS.register("tea_pot_tea_stone_tea", // Add tea-pot with tea-stone tea
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));
    public  static  final  RegistryObject<Item> TEA_POT_GLOW_BERRIES_TEA = ITEMS.register("tea_pot_glow_berries_tea", // Add tea-pot with glow berries tea
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));
    public  static  final  RegistryObject<Item> TEA_POT_SWEET_BERRIES_TEA = ITEMS.register("tea_pot_sweet_berries_tea", // Add tea-pot with sweet berries tea
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));
    public  static  final  RegistryObject<Item> TEA_POT_MINER_TEA = ITEMS.register("tea_pot_miner_tea", // Add tea-pot with miner tea
            () ->new Item(new Item.Properties().stacksTo(1).craftRemainder(ModItems.EMPTY_TEA_POT.get())));

    // Tea-cutters
    public  static  final  RegistryObject<Item> WOODEN_TEA_CUTTER = ITEMS.register("wooden_tea_cutter", // Add wooden tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(59)));
    public  static  final  RegistryObject<Item> STONE_TEA_CUTTER = ITEMS.register("stone_tea_cutter", // Add stone tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(131)));
    public  static  final  RegistryObject<Item> IRON_TEA_CUTTER = ITEMS.register("iron_tea_cutter", // Add iron tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(250)));
    public  static  final  RegistryObject<Item> GOLDEN_TEA_CUTTER = ITEMS.register("golden_tea_cutter", // Add golden tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(32)));
    public  static  final  RegistryObject<Item> DIAMOND_TEA_CUTTER = ITEMS.register("diamond_tea_cutter", // Add diamond tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(1561)));
    public  static  final  RegistryObject<Item> NETHERITE_TEA_CUTTER = ITEMS.register("netherite_tea_cutter", // Add netherite tea-cutter
            () ->new TeaCutterItem(new Item.Properties().stacksTo(1).durability(2031)));

    public  static  void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
