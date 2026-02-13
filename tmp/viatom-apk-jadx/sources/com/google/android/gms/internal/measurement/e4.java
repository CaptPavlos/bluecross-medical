package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e4 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1933a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.d f1934b;

    public e4(Context context, i1.d dVar) {
        this.f1933a = context;
        this.f1934b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e4)) {
            return false;
        }
        e4 e4Var = (e4) obj;
        return this.f1933a.equals(e4Var.f1933a) && this.f1934b.equals(e4Var.f1934b);
    }

    public final int hashCode() {
        return ((this.f1933a.hashCode() ^ 1000003) * 1000003) ^ this.f1934b.hashCode();
    }

    public final String toString() {
        String string = this.f1933a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f1934b);
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf.length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(string);
        sb.append(", hermeticFileOverrides=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
