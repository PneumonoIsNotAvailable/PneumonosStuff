package pneumono.pneumonos_stuff.registry;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.content.PlushieSize;
import pneumono.pneumonos_stuff.content.item.CatEarsItem;
import pneumono.pneumonos_stuff.content.item.HuggablePlushieItem;
import pneumono.pneumonos_stuff.content.item.NoisyPlushieItem;

import java.util.ArrayList;
import java.util.List;

public class PneumonosStuffItems {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final List<Item> PLUSHIES = new ArrayList<>();
    public static final List<CatEarsItem> CAT_EARS = new ArrayList<>();

    public static final Item BLAHAJ = registerPlushie("blahaj", new HuggablePlushieItem(PneumonosStuffBlocks.BLAHAJ, PlushieSize.SMALL, getPlushieSettings(true)));
    public static final Item DJUNGELSKOG = registerPlushie("djungelskog", new HuggablePlushieItem(PneumonosStuffBlocks.DJUNGELSKOG, PlushieSize.LARGE, getPlushieSettings(false)));
    public static final Item RUBBER_DUCK = registerPlushie("rubber_duck", new NoisyPlushieItem(PneumonosStuffBlocks.RUBBER_DUCK, getPlushieSettings(false)));
    public static final Item CALIBRATED_RUBBER_DUCK = registerPlushie("calibrated_rubber_duck", new NoisyPlushieItem(PneumonosStuffBlocks.CALIBRATED_RUBBER_DUCK, getPlushieSettings(false)));
    public static final Item AXOLOTL = registerPlushie("axolotl", new HuggablePlushieItem(PneumonosStuffBlocks.AXOLOTL, PlushieSize.MEDIUM, getPlushieSettings(true)));
    public static final Item GLOW_SQUID = registerPlushie("glow_squid", new HuggablePlushieItem(PneumonosStuffBlocks.GLOW_SQUID, PlushieSize.MEDIUM, getPlushieSettings(false)));
    public static final Item FOX = registerPlushie("fox", new HuggablePlushieItem(PneumonosStuffBlocks.FOX, PlushieSize.MEDIUM, getPlushieSettings(false)));
    public static final Item SNOW_FOX = registerPlushie("snow_fox", new HuggablePlushieItem(PneumonosStuffBlocks.SNOW_FOX, PlushieSize.MEDIUM, getPlushieSettings(false)));

    public static final Item WHITE_CAT_EARS = registerCatEars("white_cat_ears", Items.WHITE_WOOL);
    public static final Item ORANGE_CAT_EARS = registerCatEars("orange_cat_ears", Items.ORANGE_WOOL);
    public static final Item MAGENTA_CAT_EARS = registerCatEars("magenta_cat_ears", Items.MAGENTA_WOOL);
    public static final Item LIGHT_BLUE_CAT_EARS = registerCatEars("light_blue_cat_ears", Items.LIGHT_BLUE_WOOL);
    public static final Item YELLOW_CAT_EARS = registerCatEars("yellow_cat_ears", Items.YELLOW_WOOL);
    public static final Item LIME_CAT_EARS = registerCatEars("lime_cat_ears", Items.LIME_WOOL);
    public static final Item PINK_CAT_EARS = registerCatEars("pink_cat_ears", Items.PINK_WOOL);
    public static final Item GRAY_CAT_EARS = registerCatEars("gray_cat_ears", Items.GRAY_WOOL);
    public static final Item LIGHT_GRAY_CAT_EARS = registerCatEars("light_gray_cat_ears", Items.LIGHT_GRAY_WOOL);
    public static final Item CYAN_CAT_EARS = registerCatEars("cyan_cat_ears", Items.CYAN_WOOL);
    public static final Item PURPLE_CAT_EARS = registerCatEars("purple_cat_ears", Items.PURPLE_WOOL);
    public static final Item BLUE_CAT_EARS = registerCatEars("blue_cat_ears", Items.BLUE_WOOL);
    public static final Item BROWN_CAT_EARS = registerCatEars("brown_cat_ears", Items.BROWN_WOOL);
    public static final Item GREEN_CAT_EARS = registerCatEars("green_cat_ears", Items.GREEN_WOOL);
    public static final Item RED_CAT_EARS = registerCatEars("red_cat_ears", Items.RED_WOOL);
    public static final Item BLACK_CAT_EARS = registerCatEars("black_cat_ears", Items.BLACK_WOOL);

    protected static void registerPneumonosStuffItems() {

    }

    public static Item registerPlushie(String name, Item item) {
        PLUSHIES.add(item);
        return registerItem(name, item);
    }

    public static Item registerCatEars(String name, Item repairItem) {
        CatEarsItem item = new CatEarsItem(new Item.Settings().maxCount(1), repairItem);
        CAT_EARS.add(item);
        return registerItem(name, item);
    }

    public static Item registerItem(String name, Item item) {
        ITEMS.add(item);
        return Registry.register(Registries.ITEM, PneumonosStuff.identifier(name), item);
    }

    public static Item.Settings getPlushieSettings(boolean rare) {
        return new Item.Settings().maxCount(1).rarity(rare ? Rarity.RARE : Rarity.COMMON);
    }
}
