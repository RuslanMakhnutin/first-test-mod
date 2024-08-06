package com.runny.tea_mod_from_runny.util;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> TEST_TOOL_VALUABLES = tag("test_tool_valuables");
        public static final TagKey<Block> NEEDS_MANGANITE_TOOL = tag("need_manganite_tools");
//        public static final TagKey<Block> MINEABLE_WITH_CUTTER = tag("mineable_with_cutter");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TeaModFromRunny.mod_id, name));
        }
    }

    public static class Items {
        public static TagKey<Item> TEA_BASE_INGREDIENT = tag("tea_base_ingredient");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TeaModFromRunny.mod_id, name));
        }
    }
}
