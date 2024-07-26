package pneumono.pneumonos_stuff;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.pneumono.pneumonocore.config.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pneumono.pneumonos_stuff.registry.PneumonosStuffRegistry;

public class PneumonosStuff implements ModInitializer {
	public static final String MOD_ID = "pneumonos_stuff";
    public static final Logger LOGGER = LoggerFactory.getLogger("Pneumono's Stuff");

	public static final BooleanConfiguration HUG_HEALING = Configs.register(new BooleanConfiguration(MOD_ID, "hug_healing", ConfigEnv.SERVER, true));
	public static final IntegerConfiguration HUG_HEALTH_PER_MINUTE = Configs.register(new IntegerConfiguration(MOD_ID, "hug_health_per_minute", ConfigEnv.SERVER, 0, 240, 30));
	public static final BooleanConfiguration REDSTONE_QUACKING = Configs.register(new BooleanConfiguration(MOD_ID, "redstone_quacking", ConfigEnv.SERVER, true));
	public static final BooleanConfiguration DISABLE_ELYTRA = Configs.register(new BooleanConfiguration(MOD_ID, "disable_elytra", ConfigEnv.SERVER, false));
	public static final FloatConfiguration BEACON_RANGE_MULTIPLIER = Configs.register(new FloatConfiguration(MOD_ID, "beacon_range_multiplier", ConfigEnv.SERVER, 1));
	public static final BooleanConfiguration JUKEBOX_LOOPING = Configs.register(new BooleanConfiguration(MOD_ID, "jukebox_looping", ConfigEnv.SERVER, false));
	public static final BooleanConfiguration CONDUIT_PROTECTION = Configs.register(new BooleanConfiguration(MOD_ID, "conduit_protection", ConfigEnv.SERVER, false));

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Pneumono's Stuff");
		Configs.reload(MOD_ID);
		PneumonosStuffRegistry.registerPneumonosStuffContent();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}