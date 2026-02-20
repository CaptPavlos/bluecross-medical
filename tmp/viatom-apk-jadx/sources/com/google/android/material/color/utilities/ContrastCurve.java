package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d8, double d10, double d11, double d12) {
        this.low = d8;
        this.normal = d10;
        this.medium = d11;
        this.high = d12;
    }

    public double get(double d8) {
        return d8 <= -1.0d ? this.low : d8 < 0.0d ? MathUtils.lerp(this.low, this.normal, (d8 - (-1.0d)) / 1.0d) : d8 < 0.5d ? MathUtils.lerp(this.normal, this.medium, (d8 - 0.0d) / 0.5d) : d8 < 1.0d ? MathUtils.lerp(this.medium, this.high, (d8 - 0.5d) / 0.5d) : this.high;
    }
}
