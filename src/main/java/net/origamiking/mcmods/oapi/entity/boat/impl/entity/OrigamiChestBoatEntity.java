package net.origamiking.mcmods.oapi.entity.boat.impl.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;
import net.origamiking.mcmods.oapi.entity.boat.impl.OrigamiBoatInitializer;
import net.origamiking.mcmods.oapi.entity.boat.impl.OrigamiBoatTrackedData;

import java.util.Optional;
/**
 * A {@linkplain ChestBoatEntity chest boat entity} that stores a {@linkplain OrigamiBoatType Origami boat type}.
 */
public class OrigamiChestBoatEntity extends ChestBoatEntity implements OrigamiBoatHolder {
    private static final TrackedData<Optional<OrigamiBoatType>> ORIGAMI_BOAT = DataTracker.registerData(OrigamiChestBoatEntity.class, OrigamiBoatTrackedData.HANDLER);

    public OrigamiChestBoatEntity(EntityType<? extends OrigamiChestBoatEntity> type, World world) {
        super(type, world);
    }

    public OrigamiChestBoatEntity(World world) {
        this(OrigamiBoatInitializer.CHEST_BOAT, world);
    }

    public OrigamiChestBoatEntity(World world, double x, double y, double z) {
        this(OrigamiBoatInitializer.CHEST_BOAT, world);

        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    public OrigamiBoatType getOrigamiBoat() {
        return this.dataTracker.get(ORIGAMI_BOAT).orElse(null);
    }

    @Override
    public void setOrigamiBoat(OrigamiBoatType boat) {
        this.dataTracker.set(ORIGAMI_BOAT, Optional.of(boat));
    }

    @Override
    protected Text getDefaultName() {
        return EntityType.CHEST_BOAT.getName();
    }

    @Override
    public Item asItem() {
        return this.getOrigamiBoat().getChestItem();
    }

    @Override
    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return this.hasValidOrigamiBoat() && super.shouldRender(cameraX, cameraY, cameraZ);
    }

    @Override
    public void tick() {
        if (this.hasValidOrigamiBoat()) {
            super.tick();
        } else {
            this.discard();
        }
    }

    @Override
    public void setVariant(Type type) {
        return;
    }

    @Override
    public Type getVariant() {
        return this.getImpersonatedBoatType();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ORIGAMI_BOAT, Optional.empty());
    }

    // Serialization
    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.readOrigamiBoatFromNbt(nbt);

        if (!this.hasValidOrigamiBoat()) {
            this.discard();
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.writeOrigamiBoatToNbt(nbt);
    }
}
