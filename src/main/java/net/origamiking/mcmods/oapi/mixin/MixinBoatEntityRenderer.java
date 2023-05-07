package net.origamiking.mcmods.oapi.mixin;

import java.util.Map;
import com.mojang.datafixers.util.Pair;
import net.origamiking.mcmods.oapi.entity.boat.impl.client.OrigamiBoatEntityRenderer;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiBoatHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;

@Mixin(BoatEntityRenderer.class)
@Environment(EnvType.CLIENT)
public class MixinBoatEntityRenderer {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
    private Object getOrigamiBoatTextureAndModel(Map<BoatEntity.Type, Pair<Identifier, BoatEntityModel>> map, Object type, BoatEntity entity) {
        if (entity instanceof OrigamiBoatHolder && (Object) this instanceof OrigamiBoatEntityRenderer) {
            return ((OrigamiBoatEntityRenderer) (Object) this).getTextureAndModel((OrigamiBoatHolder) entity);
        }
        return map.get(type);
    }
}
