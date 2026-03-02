package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i5 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1991c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final r6 f1992a = new r6();

    /* renamed from: b, reason: collision with root package name */
    public boolean f1993b;

    static {
        new i5(0);
    }

    public i5(int i10) {
        a();
        a();
    }

    public static void b(d5 d5Var, d7 d7Var, int i10, Object obj) throws e5 {
        if (d7Var == d7.f1920d) {
            Charset charset = u5.f2192a;
            d5Var.c(i10, 3);
            ((o5) ((u4) obj)).d(d5Var);
            d5Var.c(i10, 4);
            return;
        }
        d5Var.c(i10, d7Var.f1922b);
        e7 e7Var = e7.f1937a;
        switch (d7Var.ordinal()) {
            case 0:
                d5Var.p(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                d5Var.n(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                d5Var.o(((Long) obj).longValue());
                break;
            case 3:
                d5Var.o(((Long) obj).longValue());
                break;
            case 4:
                d5Var.l(((Integer) obj).intValue());
                break;
            case 5:
                d5Var.p(((Long) obj).longValue());
                break;
            case 6:
                d5Var.n(((Integer) obj).intValue());
                break;
            case 7:
                d5Var.k(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof c5)) {
                    d5Var.r((String) obj);
                    break;
                } else {
                    d5Var.j((c5) obj);
                    break;
                }
            case 9:
                ((o5) ((u4) obj)).d(d5Var);
                break;
            case 10:
                d5Var.getClass();
                o5 o5Var = (o5) ((u4) obj);
                d5Var.m(o5Var.k());
                o5Var.d(d5Var);
                break;
            case 11:
                if (!(obj instanceof c5)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    d5Var.m(length);
                    d5Var.q(length, bArr);
                    break;
                } else {
                    d5Var.j((c5) obj);
                    break;
                }
            case 12:
                d5Var.m(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof q5)) {
                    d5Var.l(((Integer) obj).intValue());
                    break;
                } else {
                    d5Var.l(((q5) obj).a());
                    break;
                }
            case 14:
                d5Var.n(((Integer) obj).intValue());
                break;
            case 15:
                d5Var.p(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                d5Var.m((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                d5Var.o((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public final void a() {
        if (this.f1993b) {
            return;
        }
        r6 r6Var = this.f1992a;
        int i10 = r6Var.f2145b;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = r6Var.a(i11).f2161b;
            if (obj instanceof o5) {
                ((o5) obj).g();
            }
        }
        Iterator it = r6Var.c().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof o5) {
                ((o5) value).g();
            }
        }
        if (!r6Var.f2147d) {
            if (r6Var.f2145b > 0) {
                r6Var.a(0).f2160a.getClass();
                com.google.gson.internal.a.k();
                return;
            } else {
                Iterator it2 = r6Var.c().iterator();
                if (it2.hasNext()) {
                    ((Map.Entry) it2.next()).getKey().getClass();
                    com.google.gson.internal.a.k();
                    return;
                }
            }
        }
        if (!r6Var.f2147d) {
            r6Var.f2146c = r6Var.f2146c.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(r6Var.f2146c);
            r6Var.f = r6Var.f.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(r6Var.f);
            r6Var.f2147d = true;
        }
        this.f1993b = true;
    }

    public final Object clone() {
        i5 i5Var = new i5();
        r6 r6Var = this.f1992a;
        if (r6Var.f2145b > 0) {
            r6Var.a(0).f2160a.getClass();
            com.google.gson.internal.a.k();
            return null;
        }
        Iterator it = r6Var.c().iterator();
        if (!it.hasNext()) {
            return i5Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            com.google.gson.internal.a.k();
            return null;
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i5) {
            return this.f1992a.equals(((i5) obj).f1992a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1992a.hashCode();
    }

    public i5() {
    }
}
