package c1;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1495a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1496b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f1497c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f1498d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ c3 h;

    public u2(c3 c3Var, String str, String str2, long j10, Bundle bundle, boolean z9, boolean z10, boolean z11) {
        this.f1495a = str;
        this.f1496b = str2;
        this.f1497c = j10;
        this.f1498d = bundle;
        this.e = z9;
        this.f = z10;
        this.g = z11;
        this.h = c3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.h.p(this.f1495a, this.f1496b, this.f1497c, this.f1498d, this.e, this.f, this.g);
    }
}
