package pneumono.pneumonos_stuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pneumono.pneumonocore.datagen.PneumonoDatagenHelper;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.registry.PneumonosStuffItems;
import pneumono.pneumonos_stuff.registry.PneumonosStuffRegistry;

import java.util.function.Consumer;

public class AdvancementsGenerator extends FabricAdvancementProvider {
    public AdvancementsGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement getPlushieAdvancement = Advancement.Builder.create().parent(PneumonoDatagenHelper.getDummyAdvancement(new Identifier("minecraft","adventure/root")))
                .display(
                        PneumonosStuffItems.DJUNGELSKOG,
                        Text.translatable("pneumonos_stuff.advancements.get_plushie.name"),
                        Text.translatable("pneumonos_stuff.advancements.get_plushie.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("has_plushie", InventoryChangedCriterion.Conditions.items(PneumonoDatagenHelper.getTagItemPredicate(PneumonosStuffRegistry.TAG_PLUSHIES)))
                .build(consumer, PneumonosStuff.MOD_ID + ":adventure/get_plushie");

        Advancement.Builder.create().parent(getPlushieAdvancement)
                .display(
                        PneumonosStuffItems.BLAHAJ,
                        Text.translatable("pneumonos_stuff.advancements.get_blahaj.name"),
                        Text.translatable("pneumonos_stuff.advancements.get_blahaj.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("has_blahaj", InventoryChangedCriterion.Conditions.items(PneumonosStuffItems.BLAHAJ))
                .build(consumer, PneumonosStuff.MOD_ID + ":adventure/get_blahaj");
    }
}
