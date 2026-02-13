package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class HandlerPoster extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f3223a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3224b;

    /* renamed from: c, reason: collision with root package name */
    private final EventBus f3225c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3226d;

    public HandlerPoster(EventBus eventBus, Looper looper, int i10) {
        super(looper);
        this.f3225c = eventBus;
        this.f3224b = i10;
        this.f3223a = new PendingPostQueue();
    }

    public final void a(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f3223a.a(pendingPostA);
                if (!this.f3226d) {
                    this.f3226d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost pendingPostA = this.f3223a.a();
                if (pendingPostA == null) {
                    synchronized (this) {
                        pendingPostA = this.f3223a.a();
                        if (pendingPostA == null) {
                            this.f3226d = false;
                            return;
                        }
                    }
                }
                this.f3225c.a(pendingPostA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f3224b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f3226d = true;
        } catch (Throwable th) {
            this.f3226d = false;
            throw th;
        }
    }
}
