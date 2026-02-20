package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class PendingPost {

    /* renamed from: d, reason: collision with root package name */
    private static final List<PendingPost> f3227d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f3228a;

    /* renamed from: b, reason: collision with root package name */
    Subscription f3229b;

    /* renamed from: c, reason: collision with root package name */
    PendingPost f3230c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f3228a = obj;
        this.f3229b = subscription;
    }

    public static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = f3227d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost pendingPostRemove = list.remove(size - 1);
                pendingPostRemove.f3228a = obj;
                pendingPostRemove.f3229b = subscription;
                pendingPostRemove.f3230c = null;
                return pendingPostRemove;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(PendingPost pendingPost) {
        pendingPost.f3228a = null;
        pendingPost.f3229b = null;
        pendingPost.f3230c = null;
        List<PendingPost> list = f3227d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
