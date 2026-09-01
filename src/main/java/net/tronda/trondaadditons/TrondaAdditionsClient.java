package net.tronda.trondaadditons;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.tronda.trondaadditons.block.ModBlocks;

public class TrondaAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_BLOCK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_BLOCK_TRAPDOOR, RenderLayer.getCutout());
    }
}
