package net.origamiking.mcmods.oapi.blocks.custom.copper.normal;

import net.minecraft.block.ChainBlock;
import net.minecraft.block.Oxidizable;

public class CopperChainBlock extends ChainBlock {
    public final Oxidizable.OxidationLevel oxidizationLevel;

    public CopperChainBlock(Oxidizable.OxidationLevel oxidizationLevel, Settings settings) {
        super(settings);
        this.oxidizationLevel = oxidizationLevel;
    }
}
