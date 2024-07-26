package pneumono.pneumonos_stuff.mixin;

import net.minecraft.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import pneumono.pneumonos_stuff.PneumonosStuff;

@Mixin(BeaconBlockEntity.class)
@SuppressWarnings("unused")
public abstract class BeaconBlockEntityMixin {
    @ModifyVariable(method = "applyPlayerEffects", at = @At(value = "STORE"), ordinal = 0)
    private static double applyPlayerEffectsInLargerRadius(double size) {
        return size * PneumonosStuff.BEACON_RANGE_MULTIPLIER.getValue();
    }
}
