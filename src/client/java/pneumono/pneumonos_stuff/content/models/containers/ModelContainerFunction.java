package pneumono.pneumonos_stuff.content.models.containers;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;

public interface ModelContainerFunction {
    PlushieModelContainer getContainer(EntityModelLoader loader, EntityModelLayer[] layers);
}
