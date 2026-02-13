package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q6 {

    /* renamed from: a, reason: collision with root package name */
    public static final m5 f2139a;

    static {
        m6 m6Var = m6.f2086c;
        f2139a = new m5(6);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Object obj, Object obj2) {
        o5 o5Var = (o5) obj;
        v6 v6Var = o5Var.zzc;
        v6 v6Var2 = ((o5) obj2).zzc;
        v6 v6Var3 = v6.f;
        if (!v6Var3.equals(v6Var2)) {
            if (v6Var3.equals(v6Var)) {
                int i10 = v6Var.f2205a + v6Var2.f2205a;
                int[] iArrCopyOf = Arrays.copyOf(v6Var.f2206b, i10);
                System.arraycopy(v6Var2.f2206b, 0, iArrCopyOf, v6Var.f2205a, v6Var2.f2205a);
                Object[] objArrCopyOf = Arrays.copyOf(v6Var.f2207c, i10);
                System.arraycopy(v6Var2.f2207c, 0, objArrCopyOf, v6Var.f2205a, v6Var2.f2205a);
                v6Var = new v6(i10, iArrCopyOf, objArrCopyOf, true);
            } else {
                v6Var.getClass();
                if (!v6Var2.equals(v6Var3)) {
                    if (!v6Var.e) {
                        p8.u.p();
                        return;
                    }
                    int i11 = v6Var.f2205a + v6Var2.f2205a;
                    v6Var.e(i11);
                    System.arraycopy(v6Var2.f2206b, 0, v6Var.f2206b, v6Var.f2205a, v6Var2.f2205a);
                    System.arraycopy(v6Var2.f2207c, 0, v6Var.f2207c, v6Var.f2205a, v6Var2.f2205a);
                    v6Var.f2205a = i11;
                }
            }
        }
        o5Var.zzc = v6Var;
    }

    public static void c(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        if (list instanceof f5) {
            com.google.gson.internal.a.k();
            return;
        }
        int i11 = 0;
        if (!z9) {
            while (i11 < list.size()) {
                d5Var.h(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Double) list.get(i13)).getClass();
            i12 += 8;
        }
        d5Var.m(i12);
        while (i11 < list.size()) {
            d5Var.p(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
            i11++;
        }
    }

    public static void d(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        if (list instanceof k5) {
            com.google.gson.internal.a.k();
            return;
        }
        int i11 = 0;
        if (!z9) {
            while (i11 < list.size()) {
                d5Var.f(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Float) list.get(i13)).getClass();
            i12 += 4;
        }
        d5Var.m(i12);
        while (i11 < list.size()) {
            d5Var.n(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
            i11++;
        }
    }

    public static void e(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof b6)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.g(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iA += d5.a(((Long) list.get(i12)).longValue());
            }
            d5Var.m(iA);
            while (i11 < list.size()) {
                d5Var.o(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        b6 b6Var = (b6) list;
        if (!z9) {
            while (i11 < b6Var.f1892c) {
                d5Var.g(i10, b6Var.c(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < b6Var.f1892c; i13++) {
            iA2 += d5.a(b6Var.c(i13));
        }
        d5Var.m(iA2);
        while (i11 < b6Var.f1892c) {
            d5Var.o(b6Var.c(i11));
            i11++;
        }
    }

    public static void f(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof b6)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.g(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iA += d5.a(((Long) list.get(i12)).longValue());
            }
            d5Var.m(iA);
            while (i11 < list.size()) {
                d5Var.o(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        b6 b6Var = (b6) list;
        if (!z9) {
            while (i11 < b6Var.f1892c) {
                d5Var.g(i10, b6Var.c(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < b6Var.f1892c; i13++) {
            iA2 += d5.a(b6Var.c(i13));
        }
        d5Var.m(iA2);
        while (i11 < b6Var.f1892c) {
            d5Var.o(b6Var.c(i11));
            i11++;
        }
    }

    public static void g(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof b6)) {
            if (!z9) {
                while (i11 < list.size()) {
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    d5Var.g(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iA += d5.a((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            d5Var.m(iA);
            while (i11 < list.size()) {
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                d5Var.o((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        b6 b6Var = (b6) list;
        if (!z9) {
            while (i11 < b6Var.f1892c) {
                long jC = b6Var.c(i11);
                d5Var.g(i10, (jC >> 63) ^ (jC + jC));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < b6Var.f1892c; i13++) {
            long jC2 = b6Var.c(i13);
            iA2 += d5.a((jC2 >> 63) ^ (jC2 + jC2));
        }
        d5Var.m(iA2);
        while (i11 < b6Var.f1892c) {
            long jC3 = b6Var.c(i11);
            d5Var.o((jC3 >> 63) ^ (jC3 + jC3));
            i11++;
        }
    }

    public static void h(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof b6)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.h(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            d5Var.m(i12);
            while (i11 < list.size()) {
                d5Var.p(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        b6 b6Var = (b6) list;
        if (!z9) {
            while (i11 < b6Var.f1892c) {
                d5Var.h(i10, b6Var.c(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < b6Var.f1892c; i15++) {
            b6Var.c(i15);
            i14 += 8;
        }
        d5Var.m(i14);
        while (i11 < b6Var.f1892c) {
            d5Var.p(b6Var.c(i11));
            i11++;
        }
    }

    public static void i(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof b6)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.h(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            d5Var.m(i12);
            while (i11 < list.size()) {
                d5Var.p(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        b6 b6Var = (b6) list;
        if (!z9) {
            while (i11 < b6Var.f1892c) {
                d5Var.h(i10, b6Var.c(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < b6Var.f1892c; i15++) {
            b6Var.c(i15);
            i14 += 8;
        }
        d5Var.m(i14);
        while (i11 < b6Var.f1892c) {
            d5Var.p(b6Var.c(i11));
            i11++;
        }
    }

    public static void j(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.d(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iA += d5.a(((Integer) list.get(i12)).intValue());
            }
            d5Var.m(iA);
            while (i11 < list.size()) {
                d5Var.l(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                d5Var.d(i10, p5Var.d(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < p5Var.f2132c; i13++) {
            iA2 += d5.a(p5Var.d(i13));
        }
        d5Var.m(iA2);
        while (i11 < p5Var.f2132c) {
            d5Var.l(p5Var.d(i11));
            i11++;
        }
    }

    public static void k(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.e(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iS = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iS += d5.s(((Integer) list.get(i12)).intValue());
            }
            d5Var.m(iS);
            while (i11 < list.size()) {
                d5Var.m(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                d5Var.e(i10, p5Var.d(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iS2 = 0;
        for (int i13 = 0; i13 < p5Var.f2132c; i13++) {
            iS2 += d5.s(p5Var.d(i13));
        }
        d5Var.m(iS2);
        while (i11 < p5Var.f2132c) {
            d5Var.m(p5Var.d(i11));
            i11++;
        }
    }

    public static void l(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    d5Var.e(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iS = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iS += d5.s((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            d5Var.m(iS);
            while (i11 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                d5Var.m((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                int iD = p5Var.d(i11);
                d5Var.e(i10, (iD >> 31) ^ (iD + iD));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iS2 = 0;
        for (int i13 = 0; i13 < p5Var.f2132c; i13++) {
            int iD2 = p5Var.d(i13);
            iS2 += d5.s((iD2 >> 31) ^ (iD2 + iD2));
        }
        d5Var.m(iS2);
        while (i11 < p5Var.f2132c) {
            int iD3 = p5Var.d(i11);
            d5Var.m((iD3 >> 31) ^ (iD3 + iD3));
            i11++;
        }
    }

    public static void m(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.f(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            d5Var.m(i12);
            while (i11 < list.size()) {
                d5Var.n(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                d5Var.f(i10, p5Var.d(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < p5Var.f2132c; i15++) {
            p5Var.d(i15);
            i14 += 4;
        }
        d5Var.m(i14);
        while (i11 < p5Var.f2132c) {
            d5Var.n(p5Var.d(i11));
            i11++;
        }
    }

    public static void n(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.f(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            d5Var.m(i12);
            while (i11 < list.size()) {
                d5Var.n(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                d5Var.f(i10, p5Var.d(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < p5Var.f2132c; i15++) {
            p5Var.d(i15);
            i14 += 4;
        }
        d5Var.m(i14);
        while (i11 < p5Var.f2132c) {
            d5Var.n(p5Var.d(i11));
            i11++;
        }
    }

    public static void o(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        int i11 = 0;
        if (!(list instanceof p5)) {
            if (!z9) {
                while (i11 < list.size()) {
                    d5Var.d(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            d5Var.c(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iA += d5.a(((Integer) list.get(i12)).intValue());
            }
            d5Var.m(iA);
            while (i11 < list.size()) {
                d5Var.l(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        p5 p5Var = (p5) list;
        if (!z9) {
            while (i11 < p5Var.f2132c) {
                d5Var.d(i10, p5Var.d(i11));
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < p5Var.f2132c; i13++) {
            iA2 += d5.a(p5Var.d(i13));
        }
        d5Var.m(iA2);
        while (i11 < p5Var.f2132c) {
            d5Var.l(p5Var.d(i11));
            i11++;
        }
    }

    public static void p(int i10, List list, c6 c6Var, boolean z9) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d5 d5Var = (d5) c6Var.f1904a;
        if (list instanceof y4) {
            com.google.gson.internal.a.k();
            return;
        }
        int i11 = 0;
        if (!z9) {
            while (i11 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i11)).booleanValue();
                d5Var.m(i10 << 3);
                d5Var.k(zBooleanValue ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        d5Var.c(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Boolean) list.get(i13)).getClass();
            i12++;
        }
        d5Var.m(i12);
        while (i11 < list.size()) {
            d5Var.k(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    public static int q(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b6)) {
            int iA = 0;
            while (i10 < size) {
                iA += d5.a(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iA;
        }
        b6 b6Var = (b6) list;
        int iA2 = 0;
        while (i10 < size) {
            iA2 += d5.a(b6Var.c(i10));
            i10++;
        }
        return iA2;
    }

    public static int r(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b6)) {
            int iA = 0;
            while (i10 < size) {
                iA += d5.a(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iA;
        }
        b6 b6Var = (b6) list;
        int iA2 = 0;
        while (i10 < size) {
            iA2 += d5.a(b6Var.c(i10));
            i10++;
        }
        return iA2;
    }

    public static int s(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b6)) {
            int iA = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iA += d5.a((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
            return iA;
        }
        b6 b6Var = (b6) list;
        int iA2 = 0;
        while (i10 < size) {
            long jC = b6Var.c(i10);
            iA2 += d5.a((jC >> 63) ^ (jC + jC));
            i10++;
        }
        return iA2;
    }

    public static int t(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p5)) {
            int iA = 0;
            while (i10 < size) {
                iA += d5.a(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iA;
        }
        p5 p5Var = (p5) list;
        int iA2 = 0;
        while (i10 < size) {
            iA2 += d5.a(p5Var.d(i10));
            i10++;
        }
        return iA2;
    }

    public static int u(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p5)) {
            int iA = 0;
            while (i10 < size) {
                iA += d5.a(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iA;
        }
        p5 p5Var = (p5) list;
        int iA2 = 0;
        while (i10 < size) {
            iA2 += d5.a(p5Var.d(i10));
            i10++;
        }
        return iA2;
    }

    public static int v(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p5)) {
            int iS = 0;
            while (i10 < size) {
                iS += d5.s(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iS;
        }
        p5 p5Var = (p5) list;
        int iS2 = 0;
        while (i10 < size) {
            iS2 += d5.s(p5Var.d(i10));
            i10++;
        }
        return iS2;
    }

    public static int w(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p5)) {
            int iS = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iS += d5.s((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
            return iS;
        }
        p5 p5Var = (p5) list;
        int iS2 = 0;
        while (i10 < size) {
            int iD = p5Var.d(i10);
            iS2 += d5.s((iD >> 31) ^ (iD + iD));
            i10++;
        }
        return iS2;
    }

    public static int x(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (d5.s(i10 << 3) + 4) * size;
    }

    public static int y(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (d5.s(i10 << 3) + 8) * size;
    }
}
