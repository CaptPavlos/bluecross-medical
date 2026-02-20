package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.tracker.network.h;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3710a;

    /* renamed from: b, reason: collision with root package name */
    public final List<h> f3711b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f3712c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3713d;

    private a(int i10, byte[] bArr, Map<String, String> map, List<h> list) {
        this.f3713d = i10;
        this.f3710a = bArr;
        this.f3712c = map;
        if (list == null) {
            this.f3711b = null;
        } else {
            this.f3711b = DesugarCollections.unmodifiableList(list);
        }
    }

    private static Map<String, String> a(List<h> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (h hVar : list) {
            treeMap.put(hVar.a(), hVar.b());
        }
        return treeMap;
    }

    public a(int i10, byte[] bArr, List<h> list) {
        this(i10, bArr, a(list), list);
    }
}
