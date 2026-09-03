package net.tronda.trondaadditons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tronda.trondaadditons.item.ModItems;
import net.tronda.trondaadditons.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.TIN_INGOT)
                .add(Items.IRON_INGOT);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TIN_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.TIN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TIN_HOE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.TIN_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.TIN_SHOVEL);
    }
}
