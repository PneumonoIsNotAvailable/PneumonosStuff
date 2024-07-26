package pneumono.pneumonos_stuff.content.models.containers;

import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.content.block.Asymmetrical;
import pneumono.pneumonos_stuff.content.PlushieSide;
import pneumono.pneumonos_stuff.content.models.PlushieModel;

public class AsymmetricalModelContainer extends PlushieModelContainer {
    public AsymmetricalModelContainer(Identifier texture, PlushieModel leftModel, PlushieModel rightModel) {
        super(new Identifier[]{texture}, new PlushieModel[]{leftModel, rightModel});
    }

    @Override
    public PlushieModel getModel(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return models[state != null && state.getBlock() instanceof Asymmetrical && state.get(Asymmetrical.SIDE) == PlushieSide.RIGHT ? 1 : 0];
    }

    @Override
    public Identifier getTexture(World world, BlockPos pos) {
        return textures[0];
    }
}
