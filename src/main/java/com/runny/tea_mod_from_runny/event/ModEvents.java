package com.runny.tea_mod_from_runny.event;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TeaModFromRunny.mod_id)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level - 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FRESH_TEA_LEAF.get(), 4),
                    new ItemStack(ModItems.DRY_TEA_LEAF.get(), 2),
                    10, 8, 0.02f
            ));

            // Level - 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.TEA_POT_CLASSIC_TEA.get(), 1),
                    2, 10, 0.035f
            ));

            // Level - 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ModItems.TEA_POT_MINER_TEA.get(), 1),
                    1, 20, 0.05f
            ));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrades, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.GOLDEN_TEA_CUTTER.get(), 1),
                1, 20, 0.025f
        ));

        rareTrades.add((pTrades, pRandom) -> new MerchantOffer(
                new ItemStack(Items.NETHERITE_INGOT, 6),
                new ItemStack(ModItems.MANGANITE_TEA_CUUTER.get(), 1),
                1, 20, 0.25f
        ));
    }
}
