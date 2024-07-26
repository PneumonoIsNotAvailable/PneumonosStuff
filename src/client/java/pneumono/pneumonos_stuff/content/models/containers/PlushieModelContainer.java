package pneumono.pneumonos_stuff.content.models.containers;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.content.models.PlushieModel;

public abstract class PlushieModelContainer {
    protected final Identifier[] textures;
    protected final PlushieModel[] models;

    public PlushieModelContainer(Identifier[] textures, PlushieModel[] models) {
        this.models = models;
        this.textures = textures;
    }

    public abstract PlushieModel getModel(World world, BlockPos pos);

    public abstract Identifier getTexture(World world, BlockPos pos);
}
