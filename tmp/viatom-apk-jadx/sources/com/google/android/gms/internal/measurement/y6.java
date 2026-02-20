package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y6 extends z6 {
    @Override // com.google.android.gms.internal.measurement.z6
    public final void a(Object obj, long j10, byte b10) {
        if (a7.g) {
            a7.c(obj, j10, b10);
        } else {
            a7.d(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final boolean b(long j10, Object obj) {
        return a7.g ? a7.n(j10, obj) : a7.o(j10, obj);
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final void c(Object obj, long j10, boolean z9) {
        if (a7.g) {
            a7.c(obj, j10, z9 ? (byte) 1 : (byte) 0);
        } else {
            a7.d(obj, j10, z9 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final float d(long j10, Object obj) {
        return Float.intBitsToFloat(this.f2282a.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final void e(Object obj, long j10, float f) {
        this.f2282a.putInt(obj, j10, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final double f(long j10, Object obj) {
        return Double.longBitsToDouble(this.f2282a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.z6
    public final void g(Object obj, long j10, double d8) {
        this.f2282a.putLong(obj, j10, Double.doubleToLongBits(d8));
    }
}
