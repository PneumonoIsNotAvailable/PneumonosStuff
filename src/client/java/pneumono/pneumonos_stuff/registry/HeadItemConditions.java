package pneumono.pneumonos_stuff.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pneumono.pneumonos_stuff.compat.Compat;
import pneumono.pneumonos_stuff.compat.TrinketsCompatClient;
import pneumono.pneumonos_stuff.content.HeadItemCondition;

import java.util.ArrayList;
import java.util.List;

public class HeadItemConditions {
    public static final List<HeadItemCondition> CONDITIONS = new ArrayList<>();

    public static void registerHeadItemCondition(HeadItemCondition.Condition condition, ItemStack headItem) {
        CONDITIONS.add(new HeadItemCondition(condition, headItem));
    }

    public static void registerVanillaHeadItemConditions() {
        if (Compat.TRINKETS) {
            for (Item item : PneumonosStuffItems.CAT_EARS) {
                registerHeadItemCondition(TrinketsCompatClient.getCatEarsCondition(item), item.getDefaultStack());
            }
        }
    }
}
