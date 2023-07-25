package net.origamiking.mcmods.oapi;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.origamiking.mcmods.oapi.blocks.OrigamiBlockSettings;
import net.origamiking.mcmods.oapi.items.OrigamiItemSettings;

public class OrigamiFactories {
    // Normal Stuff

    public static Block block(OrigamiBlockSettings settings) {
        return new Block(settings);
    }

    public static Item item(OrigamiItemSettings settings) {
        return new Item(settings);
    }

    public static RegistryKey<Biome> biome(Identifier id) {
        return RegistryKey.of(RegistryKeys.BIOME, id);
    }

    public static RegistryKey<PlacedFeature> placedFeature(Identifier id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, id);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> configuredFeature(Identifier id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, id);
    }

    public static Block planks(boolean isNether, MapColor color) {
        return new Block(OrigamiFactories.planksSettings(isNether, color));
    }

    public static OrigamiBlockSettings planksSettings(boolean isNether, MapColor color) {
        OrigamiBlockSettings settings = isNether ? OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(color) : OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().mapColor(color)
                .item()
                .sounds(isNether ? BlockSoundGroup.NETHER_WOOD : BlockSoundGroup.WOOD);
        if(isNether) settings.flammability(5, 20);
        return settings;
    }

    public static OrigamiBlockSettings logSettings(boolean isNether, MapColor woodColor, MapColor barkColor) {
        OrigamiBlockSettings settings = isNether ? OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(woodColor) : OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().mapColor(woodColor)
                .item()
                .strength(2.0F)
                .sounds(isNether ? BlockSoundGroup.NETHER_STEM : BlockSoundGroup.WOOD);
        if(isNether) settings.flammability(5, 5);
        return settings;
    }

    public static OrigamiBlockSettings logSettings(boolean isNether, MapColor color) {
        OrigamiBlockSettings settings = isNether ? OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(color) : OrigamiBlockSettings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().mapColor(color)
                .item()
                .strength(2.0F)
                .sounds(isNether ? BlockSoundGroup.NETHER_STEM : BlockSoundGroup.WOOD);
        if(isNether) settings.flammability(5, 5);
        return settings;
    }

    public static StairsBlock stairs(Block baseBlock) {
        return new StairsBlock(baseBlock.getDefaultState(), OrigamiBlockSettings.copy(baseBlock));
    }

    public static SlabBlock slab(Block baseBlock) {
        return new SlabBlock(OrigamiBlockSettings.copy(baseBlock));
    }

    public static PressurePlateBlock pressurePlate(Block baseBlock, PressurePlateBlock.ActivationRule activationRule, BlockSetType setType) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.copy(baseBlock)
                .strength(0.5f)
                .noCollision();
        return new PressurePlateBlock(activationRule, settings, setType);
    }

    public static PressurePlateBlock pressurePlate(Block baseBlock) {
        return pressurePlate(baseBlock, PressurePlateBlock.ActivationRule.MOBS, BlockSetType.OAK);
    }

    public static ButtonBlock woodenButton(boolean isNether, BlockSetType setType) {
        return new ButtonBlock(OrigamiBlockSettings.create()
                .item()
                .pistonBehavior(PistonBehavior.DESTROY)
                .strength(0.5f)
                .noCollision()
                .sounds(isNether ? BlockSoundGroup.NETHER_WOOD : BlockSoundGroup.WOOD),
                setType, 30, true);
    }

    public static ButtonBlock woodenButton(boolean isNether) {
        return woodenButton(isNether, BlockSetType.OAK);
    }

    public static FenceBlock fence(boolean isNether, Block baseBlock) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.copy(baseBlock).item(new OrigamiItemSettings().fuelTime(isNether ? 0 : 300));
        if(isNether) settings.flammability(5, 20);
        return new FenceBlock(settings);
    }


    public static FenceGateBlock fenceGate(boolean isNether, Block baseBlock, WoodType woodType) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.copy(baseBlock).item(new OrigamiItemSettings().fuelTime(isNether ? 0 : 300));
        if(isNether) settings.flammability(5, 20);
        return new FenceGateBlock(settings, woodType);
    }

    public static FenceGateBlock fenceGate(boolean isNether, Block baseBlock) {
        return fenceGate(isNether, baseBlock, WoodType.OAK);
    }

    public static WallBlock wall(Block baseBlock) {
        return new WallBlock(OrigamiBlockSettings.copy(baseBlock));
    }

    public static TrapdoorBlock trapdoor(Block baseBlock, BlockSetType setType) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.copy(baseBlock)
                .strength(3.0f)
                .nonOpaque()
                .allowsSpawning((state, world, pos, type) -> false);
        return new TrapdoorBlock(settings, setType);
    }

    public static TrapdoorBlock woodenTrapdoor(Block baseBlock) {
        return trapdoor(baseBlock, BlockSetType.OAK);
    }

    public static DoorBlock door(Block baseBlock, BlockSetType setType) {
        return new DoorBlock(OrigamiBlockSettings.copy(baseBlock).strength(3.0f).nonOpaque(), setType);
    }

    public static DoorBlock woodenDoor(Block baseBlock) {
        return door(baseBlock, BlockSetType.OAK);
    }
    public static FlowerPotBlock potted(Block content) {
        return new FlowerPotBlock(content, OrigamiBlockSettings.create().mapColor(MapColor.CLEAR).notSolid().breakInstantly().nonOpaque().luminance(content.getDefaultState().getLuminance()).pistonBehavior(PistonBehavior.DESTROY));
    }

    public static LeavesBlock leaves() {
        return leaves(BlockSoundGroup.GRASS);
    }

    public static LeavesBlock leaves(BlockSoundGroup soundGroup) {
        return new LeavesBlock(OrigamiBlockSettings.create()
                .mapColor(MapColor.DARK_GREEN).burnable().nonOpaque()
                .item(new OrigamiItemSettings().compostingChance(0.3f))
                .pistonBehavior(PistonBehavior.DESTROY)
                .strength(0.2f)
                .ticksRandomly()
                .sounds(soundGroup)
                .nonOpaque()
                .allowsSpawning((state, world, pos, type) -> type == EntityType.OCELOT || type == EntityType.PARROT)
                .suffocates((state, world, pos) -> false)
                .blockVision((state, world, pos) -> false)
                .flammability(30, 60));
    }

    // Random Stuff
    public static SpawnEggItem spawnEgg(EntityType<? extends MobEntity> entity, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(entity, primaryColor, secondaryColor, new OrigamiItemSettings());
    }
}
