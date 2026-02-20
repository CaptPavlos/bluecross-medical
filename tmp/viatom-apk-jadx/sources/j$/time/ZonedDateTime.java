package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.chrono.ChronoZonedDateTime;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<h>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f9144a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f9145b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f9146c;

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long toEpochSecond() {
        return j$.com.android.tools.r8.a.u(this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return j$.com.android.tools.r8.a.i(this, chronoZonedDateTime);
    }

    public static ZonedDateTime now() {
        String id = TimeZone.getDefault().getID();
        Map map = ZoneId.f9140a;
        Objects.requireNonNull(id, "zoneId");
        Objects.requireNonNull(map, "aliasMap");
        Object objRequireNonNull = (String) map.get(id);
        if (objRequireNonNull == null) {
            objRequireNonNull = Objects.requireNonNull(id, "defaultObj");
        }
        ZoneId zoneIdOf = ZoneId.of((String) objRequireNonNull);
        Objects.requireNonNull(new a(zoneIdOf), "clock");
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), zoneIdOf);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f9147b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        aVar.getClass();
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), aVar.f9148a);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.l getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    public static ZonedDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f9133c;
        h hVarD = h.D(i10, i11, i12);
        j$.time.temporal.a.HOUR_OF_DAY.k(i13);
        j$.time.temporal.a.MINUTE_OF_HOUR.k(i14);
        j$.time.temporal.a.SECOND_OF_MINUTE.k(i15);
        j$.time.temporal.a.NANO_OF_SECOND.k(i16);
        return v(new LocalDateTime(hVarD, k.w(i13, i14, i15, i16)), zoneId, null);
    }

    public static ZonedDateTime v(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f fVarV = zoneId.v();
        List listF = fVarV.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) listF.get(0), TypedValues.CycleType.S_WAVE_OFFSET);
            }
        } else {
            Object objE = fVarV.e(localDateTime);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            localDateTime = localDateTime.B(Duration.e(bVar.f9324d.f9142b - bVar.f9323c.f9142b, 0).f9128a);
            zoneOffset = bVar.f9324d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return j(instant.f9131a, instant.f9132b, zoneId);
    }

    public static ZonedDateTime j(long j10, int i10, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.v().d(Instant.w(j10, i10));
        return new ZonedDateTime(LocalDateTime.z(j10, i10, zoneOffsetD), zoneId, zoneOffsetD);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.w(toEpochSecond(), toLocalTime().f9260d);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f9144a = localDateTime;
        this.f9145b = zoneOffset;
        this.f9146c = zoneId;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) qVar).f9282b;
            }
            return this.f9144a.g(qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = y.f9318a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 == 2) {
                return this.f9145b.f9142b;
            }
            return this.f9144a.e(qVar);
        }
        return j$.com.android.tools.r8.a.k(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i10 = y.f9318a[((j$.time.temporal.a) qVar).ordinal()];
        return i10 != 1 ? i10 != 2 ? this.f9144a.q(qVar) : this.f9145b.f9142b : j$.com.android.tools.r8.a.u(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.f9145b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.f9146c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f9146c.equals(zoneId) ? this : v(this.f9144a, zoneId, this.f9145b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.e toLocalDateTime() {
        return this.f9144a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.b toLocalDate() {
        return this.f9144a.f9135a;
    }

    public int getYear() {
        return this.f9144a.f9135a.f9251a;
    }

    public int getMonthValue() {
        return this.f9144a.f9135a.f9252b;
    }

    public int getDayOfMonth() {
        return this.f9144a.f9135a.f9253c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final k toLocalTime() {
        return this.f9144a.f9136b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return v(LocalDateTime.y(hVar, this.f9144a.f9136b), this.f9146c, this.f9145b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i10 = y.f9318a[aVar.ordinal()];
            if (i10 == 1) {
                return j(j10, this.f9144a.f9136b.f9260d, this.f9146c);
            }
            if (i10 != 2) {
                return v(this.f9144a.a(j10, qVar), this.f9146c, this.f9145b);
            }
            ZoneOffset zoneOffsetC = ZoneOffset.C(aVar.f9282b.a(j10, aVar));
            return (zoneOffsetC.equals(this.f9145b) || !this.f9146c.v().f(this.f9144a).contains(zoneOffsetC)) ? this : new ZonedDateTime(this.f9144a, this.f9146c, zoneOffsetC);
        }
        return (ZonedDateTime) qVar.j(this, j10);
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime b(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (ZonedDateTime) sVar.e(this, j10);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
        if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return v(this.f9144a.b(j10, sVar), this.f9146c, this.f9145b);
        }
        LocalDateTime localDateTimeB = this.f9144a.b(j10, sVar);
        ZoneOffset zoneOffset = this.f9145b;
        ZoneId zoneId = this.f9146c;
        Objects.requireNonNull(localDateTimeB, "localDateTime");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.v().f(localDateTimeB).contains(zoneOffset)) {
            return new ZonedDateTime(localDateTimeB, zoneId, zoneOffset);
        }
        localDateTimeB.getClass();
        return j(j$.com.android.tools.r8.a.t(localDateTimeB, zoneOffset), localDateTimeB.f9136b.f9260d, zoneId);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f) {
            return this.f9144a.f9135a;
        }
        return j$.com.android.tools.r8.a.r(this, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f9144a.equals(zonedDateTime.f9144a) && this.f9145b.equals(zonedDateTime.f9145b) && this.f9146c.equals(zonedDateTime.f9146c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f9144a.hashCode() ^ this.f9145b.f9142b) ^ Integer.rotateLeft(this.f9146c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f9144a.toString() + this.f9145b.f9143c;
        ZoneOffset zoneOffset = this.f9145b;
        ZoneId zoneId = this.f9146c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
