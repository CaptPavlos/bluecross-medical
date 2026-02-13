package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.internal.h;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class e {
    public static final j A;
    public static final j B;

    /* renamed from: a, reason: collision with root package name */
    public static final j f2534a = new TypeAdapters$29(Class.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$1
        @Override // com.google.gson.i
        public final Object b(i3.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported")));
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }
    }.a());

    /* renamed from: b, reason: collision with root package name */
    public static final j f2535b = new TypeAdapters$29(BitSet.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$2
        @Override // com.google.gson.i
        public final Object b(i3.a aVar) throws IOException, NumberFormatException {
            boolean zN;
            BitSet bitSet = new BitSet();
            aVar.a();
            int iX = aVar.x();
            int i10 = 0;
            while (iX != 2) {
                int iC = c.i.c(iX);
                if (iC == 5 || iC == 6) {
                    int iP = aVar.p();
                    if (iP == 0) {
                        zN = false;
                    } else {
                        if (iP != 1) {
                            StringBuilder sbR = a3.a.r(iP, "Invalid bitset value ", ", expected 0 or 1; at path ");
                            sbR.append(aVar.j(true));
                            throw new com.google.gson.e(sbR.toString());
                        }
                        zN = true;
                    }
                } else {
                    if (iC != 7) {
                        throw new com.google.gson.e("Invalid bitset value type: " + com.mbridge.msdk.dycreator.baseview.a.y(iX) + "; at path " + aVar.j(false));
                    }
                    zN = aVar.n();
                }
                if (zN) {
                    bitSet.set(i10);
                }
                i10++;
                iX = aVar.x();
            }
            aVar.f();
            return bitSet;
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            bVar.b();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.q(bitSet.get(i10) ? 1L : 0L);
            }
            bVar.f();
        }
    }.a());

    /* renamed from: c, reason: collision with root package name */
    public static final i f2536c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f2537d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;

    /* renamed from: i, reason: collision with root package name */
    public static final j f2538i;

    /* renamed from: j, reason: collision with root package name */
    public static final j f2539j;

    /* renamed from: k, reason: collision with root package name */
    public static final i f2540k;

    /* renamed from: l, reason: collision with root package name */
    public static final j f2541l;

    /* renamed from: m, reason: collision with root package name */
    public static final i f2542m;

    /* renamed from: n, reason: collision with root package name */
    public static final i f2543n;

    /* renamed from: o, reason: collision with root package name */
    public static final i f2544o;

    /* renamed from: p, reason: collision with root package name */
    public static final j f2545p;

    /* renamed from: q, reason: collision with root package name */
    public static final j f2546q;

    /* renamed from: r, reason: collision with root package name */
    public static final j f2547r;

    /* renamed from: s, reason: collision with root package name */
    public static final j f2548s;
    public static final j t;

    /* renamed from: u, reason: collision with root package name */
    public static final j f2549u;

    /* renamed from: v, reason: collision with root package name */
    public static final j f2550v;

    /* renamed from: w, reason: collision with root package name */
    public static final j f2551w;

    /* renamed from: x, reason: collision with root package name */
    public static final j f2552x;
    public static final j y;

    /* renamed from: z, reason: collision with root package name */
    public static final i f2553z;

    static {
        i iVar = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$3
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                int iX = aVar.x();
                if (iX != 9) {
                    return iX == 6 ? Boolean.valueOf(Boolean.parseBoolean(aVar.v())) : Boolean.valueOf(aVar.n());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Boolean bool = (Boolean) obj;
                if (bool == null) {
                    bVar.k();
                    return;
                }
                bVar.u();
                bVar.a();
                bVar.f8983a.write(bool.booleanValue() ? "true" : "false");
            }
        };
        f2536c = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$4
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return Boolean.valueOf(aVar.v());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Boolean bool = (Boolean) obj;
                bVar.s(bool == null ? "null" : bool.toString());
            }
        };
        f2537d = new TypeAdapters$30(Boolean.TYPE, Boolean.class, iVar);
        e = new TypeAdapters$30(Byte.TYPE, Byte.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$5
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                try {
                    int iP = aVar.p();
                    if (iP <= 255 && iP >= -128) {
                        return Byte.valueOf((byte) iP);
                    }
                    StringBuilder sbR = a3.a.r(iP, "Lossy conversion from ", " to byte; at path ");
                    sbR.append(aVar.j(true));
                    throw new com.google.gson.e(sbR.toString());
                } catch (NumberFormatException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    bVar.k();
                } else {
                    bVar.q(r4.byteValue());
                }
            }
        });
        f = new TypeAdapters$30(Short.TYPE, Short.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$6
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                try {
                    int iP = aVar.p();
                    if (iP <= 65535 && iP >= -32768) {
                        return Short.valueOf((short) iP);
                    }
                    StringBuilder sbR = a3.a.r(iP, "Lossy conversion from ", " to short; at path ");
                    sbR.append(aVar.j(true));
                    throw new com.google.gson.e(sbR.toString());
                } catch (NumberFormatException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    bVar.k();
                } else {
                    bVar.q(r4.shortValue());
                }
            }
        });
        g = new TypeAdapters$30(Integer.TYPE, Integer.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$7
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.p());
                } catch (NumberFormatException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    bVar.k();
                } else {
                    bVar.q(r4.intValue());
                }
            }
        });
        h = new TypeAdapters$29(AtomicInteger.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$8
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) {
                try {
                    return new AtomicInteger(aVar.p());
                } catch (NumberFormatException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.q(((AtomicInteger) obj).get());
            }
        }.a());
        f2538i = new TypeAdapters$29(AtomicBoolean.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$9
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) {
                return new AtomicBoolean(aVar.n());
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.t(((AtomicBoolean) obj).get());
            }
        }.a());
        f2539j = new TypeAdapters$29(AtomicIntegerArray.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$10
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.k()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.p()));
                    } catch (NumberFormatException e3) {
                        throw new com.google.gson.e(e3);
                    }
                }
                aVar.f();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i10 = 0; i10 < size; i10++) {
                    atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.b();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i10 = 0; i10 < length; i10++) {
                    bVar.q(r6.get(i10));
                }
                bVar.f();
            }
        }.a());
        f2540k = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$11
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.q());
                } catch (NumberFormatException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    bVar.k();
                } else {
                    bVar.q(number.longValue());
                }
            }
        };
        new i() { // from class: com.google.gson.internal.bind.TypeAdapters$12
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return Float.valueOf((float) aVar.o());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Number numberValueOf = (Number) obj;
                if (numberValueOf == null) {
                    bVar.k();
                    return;
                }
                if (!(numberValueOf instanceof Float)) {
                    numberValueOf = Float.valueOf(numberValueOf.floatValue());
                }
                bVar.r(numberValueOf);
            }
        };
        new i() { // from class: com.google.gson.internal.bind.TypeAdapters$13
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return Double.valueOf(aVar.o());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    bVar.k();
                } else {
                    bVar.p(number.doubleValue());
                }
            }
        };
        f2541l = new TypeAdapters$30(Character.TYPE, Character.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$14
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                String strV = aVar.v();
                if (strV.length() == 1) {
                    return Character.valueOf(strV.charAt(0));
                }
                StringBuilder sbY = a3.a.y("Expecting character, got: ", strV, "; at ");
                sbY.append(aVar.j(true));
                throw new com.google.gson.e(sbY.toString());
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Character ch = (Character) obj;
                bVar.s(ch == null ? null : String.valueOf(ch));
            }
        });
        i iVar2 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$15
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                int iX = aVar.x();
                if (iX != 9) {
                    return iX == 8 ? Boolean.toString(aVar.n()) : aVar.v();
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.s((String) obj);
            }
        };
        f2542m = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$16
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                String strV = aVar.v();
                try {
                    return f.i(strV);
                } catch (NumberFormatException e3) {
                    StringBuilder sbY = a3.a.y("Failed parsing '", strV, "' as BigDecimal; at path ");
                    sbY.append(aVar.j(true));
                    throw new com.google.gson.e(sbY.toString(), e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.r((BigDecimal) obj);
            }
        };
        f2543n = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$17
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                String strV = aVar.v();
                try {
                    f.c(strV);
                    return new BigInteger(strV);
                } catch (NumberFormatException e3) {
                    StringBuilder sbY = a3.a.y("Failed parsing '", strV, "' as BigInteger; at path ");
                    sbY.append(aVar.j(true));
                    throw new com.google.gson.e(sbY.toString(), e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.r((BigInteger) obj);
            }
        };
        f2544o = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$18
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return new h(aVar.v());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.r((h) obj);
            }
        };
        f2545p = new TypeAdapters$29(String.class, iVar2);
        f2546q = new TypeAdapters$29(StringBuilder.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$19
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return new StringBuilder(aVar.v());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                StringBuilder sb = (StringBuilder) obj;
                bVar.s(sb == null ? null : sb.toString());
            }
        });
        f2547r = new TypeAdapters$29(StringBuffer.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$20
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return new StringBuffer(aVar.v());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                StringBuffer stringBuffer = (StringBuffer) obj;
                bVar.s(stringBuffer == null ? null : stringBuffer.toString());
            }
        });
        f2548s = new TypeAdapters$29(URL.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$21
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                String strV = aVar.v();
                if (strV.equals("null")) {
                    return null;
                }
                return new URL(strV);
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                URL url = (URL) obj;
                bVar.s(url == null ? null : url.toExternalForm());
            }
        });
        t = new TypeAdapters$29(URI.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$22
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                try {
                    String strV = aVar.v();
                    if (strV.equals("null")) {
                        return null;
                    }
                    return new URI(strV);
                } catch (URISyntaxException e3) {
                    throw new com.google.gson.e(e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                URI uri = (URI) obj;
                bVar.s(uri == null ? null : uri.toASCIIString());
            }
        });
        final i iVar3 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$23
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() != 9) {
                    return InetAddress.getByName(aVar.v());
                }
                aVar.t();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                InetAddress inetAddress = (InetAddress) obj;
                bVar.s(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        final Class<InetAddress> cls = InetAddress.class;
        f2549u = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$32
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                final Class<?> cls2 = typeToken.f2599a;
                if (cls.isAssignableFrom(cls2)) {
                    return new i() { // from class: com.google.gson.internal.bind.TypeAdapters$32.1
                        @Override // com.google.gson.i
                        public final Object b(i3.a aVar) {
                            Object objB = iVar3.b(aVar);
                            if (objB != null) {
                                Class cls3 = cls2;
                                if (!cls3.isInstance(objB)) {
                                    throw new com.google.gson.e("Expected a " + cls3.getName() + " but was " + objB.getClass().getName() + "; at path " + aVar.j(true));
                                }
                            }
                            return objB;
                        }

                        @Override // com.google.gson.i
                        public final void c(i3.b bVar2, Object obj) {
                            iVar3.c(bVar2, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + iVar3 + "]";
            }
        };
        f2550v = new TypeAdapters$29(UUID.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$24
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                String strV = aVar.v();
                try {
                    return UUID.fromString(strV);
                } catch (IllegalArgumentException e3) {
                    StringBuilder sbY = a3.a.y("Failed parsing '", strV, "' as UUID; at path ");
                    sbY.append(aVar.j(true));
                    throw new com.google.gson.e(sbY.toString(), e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                UUID uuid = (UUID) obj;
                bVar.s(uuid == null ? null : uuid.toString());
            }
        });
        f2551w = new TypeAdapters$29(Currency.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$25
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) {
                String strV = aVar.v();
                try {
                    return Currency.getInstance(strV);
                } catch (IllegalArgumentException e3) {
                    StringBuilder sbY = a3.a.y("Failed parsing '", strV, "' as Currency; at path ");
                    sbY.append(aVar.j(true));
                    throw new com.google.gson.e(sbY.toString(), e3);
                }
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                bVar.s(((Currency) obj).getCurrencyCode());
            }
        }.a());
        final i iVar4 = new i() { // from class: com.google.gson.internal.bind.TypeAdapters$26
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
            @Override // com.google.gson.i
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(i3.a r13) throws java.io.IOException, java.lang.NumberFormatException {
                /*
                    r12 = this;
                    int r0 = r13.x()
                    r1 = 9
                    if (r0 != r1) goto Ld
                    r13.t()
                    r13 = 0
                    return r13
                Ld:
                    r13.b()
                    r0 = 0
                    r2 = r0
                    r3 = r2
                    r4 = r3
                    r5 = r4
                    r6 = r5
                    r7 = r6
                L17:
                    int r1 = r13.x()
                    r8 = 4
                    if (r1 == r8) goto L7f
                    java.lang.String r1 = r13.r()
                    int r9 = r13.p()
                    int r10 = r1.hashCode()
                    r11 = -1
                    switch(r10) {
                        case -1181204563: goto L65;
                        case -1074026988: goto L5a;
                        case -906279820: goto L4f;
                        case 3704893: goto L44;
                        case 104080000: goto L3b;
                        case 985252545: goto L30;
                        default: goto L2e;
                    }
                L2e:
                    r8 = r11
                    goto L6f
                L30:
                    java.lang.String r8 = "hourOfDay"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L39
                    goto L2e
                L39:
                    r8 = 5
                    goto L6f
                L3b:
                    java.lang.String r10 = "month"
                    boolean r1 = r1.equals(r10)
                    if (r1 != 0) goto L6f
                    goto L2e
                L44:
                    java.lang.String r8 = "year"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L4d
                    goto L2e
                L4d:
                    r8 = 3
                    goto L6f
                L4f:
                    java.lang.String r8 = "second"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L58
                    goto L2e
                L58:
                    r8 = 2
                    goto L6f
                L5a:
                    java.lang.String r8 = "minute"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L63
                    goto L2e
                L63:
                    r8 = 1
                    goto L6f
                L65:
                    java.lang.String r8 = "dayOfMonth"
                    boolean r1 = r1.equals(r8)
                    if (r1 != 0) goto L6e
                    goto L2e
                L6e:
                    r8 = r0
                L6f:
                    switch(r8) {
                        case 0: goto L7d;
                        case 1: goto L7b;
                        case 2: goto L79;
                        case 3: goto L77;
                        case 4: goto L75;
                        case 5: goto L73;
                        default: goto L72;
                    }
                L72:
                    goto L17
                L73:
                    r5 = r9
                    goto L17
                L75:
                    r3 = r9
                    goto L17
                L77:
                    r2 = r9
                    goto L17
                L79:
                    r7 = r9
                    goto L17
                L7b:
                    r6 = r9
                    goto L17
                L7d:
                    r4 = r9
                    goto L17
                L7f:
                    r13.h()
                    java.util.GregorianCalendar r1 = new java.util.GregorianCalendar
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters$26.b(i3.a):java.lang.Object");
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                if (((Calendar) obj) == null) {
                    bVar.k();
                    return;
                }
                bVar.d();
                bVar.i("year");
                bVar.q(r4.get(1));
                bVar.i("month");
                bVar.q(r4.get(2));
                bVar.i("dayOfMonth");
                bVar.q(r4.get(5));
                bVar.i("hourOfDay");
                bVar.q(r4.get(11));
                bVar.i("minute");
                bVar.q(r4.get(12));
                bVar.i("second");
                bVar.q(r4.get(13));
                bVar.h();
            }
        };
        f2552x = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$31
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                Class cls2 = typeToken.f2599a;
                if (cls2 == Calendar.class || cls2 == GregorianCalendar.class) {
                    return iVar4;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + iVar4 + "]";
            }
        };
        y = new TypeAdapters$29(Locale.class, new i() { // from class: com.google.gson.internal.bind.TypeAdapters$27
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                if (aVar.x() == 9) {
                    aVar.t();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.v(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                Locale locale = (Locale) obj;
                bVar.s(locale == null ? null : locale.toString());
            }
        });
        final JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.f2492a;
        f2553z = jsonElementTypeAdapter;
        final Class<com.google.gson.d> cls2 = com.google.gson.d.class;
        A = new j() { // from class: com.google.gson.internal.bind.TypeAdapters$32
            @Override // com.google.gson.j
            public final i a(com.google.gson.b bVar, TypeToken typeToken) {
                final Class cls22 = typeToken.f2599a;
                if (cls2.isAssignableFrom(cls22)) {
                    return new i() { // from class: com.google.gson.internal.bind.TypeAdapters$32.1
                        @Override // com.google.gson.i
                        public final Object b(i3.a aVar) {
                            Object objB = jsonElementTypeAdapter.b(aVar);
                            if (objB != null) {
                                Class cls3 = cls22;
                                if (!cls3.isInstance(objB)) {
                                    throw new com.google.gson.e("Expected a " + cls3.getName() + " but was " + objB.getClass().getName() + "; at path " + aVar.j(true));
                                }
                            }
                            return objB;
                        }

                        @Override // com.google.gson.i
                        public final void c(i3.b bVar2, Object obj) {
                            jsonElementTypeAdapter.c(bVar2, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls2.getName() + ",adapter=" + jsonElementTypeAdapter + "]";
            }
        };
        B = EnumTypeAdapter.f2485d;
    }

    public static j a(Class cls, i iVar) {
        return new TypeAdapters$29(cls, iVar);
    }

    public static j b(Class cls, Class cls2, i iVar) {
        return new TypeAdapters$30(cls, cls2, iVar);
    }
}
