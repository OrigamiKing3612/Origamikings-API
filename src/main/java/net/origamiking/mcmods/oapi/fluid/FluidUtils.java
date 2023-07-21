package net.origamiking.mcmods.oapi.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FluidUtils {
    public static <T extends Fluid> T registerFluid(String modid, String id, T fluid) {
        return Registry.register(Registries.FLUID, new Identifier(modid, id), fluid);
    }
}