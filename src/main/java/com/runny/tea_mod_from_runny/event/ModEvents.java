package com.runny.tea_mod_from_runny.event;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import com.runny.tea_mod_from_runny.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TeaModFromRunny.mod_id)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.TEA_PICKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level - 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.FRESH_TEA_LEAF.get(), 2),
                    new ItemStack(ModItems.DRY_TEA_LEAF.get(), 1),
                    32, 2, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.CUP.get(), 4),
                    16, 1, 0.02f));

            // Level - 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.UNFIRED_TEA_POT.get(), 1),
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    2, 4, 0.035f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModBlock.TEA_MUSHROOM.get(), 4),
                    new ItemStack(Items.EMERALD, 1),
                    64, 2, 0.035f));

            // Level - 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.TEA_POT_CLASSIC_TEA.get(), 1),
                    64, 2, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.TEA_POT_TEA_STONE_TEA.get(), 1),
                    64, 2, 0.035f));

            // Level - 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.TEA_POT_SWEET_BERRIES_TEA.get(), 1),
                    4, 6, 0.035f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.TEA_POT_GLOW_BERRIES_TEA.get(), 1),
                    4, 6, 0.035f));

            // Level - 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.EMPTY_TEA_POT.get(), 1),
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModItems.TEA_POT_MINER_TEA.get(), 1),
                    4, 8, 0.05f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.DIAMOND_TEA_CUTTER.get(), 1),
                    2, 4, 0.05f));
        }
    }
}
