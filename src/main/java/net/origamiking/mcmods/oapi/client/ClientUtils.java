package net.origamiking.mcmods.oapi.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;

public class ClientUtils {
    public static void getCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }
    public static void getCutout(Block ... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), block);
    }
    public static void getTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }
    public static void getTranslucent(Block ... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), block);
    }
    public static void getCutoutMipped(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
    }
    public static void getCutoutMipped(Block ... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), block);
    }
    public static void defaultColorProviderRegistry(Block ... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getDefaultColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), blocks);
    }
    public static void birchColorProviderRegistry(Block ... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getBirchColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getBirchColor(), blocks);
    }
    public static void mangroveColorProviderRegistry(Block ... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getMangroveColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getMangroveColor(), blocks);
    }
    public static void spruceColorProviderRegistry(Block ... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getSpruceColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getSpruceColor(), blocks);
    }
    public static void fluidTextureRegistry(FlowableFluid still, FlowableFluid flowing, int tint) {
        FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                tint
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), still, flowing);
    }
}
