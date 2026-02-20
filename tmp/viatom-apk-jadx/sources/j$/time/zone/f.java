package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.k;
import j$.time.m;
import j$.time.temporal.o;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class f implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final long[] f9332i = new long[0];

    /* renamed from: j, reason: collision with root package name */
    public static final e[] f9333j = new e[0];

    /* renamed from: k, reason: collision with root package name */
    public static final LocalDateTime[] f9334k = new LocalDateTime[0];

    /* renamed from: l, reason: collision with root package name */
    public static final b[] f9335l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f9336a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f9337b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f9338c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f9339d;
    public final ZoneOffset[] e;
    public final e[] f;
    public final TimeZone g;
    public final transient ConcurrentHashMap h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f9322b;
        if (bVar.e()) {
            if (localDateTime.x(localDateTime2)) {
                return bVar.f9323c;
            }
            if (!localDateTime.x(bVar.f9322b.B(bVar.f9324d.f9142b - bVar.f9323c.f9142b))) {
                return bVar.f9324d;
            }
        } else {
            if (!localDateTime.x(localDateTime2)) {
                return bVar.f9324d;
            }
            if (localDateTime.x(bVar.f9322b.B(bVar.f9324d.f9142b - bVar.f9323c.f9142b))) {
                return bVar.f9323c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f9336a = jArr;
        this.f9337b = zoneOffsetArr;
        this.f9338c = jArr2;
        this.e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.f9339d = f9334k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 < jArr2.length) {
                int i11 = i10 + 1;
                b bVar = new b(jArr2[i10], zoneOffsetArr2[i10], zoneOffsetArr2[i11]);
                boolean zE = bVar.e();
                LocalDateTime localDateTime = bVar.f9322b;
                if (zE) {
                    arrayList.add(localDateTime);
                    arrayList.add(bVar.f9322b.B(bVar.f9324d.f9142b - bVar.f9323c.f9142b));
                } else {
                    arrayList.add(localDateTime.B(bVar.f9324d.f9142b - bVar.f9323c.f9142b));
                    arrayList.add(bVar.f9322b);
                }
                i10 = i11;
            }
            this.f9339d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f9337b = zoneOffsetArr;
        long[] jArr = f9332i;
        this.f9336a = jArr;
        this.f9338c = jArr;
        this.f9339d = f9334k;
        this.e = zoneOffsetArr;
        this.f = f9333j;
        this.g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        this.f9337b = zoneOffsetArr;
        long[] jArr = f9332i;
        this.f9336a = jArr;
        this.f9338c = jArr;
        this.f9339d = f9334k;
        this.e = zoneOffsetArr;
        this.f = f9333j;
        this.g = timeZone;
    }

    public static ZoneOffset g(int i10) {
        return ZoneOffset.C(i10 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    public static int c(long j10, ZoneOffset zoneOffset) {
        return j$.time.h.E(j$.com.android.tools.r8.a.B(j10 + zoneOffset.f9142b, 86400)).f9251a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f9338c;
        if (jArr.length == 0) {
            return this.f9337b[0];
        }
        long j10 = instant.f9131a;
        if (this.f.length > 0 && j10 > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(j10, this.e[r8.length - 1]));
            b bVar = null;
            for (int i10 = 0; i10 < bVarArrB.length; i10++) {
                bVar = bVarArrB[i10];
                if (j10 < bVar.f9321a) {
                    return bVar.f9323c;
                }
            }
            return bVar.f9324d;
        }
        int iBinarySearch = Arrays.binarySearch(jArr, j10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.e[iBinarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        if (bVar.e()) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {bVar.f9323c, bVar.f9324d};
        ArrayList arrayList = new ArrayList(2);
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(Objects.requireNonNull(objArr[i10]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r8.v(r0) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        if (r8.f9136b.G() <= r0.f9136b.G()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r8) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b[] b(int i10) {
        j$.time.h hVarW;
        b[] bVarArr = f9335l;
        Integer numValueOf = Integer.valueOf(i10);
        b[] bVarArr2 = (b[]) this.h.get(numValueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j10 = 1;
        final int i11 = 0;
        final int i12 = 1;
        if (this.g != null) {
            if (i10 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.f9133c;
            j$.time.h hVarD = j$.time.h.D(i10 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.k(0);
            long jT = j$.com.android.tools.r8.a.t(new LocalDateTime(hVarD, k.h[0]), this.f9337b[0]);
            long j11 = 1000;
            int offset = this.g.getOffset(jT * 1000);
            long j12 = 31968000 + jT;
            while (jT < j12) {
                long j13 = jT + 7776000;
                long j14 = j11;
                if (offset != this.g.getOffset(j13 * j14)) {
                    while (j13 - jT > j10) {
                        long jB = j$.com.android.tools.r8.a.B(j13 + jT, 2L);
                        if (this.g.getOffset(jB * j14) == offset) {
                            jT = jB;
                        } else {
                            j13 = jB;
                        }
                        j10 = 1;
                    }
                    if (this.g.getOffset(jT * j14) == offset) {
                        jT = j13;
                    }
                    ZoneOffset zoneOffsetG = g(offset);
                    int offset2 = this.g.getOffset(jT * j14);
                    ZoneOffset zoneOffsetG2 = g(offset2);
                    if (c(jT, zoneOffsetG2) == i10) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(jT, zoneOffsetG, zoneOffsetG2);
                    }
                    offset = offset2;
                } else {
                    jT = j13;
                }
                j11 = j14;
                j10 = 1;
            }
            if (1916 <= i10 && i10 < 2100) {
                this.h.putIfAbsent(numValueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i13 = 0;
        while (i13 < eVarArr.length) {
            e eVar = eVarArr[i13];
            byte b10 = eVar.f9328b;
            m mVar = eVar.f9327a;
            if (b10 < 0) {
                long j15 = i10;
                s.f9188c.getClass();
                int iW = mVar.w(s.f(j15)) + 1 + eVar.f9328b;
                j$.time.h hVar = j$.time.h.f9250d;
                j$.time.temporal.a.YEAR.k(j15);
                Objects.requireNonNull(mVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(iW);
                hVarW = j$.time.h.w(i10, mVar.getValue(), iW);
                j$.time.d dVar = eVar.f9329c;
                if (dVar != null) {
                    final int value = dVar.getValue();
                    hVarW = hVarW.f(new o() { // from class: j$.time.temporal.p
                        @Override // j$.time.temporal.o
                        public final m j(m mVar2) {
                            switch (i12) {
                                case 0:
                                    int iE = mVar2.e(a.DAY_OF_WEEK);
                                    int i14 = value;
                                    if (iE == i14) {
                                        return mVar2;
                                    }
                                    return mVar2.b(iE - i14 >= 0 ? 7 - r0 : -r0, b.DAYS);
                                default:
                                    int iE2 = mVar2.e(a.DAY_OF_WEEK);
                                    int i15 = value;
                                    if (iE2 == i15) {
                                        return mVar2;
                                    }
                                    return mVar2.n(i15 - iE2 >= 0 ? 7 - r1 : -r1, b.DAYS);
                            }
                        }
                    });
                }
            } else {
                j$.time.h hVar2 = j$.time.h.f9250d;
                j$.time.temporal.a.YEAR.k(i10);
                Objects.requireNonNull(mVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(b10);
                hVarW = j$.time.h.w(i10, mVar.getValue(), b10);
                j$.time.d dVar2 = eVar.f9329c;
                if (dVar2 != null) {
                    final int value2 = dVar2.getValue();
                    hVarW = hVarW.f(new o() { // from class: j$.time.temporal.p
                        @Override // j$.time.temporal.o
                        public final m j(m mVar2) {
                            switch (i11) {
                                case 0:
                                    int iE = mVar2.e(a.DAY_OF_WEEK);
                                    int i14 = value2;
                                    if (iE == i14) {
                                        return mVar2;
                                    }
                                    return mVar2.b(iE - i14 >= 0 ? 7 - r0 : -r0, b.DAYS);
                                default:
                                    int iE2 = mVar2.e(a.DAY_OF_WEEK);
                                    int i15 = value2;
                                    if (iE2 == i15) {
                                        return mVar2;
                                    }
                                    return mVar2.n(i15 - iE2 >= 0 ? 7 - r1 : -r1, b.DAYS);
                            }
                        }
                    });
                }
            }
            if (eVar.e) {
                hVarW = hVarW.G(1L);
            }
            LocalDateTime localDateTimeY = LocalDateTime.y(hVarW, eVar.f9330d);
            d dVar3 = eVar.f;
            ZoneOffset zoneOffset = eVar.g;
            ZoneOffset zoneOffset2 = eVar.h;
            dVar3.getClass();
            int i14 = c.f9325a[dVar3.ordinal()];
            if (i14 == 1) {
                localDateTimeY = localDateTimeY.B(zoneOffset2.f9142b - ZoneOffset.UTC.f9142b);
            } else if (i14 == 2) {
                localDateTimeY = localDateTimeY.B(zoneOffset2.f9142b - zoneOffset.f9142b);
            }
            bVarArr3[i13] = new b(localDateTimeY, eVar.h, eVar.f9331i);
            i13++;
            i11 = 0;
        }
        if (i10 < 2100) {
            this.h.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.g, fVar.g) && Arrays.equals(this.f9336a, fVar.f9336a) && Arrays.equals(this.f9337b, fVar.f9337b) && Arrays.equals(this.f9338c, fVar.f9338c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f, fVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.f9336a)) ^ Arrays.hashCode(this.f9337b)) ^ Arrays.hashCode(this.f9338c)) ^ Arrays.hashCode(this.e)) ^ Arrays.hashCode(this.f);
    }

    public final String toString() {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f9337b[r0.length - 1] + "]";
    }
}
