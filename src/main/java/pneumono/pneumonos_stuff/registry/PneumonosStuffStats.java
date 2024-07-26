package pneumono.pneumonos_stuff.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import pneumono.pneumonos_stuff.PneumonosStuff;

public class PneumonosStuffStats {
    public static final Identifier TIME_HUGGING_PLUSHIES = registerStat(PneumonosStuff.identifier("time_hugging_plushies"), StatFormatter.TIME);
    public static final Identifier DUCKS_QUACKED = registerStat(PneumonosStuff.identifier("ducks_quacked"), StatFormatter.DEFAULT);

    protected static void registerPneumonosStuffStats() {

    }

    private static Identifier registerStat(Identifier name, StatFormatter formatter) {
        Registry.register(Registries.CUSTOM_STAT, name.getPath(), name);
        Stats.CUSTOM.getOrCreateStat(name, formatter);
        return name;
    }
}
