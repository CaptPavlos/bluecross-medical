package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class BackgroundPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f3204a = new PendingPostQueue();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f3205b;

    /* renamed from: c, reason: collision with root package name */
    private final EventBus f3206c;

    public BackgroundPoster(EventBus eventBus) {
        this.f3206c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f3204a.a(pendingPostA);
                if (!this.f3205b) {
                    this.f3205b = true;
                    EventBus.f3207a.execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    PendingPost pendingPostA = this.f3204a.a(1000);
                    if (pendingPostA == null) {
                        synchronized (this) {
                            pendingPostA = this.f3204a.a();
                            if (pendingPostA == null) {
                                this.f3205b = false;
                                this.f3205b = false;
                                return;
                            }
                        }
                    }
                    this.f3206c.a(pendingPostA);
                } catch (InterruptedException e) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    this.f3205b = false;
                    return;
                }
            } catch (Throwable th) {
                this.f3205b = false;
                throw th;
            }
        }
    }
}
