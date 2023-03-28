package net.origamiking.mcmods.oapi.blocks.custom.copper.normal;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CopperButtonBlock extends AbstractButtonBlock {
    public final Oxidizable.OxidationLevel oxidizationLevel;
    public CopperButtonBlock(Oxidizable.OxidationLevel oxidizationLevel, Settings settings) {
        super(false, settings);
        this.oxidizationLevel = oxidizationLevel;
    }

    @Override
    protected SoundEvent getClickSound(boolean powered) {
        return SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON;
    }
}
