package com.mbridge.msdk.foundation.same.net.f;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.k;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i<T> implements k<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.b<T> f3765a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3766b = new Handler(Looper.getMainLooper());

    public i(com.mbridge.msdk.foundation.same.net.b<T> bVar) {
        this.f3765a = bVar;
    }

    @Override // com.mbridge.msdk.tracker.network.k
    public final void a(com.mbridge.msdk.tracker.network.i<T> iVar, final w<T> wVar, final r rVar) {
        af.a("MBridgeRequestListenerWrapper", "onResponseSuccess: " + wVar.f5494a);
        this.f3766b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.f.i.1
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.foundation.same.net.d<T> dVarA;
                try {
                    if (i.this.f3765a != null) {
                        com.mbridge.msdk.foundation.same.net.b bVar = i.this.f3765a;
                        w wVar2 = wVar;
                        r rVar2 = rVar;
                        if (wVar2 == null) {
                            dVarA = null;
                        } else {
                            dVarA = com.mbridge.msdk.foundation.same.net.d.a(wVar2.f5494a, new com.mbridge.msdk.foundation.same.net.d.a(rVar2.f5443a, rVar2.f5444b, rVar2.f5446d));
                        }
                        bVar.onSuccess(dVarA);
                    }
                } catch (Exception e) {
                    af.b("MBridgeRequestListenerWrapper", "onResponseSuccess error", e);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.tracker.network.k
    public final void b(com.mbridge.msdk.tracker.network.i<T> iVar, final w<T> wVar, final r rVar) {
        af.a("MBridgeRequestListenerWrapper", "onResponseError: " + wVar.f5496c.a() + " " + wVar.f5496c.getMessage());
        this.f3766b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.f.i.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (i.this.f3765a != null) {
                        com.mbridge.msdk.foundation.same.net.b bVar = i.this.f3765a;
                        ad adVar = wVar.f5496c;
                        r rVar2 = rVar;
                        com.mbridge.msdk.foundation.same.net.a.a aVar = null;
                        if (adVar != null) {
                            com.mbridge.msdk.foundation.same.net.d.a aVar2 = rVar2 != null ? new com.mbridge.msdk.foundation.same.net.d.a(rVar2.f5443a, rVar2.f5444b, rVar2.f5446d) : new com.mbridge.msdk.foundation.same.net.d.a(0, null, null);
                            aVar = adVar.a() == 0 ? new com.mbridge.msdk.foundation.same.net.a.a(2, aVar2, adVar.getMessage()) : adVar.a() == 1 ? new com.mbridge.msdk.foundation.same.net.a.a(6, aVar2, adVar.getMessage()) : adVar.a() == 2 ? new com.mbridge.msdk.foundation.same.net.a.a(8, aVar2, adVar.getMessage()) : adVar.a() == 4 ? new com.mbridge.msdk.foundation.same.net.a.a(880041, aVar2, adVar.getMessage()) : adVar.a() == 5 ? new com.mbridge.msdk.foundation.same.net.a.a(8, aVar2, adVar.getMessage()) : adVar.a() == 6 ? new com.mbridge.msdk.foundation.same.net.a.a(15, aVar2, adVar.getMessage()) : adVar.a() == 7 ? new com.mbridge.msdk.foundation.same.net.a.a(7, aVar2, adVar.getMessage()) : adVar.a() == 8 ? new com.mbridge.msdk.foundation.same.net.a.a(10, aVar2, adVar.getMessage()) : adVar.a() == 9 ? new com.mbridge.msdk.foundation.same.net.a.a(4, aVar2, adVar.getMessage()) : new com.mbridge.msdk.foundation.same.net.a.a(2, aVar2, adVar.getMessage());
                        }
                        bVar.onError(aVar);
                    }
                } catch (Exception e) {
                    af.b("MBridgeRequestListenerWrapper", "onResponseError error", e);
                }
            }
        });
    }
}
