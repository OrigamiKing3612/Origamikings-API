package net.origamiking.mcmods.oapi.entity.boat.impl.mixin;

import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiBoatHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ItemConvertible;

@Mixin(BoatEntity.class)
public class MixinBoatEntity {
    @ModifyArg(method = "fall(DZLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V", index = 0, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/BoatEntity;dropItem(Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/entity/ItemEntity;", ordinal = 0))
    private ItemConvertible replaceOrigamiPlanksDropItem(ItemConvertible original) {
        if ((Object) this instanceof OrigamiBoatHolder) {
            OrigamiBoatType boat = ((OrigamiBoatHolder) (Object) this).getOrigamiBoat();
            return boat.getPlanks();
        }
        return original;
    }
}