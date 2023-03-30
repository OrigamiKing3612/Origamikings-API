package net.origamiking.mcmods.oapi.blocks.custom.copper.oxidiziable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.random.AbstractRandom;
import net.origamiking.mcmods.oapi.blocks.custom.copper.normal.CopperButtonBlock;

import java.util.Random;

public class OxidizableCopperButtonBlock extends CopperButtonBlock implements Oxidizable {
    public OxidizableCopperButtonBlock(OxidationLevel oxidizationLevel, Settings settings) {
        super(oxidizationLevel, settings);
    }
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return super.hasRandomTicks(state) || Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidizationLevel;
    }
}
