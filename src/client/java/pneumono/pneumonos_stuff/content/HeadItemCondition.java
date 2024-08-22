package pneumono.pneumonos_stuff.content;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public record HeadItemCondition(Condition condition, ItemStack stack) {
    public boolean shouldRender(LivingEntity entity) {
        return condition.shouldRender(entity);
    }

    public interface Condition {
        boolean shouldRender(LivingEntity entity);
    }
}
