package net.origamiking.mcmods.oapi.entity.boat.impl.item;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.RegistryKey;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatTypeRegistry;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiBoatEntity;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiChestBoatEntity;

/**
 * An {@linkplain Item item} that spawns a {@linkplain OrigamiBoatEntity boat entity} with a given {@linkplain OrigamiBoatType Origami boat type}.
 */
public class OrigamiBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);

    private final RegistryKey<OrigamiBoatType> boatKey;
    private final boolean chest;

    /**
     * @param boatKey a {@linkplain RegistryKey registry key} for the {@linkplain OrigamiBoatType Origami boat type} that should be spawned by this item
     */
    public OrigamiBoatItem(RegistryKey<OrigamiBoatType> boatKey, boolean chest, Settings settings) {
        super(settings);

        this.boatKey = boatKey;
        this.chest = chest;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        HitResult hitResult = Item.raycast(world, user, RaycastContext.FluidHandling.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(stack);
        }

        Vec3d rotationVec = user.getRotationVec(1f);
        List<Entity> riders = world.getOtherEntities(user, user.getBoundingBox().stretch(rotationVec.multiply(5d)).expand(1d), RIDERS);

        // Prevent collision with user
        if (!riders.isEmpty()) {
            Vec3d eyePos = user.getEyePos();
            for (Entity entity : riders) {
                Box box = entity.getBoundingBox().expand(entity.getTargetingMargin());
                if (box.contains(eyePos)) {
                    return TypedActionResult.pass(stack);
                }
            }
        }

        // Spawn boat entity
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            double x = hitResult.getPos().x;
            double y = hitResult.getPos().y;
            double z = hitResult.getPos().z;

            OrigamiBoatType boatType = OrigamiBoatTypeRegistry.INSTANCE.getOrThrow(this.boatKey);
            BoatEntity boatEntity;

            if (this.chest) {
                OrigamiChestBoatEntity chestBoat = new OrigamiChestBoatEntity(world, x, y, z);
                chestBoat.setOrigamiBoat(boatType);
                boatEntity = chestBoat;
            } else {
                OrigamiBoatEntity boat = new OrigamiBoatEntity(world, x, y, z);
                boat.setOrigamiBoat(boatType);
                boatEntity = boat;
            }

            boatEntity.setYaw(user.getYaw());

            if (!world.isSpaceEmpty(boatEntity, boatEntity.getBoundingBox().expand(-0.1d))) {
                return TypedActionResult.fail(stack);
            }

            if (!world.isClient()) {
                world.spawnEntity(boatEntity);
                world.emitGameEvent(user, GameEvent.ENTITY_PLACE, BlockPos.ofFloored(hitResult.getPos()));

                if (!user.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(stack, world.isClient());
        }

        return TypedActionResult.pass(stack);
    }
}
