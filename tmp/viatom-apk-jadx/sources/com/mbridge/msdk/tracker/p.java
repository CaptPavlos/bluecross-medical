package com.mbridge.msdk.tracker;

import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class p implements l {

    /* renamed from: a, reason: collision with root package name */
    private final g f5501a;

    public p(g gVar) {
        this.f5501a = gVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public final long[] a() {
        return y.a(this.f5501a) ? new long[]{0, 0} : this.f5501a.a();
    }

    @Override // com.mbridge.msdk.tracker.l
    public final void b(e eVar) {
        if (y.a(this.f5501a)) {
            return;
        }
        try {
            h hVarI = eVar.i();
            if (y.b(hVarI)) {
                eVar.a(hVarI.a(eVar));
            }
            this.f5501a.b(eVar);
        } catch (Exception e) {
            if (a.f5328a) {
                Log.e("TrackManager", "process event error", e);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.l
    public final void a(e eVar) {
        if (y.a(this.f5501a)) {
            return;
        }
        this.f5501a.a(eVar);
    }
}
