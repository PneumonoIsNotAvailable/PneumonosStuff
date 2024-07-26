package pneumono.pneumonos_stuff.content;

import net.minecraft.util.StringIdentifiable;

public enum PlushieSide implements StringIdentifiable {
    LEFT,
    RIGHT;

    @Override
    public String toString() {
        return this.asString();
    }

    @Override
    public String asString() {
        return switch (this) {
            case LEFT -> "left";
            case RIGHT -> "right";
        };
    }
}
