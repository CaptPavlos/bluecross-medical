package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements x {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5402a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final u f5405a;

        /* renamed from: b, reason: collision with root package name */
        private final w f5406b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f5407c;

        public a(u uVar, w wVar, Runnable runnable) {
            this.f5405a = uVar;
            this.f5406b = wVar;
            this.f5407c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f5405a.n()) {
                this.f5405a.c("canceled-at-delivery");
                return;
            }
            w wVar = this.f5406b;
            ad adVar = wVar.f5496c;
            u uVar = this.f5405a;
            if (adVar == null) {
                uVar.a((u) wVar.f5494a);
            } else {
                uVar.b(adVar);
            }
            boolean z9 = this.f5406b.f5497d;
            u uVar2 = this.f5405a;
            if (!z9) {
                uVar2.c("done");
            }
            Runnable runnable = this.f5407c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(final Handler handler) {
        this.f5402a = new Executor() { // from class: com.mbridge.msdk.tracker.network.g.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public final void a(u<?> uVar, ad adVar) {
        this.f5402a.execute(new a(uVar, w.a(adVar), null));
    }

    public g(Executor executor) {
        this.f5402a = executor;
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public final void a(u<?> uVar, w<?> wVar) {
        uVar.w();
        this.f5402a.execute(new a(uVar, wVar, null));
    }
}
