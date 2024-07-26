package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.pneumono.pneumonocore.entitydata.EntityDataSaver;

public class NoisyPlushieBlock extends PlushieBlock {
    public static final BooleanProperty POWERED = Properties.POWERED;
    protected final SoundEvent plushieNoise;
    protected final Identifier statistic;

    public NoisyPlushieBlock(Settings settings, SoundEvent plushieNoise, Identifier statistic, VoxelShape shape) {
        super(settings, shape);
        this.plushieNoise = plushieNoise;
        this.statistic = statistic;
        this.setDefaultState(getDefaultState()
                .with(ROTATION, 0)
                .with(WATERLOGGED, false)
                .with(POWERED, false)
        );
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            playNoise(player, pos, false);
            return ActionResult.CONSUME;
        } else {
            return ActionResult.SUCCESS;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!world.isClient()) {
            playNoise(player, pos, false);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
        builder.add(WATERLOGGED);
        builder.add(POWERED);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(POWERED, false);
    }

    public void playNoise(LivingEntity entity, boolean fromPlayer) {
        playNoise(entity, entity.getBlockPos(), fromPlayer);
    }

    public void playNoise(LivingEntity entity, BlockPos pos, boolean fromPlayer) {
        playNoise(entity.getWorld(), pos, fromPlayer);

        if (entity instanceof PlayerEntity player && this.statistic != null) {
            player.incrementStat(this.statistic);

            if (player instanceof ServerPlayerEntity serverPlayer) {
                NbtCompound nbt = ((EntityDataSaver)serverPlayer).getModdedData();
                int quacks = nbt.getInt("quacks");
                quacks++;
                nbt.putInt("quacks", quacks);
            }
        }
    }

    public void playNoise(World world, BlockPos pos, boolean fromPlayer) {
        if (!world.isClient()) {
            Random random = world.getRandom();
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), this.plushieNoise, fromPlayer ? SoundCategory.PLAYERS : SoundCategory.BLOCKS, 0.5F, (random.nextFloat() < 0.01 ? 0.4F : 1.0F) / (random.nextFloat() * 0.4F + 0.8F));
        }
    }
}