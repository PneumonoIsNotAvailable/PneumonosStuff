package pneumono.pneumonos_stuff.content.models;

public class PlushieTransformation {
    public final float scaleX;
    public final float scaleY;
    public final float scaleZ;
    public final float rotationX;
    public final float rotationY;
    public final float rotationZ;
    public final float translationX;
    public final float translationY;
    public final float translationZ;

    public PlushieTransformation(float rotationX, float rotationY, float rotationZ, float translationX, float translationY, float translationZ) {
        this(1.0F, 1.0F, 1.0F, rotationX, rotationY, rotationZ, translationX, translationY, translationZ);
    }

    public PlushieTransformation(float scale, float rotationX, float rotationY, float rotationZ, float translationX, float translationY, float translationZ) {
        this(scale, scale, scale, rotationX, rotationY, rotationZ, translationX, translationY, translationZ);
    }

    @SuppressWarnings("unusued")
    public PlushieTransformation(float scaleX, float scaleY, float scaleZ, float rotationX, float rotationY, float rotationZ, float translationX, float translationY, float translationZ) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.translationX = translationX;
        this.translationY = translationY;
        this.translationZ = translationZ;
    }
}
