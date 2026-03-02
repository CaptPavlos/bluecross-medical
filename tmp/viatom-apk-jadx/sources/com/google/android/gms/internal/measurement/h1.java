package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f1976a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1977b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1978c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l1 f1979d;

    public h1(l1 l1Var, boolean z9) {
        Objects.requireNonNull(l1Var);
        this.f1979d = l1Var;
        this.f1976a = System.currentTimeMillis();
        this.f1977b = SystemClock.elapsedRealtime();
        this.f1978c = z9;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        l1 l1Var = this.f1979d;
        if (l1Var.e) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            l1Var.b(e, false, this.f1978c);
            b();
        }
    }

    public void b() {
    }
}
