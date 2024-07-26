package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class BlahajModel extends PlushieModel {
	public BlahajModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(14, 0).cuboid(-2.0F, -4.0F, -7.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(10, 11).cuboid(0.0F, -7.0F, -3.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(20, 5).cuboid(-1.5F, -3.5F, 0.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 11).cuboid(0.0F, -5.0F, 3.0F, 0.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("right_arm", ModelPartBuilder.create().uv(12, 10).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, -3.0F, 0.0F, -0.3927F, 0.0F));
		body.addChild("left_arm", ModelPartBuilder.create().uv(12, 10).cuboid(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -1.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}