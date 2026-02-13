package com.mbridge.msdk.tracker;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.z;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u<T> extends com.mbridge.msdk.tracker.network.u<T> {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f5520a;

    /* renamed from: b, reason: collision with root package name */
    private u.b f5521b;

    /* renamed from: c, reason: collision with root package name */
    private w.b<T> f5522c;

    /* renamed from: d, reason: collision with root package name */
    private v f5523d;
    private com.mbridge.msdk.tracker.network.e e;

    public u(String str, int i10) {
        super(i10, str);
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final void a(T t) {
        w.b<T> bVar = this.f5522c;
        this.f5522c = bVar;
        if (bVar != null) {
            bVar.a(t);
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final z b() {
        if (y.a(this.e)) {
            this.e = new com.mbridge.msdk.tracker.network.e(30000, 5);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        map.put("Charset", C.UTF8_NAME);
        return map;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final boolean d() {
        return false;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final u.b e() {
        return this.f5521b;
    }

    public u(String str, int i10, int i11) {
        super(i10, str, i11);
    }

    public final void a(u.b bVar) {
        this.f5521b = bVar;
    }

    public final void a(Map<String, String> map) {
        this.f5520a = map;
    }

    public final void a(w.b<T> bVar) {
        this.f5522c = bVar;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final com.mbridge.msdk.tracker.network.w<T> a(com.mbridge.msdk.tracker.network.r rVar) {
        return this.f5523d.a(rVar);
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> a() {
        return this.f5520a;
    }

    public final void a(v vVar) {
        this.f5523d = vVar;
    }
}
