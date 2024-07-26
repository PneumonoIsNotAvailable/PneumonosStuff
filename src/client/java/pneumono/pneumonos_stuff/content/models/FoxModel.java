package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class FoxModel extends PlushieModel {
	public FoxModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getLeftTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-8.0F, -5.0F, -5.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 9).cuboid(-6.5F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(18, 11).cuboid(-8.0F, -7.0F, -3.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("back_right_leg", ModelPartBuilder.create().uv(18, 9).cuboid(9.0F, -1.0F, -17.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, -11.0F, 0.0F, 3.1416F, 0.0F));
		body.addChild("front_right_leg", ModelPartBuilder.create().uv(18, 9).cuboid(8.0F, -1.0F, -17.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, -11.0F, 0.0F, 2.7489F, 0.0F));
		body.addChild("back_left_leg", ModelPartBuilder.create().uv(18, 9).cuboid(-12.0F, -1.0F, -4.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, 0.0F, -7.0F, 0.0F, 1.1781F, 0.0F));
		body.addChild("front_left_leg", ModelPartBuilder.create().uv(18, 9).cuboid(-12.0F, -1.1F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.0F, -6.0F, 0.0F, 0.3927F, 0.0F));
		body.addChild("tail", ModelPartBuilder.create().uv(20, 0).cuboid(-12.0F, -5.1F, 8.0F, 8.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.0F, -9.0F, 0.0F, 0.3927F, 0.0F));
		body.addChild("body_main", ModelPartBuilder.create().uv(0, 9).cuboid(-2.0F, -4.2F, -8.0F, 4.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 4.0F, 0.0F, 0.7854F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	public static TexturedModelData getRightTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).mirrored().cuboid(2.0F, -5.0F, -5.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 9).mirrored().cuboid(3.5F, -2.0F, -7.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(18, 11).mirrored().cuboid(2.0F, -7.0F, -3.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("back_left_leg", ModelPartBuilder.create().uv(18, 9).mirrored().cuboid(-13.0F, -1.0F, -17.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-9.0F, 0.0F, -11.0F, 0.0F, -3.1416F, 0.0F));
		body.addChild("front_left_leg", ModelPartBuilder.create().uv(18, 9).mirrored().cuboid(-12.0F, -1.0F, -17.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-9.0F, 0.0F, -11.0F, 0.0F, -2.7489F, 0.0F));
		body.addChild("back_right_leg", ModelPartBuilder.create().uv(18, 9).mirrored().cuboid(8.0F, -1.0F, -4.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-9.0F, 0.0F, -7.0F, 0.0F, -1.1781F, 0.0F));
		body.addChild("front_right_leg", ModelPartBuilder.create().uv(18, 9).mirrored().cuboid(8.0F, -1.1F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-8.0F, 0.0F, -6.0F, 0.0F, -0.3927F, 0.0F));
		body.addChild("tail", ModelPartBuilder.create().uv(20, 0).mirrored().cuboid(4.0F, -5.1F, 8.0F, 8.0F, 5.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-8.0F, 0.0F, -9.0F, 0.0F, -0.3927F, 0.0F));
		body.addChild("body_main", ModelPartBuilder.create().uv(0, 9).mirrored().cuboid(-2.0F, -4.2F, -8.0F, 4.0F, 4.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 4.0F, 0.0F, -0.7854F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}