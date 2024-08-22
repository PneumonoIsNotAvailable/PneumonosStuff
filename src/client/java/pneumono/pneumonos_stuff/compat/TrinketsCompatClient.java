package pneumono.pneumonos_stuff.compat;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.item.Item;
import pneumono.pneumonos_stuff.content.HeadItemCondition;

import java.util.Optional;

public class TrinketsCompatClient {
    public static HeadItemCondition.Condition getCatEarsCondition(Item item) {
        return entity -> {
            Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(entity);
            return component.map(trinketComponent -> trinketComponent.isEquipped(item)).orElse(false);
        };
    }
}
