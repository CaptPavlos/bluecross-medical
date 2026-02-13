package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f5494a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f5495b;

    /* renamed from: c, reason: collision with root package name */
    public final ad f5496c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5497d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(ad adVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b<T> {
        void a(T t);
    }

    private w(T t, b.a aVar) {
        this.f5497d = false;
        this.f5494a = t;
        this.f5495b = aVar;
        this.f5496c = null;
    }

    public static <T> w<T> a(T t, b.a aVar) {
        return new w<>(t, aVar);
    }

    public static <T> w<T> a(ad adVar) {
        return new w<>(adVar);
    }

    private w(ad adVar) {
        this.f5497d = false;
        this.f5494a = null;
        this.f5495b = null;
        this.f5496c = adVar;
    }
}
