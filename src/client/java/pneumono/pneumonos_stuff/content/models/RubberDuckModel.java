package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class RubberDuckModel extends PlushieModel {
	public RubberDuckModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 7.0F, new Dilation(0.0F))
				.uv(16, 10).cuboid(-2.0F, -5.0F, 3.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(12, 10).cuboid(-1.0F, -5.0F, -5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}