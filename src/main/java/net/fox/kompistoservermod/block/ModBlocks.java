package net.fox.kompistoservermod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fox.kompistoservermod.KompistoServerMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.item.ItemPlacementContext;

public class ModBlocks {

    // DildoBlock class with rotation and facing properties
    public static class DildoBlock extends Block {
        public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
        private static final VoxelShape SHAPE = VoxelShapes.cuboid(0.325f, 0, 0.325f, 0.675f, 0.7f, 0.675f);

        public DildoBlock(Settings settings) {
            super(settings);
            this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return SHAPE;
        }

        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return SHAPE;
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }

        @Override
        public BlockState getPlacementState(ItemPlacementContext context) {
            return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
        }

        @Override
        public BlockState rotate(BlockState state, BlockRotation rotation) {
            return state.with(FACING, rotation.rotate(state.get(FACING)));
        }

        @Override
        public BlockState mirror(BlockState state, BlockMirror mirror) {
            return state.rotate(mirror.getRotation(state.get(FACING)));
        }
    }

    // WallTrimmings class
    public static class WallTrimmings extends Block {
        public WallTrimmings(Settings settings) {
            super(settings);
        }
    }

    // TableBlock class with a predefined table shape
    public static class TableBlock extends Block {
        private static final VoxelShape TABLE_TOP = VoxelShapes.cuboid(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0);
        private static final VoxelShape LEG_1 = VoxelShapes.cuboid(0.8125, 0.0, 0.8125, 0.9375, 0.9375, 0.9375);
        private static final VoxelShape LEG_2 = VoxelShapes.cuboid(0.8125, 0.0, 0.0625, 0.9375, 0.9375, 0.1875);
        private static final VoxelShape LEG_3 = VoxelShapes.cuboid(0.0625, 0.0, 0.0625, 0.1875, 0.9375, 0.1875);
        private static final VoxelShape LEG_4 = VoxelShapes.cuboid(0.0625, 0.0, 0.8125, 0.1875, 0.9375, 0.9375);
        private static final VoxelShape TABLE_SHAPE = VoxelShapes.union(TABLE_TOP, LEG_1, LEG_2, LEG_3, LEG_4);

        public TableBlock(Settings settings) {
            super(settings);
        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return TABLE_SHAPE;
        }

        @Override
        public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
            return TABLE_SHAPE;
        }
    }

    // ChairWooden class
    public static class ChairWooden extends ChairBlock {
        public ChairWooden(Settings settings) {
            super(settings);
        }
    }

    // ChairStone class
    public static class ChairStone extends ChairBlock {
        public ChairStone(Settings settings) {
            super(settings);
        }
    }

    // Block definitions
    public static final Block BIG_FUCK_OFF_DILDO = registerBlock("big_fuck_off_dildo",
            new DildoBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SLIME).nonOpaque()));

    public static final Block TABLE_WOODEN = registerBlock("table_wooden",
            new TableBlock(AbstractBlock.Settings.create().strength(3f).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    public static final Block TABLE_STONE = registerBlock("table_stone",
            new TableBlock(AbstractBlock.Settings.create().strength(6f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block WALL_TRIMMING_WOOD = registerBlock("wall_trimming_wood",
            new WallTrimmings(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.WOOD)));

    public static final Block WALL_TRIMMING_BAMBOO = registerBlock("wall_trimming_bamboo",
            new WallTrimmings(AbstractBlock.Settings.create().strength(1.5f).sounds(BlockSoundGroup.BAMBOO_WOOD)));

    // New Chair Blocks
    public static final Block CHAIR_WOODEN = registerBlock("chair_wooden",
            new ChairWooden(AbstractBlock.Settings.create().strength(2f).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    public static final Block CHAIR_STONE = registerBlock("chair_stone",
            new ChairStone(AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));

    // Helper methods for registration
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KompistoServerMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KompistoServerMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Register blocks and add them to item groups
    public static void registerModBlocks() {
        KompistoServerMod.LOGGER.info("Registering Mod Blocks for " + KompistoServerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModBlocks.BIG_FUCK_OFF_DILDO);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.WALL_TRIMMING_WOOD);
            entries.add(ModBlocks.WALL_TRIMMING_BAMBOO);
            entries.add(ModBlocks.TABLE_WOODEN);
            entries.add(ModBlocks.TABLE_STONE);
            entries.add(ModBlocks.CHAIR_WOODEN); // Add wooden chair to item group
            entries.add(ModBlocks.CHAIR_STONE);  // Add stone chair to item group
        });
    }
}