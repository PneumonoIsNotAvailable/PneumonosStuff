package pneumono.pneumonos_stuff.content.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pneumono.pneumonocore.enchantment.EnchantableItem;
import pneumono.pneumonos_stuff.registry.PneumonosStuffSounds;

public class CatEarsItem extends Item implements Equipment, EnchantableItem {
    private final Item repairItem;

    public CatEarsItem(Settings settings, Item repairItem) {
        super(settings);
        this.repairItem = repairItem;
    }

    public Item getRepairItem() {
        return repairItem;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(repairItem) && super.canRepair(stack, ingredient);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public SoundEvent getEquipSound() {
        return PneumonosStuffSounds.CAT_EARS_EQUIP;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isAcceptableEnchantment(Enchantment enchantment) {
        return enchantment.target == EnchantmentTarget.ARMOR_HEAD;
    }
}
