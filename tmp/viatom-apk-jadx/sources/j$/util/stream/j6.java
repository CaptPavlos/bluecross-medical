package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j6 extends x5 {

    /* renamed from: c, reason: collision with root package name */
    public double[] f9624c;

    /* renamed from: d, reason: collision with root package name */
    public int f9625d;

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f9624c = new double[(int) j10];
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void end() {
        int i10 = 0;
        Arrays.sort(this.f9624c, 0, this.f9625d);
        long j10 = this.f9625d;
        m5 m5Var = this.f9576a;
        m5Var.c(j10);
        if (!this.f9803b) {
            while (i10 < this.f9625d) {
                m5Var.accept(this.f9624c[i10]);
                i10++;
            }
        } else {
            while (i10 < this.f9625d && !m5Var.e()) {
                m5Var.accept(this.f9624c[i10]);
                i10++;
            }
        }
        m5Var.end();
        this.f9624c = null;
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        double[] dArr = this.f9624c;
        int i10 = this.f9625d;
        this.f9625d = i10 + 1;
        dArr[i10] = d8;
    }
}
