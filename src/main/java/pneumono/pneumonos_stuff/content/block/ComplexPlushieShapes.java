package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.Block;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ComplexPlushieShapes {
    public static final VoxelShape GLOW_SQUID = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(5, 2, 5, 11, 10, 11),
            Block.createCuboidShape(1, 0, 1, 15, 2, 15), BooleanBiFunction.OR);
}
