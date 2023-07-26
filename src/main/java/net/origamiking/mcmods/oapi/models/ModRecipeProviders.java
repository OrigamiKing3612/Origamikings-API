package net.origamiking.mcmods.oapi.models;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;

import static net.origamiking.mcmods.oapi.models.ModRecipeProvider.*;

public class ModRecipeProviders {
    public static void blockSet(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block slab, Block stair, Block wall) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.slab(slab);
        texturePool.stairs(stair);
        texturePool.wall(wall);
    }
    public static void blockSet(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block slab, Block stair) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.slab(slab);
        texturePool.stairs(stair);
    }
    public static void customFenceSet(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence, Block fence_gate) {
        customFenceModel(blockStateModelGenerator, main_block, fence);
        customFenceGateModel(blockStateModelGenerator, main_block, fence_gate);
    }
    public static void fenceSet(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence, Block fence_gate) {
        fenceModel(blockStateModelGenerator, main_block, fence);
        fenceGateModel(blockStateModelGenerator, main_block, fence_gate);
    }
}
