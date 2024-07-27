package com.runny.firsttestmod.item;

import com.runny.firsttestmod.FirstTestMod;
import com.runny.firsttestmod.block.ModBlock;
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

    public  static  final RegistryObject<CreativeModeTab> FIRSTMOD_TAB = CREATIVE_MODE_TAB.register("firstmod_tab", // Создал собственную вкладку в меню креатива
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CUPWITHTEA.get()))
                    .title(Component.translatable("creativetab.firstmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CUPWITHTEA.get());
                        output.accept(ModItems.CUP.get());
                        output.accept(ModItems.TEABAG.get());
                        output.accept(ModItems.DRYTEALEAF.get());
                        output.accept(ModItems.FRESHTEALEAF.get());
                        output.accept(ModItems.HOTWATERBUCKET.get());

                        output.accept(ModBlock.FRESHTEA_BLOCK.get());
                        output.accept(ModBlock.DRYTEA_BLOCK.get());
                        output.accept(ModBlock.TEATREE_LOG.get());
                        output.accept(ModBlock.TEATREE_WOOD.get());
                        output.accept(ModBlock.STRIPPED_TEATREE_LOG.get());
                        output.accept(ModBlock.STRIPPED_TEATREE_WOOD.get());
                        output.accept(ModBlock.TEASTONE_ORE.get());
                        output.accept(ModBlock.TEASTONE_BLOCK.get());
                    })
                    .build());

    public  static  void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
