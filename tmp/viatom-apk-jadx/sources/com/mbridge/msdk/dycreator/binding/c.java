package com.mbridge.msdk.dycreator.binding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f3192a;

    private c() {
    }

    public static c a() {
        if (f3192a == null) {
            synchronized (c.class) {
                try {
                    if (f3192a == null) {
                        f3192a = new c();
                    }
                } finally {
                }
            }
        }
        return f3192a;
    }
}
