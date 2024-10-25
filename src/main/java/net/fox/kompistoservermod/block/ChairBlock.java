package net.fox.kompistoservermod.block;

import net.fox.kompistoservermod.KompistoServerMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChairBlock extends Block {
    // Define the facing property to allow direction adjustment
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    // Define the seat and legs shape (same as before)
    private static final VoxelShape SEAT = VoxelShapes.cuboid(
            0.075, 0.4375, 0.075,
            0.925, 0.7, 0.925
    );
    private static final VoxelShape LEG_1 = VoxelShapes.cuboid(
            0.075, 0.0, 0.075,
            0.2, 0.4375, 0.2
    );
    private static final VoxelShape LEG_2 = VoxelShapes.cuboid(
            0.075, 0.0, 0.8,
            0.2, 0.4375, 0.925
    );
    private static final VoxelShape LEG_3 = VoxelShapes.cuboid(
            0.8, 0.0, 0.075,
            0.925, 0.4375, 0.2
    );
    private static final VoxelShape LEG_4 = VoxelShapes.cuboid(
            0.8, 0.0, 0.8,
            0.925, 0.4375, 0.925
    );

    private static final VoxelShape CHAIR_SHAPE = VoxelShapes.union(SEAT, LEG_1, LEG_2, LEG_3, LEG_4);

    public ChairBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING); // Add FACING to the block's properties
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        // Set the block's facing direction based on the player's facing
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        // Rotate the block's facing direction when rotated
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        // Adjust the block's facing direction when mirrored
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Use the same shape for outline
        return CHAIR_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Use the same shape for collision
        return CHAIR_SHAPE;
    }

}