package com.runny.tea_mod_from_runny.datagen;

import com.runny.tea_mod_from_runny.TeaModFromRunny;
import com.runny.tea_mod_from_runny.block.ModBlock;
import com.runny.tea_mod_from_runny.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TeaModFromRunny.mod_id, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TEA_STONE);
        simpleItem(ModItems.TEA_SLAG);
        simpleItem(ModItems.DRY_TEA_LEAF);
        simpleItem(ModItems.FRESH_TEA_LEAF);
        simpleItem(ModItems.MANGANITE);

        simpleItem(ModItems.UNFIRED_TEA_POT);
        simpleItem(ModItems.EMPTY_TEA_POT);
        simpleItem(ModItems.WATER_TEA_POT);
        simpleItem(ModItems.TEA_POT_CLASSIC_TEA);
        simpleItem(ModItems.TEA_POT_TEA_STONE_TEA);
        simpleItem(ModItems.TEA_POT_GLOW_BERRIES_TEA);
        simpleItem(ModItems.TEA_POT_SWEET_BERRIES_TEA);
        simpleItem(ModItems.TEA_POT_MINER_TEA);

        simpleItem(ModItems.WOODEN_TEA_CUTTER);
        simpleItem(ModItems.STONE_TEA_CUTTER);
        simpleItem(ModItems.IRON_TEA_CUTTER);
        simpleItem(ModItems.GOLDEN_TEA_CUTTER);
        simpleItem(ModItems.DIAMOND_TEA_CUTTER);
        simpleItem(ModItems.NETHERITE_TEA_CUTTER);
        simpleItem(ModItems.MANGANITE_TEA_CUUTER);

        simpleItem(ModItems.TEST_TOOL);

        simpleBlockItem(ModBlock.TEA_PLANKS_DOOR);

        fenceItem(ModBlock.TEA_PLANKS_FENCE, ModBlock.TEA_TREE_PLANKS);
        buttonItem(ModBlock.TEA_BUTTON, ModBlock.TEA_TREE_PLANKS);
        wallItem(ModBlock.TEA_LOG_WALL, ModBlock.TEA_TREE_LOG);
        trapdoorItem(ModBlock.TEA_TRAPDOOR);

        evenSimplerBlockItem(ModBlock.TEA_PLANKS_STAIRS);
        evenSimplerBlockItem(ModBlock.TEA_PLANKS_SLAB);
        evenSimplerBlockItem(ModBlock.TEA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlock.TEA_PLANKS_GATE_FENCE);
        evenSimplerBlockItem(ModBlock.STONE_MANGANITE_ORE);
        evenSimplerBlockItem(ModBlock.DEEPSLATE_MANGANITE_ORE);
        evenSimplerBlockItem(ModBlock.NETHERRACK_MANGANITE_ORE);
        evenSimplerBlockItem(ModBlock.END_MANGANITE_ORE);
        evenSimplerBlockItem(ModBlock.MANGANITE_BLOCK);

        handHeldItem(ModItems.MANGANITE_SWORD);
        handHeldItem(ModItems.MANGANITE_AXE);
        handHeldItem(ModItems.MANGANITE_PICKAXE);
        handHeldItem(ModItems.MANGANITE_SHOVEL);
        handHeldItem(ModItems.MANGANITE_HOE);
        handHeldItem(ModItems.MANGANITE_UPGRADE_SMITHING_TEMPLATE);

        trimmedArmorItem(ModItems.MANGANITE_HELMET);
        trimmedArmorItem(ModItems.MANGANITE_CHESTPLATE);
        trimmedArmorItem(ModItems.MANGANITE_LEGGINGS);
        trimmedArmorItem(ModItems.MANGANITE_BOOTS);
    }

    // Thx to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TeaModFromRunny.mod_id; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id, "item/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(TeaModFromRunny.mod_id, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TeaModFromRunny.mod_id + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));

    }

    public ItemModelBuilder handHeldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TeaModFromRunny.mod_id,"item/"+item.getId().getPath()));
    }
}