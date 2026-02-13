package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.o, Comparable<Instant>, Serializable {
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a, reason: collision with root package name */
    public final long f9131a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9132b;

    /* renamed from: c, reason: collision with root package name */
    public static final Instant f9130c = new Instant(0, 0);
    public static final Instant MIN = w(-31557014167219200L, 0);
    public static final Instant MAX = w(31556889864403199L, 999999999);

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f9131a, instant2.f9131a);
        return iCompare != 0 ? iCompare : this.f9132b - instant2.f9132b;
    }

    public static Instant w(long j10, long j11) {
        return v(j$.com.android.tools.r8.a.x(j10, j$.com.android.tools.r8.a.B(j11, C.NANOS_PER_SECOND)), (int) j$.com.android.tools.r8.a.A(j11, C.NANOS_PER_SECOND));
    }

    public static Instant ofEpochMilli(long j10) {
        long j11 = 1000;
        return v(j$.com.android.tools.r8.a.B(j10, j11), ((int) j$.com.android.tools.r8.a.A(j10, j11)) * 1000000);
    }

    public static Instant v(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return f9130c;
        }
        if (j10 < -31557014167219200L || j10 > 31556889864403199L) {
            throw new b("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j10, i10);
    }

    public Instant(long j10, int i10) {
        this.f9131a = j10;
        this.f9132b = i10;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.r.d(this, qVar).a(qVar.g(this), qVar);
        }
        int i10 = e.f9204a[((j$.time.temporal.a) qVar).ordinal()];
        if (i10 == 1) {
            return this.f9132b;
        }
        if (i10 == 2) {
            return this.f9132b / 1000;
        }
        if (i10 == 3) {
            return this.f9132b / 1000000;
        }
        if (i10 == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f9282b.a(this.f9131a, aVar);
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        int i10;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i11 = e.f9204a[((j$.time.temporal.a) qVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f9132b;
        } else if (i11 == 2) {
            i10 = this.f9132b / 1000;
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    return this.f9131a;
                }
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            }
            i10 = this.f9132b / 1000000;
        }
        return i10;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.j(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j10);
        int i10 = e.f9204a[aVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = ((int) j10) * 1000;
                if (i11 != this.f9132b) {
                    return v(this.f9131a, i11);
                }
            } else if (i10 == 3) {
                int i12 = ((int) j10) * 1000000;
                if (i12 != this.f9132b) {
                    return v(this.f9131a, i12);
                }
            } else {
                if (i10 != 4) {
                    throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
                }
                if (j10 != this.f9131a) {
                    return v(j10, this.f9132b);
                }
            }
        } else if (j10 != this.f9132b) {
            return v(this.f9131a, (int) j10);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Instant b(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.e(this, j10);
        }
        switch (e.f9205b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return x(0L, j10);
            case 2:
                return x(j10 / 1000000, (j10 % 1000000) * 1000);
            case 3:
                return x(j10 / 1000, (j10 % 1000) * 1000000);
            case 4:
                return x(j10, 0L);
            case 5:
                return x(j$.com.android.tools.r8.a.w(j10, 60), 0L);
            case 6:
                return x(j$.com.android.tools.r8.a.w(j10, 3600), 0L);
            case 7:
                return x(j$.com.android.tools.r8.a.w(j10, 43200), 0L);
            case 8:
                return x(j$.com.android.tools.r8.a.w(j10, 86400), 0L);
            default:
                g.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public final Instant x(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return w(j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.x(this.f9131a, j10), j11 / C.NANOS_PER_SECOND), this.f9132b + (j11 % C.NANOS_PER_SECOND));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        if (aVar == j$.time.temporal.r.f9301b || aVar == j$.time.temporal.r.f9300a || aVar == j$.time.temporal.r.e || aVar == j$.time.temporal.r.f9303d || aVar == j$.time.temporal.r.f || aVar == j$.time.temporal.r.g) {
            return null;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f9131a, j$.time.temporal.a.INSTANT_SECONDS).a(this.f9132b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.v(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j10 = this.f9131a;
        if (j10 < 0 && this.f9132b > 0) {
            return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j10 + 1, 1000), (this.f9132b / 1000000) - 1000);
        }
        return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j10, 1000), this.f9132b / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f9131a == instant.f9131a && this.f9132b == instant.f9132b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f9131a;
        return (this.f9132b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.e.a(this);
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (Instant) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
