package a9;

import g7.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import o7.m;
import t6.a0;
import t6.l;
import z1.t1;
import z8.b0;
import z8.e0;
import z8.o;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f330a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int a(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' <= c10 && c10 < 'G') {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = z.f14517b;
        z zVarI = t3.h.i("/", false);
        s6.i[] iVarArr = {new s6.i(zVarI, new h(zVarI))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(a0.h0(1));
        a0.j0(linkedHashMap, iVarArr);
        for (h hVar : l.n0(arrayList, new i(0))) {
            if (((h) linkedHashMap.put(hVar.f344a, hVar)) == null) {
                while (true) {
                    z zVar = hVar.f344a;
                    z zVarC = zVar.c();
                    if (zVarC != null) {
                        h hVar2 = (h) linkedHashMap.get(zVarC);
                        if (hVar2 != null) {
                            hVar2.h.add(zVar);
                            break;
                        }
                        h hVar3 = new h(zVarC);
                        linkedHashMap.put(zVarC, hVar3);
                        hVar3.h.add(zVar);
                        hVar = hVar3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final String c(int i10) {
        t1.k(16);
        String string = Integer.toString(i10, 16);
        string.getClass();
        return "0x".concat(string);
    }

    public static final h d(b0 b0Var) throws IOException {
        Long lValueOf;
        int intLe = b0Var.readIntLe();
        if (intLe != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(intLe));
        }
        b0Var.skip(4L);
        short shortLe = b0Var.readShortLe();
        int i10 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            com.google.gson.internal.a.m("unsupported zip: general purpose bit flag=".concat(c(i10)));
            return null;
        }
        int shortLe2 = b0Var.readShortLe() & 65535;
        short shortLe3 = b0Var.readShortLe();
        int i11 = shortLe3 & 65535;
        short shortLe4 = b0Var.readShortLe();
        int i12 = shortLe4 & 65535;
        if (i11 == -1) {
            lValueOf = null;
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((i12 >> 9) & 127) + 1980, ((i12 >> 5) & 15) - 1, shortLe4 & 31, (i11 >> 11) & 31, (i11 >> 5) & 63, (shortLe3 & 31) << 1);
            lValueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
        }
        b0Var.readIntLe();
        w wVar = new w();
        wVar.f10137a = b0Var.readIntLe() & 4294967295L;
        w wVar2 = new w();
        wVar2.f10137a = b0Var.readIntLe() & 4294967295L;
        int shortLe5 = b0Var.readShortLe() & 65535;
        int shortLe6 = b0Var.readShortLe() & 65535;
        int shortLe7 = b0Var.readShortLe() & 65535;
        b0Var.skip(8L);
        w wVar3 = new w();
        wVar3.f10137a = b0Var.readIntLe() & 4294967295L;
        String utf8 = b0Var.readUtf8(shortLe5);
        if (m.e0(utf8, (char) 0)) {
            com.google.gson.internal.a.m("bad zip: filename contains 0x00");
            return null;
        }
        long j10 = wVar2.f10137a == 4294967295L ? 8 : 0L;
        if (wVar.f10137a == 4294967295L) {
            j10 += 8;
        }
        if (wVar3.f10137a == 4294967295L) {
            j10 += 8;
        }
        u uVar = new u();
        e(b0Var, shortLe6, new j(uVar, j10, wVar2, b0Var, wVar, wVar3));
        if (j10 > 0 && !uVar.f10135a) {
            com.google.gson.internal.a.m("bad zip: zip64 extra required but absent");
            return null;
        }
        String utf82 = b0Var.readUtf8(shortLe7);
        String str = z.f14517b;
        return new h(t3.h.i("/", false).d(utf8), o7.u.X(utf8, "/", false), utf82, wVar.f10137a, wVar2.f10137a, shortLe2, lValueOf, wVar3.f10137a);
    }

    public static final void e(b0 b0Var, int i10, p pVar) throws IOException {
        z8.i iVar = b0Var.f14457b;
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                com.google.gson.internal.a.m("bad zip: truncated header in extra field");
                return;
            }
            int shortLe = b0Var.readShortLe() & 65535;
            long shortLe2 = b0Var.readShortLe() & 65535;
            long j11 = j10 - 4;
            if (j11 < shortLe2) {
                com.google.gson.internal.a.m("bad zip: truncated value in extra field");
                return;
            }
            b0Var.require(shortLe2);
            long j12 = iVar.f14479b;
            pVar.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long j13 = (iVar.f14479b + shortLe2) - j12;
            if (j13 < 0) {
                com.google.gson.internal.a.m(a3.a.f(shortLe, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j13 > 0) {
                    iVar.skip(j13);
                }
                j10 = j11 - shortLe2;
            }
        }
    }

    public static final o f(b0 b0Var, o oVar) throws IOException {
        x xVar = new x();
        xVar.f10138a = oVar != null ? oVar.e : null;
        x xVar2 = new x();
        x xVar3 = new x();
        int intLe = b0Var.readIntLe();
        if (intLe != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(intLe));
        }
        b0Var.skip(2L);
        short shortLe = b0Var.readShortLe();
        int i10 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            com.google.gson.internal.a.m("unsupported zip: general purpose bit flag=".concat(c(i10)));
            return null;
        }
        b0Var.skip(18L);
        int shortLe2 = b0Var.readShortLe() & 65535;
        b0Var.skip(b0Var.readShortLe() & 65535);
        if (oVar == null) {
            b0Var.skip(shortLe2);
            return null;
        }
        e(b0Var, shortLe2, new k(b0Var, xVar, xVar2, xVar3));
        return new o(oVar.f14497a, oVar.f14498b, oVar.f14499c, (Long) xVar3.f10138a, (Long) xVar.f10138a, (Long) xVar2.f10138a);
    }

    public static final int g(e0 e0Var, int i10) {
        int i11;
        int[] iArr = e0Var.f;
        int i12 = i10 + 1;
        int length = e0Var.e.length;
        iArr.getClass();
        int i13 = length - 1;
        int i14 = 0;
        while (true) {
            if (i14 <= i13) {
                i11 = (i14 + i13) >>> 1;
                int i15 = iArr[i11];
                if (i15 >= i12) {
                    if (i15 <= i12) {
                        break;
                    }
                    i13 = i11 - 1;
                } else {
                    i14 = i11 + 1;
                }
            } else {
                i11 = (-i14) - 1;
                break;
            }
        }
        return i11 >= 0 ? i11 : ~i11;
    }
}
