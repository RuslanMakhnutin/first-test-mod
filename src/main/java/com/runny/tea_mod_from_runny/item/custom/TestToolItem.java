package com.runny.tea_mod_from_runny.item.custom;

import com.runny.tea_mod_from_runny.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TestToolItem extends Item {
    public TestToolItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide()){
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= posClicked.getY()+64; i++) {
                BlockState state = pContext.getLevel().getBlockState(posClicked.below(i));

                if (isValuableBlock(state)){
                    outputValuableCoordinates(posClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }

            }
            if (!foundBlock){
                player.sendSystemMessage(Component.literal("Руды не найдено, увы :с"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Найдено " + I18n.get(block.getDescriptionId()) + " на " +
                "(" + blockPos.getX() + "," + blockPos.getY() + "." + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.TEST_TOOL_VALUABLES);
    }
}
