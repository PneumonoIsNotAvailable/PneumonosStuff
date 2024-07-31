package pneumono.pneumonos_stuff;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import pneumono.pneumonos_stuff.datagen.*;

@SuppressWarnings("unused")
public class PneumonosStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(AdvancementsGenerator::new);
		pack.addProvider(ItemTagsGenerator::new);
		pack.addProvider(EnglishLanguageGenerator::new);
        pack.addProvider(RecipeGenerator::new);
		pack.addProvider(ModelGenerator::new);
	}
}
