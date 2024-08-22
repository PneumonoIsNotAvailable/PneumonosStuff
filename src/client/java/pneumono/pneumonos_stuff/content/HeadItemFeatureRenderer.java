package pneumono.pneumonos_stuff.content;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import pneumono.pneumonos_stuff.registry.HeadItemConditions;

public class HeadItemFeatureRenderer<T extends LivingEntity, M extends EntityModel<T> & ModelWithHead> extends FeatureRenderer<T, M> {
    private final HeldItemRenderer heldItemRenderer;

    public HeadItemFeatureRenderer(FeatureRendererContext<T, M> context, HeldItemRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        boolean shouldRender = false;
        ItemStack stack = ItemStack.EMPTY;
        for (HeadItemCondition condition : HeadItemConditions.CONDITIONS) {
            if (condition.shouldRender(entity)) {
                shouldRender = true;
                stack = condition.stack();
                break;
            }
        }

        if (shouldRender) {
            matrices.push();

            this.getContextModel().getHead().rotate(matrices);
            matrices.translate(0.0F, -0.25F, 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            matrices.scale(0.625F, -0.625F, -0.625F);

            if (entity.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof ArmorItem) {
                matrices.translate(0.0F, 0.12F, 0.0F);
            }

            this.heldItemRenderer.renderItem(entity, stack, ModelTransformationMode.HEAD, false, matrices, vertexConsumers, light);

            matrices.pop();
        }
    }
}
