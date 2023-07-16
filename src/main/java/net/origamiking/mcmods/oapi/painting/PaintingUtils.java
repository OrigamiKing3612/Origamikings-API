package net.origamiking.mcmods.oapi.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PaintingUtils {
    public static <I extends PaintingVariant> I registerPainting(String id, String name, I paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(id, name), paintingVariant);
    }
}
