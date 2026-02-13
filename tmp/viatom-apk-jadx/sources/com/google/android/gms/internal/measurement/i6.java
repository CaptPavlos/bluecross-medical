package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i6 implements p6 {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f1994j = new int[0];

    /* renamed from: k, reason: collision with root package name */
    public static final Unsafe f1995k = a7.l();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f1996a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1997b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1998c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1999d;
    public final u4 e;
    public final int[] f;
    public final int g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final m5 f2000i;

    public i6(int[] iArr, Object[] objArr, int i10, int i11, u4 u4Var, int[] iArr2, int i12, int i13, m5 m5Var, m5 m5Var2) {
        this.f1996a = iArr;
        this.f1997b = objArr;
        this.f1998c = i10;
        this.f1999d = i11;
        this.f = iArr2;
        this.g = i12;
        this.h = i13;
        this.f2000i = m5Var;
        this.e = u4Var;
    }

    public static int F(int i10) {
        return (i10 >>> 20) & 255;
    }

    public static boolean j(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof o5) {
            return ((o5) obj).e();
        }
        return true;
    }

    public static int k(long j10, Object obj) {
        return ((Integer) a7.j(j10, obj)).intValue();
    }

    public static long l(long j10, Object obj) {
        return ((Long) a7.j(j10, obj)).longValue();
    }

    public static final int s(byte[] bArr, int i10, int i11, d7 d7Var, Class cls, x4 x4Var) throws w5 {
        d7 d7Var2 = d7.f1919c;
        switch (d7Var.ordinal()) {
            case 0:
                int i12 = i10 + 8;
                x4Var.f2259c = Double.valueOf(Double.longBitsToDouble(l5.V(i10, bArr)));
                return i12;
            case 1:
                int i13 = i10 + 4;
                x4Var.f2259c = Float.valueOf(Float.intBitsToFloat(l5.U(i10, bArr)));
                return i13;
            case 2:
            case 3:
                int iT = l5.T(bArr, i10, x4Var);
                x4Var.f2259c = Long.valueOf(x4Var.f2258b);
                return iT;
            case 4:
            case 12:
            case 13:
                int iQ = l5.Q(bArr, i10, x4Var);
                x4Var.f2259c = Integer.valueOf(x4Var.f2257a);
                return iQ;
            case 5:
            case 15:
                int i14 = i10 + 8;
                x4Var.f2259c = Long.valueOf(l5.V(i10, bArr));
                return i14;
            case 6:
            case 14:
                int i15 = i10 + 4;
                x4Var.f2259c = Integer.valueOf(l5.U(i10, bArr));
                return i15;
            case 7:
                int iT2 = l5.T(bArr, i10, x4Var);
                x4Var.f2259c = Boolean.valueOf(x4Var.f2258b != 0);
                return iT2;
            case 8:
                return l5.W(bArr, i10, x4Var);
            case 9:
            default:
                a2.a.j("unsupported field type.");
                return 0;
            case 10:
                p6 p6VarA = m6.f2086c.a(cls);
                o5 o5VarA = p6VarA.a();
                int iY = l5.Y(o5VarA, p6VarA, bArr, i10, i11, x4Var);
                p6VarA.g(o5VarA);
                x4Var.f2259c = o5VarA;
                return iY;
            case 11:
                return l5.X(bArr, i10, x4Var);
            case 16:
                int iQ2 = l5.Q(bArr, i10, x4Var);
                x4Var.f2259c = Integer.valueOf(l1.b.R(x4Var.f2257a));
                return iQ2;
            case 17:
                int iT3 = l5.T(bArr, i10, x4Var);
                x4Var.f2259c = Long.valueOf(l1.b.S(x4Var.f2258b));
                return iT3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.i6 u(com.google.android.gms.internal.measurement.o6 r35, com.google.android.gms.internal.measurement.m5 r36, com.google.android.gms.internal.measurement.m5 r37) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.u(com.google.android.gms.internal.measurement.o6, com.google.android.gms.internal.measurement.m5, com.google.android.gms.internal.measurement.m5):com.google.android.gms.internal.measurement.i6");
    }

    public static Field v(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + name.length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            androidx.privacysandbox.ads.adservices.adid.a.l(a3.a.o(sb, " not found. Known fields are ", string), e);
            return null;
        }
    }

    public final Object A(int i10, Object obj) {
        p6 p6VarY = y(i10);
        int iE = E(i10) & 1048575;
        if (!o(i10, obj)) {
            return p6VarY.a();
        }
        Object object = f1995k.getObject(obj, iE);
        if (j(object)) {
            return object;
        }
        o5 o5VarA = p6VarY.a();
        if (object != null) {
            p6VarY.b(o5VarA, object);
        }
        return o5VarA;
    }

    public final void B(int i10, Object obj, Object obj2) {
        f1995k.putObject(obj, E(i10) & 1048575, obj2);
        p(i10, obj);
    }

    public final Object C(Object obj, int i10, int i11) {
        p6 p6VarY = y(i11);
        if (!q(obj, i10, i11)) {
            return p6VarY.a();
        }
        Object object = f1995k.getObject(obj, E(i11) & 1048575);
        if (j(object)) {
            return object;
        }
        o5 o5VarA = p6VarY.a();
        if (object != null) {
            p6VarY.b(o5VarA, object);
        }
        return o5VarA;
    }

    public final void D(int i10, Object obj, int i11, Object obj2) {
        f1995k.putObject(obj, E(i11) & 1048575, obj2);
        a7.g(obj, this.f1996a[i11 + 2] & 1048575, i10);
    }

    public final int E(int i10) {
        return this.f1996a[i10 + 1];
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final o5 a() {
        return (o5) ((o5) this.e).o(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.measurement.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.b(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f7  */
    @Override // com.google.android.gms.internal.measurement.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(com.google.android.gms.internal.measurement.u4 r17) {
        /*
            Method dump skipped, instructions count: 2008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.c(com.google.android.gms.internal.measurement.u4):int");
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void d(Object obj, c6 c6Var) throws e5 {
        int i10;
        i6 i6Var = this;
        Unsafe unsafe = f1995k;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1048575;
        while (true) {
            int[] iArr = i6Var.f1996a;
            if (i12 >= iArr.length) {
                ((o5) obj).zzc.b(c6Var);
                return;
            }
            int iE = i6Var.E(i12);
            int iF = F(iE);
            int i15 = iArr[i12];
            if (iF <= 17) {
                int i16 = iArr[i12 + 2];
                int i17 = i16 & i11;
                if (i17 != i14) {
                    i13 = i17 == i11 ? 0 : unsafe.getInt(obj, i17);
                    i14 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = iE & i11;
            switch (iF) {
                case 0:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).h(i15, Double.doubleToRawLongBits(a7.f1878c.f(j10, obj)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).f(i15, Float.floatToRawIntBits(a7.f1878c.d(j10, obj)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).g(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).g(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).d(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).h(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).f(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        boolean zB = a7.f1878c.b(j10, obj);
                        d5 d5Var = (d5) c6Var.f1904a;
                        d5Var.m(i15 << 3);
                        d5Var.k(zB ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof String) {
                            d5 d5Var2 = (d5) c6Var.f1904a;
                            d5Var2.m((i15 << 3) | 2);
                            d5Var2.r((String) object);
                            break;
                        } else {
                            ((d5) c6Var.f1904a).i(i15, (c5) object);
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        c6Var.d(i15, unsafe.getObject(obj, j10), i6Var.y(i12));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).i(i15, (c5) unsafe.getObject(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).e(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).d(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).f(i15, unsafe.getInt(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        ((d5) c6Var.f1904a).h(i15, unsafe.getLong(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        int i18 = unsafe.getInt(obj, j10);
                        ((d5) c6Var.f1904a).e(i15, (i18 >> 31) ^ (i18 + i18));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        long j11 = unsafe.getLong(obj, j10);
                        ((d5) c6Var.f1904a).g(i15, (j11 >> 63) ^ (j11 + j11));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (i6Var.n(obj, i12, i14, i13, i10)) {
                        c6Var.e(i15, unsafe.getObject(obj, j10), i6Var.y(i12));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    q6.c(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 19:
                    q6.d(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 20:
                    q6.e(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 21:
                    q6.f(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 22:
                    q6.j(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 23:
                    q6.h(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 24:
                    q6.m(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 25:
                    q6.p(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 26:
                    int i19 = iArr[i12];
                    List list = (List) unsafe.getObject(obj, j10);
                    m5 m5Var = q6.f2139a;
                    if (list != null && !list.isEmpty()) {
                        d5 d5Var3 = (d5) c6Var.f1904a;
                        if (list instanceof y5) {
                            y5 y5Var = (y5) list;
                            for (int i20 = 0; i20 < list.size(); i20++) {
                                Object objF = y5Var.f();
                                if (objF instanceof String) {
                                    d5Var3.m((i19 << 3) | 2);
                                    d5Var3.r((String) objF);
                                } else {
                                    d5Var3.i(i19, (c5) objF);
                                }
                            }
                            break;
                        } else {
                            for (int i21 = 0; i21 < list.size(); i21++) {
                                String str = (String) list.get(i21);
                                d5Var3.m((i19 << 3) | 2);
                                d5Var3.r(str);
                            }
                            break;
                        }
                    } else {
                        break;
                    }
                case 27:
                    int i22 = iArr[i12];
                    List list2 = (List) unsafe.getObject(obj, j10);
                    p6 p6VarY = i6Var.y(i12);
                    m5 m5Var2 = q6.f2139a;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i23 = 0; i23 < list2.size(); i23++) {
                            c6Var.d(i22, list2.get(i23), p6VarY);
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case 28:
                    int i24 = iArr[i12];
                    List list3 = (List) unsafe.getObject(obj, j10);
                    m5 m5Var3 = q6.f2139a;
                    if (list3 != null && !list3.isEmpty()) {
                        c6Var.getClass();
                        for (int i25 = 0; i25 < list3.size(); i25++) {
                            ((d5) c6Var.f1904a).i(i24, (c5) list3.get(i25));
                        }
                        break;
                    } else {
                        break;
                    }
                case 29:
                    q6.k(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 30:
                    q6.o(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 31:
                    q6.n(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 32:
                    q6.i(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 33:
                    q6.l(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 34:
                    q6.g(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, false);
                    break;
                case 35:
                    q6.c(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 36:
                    q6.d(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 37:
                    q6.e(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 38:
                    q6.f(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 39:
                    q6.j(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 40:
                    q6.h(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 41:
                    q6.m(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 42:
                    q6.p(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 43:
                    q6.k(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 44:
                    q6.o(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 45:
                    q6.n(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 46:
                    q6.i(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 47:
                    q6.l(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 48:
                    q6.g(iArr[i12], (List) unsafe.getObject(obj, j10), c6Var, true);
                    break;
                case 49:
                    int i26 = iArr[i12];
                    List list4 = (List) unsafe.getObject(obj, j10);
                    p6 p6VarY2 = i6Var.y(i12);
                    m5 m5Var4 = q6.f2139a;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i27 = 0; i27 < list4.size(); i27++) {
                            c6Var.e(i26, list4.get(i27), p6VarY2);
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j10);
                    if (object2 != null) {
                        int i28 = i12 / 3;
                        t tVar = ((d6) i6Var.f1997b[i28 + i28]).f1918a;
                        c6Var.getClass();
                        for (Map.Entry entry : ((e6) object2).entrySet()) {
                            d5 d5Var4 = (d5) c6Var.f1904a;
                            d5Var4.c(i15, 2);
                            d5Var4.m(d6.b(tVar, entry.getKey(), entry.getValue()));
                            d6.a(d5Var4, tVar, entry.getKey(), entry.getValue());
                        }
                        break;
                    } else {
                        break;
                    }
                case 51:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).h(i15, Double.doubleToRawLongBits(((Double) a7.j(j10, obj)).doubleValue()));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).f(i15, Float.floatToRawIntBits(((Float) a7.j(j10, obj)).floatValue()));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).g(i15, l(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).g(i15, l(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).d(i15, k(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).h(i15, l(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).f(i15, k(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (i6Var.q(obj, i15, i12)) {
                        boolean zBooleanValue = ((Boolean) a7.j(j10, obj)).booleanValue();
                        d5 d5Var5 = (d5) c6Var.f1904a;
                        d5Var5.m(i15 << 3);
                        d5Var5.k(zBooleanValue ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (i6Var.q(obj, i15, i12)) {
                        Object object3 = unsafe.getObject(obj, j10);
                        if (object3 instanceof String) {
                            d5 d5Var6 = (d5) c6Var.f1904a;
                            d5Var6.m((i15 << 3) | 2);
                            d5Var6.r((String) object3);
                            break;
                        } else {
                            ((d5) c6Var.f1904a).i(i15, (c5) object3);
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (i6Var.q(obj, i15, i12)) {
                        c6Var.d(i15, unsafe.getObject(obj, j10), i6Var.y(i12));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).i(i15, (c5) unsafe.getObject(obj, j10));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).e(i15, k(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).d(i15, k(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).f(i15, k(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (i6Var.q(obj, i15, i12)) {
                        ((d5) c6Var.f1904a).h(i15, l(j10, obj));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (i6Var.q(obj, i15, i12)) {
                        int iK = k(j10, obj);
                        ((d5) c6Var.f1904a).e(i15, (iK >> 31) ^ (iK + iK));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (i6Var.q(obj, i15, i12)) {
                        long jL = l(j10, obj);
                        ((d5) c6Var.f1904a).g(i15, (jL >> 63) ^ (jL + jL));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (i6Var.q(obj, i15, i12)) {
                        c6Var.e(i15, unsafe.getObject(obj, j10), i6Var.y(i12));
                        break;
                    } else {
                        break;
                    }
            }
            i12 += 3;
            i11 = 1048575;
            i6Var = this;
        }
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final boolean e(Object obj) {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.g) {
            int i16 = this.f[i14];
            int[] iArr = this.f1996a;
            int i17 = iArr[i16];
            int iE = E(i16);
            int i18 = iArr[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i15) {
                if (i19 != 1048575) {
                    i13 = f1995k.getInt(obj, i19);
                }
                i11 = i16;
                i12 = i13;
                i10 = i19;
            } else {
                int i21 = i13;
                i10 = i15;
                i11 = i16;
                i12 = i21;
            }
            if ((268435456 & iE) == 0 || n(obj, i11, i10, i12, i20)) {
                int iF = F(iE);
                if (iF != 9 && iF != 17) {
                    if (iF != 27) {
                        if (iF == 60 || iF == 68) {
                            if (!q(obj, i17, i11) || y(i11).e(a7.j(iE & 1048575, obj))) {
                                i14++;
                                i15 = i10;
                                i13 = i12;
                            }
                        } else if (iF != 49) {
                            if (iF != 50) {
                                continue;
                            } else {
                                e6 e6Var = (e6) a7.j(iE & 1048575, obj);
                                if (e6Var.isEmpty()) {
                                    continue;
                                } else {
                                    int i22 = i11 / 3;
                                    if (((d7) ((d6) this.f1997b[i22 + i22]).f1918a.f2166b).f1921a == e7.f1941i) {
                                        p6 p6VarA = null;
                                        for (Object obj2 : e6Var.values()) {
                                            if (p6VarA == null) {
                                                p6VarA = m6.f2086c.a(obj2.getClass());
                                            }
                                            if (!p6VarA.e(obj2)) {
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            i14++;
                            i15 = i10;
                            i13 = i12;
                        }
                    }
                    List list = (List) a7.j(iE & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        p6 p6VarY = y(i11);
                        for (int i23 = 0; i23 < list.size(); i23++) {
                            if (p6VarY.e(list.get(i23))) {
                            }
                        }
                    }
                    i14++;
                    i15 = i10;
                    i13 = i12;
                } else if (!n(obj, i11, i10, i12, i20) || y(i11).e(a7.j(iE & 1048575, obj))) {
                    i14++;
                    i15 = i10;
                    i13 = i12;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final boolean f(o5 o5Var, o5 o5Var2) {
        boolean zA;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f1996a;
            if (i10 < iArr.length) {
                int iE = E(i10);
                long j10 = iE & 1048575;
                switch (F(iE)) {
                    case 0:
                        if (!m(o5Var, o5Var2, i10)) {
                            break;
                        } else {
                            z6 z6Var = a7.f1878c;
                            if (Double.doubleToLongBits(z6Var.f(j10, o5Var)) != Double.doubleToLongBits(z6Var.f(j10, o5Var2))) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 1:
                        if (!m(o5Var, o5Var2, i10)) {
                            break;
                        } else {
                            z6 z6Var2 = a7.f1878c;
                            if (Float.floatToIntBits(z6Var2.d(j10, o5Var)) != Float.floatToIntBits(z6Var2.d(j10, o5Var2))) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 2:
                        if (!m(o5Var, o5Var2, i10) || a7.h(j10, o5Var) != a7.h(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 3:
                        if (!m(o5Var, o5Var2, i10) || a7.h(j10, o5Var) != a7.h(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 4:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 5:
                        if (!m(o5Var, o5Var2, i10) || a7.h(j10, o5Var) != a7.h(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 6:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 7:
                        if (!m(o5Var, o5Var2, i10)) {
                            break;
                        } else {
                            z6 z6Var3 = a7.f1878c;
                            if (z6Var3.b(j10, o5Var) != z6Var3.b(j10, o5Var2)) {
                                break;
                            } else {
                                continue;
                                i10 += 3;
                            }
                        }
                    case 8:
                        if (!m(o5Var, o5Var2, i10) || !q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2))) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 9:
                        if (!m(o5Var, o5Var2, i10) || !q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2))) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 10:
                        if (!m(o5Var, o5Var2, i10) || !q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2))) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 11:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 12:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 13:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 14:
                        if (!m(o5Var, o5Var2, i10) || a7.h(j10, o5Var) != a7.h(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 15:
                        if (!m(o5Var, o5Var2, i10) || a7.f(j10, o5Var) != a7.f(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 16:
                        if (!m(o5Var, o5Var2, i10) || a7.h(j10, o5Var) != a7.h(j10, o5Var2)) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 17:
                        if (!m(o5Var, o5Var2, i10) || !q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2))) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zA = q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2));
                        break;
                    case 50:
                        zA = q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j11 = iArr[i10 + 2] & 1048575;
                        if (a7.f(j11, o5Var) != a7.f(j11, o5Var2) || !q6.a(a7.j(j10, o5Var), a7.j(j10, o5Var2))) {
                            break;
                        } else {
                            continue;
                            i10 += 3;
                        }
                        break;
                    default:
                        i10 += 3;
                }
                if (zA) {
                    i10 += 3;
                }
            } else if (o5Var.zzc.equals(o5Var2.zzc)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    @Override // com.google.android.gms.internal.measurement.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = j(r8)
            if (r0 != 0) goto L8
            goto L96
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.o5
            r1 = 0
            if (r0 == 0) goto L18
            r0 = r8
            com.google.android.gms.internal.measurement.o5 r0 = (com.google.android.gms.internal.measurement.o5) r0
            r0.j()
            r0.zza = r1
            r0.f()
        L18:
            r0 = r1
        L19:
            int[] r2 = r7.f1996a
            int r3 = r2.length
            if (r0 >= r3) goto L87
            int r3 = r7.E(r0)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            int r3 = F(r3)
            long r4 = (long) r4
            r6 = 9
            if (r3 == r6) goto L71
            r6 = 60
            if (r3 == r6) goto L5b
            r6 = 68
            if (r3 == r6) goto L5b
            switch(r3) {
                case 17: goto L71;
                case 18: goto L4c;
                case 19: goto L4c;
                case 20: goto L4c;
                case 21: goto L4c;
                case 22: goto L4c;
                case 23: goto L4c;
                case 24: goto L4c;
                case 25: goto L4c;
                case 26: goto L4c;
                case 27: goto L4c;
                case 28: goto L4c;
                case 29: goto L4c;
                case 30: goto L4c;
                case 31: goto L4c;
                case 32: goto L4c;
                case 33: goto L4c;
                case 34: goto L4c;
                case 35: goto L4c;
                case 36: goto L4c;
                case 37: goto L4c;
                case 38: goto L4c;
                case 39: goto L4c;
                case 40: goto L4c;
                case 41: goto L4c;
                case 42: goto L4c;
                case 43: goto L4c;
                case 44: goto L4c;
                case 45: goto L4c;
                case 46: goto L4c;
                case 47: goto L4c;
                case 48: goto L4c;
                case 49: goto L4c;
                case 50: goto L3b;
                default: goto L3a;
            }
        L3a:
            goto L84
        L3b:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.i6.f1995k
            java.lang.Object r3 = r2.getObject(r8, r4)
            if (r3 == 0) goto L84
            r6 = r3
            com.google.android.gms.internal.measurement.e6 r6 = (com.google.android.gms.internal.measurement.e6) r6
            r6.f1936a = r1
            r2.putObject(r8, r4, r3)
            goto L84
        L4c:
            java.lang.Object r2 = com.google.android.gms.internal.measurement.a7.j(r4, r8)
            com.google.android.gms.internal.measurement.t5 r2 = (com.google.android.gms.internal.measurement.t5) r2
            com.google.android.gms.internal.measurement.v4 r2 = (com.google.android.gms.internal.measurement.v4) r2
            boolean r3 = r2.f2204a
            if (r3 == 0) goto L84
            r2.f2204a = r1
            goto L84
        L5b:
            r2 = r2[r0]
            boolean r2 = r7.q(r8, r2, r0)
            if (r2 == 0) goto L84
            com.google.android.gms.internal.measurement.p6 r2 = r7.y(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.measurement.i6.f1995k
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.g(r3)
            goto L84
        L71:
            boolean r2 = r7.o(r0, r8)
            if (r2 == 0) goto L84
            com.google.android.gms.internal.measurement.p6 r2 = r7.y(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.measurement.i6.f1995k
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.g(r3)
        L84:
            int r0 = r0 + 3
            goto L19
        L87:
            com.google.android.gms.internal.measurement.m5 r0 = r7.f2000i
            r0.getClass()
            com.google.android.gms.internal.measurement.o5 r8 = (com.google.android.gms.internal.measurement.o5) r8
            com.google.android.gms.internal.measurement.v6 r8 = r8.zzc
            boolean r0 = r8.e
            if (r0 == 0) goto L96
            r8.e = r1
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.g(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void h(Object obj, byte[] bArr, int i10, int i11, x4 x4Var) {
        t(obj, bArr, i10, i11, 0, x4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[PHI: r1
      0x00db: PHI (r1v34 int) = (r1v10 int), (r1v35 int) binds: [B:85:0x01ea, B:43:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.p6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(com.google.android.gms.internal.measurement.o5 r11) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.i(com.google.android.gms.internal.measurement.o5):int");
    }

    public final boolean m(o5 o5Var, o5 o5Var2, int i10) {
        return o(i10, o5Var) == o(i10, o5Var2);
    }

    public final boolean n(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? o(i10, obj) : (i12 & i13) != 0;
    }

    public final boolean o(int i10, Object obj) {
        int i11 = this.f1996a[i10 + 2];
        long j10 = i11 & 1048575;
        if (j10 == 1048575) {
            int iE = E(i10);
            long j11 = iE & 1048575;
            switch (F(iE)) {
                case 0:
                    if (Double.doubleToRawLongBits(a7.f1878c.f(j11, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(a7.f1878c.d(j11, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (a7.h(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (a7.h(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (a7.h(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return a7.f1878c.b(j11, obj);
                case 8:
                    Object objJ = a7.j(j11, obj);
                    if (objJ instanceof String) {
                        if (((String) objJ).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objJ instanceof c5)) {
                            z8.f.a();
                            return false;
                        }
                        if (c5.f1900c.equals(objJ)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (a7.j(j11, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (c5.f1900c.equals(a7.j(j11, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (a7.h(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (a7.f(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (a7.h(j11, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (a7.j(j11, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    z8.f.a();
                    return false;
            }
        } else if (((1 << (i11 >>> 20)) & a7.f(j10, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final void p(int i10, Object obj) {
        int i11 = this.f1996a[i10 + 2];
        long j10 = 1048575 & i11;
        if (j10 == 1048575) {
            return;
        }
        a7.g(obj, j10, (1 << (i11 >>> 20)) | a7.f(j10, obj));
    }

    public final boolean q(Object obj, int i10, int i11) {
        return a7.f((long) (this.f1996a[i11 + 2] & 1048575), obj) == i10;
    }

    public final int r(int i10, int i11) {
        int[] iArr = this.f1996a;
        int length = (iArr.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = iArr[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int t(java.lang.Object r42, byte[] r43, int r44, int r45, int r46, com.google.android.gms.internal.measurement.x4 r47) {
        /*
            Method dump skipped, instructions count: 4130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i6.t(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.x4):int");
    }

    public final void w(int i10, Object obj, Object obj2) {
        if (o(i10, obj2)) {
            int iE = E(i10) & 1048575;
            Unsafe unsafe = f1995k;
            long j10 = iE;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                int i11 = this.f1996a[i10];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i11);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            p6 p6VarY = y(i10);
            if (!o(i10, obj)) {
                if (j(object)) {
                    o5 o5VarA = p6VarY.a();
                    p6VarY.b(o5VarA, object);
                    unsafe.putObject(obj, j10, o5VarA);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                p(i10, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!j(object2)) {
                o5 o5VarA2 = p6VarY.a();
                p6VarY.b(o5VarA2, object2);
                unsafe.putObject(obj, j10, o5VarA2);
                object2 = o5VarA2;
            }
            p6VarY.b(object2, object);
        }
    }

    public final void x(int i10, Object obj, Object obj2) {
        int[] iArr = this.f1996a;
        int i11 = iArr[i10];
        if (q(obj2, i11, i10)) {
            int iE = E(i10) & 1048575;
            Unsafe unsafe = f1995k;
            long j10 = iE;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                int i12 = iArr[i10];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i12);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            p6 p6VarY = y(i10);
            if (!q(obj, i11, i10)) {
                if (j(object)) {
                    o5 o5VarA = p6VarY.a();
                    p6VarY.b(o5VarA, object);
                    unsafe.putObject(obj, j10, o5VarA);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                a7.g(obj, iArr[i10 + 2] & 1048575, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!j(object2)) {
                o5 o5VarA2 = p6VarY.a();
                p6VarY.b(o5VarA2, object2);
                unsafe.putObject(obj, j10, o5VarA2);
                object2 = o5VarA2;
            }
            p6VarY.b(object2, object);
        }
    }

    public final p6 y(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        Object[] objArr = this.f1997b;
        p6 p6Var = (p6) objArr[i12];
        if (p6Var != null) {
            return p6Var;
        }
        p6 p6VarA = m6.f2086c.a((Class) objArr[i12 + 1]);
        objArr[i12] = p6VarA;
        return p6VarA;
    }

    public final t1 z(int i10) {
        int i11 = i10 / 3;
        return (t1) this.f1997b[i11 + i11 + 1];
    }
}
