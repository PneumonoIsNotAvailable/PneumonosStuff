package pneumono.pneumonos_stuff.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.pneumono.pneumonocore.effect.ModStatusEffect;
import pneumono.pneumonos_stuff.PneumonosStuff;

public class PneumonosStuffEffects {
    public static final StatusEffect CONDUIT_AURA = registerStatusEffect("conduit_aura", new ModStatusEffect(StatusEffectCategory.BENEFICIAL, 1950417));

    protected static void registerPneumonosStuffEffects() {

    }

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, PneumonosStuff.identifier(name), effect);
    }
}
