package pneumono.pneumonos_stuff.content.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import pneumono.pneumonos_stuff.registry.PneumonosStuffBlocks;

public class PlushieBlockEntity extends BlockEntity {
    private ItemStack storedPlushie;
    private static final String NBT_KEY = "plushies.storedPlushie";

    public PlushieBlockEntity(BlockPos pos, BlockState state) {
        super(PneumonosStuffBlocks.PLUSHIE_ENTITY, pos, state);
    }

    public void setStoredPlushie(ItemStack plushie) {
        this.storedPlushie = plushie;
        this.markDirty();
    }
    public ItemStack getStoredPlushie() {
        return this.storedPlushie;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.storedPlushie != null) {
            NbtCompound plushieNbt = new NbtCompound();
            this.storedPlushie.writeNbt(plushieNbt);
            nbt.put(NBT_KEY, plushieNbt);
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains(NBT_KEY)) {
            this.storedPlushie = ItemStack.fromNbt(nbt.getCompound(NBT_KEY));
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
