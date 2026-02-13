package androidx.graphics.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.collection.FloatFloatPair;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Shapes_androidKt {
    private static final void pathFromCubics(Path path, List<? extends Cubic> list) {
        path.rewind();
        int size = list.size();
        boolean z9 = true;
        for (int i10 = 0; i10 < size; i10++) {
            Cubic cubic = list.get(i10);
            if (z9) {
                path.moveTo(cubic.getAnchor0X(), cubic.getAnchor0Y());
                z9 = false;
            }
            path.cubicTo(cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic.getAnchor1X(), cubic.getAnchor1Y());
        }
        path.close();
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path) {
        roundedPolygon.getClass();
        path.getClass();
        pathFromCubics(path, roundedPolygon.getCubics());
        return path;
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            path = new Path();
        }
        return toPath(roundedPolygon, path);
    }

    public static final RoundedPolygon transformed(RoundedPolygon roundedPolygon, final Matrix matrix) {
        roundedPolygon.getClass();
        matrix.getClass();
        final float[] fArr = new float[2];
        return roundedPolygon.transformed(new PointTransformer() { // from class: androidx.graphics.shapes.Shapes_androidKt.transformed.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo68transformXgqJiTY(float f, float f10) {
                float[] fArr2 = fArr;
                fArr2[0] = f;
                fArr2[1] = f10;
                matrix.mapPoints(fArr2);
                float[] fArr3 = fArr;
                return FloatFloatPair.m9constructorimpl(fArr3[0], fArr3[1]);
            }
        });
    }

    public static final Path toPath(RoundedPolygon roundedPolygon) {
        roundedPolygon.getClass();
        return toPath$default(roundedPolygon, null, 1, null);
    }

    public static /* synthetic */ Path toPath$default(Morph morph, float f, Path path, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            path = new Path();
        }
        return toPath(morph, f, path);
    }

    public static final Path toPath(Morph morph, float f, Path path) {
        morph.getClass();
        path.getClass();
        pathFromCubics(path, morph.asCubics(f));
        return path;
    }
}
