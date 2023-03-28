package net.origamiking.mcmods.oapi.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

public class FluidUtils {
    public static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registry.FLUID, id, value);
    }
}
