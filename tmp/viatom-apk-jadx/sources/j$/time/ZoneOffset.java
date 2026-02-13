package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ZoneOffset extends ZoneId implements j$.time.temporal.n, j$.time.temporal.o, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b, reason: collision with root package name */
    public final int f9142b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f9143c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f9141d = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ConcurrentHashMap e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = C(0);
    public static final ZoneOffset f = C(-64800);
    public static final ZoneOffset g = C(64800);

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f9142b - this.f9142b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset A(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            j$.util.Objects.requireNonNull(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L63
            r1 = 3
            if (r0 == r1) goto L7f
            r4 = 5
            if (r0 == r4) goto L5a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L50
            r5 = 7
            if (r0 == r5) goto L43
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
            int r2 = D(r7, r5, r2)
            goto L85
        L37:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            int r2 = D(r7, r4, r3)
            goto L85
        L50:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
        L58:
            r2 = r3
            goto L85
        L5a:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            goto L58
        L63:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L7f:
            int r0 = D(r7, r2, r3)
            r1 = r3
            r2 = r1
        L85:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L9e
            if (r3 != r5) goto L92
            goto L9e
        L92:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L9e:
            if (r3 != r5) goto La8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = B(r7, r0, r1)
            return r7
        La8:
            j$.time.ZoneOffset r7 = B(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.A(java.lang.String):j$.time.ZoneOffset");
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f v() {
        Objects.requireNonNull(this, TypedValues.CycleType.S_WAVE_OFFSET);
        return new j$.time.zone.f(this);
    }

    public static int D(CharSequence charSequence, int i10, boolean z9) {
        if (z9) {
            String str = (String) charSequence;
            if (str.charAt(i10 - 1) != ':') {
                g.h(str, "Invalid ID for ZoneOffset, colon not found when expected: ");
                return 0;
            }
        }
        String str2 = (String) charSequence;
        char cCharAt = str2.charAt(i10);
        char cCharAt2 = str2.charAt(i10 + 1);
        if (cCharAt < '0' || cCharAt > '9' || cCharAt2 < '0' || cCharAt2 > '9') {
            g.h(str2, "Invalid ID for ZoneOffset, non numeric characters found: ");
            return 0;
        }
        return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
    }

    public static ZoneOffset B(int i10, int i11, int i12) {
        if (i10 < -18 || i10 > 18) {
            g.e("Zone offset hours not in valid range: value ", i10, " is not in the range -18 to 18");
            return null;
        }
        if (i10 > 0) {
            if (i11 < 0 || i12 < 0) {
                throw new b("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i10 < 0) {
            if (i11 > 0 || i12 > 0) {
                throw new b("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i11 > 0 && i12 < 0) || (i11 < 0 && i12 > 0)) {
            throw new b("Zone offset minutes and seconds must have the same sign");
        }
        if (i11 < -59 || i11 > 59) {
            g.e("Zone offset minutes not in valid range: value ", i11, " is not in the range -59 to 59");
            return null;
        }
        if (i12 < -59 || i12 > 59) {
            g.e("Zone offset seconds not in valid range: value ", i12, " is not in the range -59 to 59");
            return null;
        }
        if (Math.abs(i10) == 18 && (i11 | i12) != 0) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
        return C((i11 * 60) + (i10 * 3600) + i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ZoneOffset C(int i10) {
        if (i10 < -64800 || i10 > 64800) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i10 % 900 == 0) {
            Integer numValueOf = Integer.valueOf(i10);
            ConcurrentHashMap concurrentHashMap = f9141d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(numValueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(numValueOf, new ZoneOffset(i10));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(numValueOf);
            e.putIfAbsent(zoneOffset2.f9143c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i10);
    }

    public ZoneOffset(int i10) {
        String string;
        this.f9142b = i10;
        if (i10 == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i10);
            StringBuilder sb = new StringBuilder();
            int i11 = iAbs / 3600;
            int i12 = (iAbs / 60) % 60;
            sb.append(i10 < 0 ? "-" : "+");
            sb.append(i11 < 10 ? "0" : "");
            sb.append(i11);
            sb.append(i12 < 10 ? ":0" : ":");
            sb.append(i12);
            int i13 = iAbs % 60;
            if (i13 != 0) {
                sb.append(i13 < 10 ? ":0" : ":");
                sb.append(i13);
            }
            string = sb.toString();
        }
        this.f9143c = string;
    }

    @Override // j$.time.ZoneId
    public final String d() {
        return this.f9143c;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f9142b;
        }
        if (c.b(qVar)) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return j$.time.temporal.r.d(this, qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f9142b;
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return qVar.g(this);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        return (aVar == j$.time.temporal.r.f9303d || aVar == j$.time.temporal.r.e) ? this : j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f9142b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f9142b == ((ZoneOffset) obj).f9142b;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f9142b;
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f9143c;
    }

    private Object writeReplace() {
        return new s((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void z(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        F(dataOutput);
    }

    public final void F(DataOutput dataOutput) {
        int i10 = this.f9142b;
        int i11 = i10 % 900 == 0 ? i10 / 900 : 127;
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(i10);
        }
    }

    public static ZoneOffset E(DataInput dataInput) {
        byte b10 = dataInput.readByte();
        return b10 == 127 ? C(dataInput.readInt()) : C(b10 * 900);
    }
}
