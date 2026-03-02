package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class g implements e, j$.time.temporal.m, j$.time.temporal.o, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a, reason: collision with root package name */
    public final transient b f9160a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.k f9161b;

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: t */
    public final /* synthetic */ int compareTo(e eVar) {
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public static g v(l lVar, j$.time.temporal.m mVar) {
        g gVar = (g) mVar;
        if (lVar.equals(gVar.f9160a.getChronology())) {
            return gVar;
        }
        j$.time.g.f("Chronology mismatch, required: ", lVar.d(), gVar.f9160a.getChronology().d());
        return null;
    }

    public g(b bVar, j$.time.k kVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(kVar, "time");
        this.f9160a = bVar;
        this.f9161b = kVar;
    }

    public final g z(j$.time.temporal.m mVar, j$.time.k kVar) {
        b bVar = this.f9160a;
        return (bVar == mVar && this.f9161b == kVar) ? this : new g(d.v(bVar.getChronology(), mVar), kVar);
    }

    @Override // j$.time.chrono.e
    public final l getChronology() {
        return this.f9160a.getChronology();
    }

    public final int hashCode() {
        return this.f9160a.hashCode() ^ this.f9161b.hashCode();
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return v(this.f9160a.getChronology(), j$.time.temporal.r.b(this, j10, bVar));
    }

    @Override // j$.time.chrono.e
    public final b toLocalDate() {
        return this.f9160a;
    }

    public final String toString() {
        return this.f9160a.toString() + ExifInterface.GPS_DIRECTION_TRUE + this.f9161b.toString();
    }

    @Override // j$.time.chrono.e
    public final j$.time.k toLocalTime() {
        return this.f9161b;
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
            if (!((j$.time.temporal.a) qVar).n()) {
                return this.f9160a.g(qVar);
            }
            j$.time.k kVar = this.f9161b;
            kVar.getClass();
            return j$.time.temporal.r.d(kVar, qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f9161b.e(qVar) : this.f9160a.e(qVar);
        }
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f9161b.q(qVar) : this.f9160a.q(qVar);
        }
        return qVar.g(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return z(hVar, this.f9161b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final g a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            boolean zN = ((j$.time.temporal.a) qVar).n();
            b bVar = this.f9160a;
            if (zN) {
                return z(bVar, this.f9161b.a(j10, qVar));
            }
            return z(bVar.a(j10, qVar), this.f9161b);
        }
        return v(this.f9160a.getChronology(), qVar.j(this, j10));
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final g b(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return v(this.f9160a.getChronology(), sVar.e(this, j10));
        }
        switch (f.f9158a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return x(this.f9160a, 0L, 0L, 0L, j10);
            case 2:
                g gVarZ = z(this.f9160a.b(j10 / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f9161b);
                return gVarZ.x(gVarZ.f9160a, 0L, 0L, 0L, (j10 % 86400000000L) * 1000);
            case 3:
                g gVarZ2 = z(this.f9160a.b(j10 / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f9161b);
                return gVarZ2.x(gVarZ2.f9160a, 0L, 0L, 0L, (j10 % 86400000) * 1000000);
            case 4:
                return x(this.f9160a, 0L, 0L, j10, 0L);
            case 5:
                return x(this.f9160a, 0L, j10, 0L, 0L);
            case 6:
                return x(this.f9160a, j10, 0L, 0L, 0L);
            case 7:
                g gVarZ3 = z(this.f9160a.b(j10 / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f9161b);
                return gVarZ3.x(gVarZ3.f9160a, (j10 % 256) * 12, 0L, 0L, 0L);
            default:
                return z(this.f9160a.b(j10, sVar), this.f9161b);
        }
    }

    public final g x(b bVar, long j10, long j11, long j12, long j13) {
        long j14 = j10 | j11 | j12 | j13;
        j$.time.k kVar = this.f9161b;
        if (j14 == 0) {
            return z(bVar, kVar);
        }
        long j15 = j10 / 24;
        long j16 = ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * C.NANOS_PER_SECOND) + (j13 % 86400000000000L);
        long jG = kVar.G();
        long j17 = ((j10 % 24) * 3600000000000L) + j16 + jG;
        long jB = j$.com.android.tools.r8.a.B(j17, 86400000000000L) + j15 + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L);
        long jA = j$.com.android.tools.r8.a.A(j17, 86400000000000L);
        return z(bVar.b(jB, (j$.time.temporal.s) j$.time.temporal.b.DAYS), jA == jG ? this.f9161b : j$.time.k.z(jA));
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime h(ZoneOffset zoneOffset) {
        return k.v(zoneOffset, null, this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(toLocalDate().r(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    private Object writeReplace() {
        return new e0((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && j$.com.android.tools.r8.a.h(this, (e) obj) == 0;
    }
}
