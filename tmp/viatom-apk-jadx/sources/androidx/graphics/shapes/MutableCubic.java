package androidx.graphics.shapes;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i10) {
        int i11 = i10 + 1;
        long jMo68transformXgqJiTY = pointTransformer.mo68transformXgqJiTY(getPoints$graphics_shapes_release()[i10], getPoints$graphics_shapes_release()[i11]);
        getPoints$graphics_shapes_release()[i10] = Float.intBitsToFloat((int) (jMo68transformXgqJiTY >> 32));
        getPoints$graphics_shapes_release()[i11] = Float.intBitsToFloat((int) (jMo68transformXgqJiTY & 4294967295L));
    }

    public final void interpolate(Cubic cubic, Cubic cubic2, float f) {
        cubic.getClass();
        cubic2.getClass();
        for (int i10 = 0; i10 < 8; i10++) {
            getPoints$graphics_shapes_release()[i10] = Utils.interpolate(cubic.getPoints$graphics_shapes_release()[i10], cubic2.getPoints$graphics_shapes_release()[i10], f);
        }
    }

    public final void transform(PointTransformer pointTransformer) {
        pointTransformer.getClass();
        transformOnePoint(pointTransformer, 0);
        transformOnePoint(pointTransformer, 2);
        transformOnePoint(pointTransformer, 4);
        transformOnePoint(pointTransformer, 6);
    }
}
