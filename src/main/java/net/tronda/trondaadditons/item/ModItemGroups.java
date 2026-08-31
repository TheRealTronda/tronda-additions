package net.tronda.trondaadditons.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tronda.trondaadditons.TrondaAdditions;
import net.tronda.trondaadditons.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TRONDA_ADDITIONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrondaAdditions.MOD_ID, "tronda_additions"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAW_TIN))
                    .displayName(Text.translatable("itemgroup.tronda-additions.tronda_additions"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.TIN_INGOT);

                        entries.add(ModBlocks.TIN_RAW_BLOCK);
                        entries.add(ModBlocks.TIN_ORE_BLOCK);
                        entries.add(ModBlocks.TIN_BLOCK);
                    })

                    .build());

    public static void registerItemGroups() {
        TrondaAdditions.LOGGER.info("Registering item groups for " + TrondaAdditions.MOD_ID);
    }
}
