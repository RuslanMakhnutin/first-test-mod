package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TeaModFromRunny.mod_id, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.TEST_TOOL_VALUABLES)
                .add(ModBlock.TEA_STONE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlock.TEA_STONE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.TEA_STONE_ORE.get(),
                        ModBlock.TEA_STONE_BLOCK.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlock.TEA_TREE_LOG.get(),
                        ModBlock.STRIPPED_TEA_TREE_LOG.get(),
                        ModBlock.TEA_TREE_WOOD.get(),
                        ModBlock.STRIPPED_TEA_TREE_WOOD.get(),
                        ModBlock.TEA_TREE_PLANKS.get()
                        );


        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlock.TEA_LEAVES.get(),
                        ModBlock.DRY_TEA_LEAVES.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlock.TEA_SLAG_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlock.TEA_PLANKS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlock.TEA_PLANKS_GATE_FENCE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlock.TEA_PLANKS_WALL.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlock.TEA_TRAPDOOR.get());

    }
}