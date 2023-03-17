package net.origamiking.mcmods.oapi.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class FluidUtils {
    public static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, id, value);
    }
}
