package pneumono.pneumonos_stuff.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pneumono.pneumonos_stuff.content.item.HuggablePlushieItem;
import pneumono.pneumonos_stuff.content.ClientUtil;

import java.util.Objects;

@Mixin(BipedEntityModel.class)
@SuppressWarnings("unused")
public abstract class BipedEntityModelMixin {
    @Shadow
    public @Final ModelPart rightArm;

    @Shadow
    public @Final ModelPart leftArm;

    @Shadow
    public @Final ModelPart head;

    @Inject(method = "positionLeftArm", at = @At("HEAD"), cancellable = true)
    public void leftArmHug(LivingEntity entity, CallbackInfo ci) {
        if (ClientUtil.hasHuggablePlushie(entity)) {
            this.leftArm.pitch = -0.95F;
            this.leftArm.yaw = getYaw(entity, false);
            ci.cancel();
        }
    }

    @Inject(method = "positionRightArm", at = @At("HEAD"), cancellable = true)
    public void rightArmHug(LivingEntity entity, CallbackInfo ci) {
        if (ClientUtil.hasHuggablePlushie(entity)) {
            this.rightArm.pitch = -0.95F;
            this.rightArm.yaw = getYaw(entity, true);
            ci.cancel();
        }
    }

    private float getYaw(LivingEntity entity, boolean negativePi) {
        double pi = negativePi ? -Math.PI : Math.PI;
        boolean hugging = entity.isUsingItem() && entity.getActiveItem().getItem() instanceof HuggablePlushieItem;
        HuggablePlushieItem item = ClientUtil.getHuggablePlushieItem(entity);
        if (item != null) {
            return switch (item.getSize()) {
                case SMALL -> (float) (pi / (8f / (hugging ? 2 : 1)));
                case MEDIUM -> (float) (pi / (12f / (hugging ? 2 : 1)));
                case LARGE -> hugging ? (float)(pi / 40) : 0.0F;
            };
        }
        return (float)(pi / (8f / (hugging ? 2 : 1)));
    }

    @WrapOperation(method = "setAngles", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isUsingItem()Z", ordinal = 0))
    private boolean bothArmsHug(LivingEntity entity, Operation<Boolean> original) {
        if (ClientUtil.hasHuggablePlushie(entity)) {
            return false;
        } else {
            return original.call(entity);
        }
    }

    @Inject(method = "setAngles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelPart;copyTransform(Lnet/minecraft/client/model/ModelPart;)V", ordinal = 0))
    public void setHugAngles(LivingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo ci) {
        ItemStack activeItem = entity.getActiveItem();
        if (entity.isUsingItem() && activeItem.getItem() instanceof HuggablePlushieItem) {
            // "Seizure" is an Easter Egg added after I accidentally messed up the values and got... that. It was funny so I kept it :>
            boolean isSeizure = Objects.equals(activeItem.getName().getString(), "Seizure");
            float value = !isSeizure ? (float)(Math.sin(animationProgress / 20) / 4) : (float)(Math.sin(animationProgress) * 5);
            this.head.roll = value + (!isSeizure ? value / 2 : 0);
        } else {
            this.head.roll = 0.0F;
        }
    }
}
