package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class z6 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f2282a;

    public z6(Unsafe unsafe) {
        this.f2282a = unsafe;
    }

    public abstract void a(Object obj, long j10, byte b10);

    public abstract boolean b(long j10, Object obj);

    public abstract void c(Object obj, long j10, boolean z9);

    public abstract float d(long j10, Object obj);

    public abstract void e(Object obj, long j10, float f);

    public abstract double f(long j10, Object obj);

    public abstract void g(Object obj, long j10, double d8);
}
