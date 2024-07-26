package pneumono.pneumonos_stuff.content;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import pneumono.pneumonos_stuff.content.item.HuggablePlushieItem;

public class ClientUtil {
    public static boolean hasHuggablePlushie(LivingEntity entity) {
        return getHuggablePlushie(entity) != null;
    }

    public static HuggablePlushieItem getHuggablePlushieItem(LivingEntity entity) {
        ItemStack stack = getHuggablePlushie(entity);
        if (stack != null && stack.getItem() instanceof HuggablePlushieItem item) {
            return item;
        } else {
            return null;
        }
    }

    public static ItemStack getHuggablePlushie(LivingEntity entity) {
        if (entity.getMainHandStack().getItem() instanceof HuggablePlushieItem) {
            return entity.getMainHandStack();
        } else if (entity.getOffHandStack().getItem() instanceof HuggablePlushieItem) {
            return entity.getOffHandStack();
        } else {
            return null;
        }
    }
}
