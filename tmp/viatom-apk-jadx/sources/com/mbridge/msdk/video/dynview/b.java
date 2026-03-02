package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f5686b;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, SoftReference<View>> f5687a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (f5686b != null) {
            return f5686b;
        }
        synchronized (b.class) {
            try {
                if (f5686b == null) {
                    f5686b = new b();
                }
                bVar = f5686b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void a(c cVar, h hVar) {
        new com.mbridge.msdk.video.dynview.h.a(cVar, hVar, new HashMap());
    }

    public final void a(c cVar, h hVar, Map<String, Object> map) {
        new com.mbridge.msdk.video.dynview.h.a(cVar, hVar, map);
    }
}
