package com.mbridge.msdk.foundation.controller;

import android.annotation.SuppressLint;
import com.mbridge.msdk.foundation.controller.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c extends a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile c f;

    private c() {
    }

    public static c m() {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        f = new c();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    @Override // com.mbridge.msdk.foundation.controller.a
    public final void a(a.InterfaceC0026a interfaceC0026a) {
    }
}
