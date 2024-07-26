package pneumono.pneumonos_stuff.mixin.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pneumono.pneumonos_stuff.content.item.HuggablePlushieItem;

@Mixin(HeldItemFeatureRenderer.class)
@SuppressWarnings("unused")
public abstract class HeldItemFeatureRendererMixin {
    @Shadow
    @Final
    private HeldItemRenderer heldItemRenderer;

    @Inject(method = "renderItem", at = @At("HEAD"), cancellable = true)
    public void doNotRenderItem(LivingEntity entity, ItemStack stack, ModelTransformationMode transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
        if (entity instanceof PlayerEntity && stack.getItem() instanceof HuggablePlushieItem) {
            info.cancel();
        }
    }
}
