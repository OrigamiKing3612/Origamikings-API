package net.origamiking.mcmods.oapi.entity.boat.api;

import net.minecraft.item.Item;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiBoatEntity;
import net.origamiking.mcmods.oapi.entity.boat.impl.OrigamiBoatTypeImpl;
import net.origamiking.mcmods.oapi.entity.boat.impl.entity.OrigamiChestBoatEntity;

public interface OrigamiBoatType {
    /**
     * {@return whether this boat is a raft with a lower {@linkplain net.minecraft.entity.vehicle.BoatEntity#getMountedHeightOffset() mounted height offset}}
     */
    boolean isRaft();

    /**
     * {@return the {@linkplain net.minecraft.entity.vehicle.BoatEntity#getPickBlockStack() pick stack} and {@linkplain Item item} dropped when the {@linkplain OrigamiBoatEntity boat entity} is broken}
     */
    Item getItem();

    /**
     * {@return the {@linkplain net.minecraft.entity.vehicle.BoatEntity#getPickBlockStack() pick stack} and {@linkplain Item item} dropped when the {@linkplain OrigamiChestBoatEntity chest boat entity} is broken}
     */
    Item getChestItem();

    /**
     * {@return the planks {@linkplain Item item} dropped when the {@linkplain OrigamiBoatEntity boat entity} or {@linkplain OrigamiChestBoatEntity chest boat entity} is destroyed into planks and sticks}
     */
    Item getPlanks();

    /**
     * A builder for {@linkplain OrigamiBoatType Origami boat types}.
     *
     * <p>To build a Origami boat type:
     *
     * <pre>{@code
     *     OrigamiBoatType boat = new OrigamiBoatType.Builder()
     *         .item(ExampleModItems.MAHOGANY_BOAT)
     *         .build();
     * }</pre>
     */
    public static class Builder {
        private boolean raft;
        private Item item;
        private Item chestItem;
        private Item planks;

        public OrigamiBoatType build() {
            return new OrigamiBoatTypeImpl(this.raft, this.item, this.chestItem, this.planks);
        }

        /**
         * @see OrigamiBoatType#isRaft
         */
        public Builder raft() {
            this.raft = true;
            return this;
        }

        /**
         * @see OrigamiBoatType#getItem
         */
        public Builder item(Item item) {
            this.item = item;
            return this;
        }

        /**
         * @see OrigamiBoatType#getChestItem
         */
        public Builder chestItem(Item chestItem) {
            this.chestItem = chestItem;
            return this;
        }

        /**
         * @see OrigamiBoatType#getPlanks
         */
        public Builder planks(Item planks) {
            this.planks = planks;
            return this;
        }
    }
}

