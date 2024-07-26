package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.PneumonosStuff;

public class CalibratedNoisyPlushieBlock extends NoisyPlushieBlock {
    public static final IntProperty NOTE = Properties.NOTE;

    public CalibratedNoisyPlushieBlock(Settings settings, SoundEvent plushieNoise, Identifier statistic, VoxelShape shape) {
        super(settings, plushieNoise, statistic, shape);
        this.setDefaultState(getDefaultState()
                .with(ROTATION, 0)
                .with(WATERLOGGED, false)
                .with(POWERED, false)
                .with(NOTE, 0)
        );
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        if (itemStack.isIn(ItemTags.NOTEBLOCK_TOP_INSTRUMENTS) && hit.getSide() == Direction.UP) {
            return ActionResult.PASS;
        } else if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            world.setBlockState(pos, state.cycle(NOTE), 3);
            playNoise(player, pos, false);
            return ActionResult.CONSUME;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean powered = world.isReceivingRedstonePower(pos);
        if (PneumonosStuff.REDSTONE_QUACKING.getValue() && powered != state.get(POWERED)) {
            if (powered) {
                playNoise(world, pos, false);
            }

            world.setBlockState(pos, state.with(POWERED, powered), 3);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
        builder.add(WATERLOGGED);
        builder.add(POWERED);
        builder.add(NOTE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(POWERED, false)
                .with(NOTE, 0);
    }

    @Override
    public void playNoise(World world, BlockPos pos, boolean fromPlayer) {
        if (!world.isClient()) {
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), this.plushieNoise, fromPlayer ? SoundCategory.PLAYERS : SoundCategory.BLOCKS, 0.5F, getNotePitch(world, pos, fromPlayer));
        }
    }

    public static float getNotePitch(World world, BlockPos pos, boolean randomNote) {
        Random random = world.getRandom();
        BlockState state = world.getBlockState(pos);
        boolean fromCalibratedBlock = state.getBlock() instanceof CalibratedNoisyPlushieBlock;
        int note = fromCalibratedBlock ? world.getBlockState(pos).get(NOTE) : 0;
        return randomNote && !fromCalibratedBlock?
                (random.nextFloat() < 0.01 ? 0.4F : 1.0F) / (random.nextFloat() * 0.4F + 0.8F) :
                (float)Math.pow(2.0, (double)(note - 12) / 12.0);
    }
}
