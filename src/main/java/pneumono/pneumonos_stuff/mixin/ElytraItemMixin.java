package pneumono.pneumonos_stuff.mixin;

import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pneumono.pneumonos_stuff.PneumonosStuff;

@Mixin(ElytraItem.class)
@SuppressWarnings("unused")
public abstract class ElytraItemMixin {
    @Inject(method = "isUsable", at = @At("HEAD"), cancellable = true)
    private static void isNotUsable(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (PneumonosStuff.DISABLE_ELYTRA.getValue()) {
            info.setReturnValue(false);
        }
    }
}
