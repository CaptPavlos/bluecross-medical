package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f5690a;

    private b() {
    }

    public final void a(View view, c cVar, Map<String, Object> map) {
        if (cVar == null) {
            return;
        }
        int iH = cVar.h();
        if (iH == 1) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, map);
            return;
        }
        if (iH == 2) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, cVar, map);
            return;
        }
        if (iH == 3) {
            new com.mbridge.msdk.video.dynview.j.b().a(view, cVar);
        } else if (iH == 4) {
            new com.mbridge.msdk.video.dynview.j.b().b(view, cVar, map);
        } else {
            if (iH != 5) {
                return;
            }
            new com.mbridge.msdk.video.dynview.j.b();
        }
    }

    public static b a() {
        b bVar;
        if (f5690a == null) {
            synchronized (b.class) {
                try {
                    if (f5690a == null) {
                        f5690a = new b();
                    }
                    bVar = f5690a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bVar;
        }
        return f5690a;
    }
}
