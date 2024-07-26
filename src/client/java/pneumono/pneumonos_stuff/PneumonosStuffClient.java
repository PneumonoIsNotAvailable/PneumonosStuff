package pneumono.pneumonos_stuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import pneumono.pneumonos_stuff.content.item.HuggablePlushieItem;
import pneumono.pneumonos_stuff.content.ClientPlushie;
import pneumono.pneumonos_stuff.content.PlushieBlockEntityRenderer;
import pneumono.pneumonos_stuff.content.models.*;
import pneumono.pneumonos_stuff.content.models.containers.AsymmetricalModelContainer;
import pneumono.pneumonos_stuff.content.models.containers.ModelContainerFunction;
import pneumono.pneumonos_stuff.content.models.containers.PlushieModelContainer;
import pneumono.pneumonos_stuff.content.models.containers.SingleModelContainer;
import pneumono.pneumonos_stuff.registry.PneumonosStuffBlocks;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PneumonosStuffClient implements ClientModInitializer {
	public static final Map<Item, ClientPlushie> PLUSHIES = new HashMap<>();

	@Override
	public void onInitializeClient() {
		BlockEntityRendererFactories.register(PneumonosStuffBlocks.PLUSHIE_ENTITY, PlushieBlockEntityRenderer::new);
		registerClientPlushies();

		for (Item plushie : PneumonosStuffItems.PLUSHIES) {
			if (plushie instanceof HuggablePlushieItem) {
				ModelPredicateProviderRegistry.register(plushie, new Identifier("hugging"), (itemStack, clientWorld, livingEntity, i) -> {
					if (livingEntity == null) {
						return 0.0F;
					}
					return livingEntity.getActiveItem().getItem() instanceof HuggablePlushieItem && livingEntity.isUsingItem() ? 1.0F : 0.0F;
				});
			}
		}
	}

	public static void registerClientPlushies() {
		registerClientPlushie(PneumonosStuffItems.BLAHAJ,
				new PlushieTransformation(90F, -10F, 0F, -0.06F, -0.6F, -0.4F),
				(loader, layers) -> new SingleModelContainer(createTextureId("blahaj"), new BlahajModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("blahaj"), BlahajModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.DJUNGELSKOG,
				new PlushieTransformation(1.01F, -15F, 0F, 0F, 0F, 0.2F, -0.3F),
				(loader, layers) -> new SingleModelContainer(createTextureId("djungelskog"), new DjungelskogModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("djungelskog"), DjungelskogModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.RUBBER_DUCK,
				null,
				(loader, layers) -> new SingleModelContainer(createTextureId("rubber_duck"), new RubberDuckModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("rubber_duck"), RubberDuckModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.CALIBRATED_RUBBER_DUCK,
				null,
				(loader, layers) -> new SingleModelContainer(createTextureId("calibrated_rubber_duck"), new RubberDuckModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("calibrated_rubber_duck"), RubberDuckModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.AXOLOTL,
				new PlushieTransformation(90F, 0F, 0F, 0F, -0.6F, -0.3F),
				(loader, layers) -> new SingleModelContainer(createTextureId("axolotl"), new AxolotlModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("axolotl"), AxolotlModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.GLOW_SQUID,
				new PlushieTransformation(0F, 180F, 0F, 0F, 0.3F, 0.27F),
				(loader, layers) -> new SingleModelContainer(createTextureId("glow_squid"), new GlowSquidModel(loader.getModelPart(layers[0]))),
				new Pair<>(createModelLayer("glow_squid"), GlowSquidModel::getTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.FOX,
				new PlushieTransformation(90F, 0F, 0F, 0F, -0.66F, -0.35F),
				(loader, layers) -> new AsymmetricalModelContainer(createTextureId("fox"),
						new FoxModel(loader.getModelPart(layers[0])),
						new FoxModel(loader.getModelPart(layers[1]))
				),
				new Pair<>(createModelLayer("fox", "left"), FoxModel::getLeftTexturedModelData),
				new Pair<>(createModelLayer("fox", "right"), FoxModel::getRightTexturedModelData)
		);
		registerClientPlushie(PneumonosStuffItems.SNOW_FOX,
				new PlushieTransformation(90F, 0F, 0F, 0F, -0.66F, -0.35F),
				(loader, layers) -> new AsymmetricalModelContainer(createTextureId("snow_fox"),
						new FoxModel(loader.getModelPart(layers[0])),
						new FoxModel(loader.getModelPart(layers[1]))
				),
				new Pair<>(createModelLayer("snow_fox", "left"), FoxModel::getLeftTexturedModelData),
				new Pair<>(createModelLayer("snow_fox", "right"), FoxModel::getRightTexturedModelData)
		);
	}

	@SafeVarargs
	public static void registerClientPlushie(Item item, PlushieTransformation transformation, ModelContainerFunction unfinishedContainerFunction, Pair<EntityModelLayer, EntityModelLayerRegistry.TexturedModelDataProvider>... layerPairs) {
		List<EntityModelLayer> layers = new ArrayList<>();
		for (Pair<EntityModelLayer, EntityModelLayerRegistry.TexturedModelDataProvider> layer : layerPairs) {
			EntityModelLayerRegistry.registerModelLayer(layer.getLeft(), layer.getRight());
			layers.add(layer.getLeft());
		}
		PLUSHIES.put(item, new ClientPlushie(transformation, loader -> unfinishedContainerFunction.getContainer(loader, layers.toArray(new EntityModelLayer[0]))));
	}

	public interface FinishedModelContainerFunction {
		PlushieModelContainer getContainer(EntityModelLoader loader);
	}

	public static Identifier createTextureId(String name) {
		return PneumonosStuff.identifier("textures/item/" + name + ".png");
	}

	public static EntityModelLayer createModelLayer(String id) {
		return createModelLayer(id, "main");
	}

	public static EntityModelLayer createModelLayer(String id, String name) {
		return new EntityModelLayer(PneumonosStuff.identifier(id), name);
	}
}