package p8;

import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public z f12051a;

    /* renamed from: b, reason: collision with root package name */
    public x f12052b;

    /* renamed from: d, reason: collision with root package name */
    public String f12054d;
    public q e;
    public d0 g;
    public b0 h;

    /* renamed from: i, reason: collision with root package name */
    public b0 f12055i;

    /* renamed from: j, reason: collision with root package name */
    public b0 f12056j;

    /* renamed from: k, reason: collision with root package name */
    public long f12057k;

    /* renamed from: l, reason: collision with root package name */
    public long f12058l;

    /* renamed from: c, reason: collision with root package name */
    public int f12053c = -1;
    public n5 f = new n5(18);

    public static void b(String str, b0 b0Var) {
        if (b0Var.g != null) {
            com.google.gson.internal.a.n(str.concat(".body != null"));
            return;
        }
        if (b0Var.h != null) {
            com.google.gson.internal.a.n(str.concat(".networkResponse != null"));
        } else if (b0Var.f12067i != null) {
            com.google.gson.internal.a.n(str.concat(".cacheResponse != null"));
        } else {
            if (b0Var.f12068j == null) {
                return;
            }
            com.google.gson.internal.a.n(str.concat(".priorResponse != null"));
        }
    }

    public final b0 a() {
        if (this.f12051a == null) {
            androidx.window.layout.c.g("request == null");
            return null;
        }
        if (this.f12052b == null) {
            androidx.window.layout.c.g("protocol == null");
            return null;
        }
        if (this.f12053c < 0) {
            u.f(this.f12053c, "code < 0: ");
            return null;
        }
        if (this.f12054d != null) {
            return new b0(this);
        }
        androidx.window.layout.c.g("message == null");
        return null;
    }
}
