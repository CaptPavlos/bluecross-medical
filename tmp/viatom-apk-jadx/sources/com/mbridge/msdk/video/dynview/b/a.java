package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f5688b;

    /* renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f5689a;

    private a() {
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int iH = cVar.h();
        if (iH == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.f5689a = aVar.f5768a;
        } else {
            if (iH == 2) {
                new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
                return;
            }
            if (iH == 4) {
                new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
            } else if (iH != 5) {
                eVar.a(view, new ArrayList());
            } else {
                new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
            }
        }
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.f5689a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public static a a() {
        a aVar;
        if (f5688b == null) {
            synchronized (a.class) {
                try {
                    if (f5688b == null) {
                        f5688b = new a();
                    }
                    aVar = f5688b;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return f5688b;
    }
}
