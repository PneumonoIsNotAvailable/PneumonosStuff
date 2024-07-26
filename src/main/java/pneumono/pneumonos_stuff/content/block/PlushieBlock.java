package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pneumono.pneumonos_stuff.registry.PneumonosStuffSounds;

public class PlushieBlock extends BlockWithEntity implements Waterloggable {
    public static final IntProperty ROTATION = Properties.ROTATION;
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public final VoxelShape SHAPE;

    public PlushieBlock(Settings settings, VoxelShape shape) {
        super(settings);
        this.SHAPE = shape;
        setDefaultState(getDefaultState()
                .with(ROTATION, 0)
                .with(WATERLOGGED, false)
        );
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        world.playSound(null, pos, PneumonosStuffSounds.PLUSHIE_SQUEAK, SoundCategory.BLOCKS, 1.0F, 0.8F);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PlushieBlockEntity plushie) {
            ItemStack storedPlushie = plushie.getStoredPlushie();

            if (storedPlushie != null && !player.isCreative() && world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) {
                double x = (double) pos.getX() + 0.5 + MathHelper.nextDouble(world.random, -0.25, 0.25);
                double y = (double) pos.getY() + 0.5 + MathHelper.nextDouble(world.random, -0.25, 0.25) - EntityType.ITEM.getHeight() / 2.0;
                double z = (double) pos.getZ() + 0.5 + MathHelper.nextDouble(world.random, -0.25, 0.25);

                ItemEntity itemEntity = new ItemEntity(world, x, y, z, storedPlushie);
                itemEntity.setToDefaultPickupDelay();
                world.spawnEntity(itemEntity);
            }
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), MAX_ROTATIONS));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, mirror.mirror(state.get(ROTATION), MAX_ROTATIONS));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
        builder.add(WATERLOGGED);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlushieBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
