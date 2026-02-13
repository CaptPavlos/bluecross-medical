package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Duration f9127c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f9128a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9129b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int iCompare = Long.compare(this.f9128a, duration2.f9128a);
        return iCompare != 0 ? iCompare : this.f9129b - duration2.f9129b;
    }

    static {
        BigInteger.valueOf(C.NANOS_PER_SECOND);
    }

    public static Duration ofMillis(long j10) {
        long j11 = j10 / 1000;
        int i10 = (int) (j10 % 1000);
        if (i10 < 0) {
            i10 += 1000;
            j11--;
        }
        return e(j11, i10 * 1000000);
    }

    public static Duration f(long j10) {
        long j11 = j10 / C.NANOS_PER_SECOND;
        int i10 = (int) (j10 % C.NANOS_PER_SECOND);
        if (i10 < 0) {
            i10 = (int) (i10 + C.NANOS_PER_SECOND);
            j11--;
        }
        return e(j11, i10);
    }

    public static Duration e(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return f9127c;
        }
        return new Duration(j10, i10);
    }

    public Duration(long j10, int i10) {
        this.f9128a = j10;
        this.f9129b = i10;
    }

    public long toMillis() {
        long j10 = this.f9128a;
        long j11 = this.f9129b;
        if (j10 < 0) {
            j10++;
            j11 -= C.NANOS_PER_SECOND;
        }
        return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j10, 1000), j11 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f9128a == duration.f9128a && this.f9129b == duration.f9129b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f9128a;
        return (this.f9129b * 51) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        if (this == f9127c) {
            return "PT0S";
        }
        long j10 = this.f9128a;
        if (j10 < 0 && this.f9129b > 0) {
            j10++;
        }
        long j11 = j10 / 3600;
        int i10 = (int) ((j10 % 3600) / 60);
        int i11 = (int) (j10 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j11 != 0) {
            sb.append(j11);
            sb.append('H');
        }
        if (i10 != 0) {
            sb.append(i10);
            sb.append('M');
        }
        if (i11 == 0 && this.f9129b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f9128a < 0 && this.f9129b > 0 && i11 == 0) {
            sb.append("-0");
        } else {
            sb.append(i11);
        }
        if (this.f9129b > 0) {
            int length = sb.length();
            long j12 = this.f9128a;
            int i12 = this.f9129b;
            if (j12 < 0) {
                sb.append(2000000000 - i12);
            } else {
                sb.append(i12 + C.NANOS_PER_SECOND);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
