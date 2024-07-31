package pneumono.pneumonos_stuff.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPointer;
import pneumono.pneumonos_stuff.PneumonosStuff;

public class PneumonosStuffRegistry {
    public static final TagKey<Item> TAG_PLUSHIES = TagKey.of(RegistryKeys.ITEM, PneumonosStuff.identifier("plushies"));

    public static void registerPneumonosStuffContent() {
        PneumonosStuffStats.registerPneumonosStuffStats();
        PneumonosStuffSounds.registerPneumonosStuffSounds();
        PneumonosStuffBlocks.registerPneumonosStuffBlocks();
        PneumonosStuffItems.registerPneumonosStuffItems();
        PneumonosStuffEffects.registerPneumonosStuffEffects();

        Registry.register(Registries.ITEM_GROUP, PneumonosStuff.identifier("pneumonos_stuff"),
                FabricItemGroup.builder().displayName(Text.translatable("itemGroup." + PneumonosStuff.MOD_ID + ".pneumonos_stuff")).icon(() -> new ItemStack(PneumonosStuffItems.BLAHAJ))
                        .entries(((displayContext, entries) -> {
                            for (ItemConvertible item : PneumonosStuffItems.ITEMS) {
                                entries.add(item);
                            }
                        })).build()
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((content) -> {
            for (ItemConvertible item : PneumonosStuffItems.PLUSHIES) {
                content.add(item);
            }
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((content) -> content.add(PneumonosStuffItems.CALIBRATED_RUBBER_DUCK));

        DispenserBehavior catEarsDispenserBehaviour = new FallibleItemDispenserBehavior() {
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(ArmorItem.dispenseArmor(pointer, stack));
                return stack;
            }
        };
        for (Item item : PneumonosStuffItems.CAT_EARS) {
            DispenserBlock.registerBehavior(item, catEarsDispenserBehaviour);
        }
    }
}
