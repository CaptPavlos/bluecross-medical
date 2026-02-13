package j$.time.format;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public class i implements f {
    public static final long[] f = {0, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, 1000000, 10000000, 100000000, C.NANOS_PER_SECOND, 10000000000L};

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f9220a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9221b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9222c;

    /* renamed from: d, reason: collision with root package name */
    public final u f9223d;
    public final int e;

    public i(j$.time.temporal.q qVar, int i10, int i11, u uVar) {
        this.f9220a = qVar;
        this.f9221b = i10;
        this.f9222c = i11;
        this.f9223d = uVar;
        this.e = 0;
    }

    public i(j$.time.temporal.q qVar, int i10, int i11, u uVar, int i12) {
        this.f9220a = qVar;
        this.f9221b = i10;
        this.f9222c = i11;
        this.f9223d = uVar;
        this.e = i12;
    }

    public i a() {
        if (this.e == -1) {
            return this;
        }
        return new i(this.f9220a, this.f9221b, this.f9222c, this.f9223d, -1);
    }

    public i b(int i10) {
        return new i(this.f9220a, this.f9221b, this.f9222c, this.f9223d, this.e + i10);
    }

    @Override // j$.time.format.f
    public boolean e(p pVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f9220a;
        Long lA = pVar.a(qVar);
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        s sVar = pVar.f9243b.f9210c;
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        int length = string.length();
        int i10 = this.f9222c;
        if (length > i10) {
            throw new j$.time.b("Field " + qVar + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + i10);
        }
        sVar.getClass();
        int i11 = this.f9221b;
        u uVar = this.f9223d;
        if (jLongValue >= 0) {
            int i12 = c.f9215a[uVar.ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    sb.append('+');
                }
            } else if (i11 < 19 && jLongValue >= f[i11]) {
                sb.append('+');
            }
        } else {
            int i13 = c.f9215a[uVar.ordinal()];
            if (i13 == 1 || i13 == 2 || i13 == 3) {
                sb.append('-');
            } else if (i13 == 4) {
                throw new j$.time.b("Field " + qVar + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i14 = 0; i14 < i11 - string.length(); i14++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    public String toString() {
        int i10 = this.f9222c;
        j$.time.temporal.q qVar = this.f9220a;
        u uVar = this.f9223d;
        int i11 = this.f9221b;
        if (i11 == 1 && i10 == 19 && uVar == u.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i11 == i10 && uVar == u.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i11 + ")";
        }
        return "Value(" + qVar + "," + i11 + "," + i10 + "," + uVar + ")";
    }
}
