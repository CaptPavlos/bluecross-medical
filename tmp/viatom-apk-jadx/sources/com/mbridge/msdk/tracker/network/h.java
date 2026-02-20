package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f5408a;

    /* renamed from: b, reason: collision with root package name */
    private final String f5409b;

    public h(String str, String str2) {
        this.f5408a = str;
        this.f5409b = str2;
    }

    public final String a() {
        return this.f5408a;
    }

    public final String b() {
        return this.f5409b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (TextUtils.equals(this.f5408a, hVar.f5408a) && TextUtils.equals(this.f5409b, hVar.f5409b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5409b.hashCode() + (this.f5408a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.f5408a);
        sb.append(",value=");
        return a3.a.o(sb, this.f5409b, "]");
    }
}
