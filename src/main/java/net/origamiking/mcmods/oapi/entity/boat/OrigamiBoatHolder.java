package net.origamiking.mcmods.oapi.entity.boat;

import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public interface OrigamiBoatHolder {
    static final String BOAT_KEY = "OrigamiBoat";

    OrigamiBoatType getOrigamiBoat();

    void setOrigamiBoat(OrigamiBoatType boat);

    default boolean hasValidOrigamiBoat() {
        return this.getOrigamiBoat() != null;
    }

    default void readOrigamiBoatFromNbt(NbtCompound nbt) {
        Identifier id = Identifier.tryParse(nbt.getString(BOAT_KEY));
        if (id != null) {
            OrigamiBoatType boat = OrigamiBoatTypeRegistry.INSTANCE.get(id);
            if (boat != null) {
                this.setOrigamiBoat(boat);
            }
        }
    }

    default void writeOrigamiBoatToNbt(NbtCompound nbt) {
        Identifier boatId = OrigamiBoatTypeRegistry.INSTANCE.getId(this.getOrigamiBoat());
        if (boatId != null) {
            nbt.putString(BOAT_KEY, boatId.toString());
        }
    }

    default BoatEntity.Type getImpersonatedBoatType() {
        return this.getOrigamiBoat().isRaft() ? BoatEntity.Type.BAMBOO : BoatEntity.Type.OAK;
    }
}
