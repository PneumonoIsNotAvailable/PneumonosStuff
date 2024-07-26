package pneumono.pneumonos_stuff.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.entity.ConduitBlockEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.registry.PneumonosStuffEffects;

@Mixin(ConduitBlockEntity.class)
@SuppressWarnings("unused")
public abstract class ConduitBlockEntityMixin {
    @ModifyExpressionValue(method = "givePlayersEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isTouchingWaterOrRain()Z"))
    private static boolean removeInWaterCondition(boolean original) {
        return PneumonosStuff.CONDUIT_PROTECTION.getValue() || original;
    }

    @ModifyExpressionValue(method = "givePlayersEffects", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/effect/StatusEffects;CONDUIT_POWER:Lnet/minecraft/entity/effect/StatusEffect;"))
    private static StatusEffect conduitPowerOrProtection(StatusEffect original, @Local PlayerEntity playerEntity) {
        return playerEntity.isTouchingWaterOrRain() ? original : PneumonosStuffEffects.CONDUIT_AURA;
    }
}
