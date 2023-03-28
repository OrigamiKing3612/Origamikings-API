package net.origamiking.mcmods.oapi.blocks.custom.copper.normal;

import net.minecraft.block.Oxidizable;
import net.minecraft.block.TrapdoorBlock;

public class CopperTrapdoorBlock extends TrapdoorBlock {
    public final Oxidizable.OxidationLevel oxidizationLevel;
    public CopperTrapdoorBlock(Oxidizable.OxidationLevel oxidizationLevel, Settings settings) {
        super(settings);
        this.oxidizationLevel = oxidizationLevel;
    }

}
