package com.mbridge.msdk.dycreator.bus;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable th, Object obj, Object obj2) {
        this.eventBus = eventBus;
        this.throwable = th;
        this.causingEvent = obj;
        this.causingSubscriber = obj2;
    }
}
