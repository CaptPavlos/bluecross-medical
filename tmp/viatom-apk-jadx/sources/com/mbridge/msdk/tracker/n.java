package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    private q f5374a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5375b;

    /* renamed from: c, reason: collision with root package name */
    private final o f5376c;

    /* renamed from: d, reason: collision with root package name */
    private final v f5377d;
    private final int e;
    private com.mbridge.msdk.tracker.network.v f;
    private final Executor g;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements w.a {

        /* renamed from: a, reason: collision with root package name */
        private final q f5379a;

        /* renamed from: b, reason: collision with root package name */
        private final s f5380b;

        public a(q qVar, s sVar) {
            this.f5379a = qVar;
            this.f5380b = sVar;
        }

        @Override // com.mbridge.msdk.tracker.network.w.a
        public final void a(ad adVar) {
            if (y.b(this.f5379a)) {
                try {
                    this.f5379a.a(this.f5380b, 0, adVar.getMessage());
                } catch (Exception e) {
                    if (com.mbridge.msdk.tracker.a.f5328a) {
                        Log.e("TrackManager", "onErrorResponse error", e);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b implements w.b {

        /* renamed from: a, reason: collision with root package name */
        private final q f5381a;

        /* renamed from: b, reason: collision with root package name */
        private final s f5382b;

        public b(q qVar, s sVar) {
            this.f5381a = qVar;
            this.f5382b = sVar;
        }

        @Override // com.mbridge.msdk.tracker.network.w.b
        public final void a(Object obj) {
            if (y.b(this.f5381a)) {
                try {
                    this.f5381a.a(this.f5382b);
                } catch (Exception e) {
                    if (com.mbridge.msdk.tracker.a.f5328a) {
                        Log.e("TrackManager", "onResponse error", e);
                    }
                }
            }
        }
    }

    public n(int i10, o oVar, v vVar, int i11) {
        this.f5375b = i10;
        this.f5376c = oVar;
        this.f5377d = vVar;
        this.e = i11;
        this.g = new ThreadPoolExecutor(i10, i10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.tracker.n.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeReportResponseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(s sVar, Map<String, String> map, boolean z9) {
        if (y.a(map)) {
            q qVar = this.f5374a;
            if (qVar != null) {
                try {
                    qVar.a(sVar, 0, "params is null");
                    return;
                } catch (Exception e) {
                    if (com.mbridge.msdk.tracker.a.f5328a) {
                        Log.e("TrackManager", "send error", e);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        try {
            if (!y.b(this.f)) {
                com.mbridge.msdk.tracker.network.v vVarA = com.mbridge.msdk.tracker.network.toolbox.n.a(new com.mbridge.msdk.tracker.network.toolbox.b(this.f5376c.c()), new com.mbridge.msdk.tracker.network.g(this.g), this.f5375b, null);
                this.f = vVarA;
                vVarA.a();
            }
            u uVar = this.e == 1 ? new u(this.f5376c.b(), 1, this.f5376c.a()) : new u(this.f5376c.b(), 1);
            uVar.a(map);
            uVar.b(false);
            uVar.c(true);
            uVar.d(true);
            uVar.a(this.f5377d);
            uVar.a(z9 ? u.b.HIGH : u.b.NORMAL);
            uVar.a((w.b) new b(this.f5374a, sVar));
            uVar.a((w.a) new a(this.f5374a, sVar));
            this.f.a(uVar);
        } catch (Exception e3) {
            if (com.mbridge.msdk.tracker.a.f5328a) {
                Log.e("TrackManager", "send error", e3);
            }
            if (y.b(this.f5374a)) {
                this.f5374a.a(sVar, 0, e3.getMessage());
            }
        }
    }

    public final void a(q qVar) {
        this.f5374a = qVar;
    }
}
