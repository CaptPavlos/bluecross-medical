package com.mbridge.msdk.tracker.network.toolbox;

import j$.util.DesugarCollections;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f5453a;

    /* renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.tracker.network.h> f5454b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5455c;

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f5456d;
    private final byte[] e;

    public g(int i10, List<com.mbridge.msdk.tracker.network.h> list, int i11, InputStream inputStream) {
        this.f5453a = i10;
        this.f5454b = list;
        this.f5455c = i11;
        this.f5456d = inputStream;
        this.e = null;
    }

    public final int a() {
        return this.f5453a;
    }

    public final List<com.mbridge.msdk.tracker.network.h> b() {
        return DesugarCollections.unmodifiableList(this.f5454b);
    }

    public final int c() {
        return this.f5455c;
    }

    public final InputStream d() {
        InputStream inputStream = this.f5456d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }

    public g(int i10, List<com.mbridge.msdk.tracker.network.h> list) {
        this(i10, list, -1, null);
    }
}
