package net.origamiking.mcmods.oapi;

import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.origamiking.mcmods.oapi.blocks.OrigamiBlockSettings;
import net.origamiking.mcmods.oapi.entity.boat.impl.item.OrigamiBoatItem;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatType;
import net.origamiking.mcmods.oapi.entity.boat.api.OrigamiBoatTypeRegistry;
import net.origamiking.mcmods.oapi.items.OrigamiItemSettings;

public class OrigamiFactories {
    // Normal Stuff

    public static Block block(AbstractBlock.Settings settings) {
        return new Block(settings);
    }

    public static Item item(Item.Settings settings) {
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
    public static TagKey<Block> blockTag(Identifier id) {
        return TagKey.of(RegistryKeys.BLOCK, id);
    }

    public static TagKey<Item> itemTag(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }

    public static TagKey<Biome> biomeTag(Identifier id) {
        return TagKey.of(RegistryKeys.BIOME, id);
    }

    public static TagKey<Fluid> fluidTag(Identifier id) {
        return TagKey.of(RegistryKeys.FLUID, id);
    }



    /*==========*/
    /*   WOOD   */
    /*==========*/

    public static Block planks(boolean isNether, MapColor color) {
        return new Block(OrigamiFactories.planksSettings(isNether, color));
    }

    public static OrigamiBlockSettings planksSettings(boolean isNether, MapColor color) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.of(isNether ? Material.NETHER_WOOD : Material.WOOD, color)
                .item()
                .strength(2.0f, 3.0f)
                .sounds(isNether ? BlockSoundGroup.NETHER_WOOD : BlockSoundGroup.WOOD);
        if(isNether) settings.flammability(5, 20);
        return settings;
    }

    public static OrigamiBlockSettings logSettings(boolean isNether, MapColor woodColor, MapColor barkColor) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.of(isNether ? Material.NETHER_WOOD : Material.WOOD, (state) -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? woodColor : barkColor)
                .item()
                .strength(2.0F)
                .sounds(isNether ? BlockSoundGroup.NETHER_STEM : BlockSoundGroup.WOOD);
        if(isNether) settings.flammability(5, 5);
        return settings;
    }

    public static OrigamiBlockSettings logSettings(boolean isNether, MapColor color) {
        OrigamiBlockSettings settings = OrigamiBlockSettings.of(isNether ? Material.NETHER_WOOD : Material.WOOD, color)
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
        return new ButtonBlock(OrigamiBlockSettings.of(Material.DECORATION)
                .item()
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
        return new FlowerPotBlock(content, OrigamiBlockSettings.of(Material.DECORATION).breakInstantly().nonOpaque().luminance(content.getDefaultState().getLuminance()));
    }

    public static LeavesBlock leaves() {
        return leaves(BlockSoundGroup.GRASS);
    }

    public static LeavesBlock leaves(BlockSoundGroup soundGroup) {
        return new LeavesBlock(OrigamiBlockSettings.of(Material.LEAVES)
                .item(new OrigamiItemSettings().compostingChance(0.3f))
                .strength(0.2f)
                .ticksRandomly()
                .sounds(soundGroup)
                .nonOpaque()
                .allowsSpawning((state, world, pos, type) -> type == EntityType.OCELOT || type == EntityType.PARROT)
                .suffocates((state, world, pos) -> false)
                .blockVision((state, world, pos) -> false)
                .flammability(30, 60));
    }
// Comming soon
//
//    public static SignBlocks signs(Identifier texturePath, Block basePlanks) {
//        var signTexture = Identifier.of(texturePath.getNamespace(), "entity/signs/" + texturePath.getPath());
//        var hangingSignTexture = Identifier.of(texturePath.getNamespace(), "entity/signs/hanging/" + texturePath.getPath());
//        var hangingSignGuiTexture = Identifier.of(texturePath.getNamespace(), "textures/gui/hanging_signs/" + texturePath.getPath());
//
//        var sign = new TerraformSignBlock(signTexture, signSettings(basePlanks));
//        var wallSign = new TerraformWallSignBlock(signTexture, signSettings(basePlanks));
//        var hangingSign = new TerraformHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, hangingSignSettings(basePlanks));
//        var wallHangingSign = new TerraformWallHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, hangingSignSettings(basePlanks));
//        var signItem = new SignItem(new OrigamiItemSettings().maxCount(16), sign, wallSign);
//        var hangingSignItem = new HangingSignItem(hangingSign, wallHangingSign, new OrigamiItemSettings().maxCount(16).requires(FeatureFlags.UPDATE_1_20));
//
//        return new SignBlocks(sign, wallSign, hangingSign, wallHangingSign, signItem, hangingSignItem);
//    }

    public static OrigamiBlockSettings signSettings(Block basePlanks, boolean hanging) {
        var settings = OrigamiBlockSettings.of(basePlanks.getDefaultState().getMaterial(), basePlanks.getDefaultMapColor()).noCollision().strength(1.0F);
        if(hanging) {
            settings.sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20);
        }
        else {
            settings.sounds(BlockSoundGroup.WOOD);
        }
        return settings;
    }

    public static OrigamiBlockSettings signSettings(Block basePlanks) {
        return signSettings(basePlanks, false);
    }

    public static OrigamiBlockSettings hangingSignSettings(Block basePlanks) {
        return signSettings(basePlanks, true);
    }

    public static OrigamiBoatType boat(Identifier id, ItemConvertible planks, boolean raft) {
        RegistryKey<OrigamiBoatType> key = OrigamiBoatTypeRegistry.createKey(id);
        var builder = new OrigamiBoatType.Builder()
                .item(new OrigamiBoatItem(key, false, new Item.Settings().maxCount(1)))
                .chestItem(new OrigamiBoatItem(key, true, new Item.Settings().maxCount(1)))
                .planks(planks.asItem());
        if(raft) builder.raft();
        return builder.build();
    }
    public static OrigamiBoatType boat(Identifier id, ItemConvertible planks) {
        return boat(id, planks, false);
    }
    public static OrigamiBoatType raft(Identifier id, ItemConvertible planks) {
        return boat(id, planks, true);
    }
    // Random Stuff
    public static SpawnEggItem spawnEgg(EntityType<? extends MobEntity> entity, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(entity, primaryColor, secondaryColor, new OrigamiItemSettings());
    }
}