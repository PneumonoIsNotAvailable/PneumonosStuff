package pneumono.pneumonos_stuff.content.models;

import net.minecraft.client.model.*;

public class GlowSquidModel extends PlushieModel {
	public GlowSquidModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -10.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		body.addChild("north_west_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		body.addChild("west_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
		body.addChild("south_west_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -1.9635F, 0.0F));
		body.addChild("south_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, -2.7489F, 0.0F));
		body.addChild("south_east_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 2.7489F, 0.0F));
		body.addChild("east_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.9635F, 0.0F));
		body.addChild("north_east_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
		body.addChild("north_tentacle", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.0F, 0.3927F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}
}