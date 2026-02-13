package com.mbridge.msdk.tracker.network;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f5443a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5444b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f5445c;

    /* renamed from: d, reason: collision with root package name */
    public final List<h> f5446d;
    public final boolean e;
    public final long f;

    private r(int i10, byte[] bArr, Map<String, String> map, List<h> list, boolean z9, long j10) {
        this.f5443a = i10;
        this.f5444b = bArr;
        this.f5445c = map;
        if (list == null) {
            this.f5446d = null;
        } else {
            this.f5446d = DesugarCollections.unmodifiableList(list);
        }
        this.e = z9;
        this.f = j10;
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

    public r(int i10, byte[] bArr, boolean z9, long j10, List<h> list) {
        this(i10, bArr, a(list), list, z9, j10);
    }
}
