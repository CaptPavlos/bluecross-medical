package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k6 extends y5 {

    /* renamed from: c, reason: collision with root package name */
    public int[] f9646c;

    /* renamed from: d, reason: collision with root package name */
    public int f9647d;

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f9646c = new int[(int) j10];
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void end() {
        int i10 = 0;
        Arrays.sort(this.f9646c, 0, this.f9647d);
        long j10 = this.f9647d;
        m5 m5Var = this.f9586a;
        m5Var.c(j10);
        if (!this.f9808b) {
            while (i10 < this.f9647d) {
                m5Var.accept(this.f9646c[i10]);
                i10++;
            }
        } else {
            while (i10 < this.f9647d && !m5Var.e()) {
                m5Var.accept(this.f9646c[i10]);
                i10++;
            }
        }
        m5Var.end();
        this.f9646c = null;
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        int[] iArr = this.f9646c;
        int i11 = this.f9647d;
        this.f9647d = i11 + 1;
        iArr[i11] = i10;
    }
}
