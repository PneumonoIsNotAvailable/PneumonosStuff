package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import pneumono.pneumonos_stuff.registry.PneumonosStuffBlocks;
import pneumono.pneumonos_stuff.registry.PneumonosStuffEffects;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;
import pneumono.pneumonos_stuff.registry.PneumonosStuffStats;

public class EnglishLanguageGenerator extends FabricLanguageProvider {
    public EnglishLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add(PneumonosStuffItems.BLAHAJ, "Blåhaj");
        builder.add(PneumonosStuffItems.DJUNGELSKOG, "Djungelskog");
        builder.add(PneumonosStuffItems.RUBBER_DUCK, "Rubber Duck");
        builder.add(PneumonosStuffItems.CALIBRATED_RUBBER_DUCK, "Calibrated Rubber Duck");
        builder.add(PneumonosStuffItems.AXOLOTL, "Axolotl");
        builder.add(PneumonosStuffItems.GLOW_SQUID, "Glow Squid");
        builder.add(PneumonosStuffItems.FOX, "Fox");
        builder.add(PneumonosStuffItems.SNOW_FOX, "Snow Fox");
        builder.add(PneumonosStuffBlocks.BLAHAJ, "Blåhaj");
        builder.add(PneumonosStuffBlocks.DJUNGELSKOG, "Djungelskog");
        builder.add(PneumonosStuffBlocks.RUBBER_DUCK, "Rubber Duck");
        builder.add(PneumonosStuffBlocks.CALIBRATED_RUBBER_DUCK, "Calibrated Rubber Duck");
        builder.add(PneumonosStuffBlocks.AXOLOTL, "Axolotl");
        builder.add(PneumonosStuffBlocks.GLOW_SQUID, "Glow Squid");
        builder.add(PneumonosStuffBlocks.FOX, "Fox");
        builder.add(PneumonosStuffBlocks.SNOW_FOX, "Snow Fox");

        builder.add(PneumonosStuffItems.WHITE_CAT_EARS, "White Cat Ears");
        builder.add(PneumonosStuffItems.ORANGE_CAT_EARS, "Orange Cat Ears");
        builder.add(PneumonosStuffItems.MAGENTA_CAT_EARS, "Magenta Cat Ears");
        builder.add(PneumonosStuffItems.LIGHT_BLUE_CAT_EARS, "Light Blue Cat Ears");
        builder.add(PneumonosStuffItems.YELLOW_CAT_EARS, "Yellow Cat Ears");
        builder.add(PneumonosStuffItems.LIME_CAT_EARS, "Lime Cat Ears");
        builder.add(PneumonosStuffItems.PINK_CAT_EARS, "Pink Cat Ears");
        builder.add(PneumonosStuffItems.GRAY_CAT_EARS, "Gray Cat Ears");
        builder.add(PneumonosStuffItems.LIGHT_GRAY_CAT_EARS, "Light Gray Cat Ears");
        builder.add(PneumonosStuffItems.CYAN_CAT_EARS, "Cyan Cat Ears");
        builder.add(PneumonosStuffItems.PURPLE_CAT_EARS, "Purple Cat Ears");
        builder.add(PneumonosStuffItems.BLUE_CAT_EARS, "Blue Cat Ears");
        builder.add(PneumonosStuffItems.BROWN_CAT_EARS, "Brown Cat Ears");
        builder.add(PneumonosStuffItems.GREEN_CAT_EARS, "Green Cat Ears");
        builder.add(PneumonosStuffItems.RED_CAT_EARS, "Red Cat Ears");
        builder.add(PneumonosStuffItems.BLACK_CAT_EARS, "Black Cat Ears");

        builder.add("itemGroup.pneumonos_stuff.pneumonos_stuff", "Pneumono's Stuff");

        builder.add("stat.pneumonos_stuff." + PneumonosStuffStats.TIME_HUGGING_PLUSHIES.getPath(), "Time Hugging Plushies");
        builder.add("stat.pneumonos_stuff." + PneumonosStuffStats.DUCKS_QUACKED.getPath(), "Ducks Quacked");

        builder.add(PneumonosStuffEffects.CONDUIT_AURA, "Conduit Aura");

        builder.add("subtitles.pneumonos_stuff.item.plushie.squeak", "Plushie squeaks");
        builder.add("subtitles.pneumonos_stuff.item.rubber_duck.quack", "Rubber duck quacks");
        builder.add("subtitles.pneumonos_stuff.item.cat_ears.equip", "Cat Ears rustle");

        builder.add("configs.pneumonos_stuff.screen_title", "Pneumono's Stuff Configs");
        builder.add("configs.pneumonos_stuff.hug_healing", "Hug Healing");
        builder.add("configs.pneumonos_stuff.hug_healing.tooltip", "Whether or not huggable plushies grant players health regeneration");
        builder.add("configs.pneumonos_stuff.hug_health_per_minute", "Hug Healing Rate");
        builder.add("configs.pneumonos_stuff.hug_health_per_minute.tooltip", "The amount of health regenerated per minute (e.g. 30HP/60s = 0.5HP/s = 1HP every 2s)");
        builder.add("configs.pneumonos_stuff.redstone_quacking", "Redstone Quacking");
        builder.add("configs.pneumonos_stuff.redstone_quacking.tooltip", "Whether or not rubber ducks can be quacked automatically");
        builder.add("configs.pneumonos_stuff.disable_elytra", "Disable Elytra");
        builder.add("configs.pneumonos_stuff.disable_elytra.tooltip", "Whether or not elytra are disabled");
        builder.add("configs.pneumonos_stuff.beacon_range_multiplier", "Beacon Range Multiplier");
        builder.add("configs.pneumonos_stuff.beacon_range_multiplier.tooltip", "The multiplier applied to beacon range");
        builder.add("configs.pneumonos_stuff.jukebox_looping", "Jukebox Looping");
        builder.add("configs.pneumonos_stuff.jukebox_looping.tooltip", "Whether or not jukeboxes loop");
        builder.add("configs.pneumonos_stuff.conduit_protection", "Conduit Protection");
        builder.add("configs.pneumonos_stuff.conduit_protection.tooltip", "Whether or not conduits give conduit protection");

        builder.add("pneumonos_stuff.advancements.get_plushie.name", "Squimshy");
        builder.add("pneumonos_stuff.advancements.get_plushie.desc", "Find or Craft your first Plushie");
        builder.add("pneumonos_stuff.advancements.get_blahaj.name", "Blåhaj go Spinny");
        builder.add("pneumonos_stuff.advancements.get_blahaj.desc", "Craft the most valuable item in the game");
    }
}
