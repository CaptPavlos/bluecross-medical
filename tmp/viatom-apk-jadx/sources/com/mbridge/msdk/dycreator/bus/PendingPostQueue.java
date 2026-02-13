package com.mbridge.msdk.dycreator.bus;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class PendingPostQueue {

    /* renamed from: a, reason: collision with root package name */
    private PendingPost f3231a;

    /* renamed from: b, reason: collision with root package name */
    private PendingPost f3232b;

    public final synchronized void a(PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.f3232b;
            if (pendingPost2 != null) {
                pendingPost2.f3230c = pendingPost;
                this.f3232b = pendingPost;
            } else {
                if (this.f3231a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f3232b = pendingPost;
                this.f3231a = pendingPost;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f3231a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.f3230c;
            this.f3231a = pendingPost2;
            if (pendingPost2 == null) {
                this.f3232b = null;
            }
        }
        return pendingPost;
    }

    public final synchronized PendingPost a(int i10) throws InterruptedException {
        try {
            if (this.f3231a == null) {
                wait(i10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a();
    }
}
