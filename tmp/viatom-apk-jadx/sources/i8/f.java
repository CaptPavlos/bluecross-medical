package i8;

import com.google.android.gms.internal.measurement.p4;
import h0.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends p4 {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9070c;

    public f(a0 a0Var, boolean z9) {
        super(a0Var);
        this.f9070c = z9;
    }

    @Override // com.google.android.gms.internal.measurement.p4
    public final void c(byte b10) {
        if (this.f9070c) {
            h(String.valueOf(b10 & 255));
            return;
        }
        String strValueOf = String.valueOf(b10 & 255);
        strValueOf.getClass();
        ((a0) this.f2129b).j(strValueOf);
    }

    @Override // com.google.android.gms.internal.measurement.p4
    public final void e(int i10) {
        if (this.f9070c) {
            h(Long.toString(4294967295L & i10, 10));
            return;
        }
        String string = Long.toString(4294967295L & i10, 10);
        string.getClass();
        ((a0) this.f2129b).j(string);
    }

    @Override // com.google.android.gms.internal.measurement.p4
    public final void f(long j10) {
        int i10 = 63;
        String str = "0";
        if (this.f9070c) {
            if (j10 != 0) {
                if (j10 > 0) {
                    str = Long.toString(j10, 10);
                } else {
                    char[] cArr = new char[64];
                    long j11 = (j10 >>> 1) / 5;
                    long j12 = 10;
                    cArr[63] = Character.forDigit((int) (j10 - (j11 * j12)), 10);
                    while (j11 > 0) {
                        i10--;
                        cArr[i10] = Character.forDigit((int) (j11 % j12), 10);
                        j11 /= j12;
                    }
                    str = new String(cArr, i10, 64 - i10);
                }
            }
            h(str);
            return;
        }
        if (j10 != 0) {
            if (j10 > 0) {
                str = Long.toString(j10, 10);
            } else {
                char[] cArr2 = new char[64];
                long j13 = (j10 >>> 1) / 5;
                long j14 = 10;
                cArr2[63] = Character.forDigit((int) (j10 - (j13 * j14)), 10);
                while (j13 > 0) {
                    i10--;
                    cArr2[i10] = Character.forDigit((int) (j13 % j14), 10);
                    j13 /= j14;
                }
                str = new String(cArr2, i10, 64 - i10);
            }
        }
        str.getClass();
        ((a0) this.f2129b).j(str);
    }

    @Override // com.google.android.gms.internal.measurement.p4
    public final void g(short s9) {
        if (this.f9070c) {
            h(String.valueOf(s9 & 65535));
            return;
        }
        String strValueOf = String.valueOf(s9 & 65535);
        strValueOf.getClass();
        ((a0) this.f2129b).j(strValueOf);
    }
}
