package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.o, j$.time.chrono.e, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f9133c = y(h.f9250d, k.e);

    /* renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f9134d = y(h.e, k.f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a, reason: collision with root package name */
    public final h f9135a;

    /* renamed from: b, reason: collision with root package name */
    public final k f9136b;

    @Override // j$.time.chrono.e
    public final j$.time.chrono.l getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime h(ZoneOffset zoneOffset) {
        return ZonedDateTime.v(this, zoneOffset, null);
    }

    public static LocalDateTime y(h hVar, k kVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(kVar, "time");
        return new LocalDateTime(hVar, kVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(((h) toLocalDate()).r(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public static LocalDateTime z(long j10, int i10, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        long j11 = i10;
        j$.time.temporal.a.NANO_OF_SECOND.k(j11);
        return new LocalDateTime(h.E(j$.com.android.tools.r8.a.B(j10 + zoneOffset.f9142b, 86400)), k.z((((int) j$.com.android.tools.r8.a.A(r5, r7)) * C.NANOS_PER_SECOND) + j11));
    }

    public static LocalDateTime w(j$.time.temporal.n nVar) {
        if (nVar instanceof LocalDateTime) {
            return (LocalDateTime) nVar;
        }
        if (!(nVar instanceof ZonedDateTime)) {
            if (nVar instanceof OffsetDateTime) {
                return ((OffsetDateTime) nVar).toLocalDateTime();
            }
            try {
                return new LocalDateTime(h.x(nVar), k.x(nVar));
            } catch (b e) {
                throw new b("Unable to obtain LocalDateTime from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName(), e);
            }
        }
        return ((ZonedDateTime) nVar).f9144a;
    }

    public LocalDateTime(h hVar, k kVar) {
        this.f9135a = hVar;
        this.f9136b = kVar;
    }

    public final LocalDateTime E(h hVar, k kVar) {
        return (this.f9135a == hVar && this.f9136b == kVar) ? this : new LocalDateTime(hVar, kVar);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.e(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.n();
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).n()) {
                k kVar = this.f9136b;
                kVar.getClass();
                return j$.time.temporal.r.d(kVar, qVar);
            }
            return this.f9135a.g(qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f9136b.e(qVar) : this.f9135a.e(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f9136b.q(qVar) : this.f9135a.q(qVar);
        }
        return qVar.g(this);
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.b toLocalDate() {
        return this.f9135a;
    }

    @Override // j$.time.chrono.e
    public final k toLocalTime() {
        return this.f9136b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return E(hVar, this.f9136b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            boolean zN = ((j$.time.temporal.a) qVar).n();
            h hVar = this.f9135a;
            if (zN) {
                return E(hVar, this.f9136b.a(j10, qVar));
            }
            return E(hVar.a(j10, qVar), this.f9136b);
        }
        return (LocalDateTime) qVar.j(this, j10);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.e(this, j10);
        }
        switch (i.f9254a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return C(this.f9135a, 0L, 0L, 0L, j10);
            case 2:
                LocalDateTime localDateTimeE = E(this.f9135a.G(j10 / 86400000000L), this.f9136b);
                return localDateTimeE.C(localDateTimeE.f9135a, 0L, 0L, 0L, (j10 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimeE2 = E(this.f9135a.G(j10 / 86400000), this.f9136b);
                return localDateTimeE2.C(localDateTimeE2.f9135a, 0L, 0L, 0L, (j10 % 86400000) * 1000000);
            case 4:
                return B(j10);
            case 5:
                return C(this.f9135a, 0L, j10, 0L, 0L);
            case 6:
                return C(this.f9135a, j10, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimeE3 = E(this.f9135a.G(j10 / 256), this.f9136b);
                return localDateTimeE3.C(localDateTimeE3.f9135a, (j10 % 256) * 12, 0L, 0L, 0L);
            default:
                return E(this.f9135a.b(j10, sVar), this.f9136b);
        }
    }

    public final LocalDateTime B(long j10) {
        return C(this.f9135a, 0L, 0L, j10, 0L);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    public final LocalDateTime C(h hVar, long j10, long j11, long j12, long j13) {
        long j14 = j10 | j11 | j12 | j13;
        k kVar = this.f9136b;
        if (j14 == 0) {
            return E(hVar, kVar);
        }
        long j15 = 1;
        long j16 = ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * C.NANOS_PER_SECOND) + (j13 % 86400000000000L);
        long jG = kVar.G();
        long j17 = ((((j10 % 24) * 3600000000000L) + j16) * j15) + jG;
        long jB = j$.com.android.tools.r8.a.B(j17, 86400000000000L) + (((j10 / 24) + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L)) * j15);
        long jA = j$.com.android.tools.r8.a.A(j17, 86400000000000L);
        return E(hVar.G(jB), jA == jG ? this.f9136b : k.z(jA));
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f) {
            return this.f9135a;
        }
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar);
        }
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public final int v(LocalDateTime localDateTime) {
        int iV = this.f9135a.v(localDateTime.f9135a);
        return iV == 0 ? this.f9136b.compareTo(localDateTime.f9136b) : iV;
    }

    public final boolean x(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar) < 0;
        }
        long jR = this.f9135a.r();
        long jR2 = eVar.toLocalDate().r();
        if (jR >= jR2) {
            return jR == jR2 && this.f9136b.G() < eVar.toLocalTime().G();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f9135a.equals(localDateTime.f9135a) && this.f9136b.equals(localDateTime.f9136b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9135a.hashCode() ^ this.f9136b.hashCode();
    }

    public final String toString() {
        return this.f9135a.toString() + ExifInterface.GPS_DIRECTION_TRUE + this.f9136b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
