package pneumono.pneumonos_stuff.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import pneumono.pneumonos_stuff.PneumonosStuff;
import pneumono.pneumonos_stuff.content.block.*;
import pneumono.pneumonos_stuff.content.block.ComplexPlushieShapes;

public class PneumonosStuffBlocks {
    public static final Block BLAHAJ = registerBlock("blahaj", getDefaultBlock(MapColor.LIGHT_BLUE, getShape(12, 5)));
    public static final Block DJUNGELSKOG = registerBlock("djungelskog", getDefaultBlock(MapColor.TERRACOTTA_BROWN, getShape(12, 13)));
    public static final Block RUBBER_DUCK = registerBlock("rubber_duck", new NoisyPlushieBlock(
            getDefaultBlockSettings(MapColor.YELLOW),
            PneumonosStuffSounds.DUCK_QUACK,
            PneumonosStuffStats.DUCKS_QUACKED,
            getShape(8, 6)
    ));
    public static final Block CALIBRATED_RUBBER_DUCK = registerBlock("calibrated_rubber_duck", new CalibratedNoisyPlushieBlock(
            getDefaultBlockSettings(MapColor.YELLOW),
            PneumonosStuffSounds.DUCK_QUACK,
            PneumonosStuffStats.DUCKS_QUACKED,
            getShape(8, 6)
    ));
    public static final Block AXOLOTL = registerBlock("axolotl", getDefaultBlock(MapColor.PINK, getShape(14, 4)));
    public static final Block GLOW_SQUID = registerBlock("glow_squid", new PlushieBlock(getDefaultBlockSettings(MapColor.BRIGHT_TEAL).luminance(state -> 6), ComplexPlushieShapes.GLOW_SQUID));
    public static final Block FOX = registerBlock("fox", new AsymmetricalPlushieBlock(getDefaultBlockSettings(MapColor.TERRACOTTA_BROWN), getShape(12, 4)));
    public static final Block SNOW_FOX = registerBlock("snow_fox", new AsymmetricalPlushieBlock(getDefaultBlockSettings(MapColor.WHITE), getShape(12, 4)));

    public static BlockEntityType<PlushieBlockEntity> PLUSHIE_ENTITY = registerBlockEntity(
            "plushie", PlushieBlockEntity::new,
            BLAHAJ, DJUNGELSKOG, RUBBER_DUCK, CALIBRATED_RUBBER_DUCK, AXOLOTL, GLOW_SQUID, FOX, SNOW_FOX
    );

    protected static void registerPneumonosStuffBlocks() {

    }

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, PneumonosStuff.identifier(name), block);
    }

    public static PlushieBlock getDefaultBlock(MapColor color, VoxelShape shape) {
        return new PlushieBlock(getDefaultBlockSettings(color), shape);
    }

    public static AbstractBlock.Settings getDefaultBlockSettings(MapColor color) {
        return AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).mapColor(color).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).strength(0.1F).burnable();
    }

    public static VoxelShape getShape(int width, int height) {
        float distance = (16 - width) / 2F;
        return Block.createCuboidShape(distance, 0, distance, 16 - distance, height, 16 - distance);
    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, PneumonosStuff.identifier(name), FabricBlockEntityTypeBuilder.create(factory, blocks).build());
    }
}
