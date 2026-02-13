package androidx.interpolator.view.animation;

import a3.a;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f10 = this.mStepSize;
        float f11 = (f - (iMin * f10)) / f10;
        float[] fArr2 = this.mValues;
        float f12 = fArr2[iMin];
        return a.d(fArr2[iMin + 1], f12, f11, f12);
    }
}
