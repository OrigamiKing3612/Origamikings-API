package net.origamiking.mcmods.oapi.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockAccessor;
import net.fabricmc.fabric.mixin.object.builder.AbstractBlockSettingsAccessor;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import java.util.function.Function;
import java.util.function.ToIntFunction;
/**
 * My version of {@code Block.Settings}. This adds more stuff then the {@code FabricBlockSettings}
 *
 * <p>To use this, replace {@code Block.Settings.create()} or {@code FabricBlockSettings.create()} with
 * {@code OrigamiBlockSettings.create()}.
 */

public class OrigamiBlockSettings extends FabricBlockSettings {
    private int flameBurn;
    private int flameSpread;
    @Nullable
    private Block stripInto;
    @Nullable
    private Item.Settings itemSettings;
    public OrigamiBlockSettings() {
        super();
    }
    public OrigamiBlockSettings(AbstractBlock.Settings settings) {
        this();
        // Mostly Copied from vanilla's copy method
        // Note: If new methods are added to Block settings, an accessor must be added here
        AbstractBlockSettingsAccessor thisAccessor = (AbstractBlockSettingsAccessor) this;
        AbstractBlockSettingsAccessor otherAccessor = (AbstractBlockSettingsAccessor) settings;

        // Copied in vanilla: sorted by vanilla copy order
        this.hardness(otherAccessor.getHardness());
        this.resistance(otherAccessor.getResistance());
        this.collidable(otherAccessor.getCollidable());
        thisAccessor.setRandomTicks(otherAccessor.getRandomTicks());
        this.luminance(otherAccessor.getLuminance());
        thisAccessor.setMapColorProvider(otherAccessor.getMapColorProvider());
        this.sounds(otherAccessor.getSoundGroup());
        this.slipperiness(otherAccessor.getSlipperiness());
        this.velocityMultiplier(otherAccessor.getVelocityMultiplier());
        thisAccessor.setDynamicBounds(otherAccessor.getDynamicBounds());
        thisAccessor.setOpaque(otherAccessor.getOpaque());
        thisAccessor.setIsAir(otherAccessor.getIsAir());
        thisAccessor.setToolRequired(otherAccessor.isToolRequired());
        thisAccessor.setOffsetter(otherAccessor.getOffsetter());
        thisAccessor.setBlockBreakParticles(otherAccessor.getBlockBreakParticles());
        thisAccessor.setRequiredFeatures(otherAccessor.getRequiredFeatures());

        // Not copied in vanilla: field definition order
        this.jumpVelocityMultiplier(otherAccessor.getJumpVelocityMultiplier());
        this.drops(otherAccessor.getLootTableId());
        this.allowsSpawning(otherAccessor.getAllowsSpawningPredicate());
        this.solidBlock(otherAccessor.getSolidBlockPredicate());
        this.suffocates(otherAccessor.getSuffocationPredicate());
        this.blockVision(otherAccessor.getBlockVisionPredicate());
        this.postProcess(otherAccessor.getPostProcessPredicate());
        this.emissiveLighting(otherAccessor.getEmissiveLightingPredicate());
    }
    public int getFlameBurn() {
        return flameBurn;
    }

    public int getFlameSpread() {
        return flameSpread;
    }

    @Nullable
    public Block getStripInto() {
        return stripInto;
    }
    @Nullable
    public Item.Settings getItemSettings() {
        return itemSettings;
    }

    public static OrigamiBlockSettings create() {
        return new OrigamiBlockSettings();
    }
    public static OrigamiBlockSettings copy(AbstractBlock block) {
        return new OrigamiBlockSettings(((AbstractBlockAccessor) block).getSettings());
    }

    public static OrigamiBlockSettings copyOf(AbstractBlock block) {
        return copy(block);
    }

    public static OrigamiBlockSettings copyOf(AbstractBlock.Settings settings) {
        return new OrigamiBlockSettings(settings);
    }

    //new stuff
    /**
     * Burning and spreading chances of a block.
     *
     * @see FireBlock#registerDefaultFlammables() to see vanilla values
     */
    public OrigamiBlockSettings flammability(int burn, int spread) {
        this.flameBurn = burn;
        this.flameSpread = spread;
        return this;
    }
    @Override
    public OrigamiBlockSettings pistonBehavior(PistonBehavior pistonBehavior) {
        super.pistonBehavior(pistonBehavior);
        return this;
    }
    /**
     * Sets the block that this block will be stripped into when using an axe.
     * @see net.minecraft.item.AxeItem Vanilla axe stripping values
     */
    public OrigamiBlockSettings stripInto(Block block) {
        this.stripInto = block;
        return this;
    }
    /**
     * Provides item settings for a {@code BlockItem} to be registered with this block.
     * <p>The item will be registered with the same identifier as the block.
     */
    public OrigamiBlockSettings item(Item.Settings itemSettings) {
        this.itemSettings = itemSettings;
        return this;
    }

    /**
     * Provides empty item settings for a {@code BlockItem} to be registered with this block.
     * <p>The item will be registered with the same identifier as the block.
     */
    public OrigamiBlockSettings item() {
        return item(new Item.Settings());
    }

    // overrides
    @Override
    public OrigamiBlockSettings noCollision() {
        super.noCollision();
        return this;
    }

    @Override
    public OrigamiBlockSettings nonOpaque() {
        super.nonOpaque();
        return this;
    }

    @Override
    public OrigamiBlockSettings burnable() {
        super.burnable();
        return this;
    }

    @Override
    public OrigamiBlockSettings slipperiness(float value) {
        super.slipperiness(value);
        return this;
    }

    @Override
    public OrigamiBlockSettings velocityMultiplier(float velocityMultiplier) {
        super.velocityMultiplier(velocityMultiplier);
        return this;
    }

    @Override
    public OrigamiBlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier) {
        super.jumpVelocityMultiplier(jumpVelocityMultiplier);
        return this;
    }

    @Override
    public OrigamiBlockSettings sounds(BlockSoundGroup group) {
        super.sounds(group);
        return this;
    }

    @Override
    public OrigamiBlockSettings luminance(ToIntFunction<BlockState> luminanceFunction) {
        super.luminance(luminanceFunction);
        return this;
    }

    @Override
    public OrigamiBlockSettings strength(float hardness, float resistance) {
        super.strength(hardness, resistance);
        return this;
    }

    @Override
    public OrigamiBlockSettings breakInstantly() {
        super.breakInstantly();
        return this;
    }

    public OrigamiBlockSettings strength(float strength) {
        super.strength(strength);
        return this;
    }

    @Override
    public OrigamiBlockSettings ticksRandomly() {
        super.ticksRandomly();
        return this;
    }

    @Override
    public OrigamiBlockSettings dynamicBounds() {
        super.dynamicBounds();
        return this;
    }

    @Override
    public OrigamiBlockSettings dropsLike(Block block) {
        super.dropsLike(block);
        return this;
    }

    @Override
    public OrigamiBlockSettings air() {
        super.air();
        return this;
    }

    @Override
    public OrigamiBlockSettings allowsSpawning(AbstractBlock.TypedContextPredicate<EntityType<?>> predicate) {
        super.allowsSpawning(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings solidBlock(AbstractBlock.ContextPredicate predicate) {
        super.solidBlock(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings suffocates(AbstractBlock.ContextPredicate predicate) {
        super.suffocates(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings blockVision(AbstractBlock.ContextPredicate predicate) {
        super.blockVision(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings postProcess(AbstractBlock.ContextPredicate predicate) {
        super.postProcess(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings emissiveLighting(AbstractBlock.ContextPredicate predicate) {
        super.emissiveLighting(predicate);
        return this;
    }

    @Override
    public OrigamiBlockSettings dropsNothing() {
        super.dropsNothing();
        return this;
    }

    @Override
    public OrigamiBlockSettings noBlockBreakParticles() {
        super.noBlockBreakParticles();
        return this;
    }

    @Override
    public OrigamiBlockSettings requires(FeatureFlag... features) {
        super.requires(features);
        return this;
    }

    @Override
    public OrigamiBlockSettings luminance(int luminance) {
        super.luminance(luminance);
        return this;
    }

    @Override
    public OrigamiBlockSettings hardness(float hardness) {
        super.hardness(hardness);
        return this;
    }

    @Override
    public OrigamiBlockSettings resistance(float resistance) {
        super.resistance(resistance);
        return this;
    }

    @Override
    public OrigamiBlockSettings drops(Identifier dropTableId) {
        super.drops(dropTableId);
        return this;
    }

    @Override
    public OrigamiBlockSettings requiresTool() {
        super.requiresTool();
        return this;
    }

    @Override
    public OrigamiBlockSettings mapColor(MapColor color) {
        super.mapColor(color);
        return this;
    }

    @Override
    public OrigamiBlockSettings mapColor(DyeColor color) {
        super.mapColor(color);
        return this;
    }

    @Override
    public OrigamiBlockSettings collidable(boolean collidable) {
        super.collidable(collidable);
        return this;
    }
}
