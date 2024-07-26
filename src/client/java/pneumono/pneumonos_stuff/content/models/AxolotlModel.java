package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class AxolotlModel extends PlushieModel {
	public AxolotlModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 11).cuboid(-4.0F, -4.0F, -3.0F, 8.0F, 4.0F, 10.0F, new Dilation(0.0F))
				.uv(2, 17).cuboid(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 9.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-4.0F, -5.0F, -8.0F, 8.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("back_right_leg", ModelPartBuilder.create().uv(-3, 13).cuboid(-1.5F, -0.1F, -5.0F, 3.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 5.0F, 0.0F, 1.1781F, 0.0F));
		body.addChild("front_right_leg", ModelPartBuilder.create().uv(-3, 13).cuboid(-1.5F, -0.1F, -5.0F, 3.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, -2.0F, 0.0F, 1.1781F, 0.0F));
		body.addChild("back_left_leg", ModelPartBuilder.create().uv(-3, 13).cuboid(-1.5F, -0.1F, -5.0F, 3.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 5.0F, 0.0F, -1.1781F, 0.0F));
		body.addChild("front_left_leg", ModelPartBuilder.create().uv(-3, 13).cuboid(-1.5F, -0.1F, -5.0F, 3.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, -2.0F, 0.0F, -1.1781F, 0.0F));
		body.addChild("top_gills", ModelPartBuilder.create().uv(3, 37).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -4.0F, -0.3927F, 0.0F, 0.0F));
		body.addChild("right_gills", ModelPartBuilder.create().uv(0, 40).cuboid(-3.0F, -4.0F, 0.0F, 3.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, -4.0F, 0.0F, 0.3927F, 0.0F));
		body.addChild("left_gills", ModelPartBuilder.create().uv(11, 40).cuboid(0.0F, -4.0F, 0.0F, 3.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -3.0F, -4.0F, 0.0F, -0.3927F, 0.0F));
		body.addChild("tail_end", ModelPartBuilder.create().uv(15, 20).cuboid(0.0F, -3.0F, -6.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, -2.0F, 9.2F, 0.0F, -0.7854F, 0.0F));
		body.addChild("tail_middle", ModelPartBuilder.create().uv(8, 31).cuboid(0.0F, -3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 7.0F, 0.0F, -0.3927F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}