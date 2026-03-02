package c1;

import java.lang.Thread;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f1384a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r1 f1385b;

    public o1(r1 r1Var, String str) {
        this.f1385b = r1Var;
        this.f1384a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        w0 w0Var = this.f1385b.f1149a.f;
        u1.m(w0Var);
        w0Var.f.c(th, this.f1384a);
    }
}
