package net.origamiking.mcmods.oapi.models;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;

public class ModRecipeProvider {
    public static void slabModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block slab) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.slab(slab);
    }

    public static void stairModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block stair) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.stairs(stair);
    }

    public static void wallModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block wall) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.wall(wall);
    }

    public static void buttonModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block button) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.button(button);
    }

    public static void fenceModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.fence(fence);
    }

    public static void customFenceModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.customFence(fence);
    }

    public static void fenceGateModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.fenceGate(fence);
    }

    public static void customFenceGateModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block fence) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.customFenceGate(fence);
    }

    public static void pressurePlateModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block pressurePlate) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.pressurePlate(pressurePlate);
    }

    public static void signModel(BlockStateModelGenerator blockStateModelGenerator, Block main_block, Block sign) {
        BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(main_block);
        texturePool.sign(sign);
    }
}
