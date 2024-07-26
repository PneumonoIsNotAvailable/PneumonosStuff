package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import pneumono.pneumonos_stuff.content.item.CatEarsItem;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;

import java.util.Map;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        makePlushieRecipe(exporter, PneumonosStuffItems.BLAHAJ, new String[]{
                "BBB",
                "BHB",
                "WWW"
        }, Map.of(
                'B', Items.LIGHT_BLUE_WOOL,
                'H', Items.PINK_WOOL,
                'W', Items.WHITE_WOOL
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.DJUNGELSKOG, new String[]{
                " B ",
                "BLB",
                "BBB"
        }, Map.of(
                'B', Items.BROWN_WOOL,
                'L', Items.BLACK_WOOL
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.RUBBER_DUCK, new String[]{
                " Y ",
                "YNY",
                "YYY"
        }, Map.of(
                'Y', Items.YELLOW_WOOL,
                'N', Items.NOTE_BLOCK
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.CALIBRATED_RUBBER_DUCK, new String[]{
                " C ",
                "RDR",
                "RNR"
        }, Map.of(
                'C', Items.COMPARATOR,
                'R', Items.REDSTONE,
                'D', PneumonosStuffItems.RUBBER_DUCK,
                'N', Items.NOTE_BLOCK
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.AXOLOTL, new String[]{
                "SPS",
                "PPP"
        }, Map.of(
                'S', Items.STRING,
                'P', Items.PINK_WOOL
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.GLOW_SQUID, new String[]{
                "CGC",
                "CGC"
        }, Map.of(
                'C', Items.CYAN_WOOL,
                'G', Items.GLOW_INK_SAC
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.FOX, new String[]{
                "WWW",
                "WEW"
        }, Map.of(
                'W', Items.ORANGE_WOOL,
                'E', Items.EMERALD
        ));

        makePlushieRecipe(exporter, PneumonosStuffItems.SNOW_FOX, new String[]{
                "WWW",
                "WEW"
        }, Map.of(
                'W', Items.WHITE_WOOL,
                'E', Items.EMERALD
        ));

        for (CatEarsItem catEars : PneumonosStuffItems.CAT_EARS) {
            Item wool = catEars.getRepairItem();
            ShapedRecipeJsonBuilder
                    .create(RecipeCategory.MISC, catEars)
                    .pattern("WWW")
                    .pattern("W W")
                    .input('W', wool)
                    .criterion(FabricRecipeProvider.hasItem(wool), FabricRecipeProvider.conditionsFromItem(wool))
                    .offerTo(exporter);
        }
    }

    private void makePlushieRecipe(Consumer<RecipeJsonProvider> exporter, Item result, String[] patterns, Map<Character, Item> ingredients) {
        ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, result);
        for (String pattern : patterns) {
            builder.pattern(pattern);
        }

        for (Character character : ingredients.keySet()) {
            Item item = ingredients.get(character);
            builder.input(character, item);
            builder.criterion(FabricRecipeProvider.hasItem(item), FabricRecipeProvider.conditionsFromItem(item));
        }

        builder.offerTo(exporter);
    }
}
