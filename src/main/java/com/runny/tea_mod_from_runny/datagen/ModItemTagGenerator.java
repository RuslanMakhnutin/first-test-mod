package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import com.runny.tea_mod_from_runny.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, TeaModFromRunny.mod_id, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.TEA_BASE_INGREDIENT)
                .add(ModItems.TEA_STONE.get(),
                        ModItems.DRY_TEA_LEAF.get()
                );

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MANGANITE_HELMET.get(),
                        ModItems.MANGANITE_CHESTPLATE.get(),
                        ModItems.MANGANITE_LEGGINGS.get(),
                        ModItems.MANGANITE_BOOTS.get());
    }
}