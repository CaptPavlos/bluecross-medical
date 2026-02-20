package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a extends com.mbridge.msdk.dycreator.c.a {

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f3256b = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    protected ConcurrentHashMap<Integer, Object> f3255a = new ConcurrentHashMap<>();

    public final synchronized void a(Object obj, int i10) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f3255a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.f3255a.put(Integer.valueOf(i10), obj);
            }
        }
    }

    public final synchronized void a() {
        this.f3255a.clear();
    }
}
