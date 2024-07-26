package pneumono.pneumonos_stuff.content;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import pneumono.pneumonos_stuff.content.block.PlushieBlockEntity;
import pneumono.pneumonos_stuff.registry.PneumonosStuffSounds;

public class PlushieItem extends Item {
    private final Block block;

    public PlushieItem(Block block, Settings settings) {
        super(settings);
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return place(new ItemPlacementContext(context));
    }

    public ActionResult place(ItemPlacementContext context) {
        World world = context.getWorld();
        if (!this.getBlock().isEnabled(world.getEnabledFeatures()) || !context.canPlace()) {
            return ActionResult.FAIL;
        } else {
            PlayerEntity player = context.getPlayer();
            BlockPos pos = context.getBlockPos();

            // Check whether plushie can be placed
            BlockState blockState = this.getBlock().getPlacementState(context);
            boolean canPlace = blockState != null &&
                    blockState.canPlaceAt(world, pos) &&
                    world.canPlace(blockState, pos, (player == null ? ShapeContext.absent() : ShapeContext.of(player)));

            BlockState stateToPlace = canPlace ? blockState : null;

            // Attempt placement if it can
            if (stateToPlace == null || !world.setBlockState(pos, stateToPlace, 11)) {
                return ActionResult.FAIL;
            } else {
                ItemStack stack = context.getStack();
                BlockState placedState = world.getBlockState(pos);
                placedState.getBlock().onPlaced(world, pos, placedState, player, stack);

                // Update NBT of newly placed plushie :>
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof PlushieBlockEntity plushie) {
                    plushie.setStoredPlushie(stack.copy());
                }

                // Extras
                if (player instanceof ServerPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)player, pos, stack);
                }
                world.playSound(player, pos, PneumonosStuffSounds.PLUSHIE_SQUEAK, SoundCategory.BLOCKS, 1.0F, 0.8F);
                world.emitGameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(player, placedState));
                if (player == null || !player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }

                return ActionResult.success(world.isClient);
            }
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        if (!world.isClient()) {
            world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), PneumonosStuffSounds.PLUSHIE_SQUEAK, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient()) {
            world.playSound(null, miner.getX(), miner.getY(), miner.getZ(), PneumonosStuffSounds.PLUSHIE_SQUEAK, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
