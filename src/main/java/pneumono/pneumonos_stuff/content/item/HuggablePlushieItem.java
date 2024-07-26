package pneumono.pneumonos_stuff.content.item;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.content.PlushieItem;
import pneumono.pneumonos_stuff.content.PlushieSize;
import pneumono.pneumonos_stuff.registry.PneumonosStuffStats;

public class HuggablePlushieItem extends PlushieItem {
    private final PlushieSize size;

    public HuggablePlushieItem(Block block, PlushieSize size, Settings settings) {
        super(block, settings);
        this.size = size;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player != null && player.isSneaking()) {
            return place(new ItemPlacementContext(context));
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
        int timeHeld = this.getMaxUseTime(stack) - remainingUseTicks;
        int configValue = PneumonosStuff.HUG_HEALTH_PER_MINUTE.getValue();
        if (configValue != 0 && remainingUseTicks >= 0 && timeHeld != 0 && timeHeld % Math.ceil(1200F / configValue) == 0) {
            if (world instanceof ServerWorld serverWorld) {
                float yaw = user.getYaw();
                double d = -MathHelper.sin(yaw * 0.017453292F);
                double e = MathHelper.cos(yaw * 0.017453292F);
                double d2 = -MathHelper.sin((yaw + 45) * 0.017453292F);
                double e2 = MathHelper.cos((yaw + 45) * 0.017453292F);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() + d, user.getY() + 2, user.getZ() + e, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() - e, user.getY() + 2, user.getZ() + d, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() - d, user.getY() + 2, user.getZ() - e, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() + e, user.getY() + 2, user.getZ() - d, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() + d2, user.getY() + 2, user.getZ() + e2, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() - e2, user.getY() + 2, user.getZ() + d2, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() - d2, user.getY() + 2, user.getZ() - e2, 0, 0, 0.0, 0, 0.0);
                serverWorld.spawnParticles(ParticleTypes.HEART, user.getX() + e2, user.getY() + 2, user.getZ() - d2, 0, 0, 0.0, 0, 0.0);
            }
            if (PneumonosStuff.HUG_HEALING.getValue()) {
                user.heal(1);
            }
            super.onStoppedUsing(stack, world, user, remainingUseTicks);
        }
        if (user instanceof PlayerEntity player) {
            player.incrementStat(PneumonosStuffStats.TIME_HUGGING_PLUSHIES);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public PlushieSize getSize() {
        return size;
    }
}
