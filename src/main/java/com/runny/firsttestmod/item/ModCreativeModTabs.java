package com.runny.firsttestmod.item;

import com.runny.firsttestmod.FirstTestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public  static  final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstTestMod.mod_id);

    public  static  final RegistryObject<CreativeModeTab> FIRSTMOD_TAB = CREATIVE_MODE_TAB.register("firstmod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CUPWITHTEA.get()))
                    .title(Component.translatable("creativetab.firstmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CUPWITHTEA.get());
                        output.accept(ModItems.CUP.get());
                        output.accept(ModItems.TEABAG.get());
                    })
                    .build());

    public  static  void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
