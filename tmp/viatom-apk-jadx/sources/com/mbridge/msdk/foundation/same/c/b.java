package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.same.c.d;
import com.mbridge.msdk.foundation.tools.ak;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f3656a;

    private b(Context context) {
    }

    public final Bitmap a(String str) {
        if (ak.k(str)) {
            return null;
        }
        return d.a.f3665a.a(str);
    }

    public final boolean b(String str) {
        if (ak.k(str)) {
            return false;
        }
        return d.a.f3665a.b(str);
    }

    public static b a(Context context) {
        if (f3656a == null) {
            f3656a = new b(context);
        }
        return f3656a;
    }

    public final void a(String str, c cVar) {
        d.a.f3665a.a(str, null, cVar);
    }
}
