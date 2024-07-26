package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class TransBeeModel extends PlushieModel {
	public TransBeeModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-3.5F, -7.0F, -5.0F, 7.0F, 7.0F, 10.0F, new Dilation(0.0F))
				.uv(2, 24).cuboid(1.5F, -7.1F, -3.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(2, 18).cuboid(-8.5F, -7.1F, -3.0F, 7.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(24, 7).cuboid(0.0F, -4.0F, 5.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(2, 0).cuboid(-1.5F, -7.0F, -8.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(3, 3).cuboid(1.5F, -7.0F, -8.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("back_legs", ModelPartBuilder.create().uv(27, 5).cuboid(5.5F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 2.0F, 0.3927F, 0.0F, 0.0F));
		body.addChild("middle_legs", ModelPartBuilder.create().uv(27, 3).cuboid(5.5F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		body.addChild("front_legs", ModelPartBuilder.create().uv(28, 1).cuboid(6.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}