package net.tronda.trondaadditons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.tronda.trondaadditons.block.ModBlocks;
import net.tronda.trondaadditons.block.custom.TinRedstoneLamp;
import net.tronda.trondaadditons.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_RAW_BLOCK);
        BlockStateModelGenerator.BlockTexturePool tinBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TIN_BLOCK);

        tinBlockPool.stairs(ModBlocks.TIN_BLOCK_STAIRS);
        tinBlockPool.slab(ModBlocks.TIN_BLOCK_SLAB);

        tinBlockPool.button(ModBlocks.TIN_BLOCK_BUTTON);
        tinBlockPool.pressurePlate(ModBlocks.TIN_BLOCK_PRESSURE_PLATE);

        tinBlockPool.fence(ModBlocks.TIN_BLOCK_FENCE);
        tinBlockPool.fenceGate(ModBlocks.TIN_BLOCK_FENCE_GATE);
        tinBlockPool.wall(ModBlocks.TIN_BLOCK_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.TIN_BLOCK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TIN_BLOCK_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.TIN_REDSTONE_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.TIN_REDSTONE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.TIN_REDSTONE_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(TinRedstoneLamp.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_COB, Models.GENERATED);
    }
}
