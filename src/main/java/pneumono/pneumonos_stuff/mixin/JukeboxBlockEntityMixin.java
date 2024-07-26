package pneumono.pneumonos_stuff.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.entity.Hopper;
import net.minecraft.block.entity.JukeboxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import pneumono.pneumonos_stuff.PneumonosStuff;

import java.util.Objects;

@Mixin(JukeboxBlockEntity.class)
@SuppressWarnings("unused")
public abstract class JukeboxBlockEntityMixin {
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/JukeboxBlockEntity;stopPlaying()V"))
    private void stopPlayingOrLoop(JukeboxBlockEntity blockEntity, Operation<Void> original) {
        if (!PneumonosStuff.JUKEBOX_LOOPING.getValue() || Objects.requireNonNull(blockEntity.getWorld()).getBlockEntity(blockEntity.getPos().down()) instanceof Hopper) {
            original.call(blockEntity);
        } else {
            blockEntity.startPlaying();
        }
    }
}
