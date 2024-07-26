package pneumono.pneumonos_stuff.content.models.containers;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.content.models.PlushieModel;

public class SingleModelContainer extends PlushieModelContainer {
    public SingleModelContainer(Identifier texture, PlushieModel model) {
        super(new Identifier[]{texture}, new PlushieModel[]{model});
    }

    @Override
    public PlushieModel getModel(World world, BlockPos pos) {
        return models[0];
    }

    @Override
    public Identifier getTexture(World world, BlockPos pos) {
        return textures[0];
    }
}
