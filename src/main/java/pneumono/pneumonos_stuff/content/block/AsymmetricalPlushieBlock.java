package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import pneumono.pneumonos_stuff.content.PlushieSide;

public class AsymmetricalPlushieBlock extends PlushieBlock implements Asymmetrical {
    public AsymmetricalPlushieBlock(Settings settings, VoxelShape shape) {
        super(settings, shape);
        setDefaultState(getDefaultState()
                .with(ROTATION, 0)
                .with(WATERLOGGED, false)
                .with(SIDE, PlushieSide.LEFT)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(SIDE, getSide(ctx));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
        builder.add(WATERLOGGED);
        builder.add(SIDE);
    }
}
