package j$.time.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a, reason: collision with root package name */
    public final transient g f9172a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ZoneOffset f9173b;

    /* renamed from: c, reason: collision with root package name */
    public final transient ZoneId f9174c;

    @Override // j$.time.temporal.n
    public final /* synthetic */ int e(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.k(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.r(this, aVar);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long toEpochSecond() {
        return j$.com.android.tools.r8.a.u(this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return j$.com.android.tools.r8.a.i(this, chronoZonedDateTime);
    }

    public static k v(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, gVar);
        }
        j$.time.zone.f fVarV = zoneId.v();
        LocalDateTime localDateTimeW = LocalDateTime.w(gVar);
        List listF = fVarV.f(localDateTimeW);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            gVar = gVar;
        } else {
            Object objE = fVarV.e(localDateTimeW);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            gVar = gVar.x(gVar.f9160a, 0L, 0L, Duration.e(bVar.f9324d.f9142b - bVar.f9323c.f9142b, 0).f9128a, 0L);
            zoneOffset = bVar.f9324d;
        }
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, zoneOffset, gVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f9172a.g(qVar);
            }
            return ((j$.time.temporal.a) qVar).f9282b;
        }
        return qVar.f(this);
    }

    public static k j(l lVar, j$.time.temporal.m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.getChronology())) {
            return kVar;
        }
        j$.time.g.f("Chronology mismatch, required: ", lVar.d(), kVar.getChronology().d());
        return null;
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = i.f9168a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                return toEpochSecond();
            }
            if (i10 != 2) {
                return ((g) toLocalDateTime()).q(qVar);
            }
            return getOffset().f9142b;
        }
        return qVar.g(this);
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        this.f9172a = (g) Objects.requireNonNull(gVar, "dateTime");
        this.f9173b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        this.f9174c = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.f9173b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final b toLocalDate() {
        return ((g) toLocalDateTime()).toLocalDate();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.k toLocalTime() {
        return ((g) toLocalDateTime()).toLocalTime();
    }

    public final int hashCode() {
        return (this.f9172a.hashCode() ^ this.f9173b.f9142b) ^ Integer.rotateLeft(this.f9174c.hashCode(), 3);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final e toLocalDateTime() {
        return this.f9172a;
    }

    public final String toString() {
        String str = this.f9172a.toString() + this.f9173b.f9143c;
        ZoneOffset zoneOffset = this.f9173b;
        ZoneId zoneId = this.f9174c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.f9174c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final l getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime m(ZoneId zoneId) {
        return v(zoneId, this.f9173b, this.f9172a);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return j(getChronology(), qVar.j(this, j10));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i10 = j.f9170a[aVar.ordinal()];
        if (i10 == 1) {
            return b(j10 - j$.com.android.tools.r8.a.u(this), j$.time.temporal.b.SECONDS);
        }
        if (i10 != 2) {
            return v(this.f9174c, this.f9173b, this.f9172a.a(j10, qVar));
        }
        ZoneOffset zoneOffsetC = ZoneOffset.C(aVar.f9282b.a(j10, aVar));
        g gVar = this.f9172a;
        gVar.getClass();
        Instant instantW = Instant.w(j$.com.android.tools.r8.a.t(gVar, zoneOffsetC), gVar.f9161b.f9260d);
        ZoneId zoneId = this.f9174c;
        l chronology = getChronology();
        ZoneOffset zoneOffsetD = zoneId.v().d(instantW);
        Objects.requireNonNull(zoneOffsetD, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, zoneOffsetD, (g) chronology.p(LocalDateTime.z(instantW.f9131a, instantW.f9132b, zoneOffsetD)));
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final k b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return j(getChronology(), this.f9172a.b(j10, sVar).j(this));
        }
        return j(getChronology(), sVar.e(this, j10));
    }

    private Object writeReplace() {
        return new e0((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && j$.com.android.tools.r8.a.i(this, (ChronoZonedDateTime) obj) == 0;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return j(getChronology(), hVar.j(this));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j(getChronology(), j$.time.temporal.r.b(this, j10, bVar));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.w(toEpochSecond(), toLocalTime().f9260d);
    }
}
