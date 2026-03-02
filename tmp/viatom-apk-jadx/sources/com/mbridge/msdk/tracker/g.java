package com.mbridge.msdk.tracker;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class g implements l {

    /* renamed from: a, reason: collision with root package name */
    private final c f5340a;

    /* renamed from: b, reason: collision with root package name */
    private final r f5341b;

    /* renamed from: c, reason: collision with root package name */
    private final j f5342c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicLong f5343d = new AtomicLong(0);
    private final long[] e = new long[2];
    private volatile i f;

    public g(c cVar, r rVar, j jVar) {
        this.f5340a = cVar;
        this.f5341b = rVar;
        this.f5342c = jVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public final long[] a() {
        long[] jArr = this.e;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }

    @Override // com.mbridge.msdk.tracker.l
    public final void b(final e eVar) {
        this.f5342c.b(new Runnable() { // from class: com.mbridge.msdk.tracker.g.1
            private void a(i iVar, int i10) {
                while (true) {
                    g gVar = g.this;
                    if (i10 <= 0) {
                        gVar.f = iVar;
                        return;
                    } else {
                        if (gVar.f5340a.a(iVar) > 0) {
                            g.this.f5341b.c();
                            g.this.f5341b.d();
                            g.this.f5341b.a(eVar);
                            return;
                        }
                        i10--;
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(eVar.h() + System.currentTimeMillis());
                if (g.this.f != null) {
                    a(g.this.f, 5);
                    g.this.f = null;
                }
                a(iVar, 5);
            }
        });
    }

    @Override // com.mbridge.msdk.tracker.l
    public final void a(e eVar) {
        long jIncrementAndGet = this.f5343d.incrementAndGet();
        this.e[0] = System.currentTimeMillis();
        this.e[1] = jIncrementAndGet;
    }
}
