package pneumono.pneumonos_stuff.content.block;

import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import pneumono.pneumonos_stuff.content.PlushieSide;

public interface Asymmetrical {
    EnumProperty<PlushieSide> SIDE = EnumProperty.of("side", PlushieSide.class);

    default PlushieSide getSide(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        Direction direction = ctx.getHorizontalPlayerFacing();

        Vec3d hitPos = ctx.getHitPos();
        double x = hitPos.x - (double)blockPos.getX();
        double z = hitPos.z - (double)blockPos.getZ();
        return switch (direction) {
            case NORTH -> x < 0.5 ? PlushieSide.LEFT : PlushieSide.RIGHT;
            case SOUTH -> x > 0.5 ? PlushieSide.LEFT : PlushieSide.RIGHT;
            case WEST -> z > 0.5 ? PlushieSide.LEFT : PlushieSide.RIGHT;
            case EAST -> z < 0.5 ? PlushieSide.LEFT : PlushieSide.RIGHT;
            default -> PlushieSide.LEFT;
        };
    }
}
