package net.origamiking.mcmods.oapi.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenUtils {
    public static <S extends ScreenHandler> ScreenHandlerType<S> registerScreenHandler(String id, String name, ScreenHandlerType<S> screenHandler) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(id, name), screenHandler);
    }
}
