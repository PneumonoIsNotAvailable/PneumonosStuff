package pneumono.pneumonos_stuff.content;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.world.World;
import pneumono.pneumonos_stuff.PneumonosStuffClient;
import pneumono.pneumonos_stuff.content.block.PlushieBlock;
import pneumono.pneumonos_stuff.content.block.PlushieBlockEntity;
import pneumono.pneumonos_stuff.content.models.containers.PlushieModelContainer;
import pneumono.pneumonos_stuff.content.models.PlushieModel;

import java.util.Map;

public class PlushieBlockEntityRenderer implements BlockEntityRenderer<PlushieBlockEntity> {
    private final Map<Item, PlushieModelContainer> MODELS;

    public PlushieBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    public static Map<Item, PlushieModelContainer> getModels(EntityModelLoader loader) {
        ImmutableMap.Builder<Item, PlushieModelContainer> builder = ImmutableMap.builder();

        for (Item item : PneumonosStuffClient.PLUSHIES.keySet()) {
            ClientPlushie plushie = PneumonosStuffClient.PLUSHIES.get(item);
            builder.put(item, plushie.container().getContainer(loader));
        }

        return builder.build();
    }

    @Override
    public void render(PlushieBlockEntity plushie, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = plushie.getCachedState();

        int rotation = blockState.get(PlushieBlock.ROTATION);
        float angle = RotationPropertyHelper.toDegrees(rotation);

        ItemStack stack = plushie.getStoredPlushie();
        if (stack != null) {
            World world = plushie.getWorld();
            BlockPos pos = plushie.getPos();
            Item item = stack.getItem();
            PlushieModelContainer container = this.MODELS.get(item);

            PlushieModel model = container.getModel(world, pos);
            renderPlushie(angle, matrixStack, vertexConsumers, light, overlay, model, RenderLayer.getEntityCutoutNoCullZOffset(container.getTexture(world, pos)));
        }
    }

    public static void renderPlushie(float angle, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, PlushieModel model, RenderLayer renderLayer) {
        matrices.push();

        matrices.scale(-1.0F, -1.0F, 1.0F);
        matrices.translate(-0.5F, -1.5F, 0.5F);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);

        model.setRotation(angle);
        model.render(matrices, vertexConsumer, light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);

        matrices.pop();
    }
}
