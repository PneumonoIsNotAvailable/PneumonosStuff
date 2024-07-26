package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;
import pneumono.pneumonos_stuff.registry.PneumonosStuffRegistry;

import java.util.concurrent.CompletableFuture;

public class ItemTagsGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagsGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        FabricTagBuilder builder = getOrCreateTagBuilder(PneumonosStuffRegistry.TAG_PLUSHIES);
        for (Item item : PneumonosStuffItems.PLUSHIES) {
            builder.add(item);
        }
    }
}
