package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import pneumono.pneumonos_stuff.registry.PneumonosStuffEffects;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;
import pneumono.pneumonos_stuff.registry.PneumonosStuffStats;

public class EnglishLanguageGenerator extends FabricLanguageProvider {
    public EnglishLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(PneumonosStuffItems.BLAHAJ, "Blåhaj");
        translationBuilder.add(PneumonosStuffItems.DJUNGELSKOG, "Djungelskog");
        translationBuilder.add(PneumonosStuffItems.RUBBER_DUCK, "Rubber Duck");
        translationBuilder.add(PneumonosStuffItems.CALIBRATED_RUBBER_DUCK, "Calibrated Rubber Duck");
        translationBuilder.add(PneumonosStuffItems.AXOLOTL, "Axolotl");
        translationBuilder.add(PneumonosStuffItems.GLOW_SQUID, "Glow Squid");
        translationBuilder.add(PneumonosStuffItems.FOX, "Fox");
        translationBuilder.add(PneumonosStuffItems.SNOW_FOX, "Snow Fox");

        translationBuilder.add(PneumonosStuffItems.WHITE_CAT_EARS, "White Cat Ears");
        translationBuilder.add(PneumonosStuffItems.ORANGE_CAT_EARS, "Orange Cat Ears");
        translationBuilder.add(PneumonosStuffItems.MAGENTA_CAT_EARS, "Magenta Cat Ears");
        translationBuilder.add(PneumonosStuffItems.LIGHT_BLUE_CAT_EARS, "Light Blue Cat Ears");
        translationBuilder.add(PneumonosStuffItems.YELLOW_CAT_EARS, "Yellow Cat Ears");
        translationBuilder.add(PneumonosStuffItems.LIME_CAT_EARS, "Lime Cat Ears");
        translationBuilder.add(PneumonosStuffItems.PINK_CAT_EARS, "Pink Cat Ears");
        translationBuilder.add(PneumonosStuffItems.GRAY_CAT_EARS, "Gray Cat Ears");
        translationBuilder.add(PneumonosStuffItems.LIGHT_GRAY_CAT_EARS, "Light Gray Cat Ears");
        translationBuilder.add(PneumonosStuffItems.CYAN_CAT_EARS, "Cyan Cat Ears");
        translationBuilder.add(PneumonosStuffItems.PURPLE_CAT_EARS, "Purple Cat Ears");
        translationBuilder.add(PneumonosStuffItems.BLUE_CAT_EARS, "Blue Cat Ears");
        translationBuilder.add(PneumonosStuffItems.BROWN_CAT_EARS, "Brown Cat Ears");
        translationBuilder.add(PneumonosStuffItems.GREEN_CAT_EARS, "Green Cat Ears");
        translationBuilder.add(PneumonosStuffItems.RED_CAT_EARS, "Red Cat Ears");
        translationBuilder.add(PneumonosStuffItems.BLACK_CAT_EARS, "Black Cat Ears");

        translationBuilder.add("itemGroup.pneumonos_stuff.pneumonos_stuff", "Pneumono's Stuff");

        translationBuilder.add(PneumonosStuffStats.TIME_HUGGING_PLUSHIES, "Time Hugging Plushies");
        translationBuilder.add(PneumonosStuffStats.DUCKS_QUACKED, "Ducks Quacked");

        translationBuilder.add(PneumonosStuffEffects.CONDUIT_AURA, "Conduit Aura");

        translationBuilder.add("subtitles.pneumonos_stuff.item.plushie.squeak", "Plushie squeaks");
        translationBuilder.add("subtitles.pneumonos_stuff.item.rubber_duck.quack", "Rubber duck quacks");
        translationBuilder.add("subtitles.pneumonos_stuff.item.cat_ears.equip", "Cat Ears rustle");

        translationBuilder.add("configs.pneumonos_stuff.screen_title", "Pneumono's Stuff Configs");
        translationBuilder.add("configs.pneumonos_stuff.hug_healing", "Hug Healing");
        translationBuilder.add("configs.pneumonos_stuff.hug_healing.tooltip", "Whether or not huggable plushies grant players health regeneration");
        translationBuilder.add("configs.pneumonos_stuff.hug_health_per_minute", "Hug Healing Rate");
        translationBuilder.add("configs.pneumonos_stuff.hug_health_per_minute.tooltip", "The amount of health regenerated per minute (e.g. 30HP/60s = 0.5HP/s = 1HP every 2s)");
        translationBuilder.add("configs.pneumonos_stuff.redstone_quacking", "Redstone Quacking");
        translationBuilder.add("configs.pneumonos_stuff.redstone_quacking.tooltip", "Whether or not rubber ducks can be quacked automatically");
        translationBuilder.add("configs.pneumonos_stuff.disable_elytra", "Disable Elytra");
        translationBuilder.add("configs.pneumonos_stuff.disable_elytra.tooltip", "Whether or not elytra are disabled");

        translationBuilder.add("pneumonos_stuff.advancements.get_plushie.name", "Squimshy");
        translationBuilder.add("pneumonos_stuff.advancements.get_plushie.desc", "Find or Craft your first Plushie");
        translationBuilder.add("pneumonos_stuff.advancements.get_blahaj.name", "Blåhaj go Spinny");
        translationBuilder.add("pneumonos_stuff.advancements.get_blahaj.desc", "Craft the most valuable item in the game");
    }
}
