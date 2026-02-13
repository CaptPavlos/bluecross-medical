package com.mbridge.msdk.dycreator.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f2919a;

    /* renamed from: b, reason: collision with root package name */
    private String f2920b;

    public a(b bVar) {
        if (bVar != null) {
            this.f2919a = bVar.a();
            this.f2920b = bVar.b();
        }
    }

    public final String toString() {
        return a3.a.k(new StringBuilder("DyError{errorCode="), this.f2919a, '}');
    }

    public a(int i10, String str) {
        this.f2919a = i10;
        this.f2920b = str;
    }
}
