package p7;

import com.google.android.gms.internal.measurement.l5;
import kotlin.jvm.internal.l;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final long f12036b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f12037c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f12038d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f12039a;

    static {
        int i10 = b.f12040a;
        f12036b = l1.b.x(4611686018427387903L);
        f12037c = l1.b.x(-4611686018427387903L);
    }

    public static final long a(long j10, long j11) {
        long j12 = 1000000;
        long j13 = j11 / j12;
        long j14 = j10 + j13;
        if (-4611686018426L > j14 || j14 >= 4611686018427L) {
            return l1.b.x(l5.n(j14, -4611686018427387903L, 4611686018427387903L));
        }
        return l1.b.z((j14 * j12) + (j11 - (j13 * j12)));
    }

    public static final void b(StringBuilder sb, int i10, int i11, int i12, String str, boolean z9) {
        sb.append(i10);
        if (i11 != 0) {
            sb.append('.');
            String strP0 = m.p0(i12, String.valueOf(i11));
            int i13 = -1;
            int length = strP0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strP0.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (z9 || i15 >= 3) {
                sb.append((CharSequence) strP0, 0, ((i13 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strP0, 0, i15);
            }
        }
        sb.append(str);
    }

    public static int c(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return l.d(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return j10 < 0 ? -i10 : i10;
    }

    public static final int d(long j10) {
        if (e(j10)) {
            return 0;
        }
        return (int) ((((int) j10) & 1) == 1 ? ((j10 >> 1) % 1000) * 1000000 : (j10 >> 1) % 1000000000);
    }

    public static final boolean e(long j10) {
        return j10 == f12036b || j10 == f12037c;
    }

    public static final long f(long j10, long j11) {
        if (e(j10)) {
            if (!e(j11) || (j11 ^ j10) >= 0) {
                return j10;
            }
            com.google.gson.internal.a.n("Summing infinite durations of different signs yields an undefined result.");
            return 0L;
        }
        if (e(j11)) {
            return j11;
        }
        int i10 = ((int) j10) & 1;
        if (i10 != (((int) j11) & 1)) {
            return i10 == 1 ? a(j10 >> 1, j11 >> 1) : a(j11 >> 1, j10 >> 1);
        }
        long j12 = (j10 >> 1) + (j11 >> 1);
        return i10 == 0 ? (-4611686018426999999L > j12 || j12 >= 4611686018427000000L) ? l1.b.x(j12 / 1000000) : l1.b.z(j12) : l1.b.y(j12);
    }

    public static final long g(long j10, c cVar) {
        if (j10 == f12036b) {
            return Long.MAX_VALUE;
        }
        if (j10 == f12037c) {
            return Long.MIN_VALUE;
        }
        return cVar.f12044a.convert(j10 >> 1, ((((int) j10) & 1) == 0 ? c.NANOSECONDS : c.MILLISECONDS).f12044a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return c(this.f12039a, ((a) obj).f12039a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f12039a == ((a) obj).f12039a;
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f12039a;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        long j10;
        int iG;
        long j11 = this.f12039a;
        if (j11 == 0) {
            return "0s";
        }
        if (j11 == f12036b) {
            return "Infinity";
        }
        if (j11 == f12037c) {
            return "-Infinity";
        }
        int i10 = 0;
        boolean z9 = j11 < 0;
        StringBuilder sb = new StringBuilder();
        if (z9) {
            sb.append('-');
        }
        if (j11 < 0) {
            j11 = (((int) j11) & 1) + ((-(j11 >> 1)) << 1);
            int i11 = b.f12040a;
        }
        long jG = g(j11, c.DAYS);
        int iG2 = e(j11) ? 0 : (int) (g(j11, c.HOURS) % 24);
        if (e(j11)) {
            j10 = 0;
            iG = 0;
        } else {
            j10 = 0;
            iG = (int) (g(j11, c.MINUTES) % 60);
        }
        int iG3 = e(j11) ? 0 : (int) (g(j11, c.SECONDS) % 60);
        int iD = d(j11);
        boolean z10 = jG != j10;
        boolean z11 = iG2 != 0;
        boolean z12 = iG != 0;
        boolean z13 = (iG3 == 0 && iD == 0) ? false : true;
        if (z10) {
            sb.append(jG);
            sb.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            sb.append(iG2);
            sb.append('h');
            i10 = i12;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            sb.append(iG);
            sb.append('m');
            i10 = i13;
        }
        if (z13) {
            int i14 = i10 + 1;
            if (i10 > 0) {
                sb.append(' ');
            }
            if (iG3 != 0 || z10 || z11 || z12) {
                b(sb, iG3, iD, 9, "s", false);
            } else if (iD >= 1000000) {
                b(sb, iD / 1000000, iD % 1000000, 6, "ms", false);
            } else if (iD >= 1000) {
                b(sb, iD / 1000, iD % 1000, 3, "us", false);
            } else {
                sb.append(iD);
                sb.append("ns");
            }
            i10 = i14;
        }
        if (z9 && i10 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
