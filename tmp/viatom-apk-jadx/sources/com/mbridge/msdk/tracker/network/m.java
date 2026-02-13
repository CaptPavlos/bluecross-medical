package com.mbridge.msdk.tracker.network;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5416a = "m";

    /* renamed from: b, reason: collision with root package name */
    private static volatile m f5417b;

    /* renamed from: c, reason: collision with root package name */
    private v f5418c;

    private m() {
    }

    public static m a() {
        if (f5417b == null) {
            synchronized (m.class) {
                try {
                    if (f5417b == null) {
                        f5417b = new m();
                    }
                } finally {
                }
            }
        }
        return f5417b;
    }

    public final v b() {
        if (this.f5418c == null) {
            v vVarA = com.mbridge.msdk.tracker.network.toolbox.n.a(new com.mbridge.msdk.tracker.network.toolbox.b(new com.mbridge.msdk.tracker.network.toolbox.k()), null, 10, new com.mbridge.msdk.tracker.network.toolbox.j());
            this.f5418c = vVarA;
            vVarA.a();
        }
        return this.f5418c;
    }
}
