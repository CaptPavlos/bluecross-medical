package x5;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return (float) ((Math.cos(10.0d * f) * Math.pow(2.718281828459045d, (-f) / 0.2d) * (-1)) + 1);
    }
}
