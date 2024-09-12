package com.runny.tea_mod_from_runny.item.custom;

import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.block.custom.TeaCropBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.advancements.critereon.SummonedEntityTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class TeaCutterItem extends Item {
    public TeaCutterItem(Properties pProperties) {
        super(pProperties);
    }
    Random rand = new Random();
    int leavesRandCount, seedsRandCount;

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level lvl = pContext.getLevel();
        if (!lvl.isClientSide()) {
            leavesRandCount = rand.nextInt(2, 4);
            seedsRandCount = rand.nextInt(1, 2);
            BlockPos posClicked = pContext.getClickedPos().above();
            Player player = pContext.getPlayer();
            BlockState state = lvl.getBlockState(posClicked.below());
            int age = state.getValue(TeaCropBlock.AGE);
            int maxAge = ((TeaCropBlock) state.getBlock()).getMaxAge();

            if (isTeaLeaves(state)) {
                if (state.getBlock() instanceof TeaCropBlock) {
                    if (age == maxAge) {
//                        player.sendSystemMessage(Component.literal("You have received " + leavesRandCount + " leaves of tea!"));
                        ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.FRESH_TEA_LEAF.get(), leavesRandCount));
                        ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.TEA_SEEDS.get(), seedsRandCount));
                        lvl.destroyBlock(posClicked.below(), false);
                        lvl.setBlock(posClicked.below(), ModBlock.TEA_CROP.get().defaultBlockState(),1);
                    }
                }
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.tea_mod_from_runny.tea_cutter.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private boolean isTeaLeaves(BlockState state) {
        return state.is(ModBlock.TEA_CROP.get());
    }

}