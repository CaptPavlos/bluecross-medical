package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class d6 extends z5 {

    /* renamed from: c, reason: collision with root package name */
    public t6 f9555c;

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j10) {
        t6 t6Var;
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return;
        }
        if (j10 <= 0) {
            t6Var = new t6();
        } else {
            t6Var = new t6((int) j10);
        }
        this.f9555c = t6Var;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void end() {
        long[] jArr = (long[]) this.f9555c.b();
        Arrays.sort(jArr);
        long length = jArr.length;
        m5 m5Var = this.f9595a;
        m5Var.c(length);
        int i10 = 0;
        if (!this.f9818b) {
            int length2 = jArr.length;
            while (i10 < length2) {
                m5Var.accept(jArr[i10]);
                i10++;
            }
        } else {
            int length3 = jArr.length;
            while (i10 < length3) {
                long j10 = jArr[i10];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(j10);
                i10++;
            }
        }
        m5Var.end();
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        this.f9555c.accept(j10);
    }
}
