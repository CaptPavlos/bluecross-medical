package com.mbridge.msdk.dycreator.bus;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Subscription {

    /* renamed from: a, reason: collision with root package name */
    final Object f3239a;

    /* renamed from: b, reason: collision with root package name */
    final SubscriberMethod f3240b;

    public Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f3239a = obj;
        this.f3240b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            Subscription subscription = (Subscription) obj;
            if (this.f3239a == subscription.f3239a && this.f3240b.equals(subscription.f3240b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3240b.f3236d.hashCode() + this.f3239a.hashCode();
    }
}
