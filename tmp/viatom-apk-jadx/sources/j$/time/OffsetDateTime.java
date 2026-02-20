package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.o, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9137c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f9138a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f9139b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int iCompare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f9139b.equals(offsetDateTime2.f9139b)) {
            iCompare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f9138a;
            ZoneOffset zoneOffset = this.f9139b;
            localDateTime.getClass();
            long jT = j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
            LocalDateTime localDateTime2 = offsetDateTime2.f9138a;
            ZoneOffset zoneOffset2 = offsetDateTime2.f9139b;
            localDateTime2.getClass();
            iCompare = Long.compare(jT, j$.com.android.tools.r8.a.t(localDateTime2, zoneOffset2));
            if (iCompare == 0) {
                iCompare = this.f9138a.f9136b.f9260d - offsetDateTime2.f9138a.f9136b.f9260d;
            }
        }
        return iCompare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : iCompare;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f9133c;
        ZoneOffset zoneOffset = ZoneOffset.g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f9134d;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime v(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffsetD = zoneId.v().d(instant);
        return new OffsetDateTime(LocalDateTime.z(instant.f9131a, instant.f9132b, zoneOffsetD), zoneOffsetD);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.f9138a = (LocalDateTime) Objects.requireNonNull(localDateTime, "dateTime");
        this.f9139b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final OffsetDateTime x(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f9138a == localDateTime && this.f9139b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
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
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f9138a.g(qVar);
            }
            return ((j$.time.temporal.a) qVar).f9282b;
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = p.f9268a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i10 == 2) {
                return this.f9139b.f9142b;
            }
            return this.f9138a.e(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i10 = p.f9268a[((j$.time.temporal.a) qVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? this.f9138a.q(qVar) : this.f9139b.f9142b;
        }
        LocalDateTime localDateTime = this.f9138a;
        ZoneOffset zoneOffset = this.f9139b;
        localDateTime.getClass();
        return j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f9138a;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        LocalDateTime localDateTime = this.f9138a;
        return x(localDateTime.E(hVar, localDateTime.f9136b), this.f9139b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i10 = p.f9268a[aVar.ordinal()];
            LocalDateTime localDateTime = this.f9138a;
            if (i10 == 1) {
                return v(Instant.w(j10, localDateTime.f9136b.f9260d), this.f9139b);
            }
            if (i10 == 2) {
                return x(localDateTime, ZoneOffset.C(aVar.f9282b.a(j10, aVar)));
            }
            return x(localDateTime.a(j10, qVar), this.f9139b);
        }
        return (OffsetDateTime) qVar.j(this, j10);
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return x(this.f9138a.b(j10, sVar), this.f9139b);
        }
        return (OffsetDateTime) sVar.e(this, j10);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9303d || aVar == j$.time.temporal.r.e) {
            return this.f9139b;
        }
        if (aVar == j$.time.temporal.r.f9300a) {
            return null;
        }
        if (aVar == j$.time.temporal.r.f) {
            return this.f9138a.f9135a;
        }
        if (aVar == j$.time.temporal.r.g) {
            return this.f9138a.f9136b;
        }
        if (aVar == j$.time.temporal.r.f9301b) {
            return j$.time.chrono.s.f9188c;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f9138a.f9135a.r(), j$.time.temporal.a.EPOCH_DAY).a(this.f9138a.f9136b.G(), j$.time.temporal.a.NANO_OF_DAY).a(this.f9139b.f9142b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f9138a.equals(offsetDateTime.f9138a) && this.f9139b.equals(offsetDateTime.f9139b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9138a.hashCode() ^ this.f9139b.f9142b;
    }

    public final String toString() {
        return this.f9138a.toString() + this.f9139b.f9143c;
    }

    private Object writeReplace() {
        return new s((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
