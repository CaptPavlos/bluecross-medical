package com.mbridge.msdk.dycreator.bus;

import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class AsyncPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f3202a = new PendingPostQueue();

    /* renamed from: b, reason: collision with root package name */
    private final EventBus f3203b;

    public AsyncPoster(EventBus eventBus) {
        this.f3203b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f3202a.a(PendingPost.a(subscription, obj));
        EventBus.f3207a.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost pendingPostA = this.f3202a.a();
        if (pendingPostA != null) {
            this.f3203b.a(pendingPostA);
        } else {
            c.g("No pending post available");
        }
    }
}
