package pneumono.pneumonos_stuff.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import pneumono.pneumonos_stuff.PneumonosStuff;

public class PneumonosStuffSounds {
    public static SoundEvent PLUSHIE_SQUEAK = registerSoundEvent("item.plushie.squeak");
    public static SoundEvent DUCK_QUACK = registerSoundEvent("item.rubber_duck.quack");
    public static SoundEvent CAT_EARS_EQUIP = registerSoundEvent("item.cat_ears.equip");

    protected static void registerPneumonosStuffSounds() {

    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = PneumonosStuff.identifier(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
