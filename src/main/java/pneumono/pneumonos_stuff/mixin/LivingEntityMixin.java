package pneumono.pneumonos_stuff.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pneumono.pneumonos_stuff.registry.PneumonosStuffEffects;

@Mixin(LivingEntity.class)
@SuppressWarnings("unused")
public abstract class LivingEntityMixin {
    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damageIfNotWater(DamageSource source, float amount, CallbackInfoReturnable<Boolean> info) {
        RegistryKey<DamageType> key = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of("origins", "hurt_by_water"));
        if (source.isOf(key) && (hasStatusEffect(PneumonosStuffEffects.CONDUIT_AURA) || hasStatusEffect(StatusEffects.CONDUIT_POWER))) {
            info.setReturnValue(false);
        }
    }
}
