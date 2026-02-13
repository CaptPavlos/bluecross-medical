package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b6 extends x5 {

    /* renamed from: c, reason: collision with root package name */
    public p6 f9522c;

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j10) {
        p6 p6Var;
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return;
        }
        if (j10 <= 0) {
            p6Var = new p6();
        } else {
            p6Var = new p6((int) j10);
        }
        this.f9522c = p6Var;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void end() {
        double[] dArr = (double[]) this.f9522c.b();
        Arrays.sort(dArr);
        long length = dArr.length;
        m5 m5Var = this.f9576a;
        m5Var.c(length);
        int i10 = 0;
        if (!this.f9803b) {
            int length2 = dArr.length;
            while (i10 < length2) {
                m5Var.accept(dArr[i10]);
                i10++;
            }
        } else {
            int length3 = dArr.length;
            while (i10 < length3) {
                double d8 = dArr[i10];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(d8);
                i10++;
            }
        }
        m5Var.end();
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        this.f9522c.accept(d8);
    }
}
