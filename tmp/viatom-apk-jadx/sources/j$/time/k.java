package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class k implements j$.time.temporal.m, j$.time.temporal.o, Comparable, Serializable {
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k[] h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a, reason: collision with root package name */
    public final byte f9257a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f9258b;

    /* renamed from: c, reason: collision with root package name */
    public final byte f9259c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9260d;

    static {
        int i10 = 0;
        while (true) {
            k[] kVarArr = h;
            if (i10 < kVarArr.length) {
                kVarArr[i10] = new k(i10, 0, 0, 0);
                i10++;
            } else {
                k kVar = kVarArr[0];
                g = kVar;
                k kVar2 = kVarArr[12];
                e = kVar;
                f = new k(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static k z(long j10) {
        j$.time.temporal.a.NANO_OF_DAY.k(j10);
        int i10 = (int) (j10 / 3600000000000L);
        long j11 = j10 - (i10 * 3600000000000L);
        int i11 = (int) (j11 / 60000000000L);
        long j12 = j11 - (i11 * 60000000000L);
        int i12 = (int) (j12 / C.NANOS_PER_SECOND);
        return w(i10, i11, i12, (int) (j12 - (i12 * C.NANOS_PER_SECOND)));
    }

    public static k x(j$.time.temporal.n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        k kVar = (k) nVar.k(j$.time.temporal.r.g);
        if (kVar != null) {
            return kVar;
        }
        throw new b("Unable to obtain LocalTime from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName());
    }

    public static k w(int i10, int i11, int i12, int i13) {
        if ((i11 | i12 | i13) == 0) {
            return h[i10];
        }
        return new k(i10, i11, i12, i13);
    }

    public k(int i10, int i11, int i12, int i13) {
        this.f9257a = (byte) i10;
        this.f9258b = (byte) i11;
        this.f9259c = (byte) i12;
        this.f9260d = i13;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n();
        }
        return qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return y(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.NANO_OF_DAY) {
                return G();
            }
            if (qVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return G() / 1000;
            }
            return y(qVar);
        }
        return qVar.g(this);
    }

    public final int y(j$.time.temporal.q qVar) {
        switch (j.f9255a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f9260d;
            case 2:
                throw new j$.time.temporal.t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f9260d / 1000;
            case 4:
                throw new j$.time.temporal.t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f9260d / 1000000;
            case 6:
                return (int) (G() / 1000000);
            case 7:
                return this.f9259c;
            case 8:
                return H();
            case 9:
                return this.f9258b;
            case 10:
                return (this.f9257a * 60) + this.f9258b;
            case 11:
                return this.f9257a % 12;
            case 12:
                int i10 = this.f9257a % 12;
                if (i10 % 12 == 0) {
                    return 12;
                }
                return i10;
            case 13:
                return this.f9257a;
            case 14:
                byte b10 = this.f9257a;
                if (b10 == 0) {
                    return 24;
                }
                return b10;
            case 15:
                return this.f9257a / 12;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final k a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (k) qVar.j(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j10);
        switch (j.f9255a[aVar.ordinal()]) {
            case 1:
                return J((int) j10);
            case 2:
                return z(j10);
            case 3:
                return J(((int) j10) * 1000);
            case 4:
                return z(j10 * 1000);
            case 5:
                return J(((int) j10) * 1000000);
            case 6:
                return z(j10 * 1000000);
            case 7:
                int i10 = (int) j10;
                if (this.f9259c != i10) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.k(i10);
                    return w(this.f9257a, this.f9258b, i10, this.f9260d);
                }
                return this;
            case 8:
                return E(j10 - H());
            case 9:
                int i11 = (int) j10;
                if (this.f9258b != i11) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.k(i11);
                    return w(this.f9257a, i11, this.f9259c, this.f9260d);
                }
                return this;
            case 10:
                return C(j10 - ((this.f9257a * 60) + this.f9258b));
            case 11:
                return B(j10 - (this.f9257a % 12));
            case 12:
                if (j10 == 12) {
                    j10 = 0;
                }
                return B(j10 - (this.f9257a % 12));
            case 13:
                int i12 = (int) j10;
                if (this.f9257a != i12) {
                    j$.time.temporal.a.HOUR_OF_DAY.k(i12);
                    return w(i12, this.f9258b, this.f9259c, this.f9260d);
                }
                return this;
            case 14:
                if (j10 == 24) {
                    j10 = 0;
                }
                int i13 = (int) j10;
                if (this.f9257a != i13) {
                    j$.time.temporal.a.HOUR_OF_DAY.k(i13);
                    return w(i13, this.f9258b, this.f9259c, this.f9260d);
                }
                return this;
            case 15:
                return B((j10 - (this.f9257a / 12)) * 12);
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final k J(int i10) {
        if (this.f9260d == i10) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.k(i10);
        return w(this.f9257a, this.f9258b, this.f9259c, i10);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final k b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (j.f9256b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return D(j10);
                case 2:
                    return D((j10 % 86400000000L) * 1000);
                case 3:
                    return D((j10 % 86400000) * 1000000);
                case 4:
                    return E(j10);
                case 5:
                    return C(j10);
                case 6:
                    return B(j10);
                case 7:
                    return B((j10 % 2) * 12);
                default:
                    g.b(sVar, "Unsupported unit: ");
                    return null;
            }
        }
        return (k) sVar.e(this, j10);
    }

    public final k B(long j10) {
        return j10 == 0 ? this : w(((((int) (j10 % 24)) + this.f9257a) + 24) % 24, this.f9258b, this.f9259c, this.f9260d);
    }

    public final k C(long j10) {
        if (j10 != 0) {
            int i10 = (this.f9257a * 60) + this.f9258b;
            int i11 = ((((int) (j10 % 1440)) + i10) + 1440) % 1440;
            if (i10 != i11) {
                return w(i11 / 60, i11 % 60, this.f9259c, this.f9260d);
            }
        }
        return this;
    }

    public final k E(long j10) {
        if (j10 != 0) {
            int i10 = (this.f9258b * 60) + (this.f9257a * 3600) + this.f9259c;
            int i11 = ((((int) (j10 % 86400)) + i10) + 86400) % 86400;
            if (i10 != i11) {
                return w(i11 / 3600, (i11 / 60) % 60, i11 % 60, this.f9260d);
            }
        }
        return this;
    }

    public final k D(long j10) {
        if (j10 != 0) {
            long jG = G();
            long j11 = (((j10 % 86400000000000L) + jG) + 86400000000000L) % 86400000000000L;
            if (jG != j11) {
                return w((int) (j11 / 3600000000000L), (int) ((j11 / 60000000000L) % 60), (int) ((j11 / C.NANOS_PER_SECOND) % 60), (int) (j11 % C.NANOS_PER_SECOND));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9301b || aVar == j$.time.temporal.r.f9300a || aVar == j$.time.temporal.r.e || aVar == j$.time.temporal.r.f9303d) {
            return null;
        }
        if (aVar == j$.time.temporal.r.g) {
            return this;
        }
        if (aVar == j$.time.temporal.r.f) {
            return null;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int H() {
        return (this.f9258b * 60) + (this.f9257a * 3600) + this.f9259c;
    }

    public final long G() {
        return (this.f9259c * C.NANOS_PER_SECOND) + (this.f9258b * 60000000000L) + (this.f9257a * 3600000000000L) + this.f9260d;
    }

    @Override // java.lang.Comparable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        int iCompare = Integer.compare(this.f9257a, kVar.f9257a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.f9258b, kVar.f9258b)) == 0 && (iCompare = Integer.compare(this.f9259c, kVar.f9259c)) == 0) ? Integer.compare(this.f9260d, kVar.f9260d) : iCompare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f9257a == kVar.f9257a && this.f9258b == kVar.f9258b && this.f9259c == kVar.f9259c && this.f9260d == kVar.f9260d) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (k) j$.com.android.tools.r8.a.a(hVar, this);
    }

    public final int hashCode() {
        long jG = G();
        return (int) (jG ^ (jG >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b10 = this.f9257a;
        byte b11 = this.f9258b;
        byte b12 = this.f9259c;
        int i10 = this.f9260d;
        sb.append(b10 < 10 ? "0" : "");
        sb.append((int) b10);
        sb.append(b11 < 10 ? ":0" : ":");
        sb.append((int) b11);
        if (b12 > 0 || i10 > 0) {
            sb.append(b12 < 10 ? ":0" : ":");
            sb.append((int) b12);
            if (i10 > 0) {
                sb.append('.');
                if (i10 % 1000000 == 0) {
                    sb.append(Integer.toString((i10 / 1000000) + 1000).substring(1));
                } else if (i10 % 1000 == 0) {
                    sb.append(Integer.toString((i10 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i10 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void K(DataOutput dataOutput) {
        if (this.f9260d == 0) {
            if (this.f9259c == 0) {
                byte b10 = this.f9258b;
                byte b11 = this.f9257a;
                if (b10 == 0) {
                    dataOutput.writeByte(~b11);
                    return;
                } else {
                    dataOutput.writeByte(b11);
                    dataOutput.writeByte(~this.f9258b);
                    return;
                }
            }
            dataOutput.writeByte(this.f9257a);
            dataOutput.writeByte(this.f9258b);
            dataOutput.writeByte(~this.f9259c);
            return;
        }
        dataOutput.writeByte(this.f9257a);
        dataOutput.writeByte(this.f9258b);
        dataOutput.writeByte(this.f9259c);
        dataOutput.writeInt(this.f9260d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    public static k F(DataInput dataInput) throws IOException {
        int i10;
        int i11;
        int i12 = dataInput.readByte();
        byte b10 = 0;
        if (i12 < 0) {
            i12 = ~i12;
            i11 = 0;
            i10 = 0;
        } else {
            byte b11 = dataInput.readByte();
            if (b11 < 0) {
                ?? r72 = ~b11;
                i10 = 0;
                b10 = r72;
                i11 = 0;
            } else {
                byte b12 = dataInput.readByte();
                if (b12 < 0) {
                    i11 = ~b12;
                    i10 = 0;
                    b10 = b11;
                } else {
                    i10 = dataInput.readInt();
                    b10 = b11;
                    i11 = b12;
                }
            }
        }
        j$.time.temporal.a.HOUR_OF_DAY.k(i12);
        j$.time.temporal.a.MINUTE_OF_HOUR.k(b10);
        j$.time.temporal.a.SECOND_OF_MINUTE.k(i11);
        j$.time.temporal.a.NANO_OF_SECOND.k(i10);
        return w(i12, b10, i11, i10);
    }
}
