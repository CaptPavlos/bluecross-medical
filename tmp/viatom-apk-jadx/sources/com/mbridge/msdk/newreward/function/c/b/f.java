package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.tracker.network.toolbox.j;
import com.mbridge.msdk.tracker.network.toolbox.k;
import com.mbridge.msdk.tracker.network.toolbox.n;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.v;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f4708a;

    /* renamed from: b, reason: collision with root package name */
    private v f4709b;

    private f() {
    }

    public static f a() {
        if (f4708a == null) {
            synchronized (f.class) {
                try {
                    if (f4708a == null) {
                        f4708a = new f();
                    }
                } finally {
                }
            }
        }
        return f4708a;
    }

    private v b() {
        if (this.f4709b == null) {
            v vVarA = n.a(new com.mbridge.msdk.tracker.network.toolbox.b(new k()), new com.mbridge.msdk.tracker.network.g(c()), 5, new j());
            this.f4709b = vVarA;
            vVarA.a();
        }
        return this.f4709b;
    }

    private static ThreadPoolExecutor c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.newreward.function.c.b.f.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("campaign_response_thread");
                return thread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public final void a(a aVar) {
        b().a(aVar);
    }

    public final void a(u<JSONObject> uVar) {
        b().a(uVar);
    }
}
