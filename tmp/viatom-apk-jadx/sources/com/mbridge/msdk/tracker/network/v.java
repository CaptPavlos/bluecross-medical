package com.mbridge.msdk.tracker.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f5487a;
    private final int e;
    private final b f;
    private final n g;
    private final x h;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f5488b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    private final Set<u<?>> f5489c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<u<?>> f5490d = new PriorityBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private final List<a> f5491i = new ArrayList();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(u<?> uVar, int i10);
    }

    public v(n nVar, x xVar, int i10, b bVar) {
        this.e = i10;
        this.f = bVar;
        this.g = nVar;
        this.h = xVar;
    }

    private void b(int i10) {
        this.f5487a = new ThreadPoolExecutor(i10, i10, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.tracker.network.v.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "NetworkDispatcher");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final <T> u<T> a(u<T> uVar) {
        uVar.a(this);
        synchronized (this.f5489c) {
            this.f5489c.add(uVar);
        }
        uVar.c(this.f5488b.incrementAndGet());
        a(uVar, 0);
        this.f5490d.add(uVar);
        if (this.f5487a == null) {
            a(this.e);
        }
        this.f5487a.execute(new Runnable() { // from class: com.mbridge.msdk.tracker.network.v.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    new o(v.this.f5490d, v.this.g, v.this.f, v.this.h).run();
                } catch (Throwable unused) {
                }
            }
        });
        return uVar;
    }

    public final <T> void b(u<T> uVar) {
        synchronized (this.f5489c) {
            this.f5489c.remove(uVar);
        }
        a(uVar, 5);
    }

    private void a(int i10) {
        if (this.f5487a != null) {
            return;
        }
        try {
            b(i10);
            if (this.f5487a != null) {
                this.f5487a.allowCoreThreadTimeOut(true);
            }
        } catch (Throwable unused) {
            try {
                b(5);
            } catch (Exception unused2) {
            } catch (Throwable th) {
                if (this.f5487a != null) {
                    this.f5487a.allowCoreThreadTimeOut(true);
                }
                throw th;
            }
            if (this.f5487a != null) {
                this.f5487a.allowCoreThreadTimeOut(true);
            }
        }
    }

    public final void a(u<?> uVar, int i10) {
        synchronized (this.f5491i) {
            try {
                Iterator<a> it = this.f5491i.iterator();
                while (it.hasNext()) {
                    it.next().a(uVar, i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        this.f5487a = null;
        a(this.e);
    }
}
