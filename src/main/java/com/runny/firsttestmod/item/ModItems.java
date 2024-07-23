package com.runny.firsttestmod.item;

import com.runny.firsttestmod.FirstTestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public  static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstTestMod.mod_id);

    public  static  final RegistryObject<Item> CUP = ITEMS.register("cup", // Создал предмет чашка
            () ->new Item(new Item.Properties()));

    public  static  final RegistryObject<Item> CUPWITHTEA = ITEMS.register("cupwithtea", // Создал предмет чашки с чаем
            () ->new Item(new Item.Properties()));

    public  static  final RegistryObject<Item> TEABAG = ITEMS.register("teabag", // Создал предмет чайного пакетика
            () ->new Item(new Item.Properties()));

    public  static  void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
