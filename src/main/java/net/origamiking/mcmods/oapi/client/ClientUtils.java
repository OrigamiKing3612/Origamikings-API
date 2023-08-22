package net.origamiking.mcmods.oapi.client;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ClientUtils {
    public static void getCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

    public static void getCutout(Block... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), block);
    }

    public static void getTranslucent(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
    }

    public static void getTranslucent(Block... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), block);
    }

    public static void getCutoutMipped(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
    }

    public static void getCutoutMipped(Block... block) {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), block);
    }

    public static void defaultColorProviderRegistry(Block... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getDefaultColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), blocks);
    }

    public static void birchColorProviderRegistry(Block... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getBirchColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getBirchColor(), blocks);
    }

    public static void mangroveColorProviderRegistry(Block... blocks) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.getMangroveColor(), blocks);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getMangroveColor(), blocks);
    }

    public static void spruceColorProviderRegistry(Block... blocks) {
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

    public static <T extends BlockEntity> void registerBlockEntityRenderer(BlockEntityType<? extends T> type, BlockEntityRendererFactory<T> factory) {
        BlockEntityRendererFactories.register(type, factory);
    }

    public static <E extends Entity> void registerEntityRenderer(EntityType<? extends E> entityType, EntityRendererFactory<E> entityRendererFactory) {
        EntityRendererRegistry.register(entityType, entityRendererFactory);
    }

    public static <M extends ScreenHandler, U extends Screen & ScreenHandlerProvider<M>> void registerHandledScreen(ScreenHandlerType<? extends M> type, HandledScreens.Provider<M, U> provider) {
        HandledScreens.register(type, provider);
    }
}
