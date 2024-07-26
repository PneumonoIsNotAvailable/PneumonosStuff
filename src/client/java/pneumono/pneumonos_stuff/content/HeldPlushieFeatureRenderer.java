package pneumono.pneumonos_stuff.content;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import pneumono.pneumonos_stuff.PneumonosStuffClient;
import pneumono.pneumonos_stuff.content.models.PlushieTransformation;

public class HeldPlushieFeatureRenderer<T extends LivingEntity, M extends EntityModel<T> & ModelWithHead> extends FeatureRenderer<T, M> {
    private final HeldItemRenderer heldItemRenderer;

    public HeldPlushieFeatureRenderer(FeatureRendererContext<T, M> context, HeldItemRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack item = ClientUtil.getHuggablePlushie(entity);
        if (item != null) {
            matrices.push();

            PlushieTransformation transformation = PneumonosStuffClient.PLUSHIES.get(item.getItem()).transformation();

            ((BipedEntityModel<?>)this.getContextModel()).body.rotate(matrices);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(transformation.rotationX));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(transformation.rotationY));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(transformation.rotationZ));
            matrices.translate(transformation.translationX, transformation.translationY, transformation.translationZ);
            matrices.scale(transformation.scaleX, -transformation.scaleY, -transformation.scaleZ);

            this.heldItemRenderer.renderItem(entity, item, ModelTransformationMode.NONE, false, matrices, vertexConsumerProvider, light);

            matrices.pop();
        }
    }
}