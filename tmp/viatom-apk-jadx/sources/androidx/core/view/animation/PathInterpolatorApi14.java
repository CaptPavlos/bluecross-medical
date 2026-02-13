package androidx.core.view.animation;

import a3.a;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i10 = (int) (length / 0.002f);
        int i11 = i10 + 1;
        this.mX = new float[i11];
        this.mY = new float[i11];
        float[] fArr = new float[2];
        for (int i12 = 0; i12 < i11; i12++) {
            pathMeasure.getPosTan((i12 * length) / i10, fArr, null);
            this.mX[i12] = fArr[0];
            this.mY[i12] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f10, f11, f12, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f10, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float[] fArr;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i10 = 0;
        while (true) {
            int i11 = length - i10;
            fArr = this.mX;
            if (i11 <= 1) {
                break;
            }
            int i12 = (i10 + length) / 2;
            if (f < fArr[i12]) {
                length = i12;
            } else {
                i10 = i12;
            }
        }
        float f10 = fArr[length];
        float f11 = fArr[i10];
        float f12 = f10 - f11;
        float[] fArr2 = this.mY;
        if (f12 == 0.0f) {
            return fArr2[i10];
        }
        float f13 = fArr2[i10];
        return a.d(fArr2[length], f13, (f - f11) / f12, f13);
    }

    public PathInterpolatorApi14(float f, float f10) {
        this(createQuad(f, f10));
    }

    public PathInterpolatorApi14(float f, float f10, float f11, float f12) {
        this(createCubic(f, f10, f11, f12));
    }
}
