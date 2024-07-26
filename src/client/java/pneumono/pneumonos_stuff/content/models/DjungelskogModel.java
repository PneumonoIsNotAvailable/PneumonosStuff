package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class DjungelskogModel extends PlushieModel {
	public DjungelskogModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartdata = modelData.getRoot();

		ModelPartData body = modelPartdata.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-5.0F, -9.0F, -3.0F, 10.0F, 9.0F, 11.0F, new Dilation(0.0F))
				.uv(0, 20).cuboid(-4.0F, -11.0F, 3.0F, 8.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(18, 20).cuboid(-3.0F, -15.0F, 0.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F))
				.uv(31, 9).cuboid(-4.0F, -16.0F, 4.0F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(26, 31).cuboid(-2.0F, -13.0F, -2.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 26).cuboid(1.0F, -3.0F, -7.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 26).cuboid(-4.0F, -3.0F, -7.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("arms", ModelPartBuilder.create()
				.uv(6, 26).cuboid(-1.0F, -1.0F, -7.0F, 2.0F, 3.0F, 8.0F, new Dilation(0.0F))
				.uv(6, 37).cuboid(11.0F, -1.0F, -7.0F, 2.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -7.0F, 5.0F, 0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}