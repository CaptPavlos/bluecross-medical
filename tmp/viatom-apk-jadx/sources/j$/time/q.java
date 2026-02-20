package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class q implements j$.time.temporal.m, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9269c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a, reason: collision with root package name */
    public final k f9270a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f9271b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        q qVar = (q) obj;
        boolean zEquals = this.f9271b.equals(qVar.f9271b);
        k kVar = this.f9270a;
        if (zEquals) {
            return kVar.compareTo(qVar.f9270a);
        }
        int iCompare = Long.compare(kVar.G() - (this.f9271b.f9142b * C.NANOS_PER_SECOND), qVar.f9270a.G() - (qVar.f9271b.f9142b * C.NANOS_PER_SECOND));
        return iCompare == 0 ? this.f9270a.compareTo(qVar.f9270a) : iCompare;
    }

    static {
        k kVar = k.e;
        ZoneOffset zoneOffset = ZoneOffset.g;
        kVar.getClass();
        new q(kVar, zoneOffset);
        k kVar2 = k.f;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        kVar2.getClass();
        new q(kVar2, zoneOffset2);
    }

    public q(k kVar, ZoneOffset zoneOffset) {
        this.f9270a = (k) Objects.requireNonNull(kVar, "time");
        this.f9271b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final q w(k kVar, ZoneOffset zoneOffset) {
        return (this.f9270a == kVar && this.f9271b.equals(zoneOffset)) ? this : new q(kVar, zoneOffset);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).n() || qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                k kVar = this.f9270a;
                kVar.getClass();
                return j$.time.temporal.r.d(kVar, qVar);
            }
            return ((j$.time.temporal.a) qVar).f9282b;
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f9271b.f9142b;
            }
            return this.f9270a.q(qVar);
        }
        return qVar.g(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
            k kVar = this.f9270a;
            if (qVar == aVar) {
                j$.time.temporal.a aVar2 = (j$.time.temporal.a) qVar;
                return w(kVar, ZoneOffset.C(aVar2.f9282b.a(j10, aVar2)));
            }
            return w(kVar.a(j10, qVar), this.f9271b);
        }
        return (q) qVar.j(this, j10);
    }

    @Override // j$.time.temporal.m
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final q b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return w(this.f9270a.b(j10, sVar), this.f9271b);
        }
        return (q) sVar.e(this, j10);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9303d || aVar == j$.time.temporal.r.e) {
            return this.f9271b;
        }
        if (((aVar == j$.time.temporal.r.f9300a) || (aVar == j$.time.temporal.r.f9301b)) || aVar == j$.time.temporal.r.f) {
            return null;
        }
        if (aVar == j$.time.temporal.r.g) {
            return this.f9270a;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f9270a.G(), j$.time.temporal.a.NANO_OF_DAY).a(this.f9271b.f9142b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f9270a.equals(qVar.f9270a) && this.f9271b.equals(qVar.f9271b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9270a.hashCode() ^ this.f9271b.f9142b;
    }

    public final String toString() {
        return this.f9270a.toString() + this.f9271b.f9143c;
    }

    private Object writeReplace() {
        return new s((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (q) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
