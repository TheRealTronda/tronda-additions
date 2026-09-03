package net.tronda.trondaadditons.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tronda.trondaadditons.TrondaAdditions;
import net.tronda.trondaadditons.item.custom.ChiselItem;

public class ModItems {
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));

    public static final Item TIN_CHISEL = registerItem("tin_chisel", new ChiselItem(new Item.Settings().maxDamage(512)));

    public static final Item CORN_COB = registerItem("corn_cob", new Item(new Item.Settings().food(ModFoodComponent.CORN_COB)));
    public static final Item COKE = registerItem("coke", new Item(new Item.Settings()));

    public static final Item TIN_SWORD = registerItem("tin_sword",
            new SwordItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.TIN, 3, -2.4f))));
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe",
            new PickaxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ModToolMaterials.TIN, 1, -2.4f))));
    public static final Item TIN_SHOVEL = registerItem("tin_shovel",
            new ShovelItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
                    ShovelItem.createAttributeModifiers(ModToolMaterials.TIN, 1.5f, -3.0f))));
    public static final Item TIN_AXE = registerItem("tin_axe",
            new AxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
                    AxeItem.createAttributeModifiers(ModToolMaterials.TIN, 6, -3.2f))));
    public static final Item TIN_HOE = registerItem("tin_hoe",
            new HoeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(
                    HoeItem.createAttributeModifiers(ModToolMaterials.TIN, 0, -3.0f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TrondaAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TrondaAdditions.LOGGER.info("Registering mod items for " + TrondaAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TIN_INGOT);
            entries.add(RAW_TIN);
        });
    }
}
