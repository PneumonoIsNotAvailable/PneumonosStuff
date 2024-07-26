package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public abstract class PlushieModel extends Model {
    public final ModelPart root;

    public PlushieModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);
        this.root = root;
    }

    public void setRotation(float yaw) {
        root.yaw = yaw * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
