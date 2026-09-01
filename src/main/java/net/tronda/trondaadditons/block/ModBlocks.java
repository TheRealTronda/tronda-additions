package net.tronda.trondaadditons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.tronda.trondaadditons.TrondaAdditions;
import net.tronda.trondaadditons.block.custom.MagicBlock;

public class ModBlocks {
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block TIN_BLOCK_STAIRS = registerBlock("tin_blocks_stairs",
            new StairsBlock(ModBlocks.TIN_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_SLAB = registerBlock("tin_blocks_slab",
            new SlabBlock(AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_BUTTON = registerBlock("tin_blocks_button",
            new ButtonBlock(BlockSetType.IRON, 2,
                    AbstractBlock.Settings.create().requiresTool().strength(2f).noCollision().sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_PRESSURE_PLATE = registerBlock("tin_blocks_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().strength(2f).noCollision().sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_FENCE = registerBlock("tin_blocks_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_FENCE_GATE = registerBlock("tin_blocks_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_WALL= registerBlock("tin_blocks_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_DOOR= registerBlock("tin_blocks_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque().strength(2f).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK_TRAPDOOR= registerBlock("tin_blocks_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque().strength(2f).sounds(BlockSoundGroup.METAL)));


    public static final Block TIN_ORE_BLOCK = registerBlock("tin_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.STONE)));
    public static final Block TIN_RAW_BLOCK = registerBlock("tin_raw_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.TUFF)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TrondaAdditions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TrondaAdditions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TrondaAdditions.LOGGER.info("Registering blocks for " + TrondaAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(TIN_BLOCK);
            entries.add(TIN_ORE_BLOCK);
            entries.add(TIN_RAW_BLOCK);
        });
    }
}
