package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l6 extends z5 {

    /* renamed from: c, reason: collision with root package name */
    public long[] f9661c;

    /* renamed from: d, reason: collision with root package name */
    public int f9662d;

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f9661c = new long[(int) j10];
        }
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void end() {
        int i10 = 0;
        Arrays.sort(this.f9661c, 0, this.f9662d);
        long j10 = this.f9662d;
        m5 m5Var = this.f9595a;
        m5Var.c(j10);
        if (!this.f9818b) {
            while (i10 < this.f9662d) {
                m5Var.accept(this.f9661c[i10]);
                i10++;
            }
        } else {
            while (i10 < this.f9662d && !m5Var.e()) {
                m5Var.accept(this.f9661c[i10]);
                i10++;
            }
        }
        m5Var.end();
        this.f9661c = null;
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        long[] jArr = this.f9661c;
        int i10 = this.f9662d;
        this.f9662d = i10 + 1;
        jArr[i10] = j10;
    }
}
