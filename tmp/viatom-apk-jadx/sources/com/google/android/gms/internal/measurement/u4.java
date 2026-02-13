package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class u4 {
    protected int zza;

    public static void c(Iterable iterable, List list) {
        Charset charset = u5.f2192a;
        iterable.getClass();
        if (iterable instanceof y5) {
            List listA = ((y5) iterable).a();
            y5 y5Var = (y5) list;
            int size = list.size();
            for (Object obj : listA) {
                if (obj == null) {
                    int size2 = y5Var.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    int size3 = y5Var.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            androidx.window.layout.c.k(string);
                            return;
                        }
                        y5Var.remove(size3);
                    }
                } else if (obj instanceof c5) {
                    y5Var.j();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    c5.e(0, bArr.length, bArr);
                    y5Var.j();
                } else {
                    y5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof l6) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size4 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size4);
            } else if (list instanceof n6) {
                n6 n6Var = (n6) list;
                int i10 = n6Var.f2105c + size4;
                int length = n6Var.f2104b.length;
                if (i10 > length) {
                    if (length != 0) {
                        while (length < i10) {
                            length = Math.max(((length * 3) / 2) + 1, 10);
                        }
                        n6Var.f2104b = Arrays.copyOf(n6Var.f2104b, length);
                    } else {
                        n6Var.f2104b = new Object[Math.max(i10, 10)];
                    }
                }
            }
        }
        int size5 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    n5.a(size5, list);
                    throw null;
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size6 = list2.size();
        for (int i11 = 0; i11 < size6; i11++) {
            Object obj3 = list2.get(i11);
            if (obj3 == null) {
                n5.a(size5, list);
                throw null;
            }
            list.add(obj3);
        }
    }

    public final byte[] a() {
        try {
            o5 o5Var = (o5) this;
            int iK = o5Var.k();
            byte[] bArr = new byte[iK];
            d5 d5Var = new d5(bArr, iK);
            o5Var.d(d5Var);
            if (iK - d5Var.f1917d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            androidx.privacysandbox.ads.adservices.adid.a.l(androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e);
            return null;
        }
    }

    public abstract int b(p6 p6Var);
}
