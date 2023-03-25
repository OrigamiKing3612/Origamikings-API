package net.origamiking.mcmods.oapi.blocks.custom.copper.normal;

import net.minecraft.block.LanternBlock;
import net.minecraft.block.Oxidizable;

public class CopperLanternBlock extends LanternBlock {
    public final Oxidizable.OxidationLevel oxidizationLevel;
    public CopperLanternBlock(Oxidizable.OxidationLevel oxidizationLevel, Settings settings) {
        super(settings);
        this.oxidizationLevel = oxidizationLevel;
    }

}
