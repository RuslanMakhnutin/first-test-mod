package com.runny.tea_mod_from_runny.villager;

import com.google.common.collect.ImmutableSet;
import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TeaModFromRunny.mod_id);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TeaModFromRunny.mod_id);

    public static final RegistryObject<PoiType> TEA_PICKER_POI = POI_TYPES.register("tea_picker_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlock.TEA_DRYER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> TEA_PICKER =
            VILLAGER_PROFESSIONS.register("tea_picker", () -> new VillagerProfession("tea_picker",
                    holder -> holder.get() == TEA_PICKER_POI.get(), holder -> holder.get() == TEA_PICKER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
