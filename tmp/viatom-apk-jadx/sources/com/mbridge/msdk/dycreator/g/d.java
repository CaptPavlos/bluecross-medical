package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends a {
    public final void a(Object obj) {
        i iVar;
        try {
            synchronized (this) {
                try {
                    ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f3255a;
                    if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                        for (Map.Entry<Integer, Object> entry : this.f3255a.entrySet()) {
                            if (entry != null && (entry.getValue() instanceof i) && (iVar = (i) entry.getValue()) != null) {
                                iVar.a(obj);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
