package com.runny.tea_mod_from_runny.item.custom;

import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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
    int count;


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level lvl = pContext.getLevel();
        if (!lvl.isClientSide()){
            count = rand.nextInt(1,9);
            BlockPos posClicked = pContext.getClickedPos().above();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
                BlockState state = lvl.getBlockState(posClicked.below());

                if (isTeaLeaves(state)){
                    foundBlock = true;
                    player.sendSystemMessage(Component.literal("You have received " + count + " leaves of tea!"));
                    ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.FRESH_TEA_LEAF.get(), count));
                    lvl.destroyBlock(posClicked.below(),true);
                }
                if (!foundBlock){
                player.sendSystemMessage(Component.literal("This is not tea!"));
                }
        }

        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.tea_mod_from_runny.tea_cutter.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private boolean isTeaLeaves(BlockState state) {
        return state.is(ModBlock.TEA_LEAVES.get());
    }
}
