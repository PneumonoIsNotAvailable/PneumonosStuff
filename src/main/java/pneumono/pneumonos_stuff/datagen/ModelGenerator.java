package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.item.Item;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;

import java.util.Optional;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Model templateCatEars = createParentItemModel("template_cat_ears", TextureKey.LAYER0);
        for (Item item : PneumonosStuffItems.CAT_EARS) {
            itemModelGenerator.register(item, templateCatEars);
        }
    }

    public static Model createParentItemModel(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(PneumonosStuff.identifier("item/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
