package net.tronda.trondaadditons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.tronda.trondaadditons.TrondaAdditions;
import net.tronda.trondaadditons.block.ModBlocks;
import net.tronda.trondaadditons.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE_BLOCK);

        offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 200, "tin");
        offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.25f, 100, "tin");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT, RecipeCategory.DECORATIONS, ModBlocks.TIN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TIN, RecipeCategory.DECORATIONS, ModBlocks.TIN_RAW_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_CHISEL)
                .pattern(" T ")
                .pattern(" T ")
                .pattern(" S ")
                .input('T', ModItems.TIN_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, "tin_chisel_default"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK, 9)
                .input(ModBlocks.TIN_BLOCK)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, "magic_block_default"));

        generateSwordRecipe(exporter, ModItems.TIN_SWORD, ModItems.TIN_INGOT, "tin");
        generatePickaxeRecipe(exporter, ModItems.TIN_PICKAXE, ModItems.TIN_INGOT, "tin");
        generateAxeRecipe(exporter, ModItems.TIN_AXE, ModItems.TIN_INGOT, "tin");
        generateShovelRecipe(exporter, ModItems.TIN_SHOVEL, ModItems.TIN_INGOT, "tin");
        generateHoeRecipe(exporter, ModItems.TIN_HOE, ModItems.TIN_INGOT, "tin");
    }

    public void generateSwordRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible materialItem, String prefix) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
                .pattern(" $ ")
                .pattern(" $ ")
                .pattern(" | ")
                .input('$', materialItem)
                .input('|', Items.STICK)
                .criterion(hasItem(materialItem), conditionsFromItem(materialItem))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, prefix +"_sword_default"));
    }
    public void generatePickaxeRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible materialItem, String prefix) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
                .pattern("$$$")
                .pattern(" | ")
                .pattern(" | ")
                .input('$', materialItem)
                .input('|', Items.STICK)
                .criterion(hasItem(materialItem), conditionsFromItem(materialItem))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, prefix +"_pickaxe_default"));
    }
    public void generateHoeRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible materialItem, String prefix) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
                .pattern(" $$")
                .pattern(" | ")
                .pattern(" | ")
                .input('$', materialItem)
                .input('|', Items.STICK)
                .criterion(hasItem(materialItem), conditionsFromItem(materialItem))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, prefix +"_hoe_default"));
    }
    public void generateShovelRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible materialItem, String prefix) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
                .pattern(" $ ")
                .pattern(" | ")
                .pattern(" | ")
                .input('$', materialItem)
                .input('|', Items.STICK)
                .criterion(hasItem(materialItem), conditionsFromItem(materialItem))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, prefix +"_shovel_default"));
    }
    public void generateAxeRecipe(RecipeExporter exporter, ItemConvertible resultItem, ItemConvertible materialItem, String prefix) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, resultItem)
                .pattern(" $$")
                .pattern(" |$")
                .pattern(" | ")
                .input('$', materialItem)
                .input('|', Items.STICK)
                .criterion(hasItem(materialItem), conditionsFromItem(materialItem))
                .offerTo(exporter, Identifier.of(TrondaAdditions.MOD_ID, prefix +"_axe_default"));
    }
}
