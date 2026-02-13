package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class LogDecelerateInterpolator implements TimeInterpolator {
    int mBase;
    int mDrift;
    final float mLogScale;

    public LogDecelerateInterpolator(int i10, int i11) {
        this.mBase = i10;
        this.mDrift = i11;
        this.mLogScale = 1.0f / computeLog(1.0f, i10, i11);
    }

    public static float computeLog(float f, int i10, int i11) {
        return (i11 * f) + ((float) (-Math.pow(i10, -f))) + 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return computeLog(f, this.mBase, this.mDrift) * this.mLogScale;
    }
}
