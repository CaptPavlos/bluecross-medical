package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class m6 extends a6 {

    /* renamed from: d, reason: collision with root package name */
    public Object[] f9671d;
    public int e;

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
        } else {
            this.f9671d = new Object[(int) j10];
        }
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void end() {
        int i10 = 0;
        Arrays.sort(this.f9671d, 0, this.e, this.f9514b);
        long j10 = this.e;
        m5 m5Var = this.f9607a;
        m5Var.c(j10);
        if (!this.f9515c) {
            while (i10 < this.e) {
                m5Var.accept((m5) this.f9671d[i10]);
                i10++;
            }
        } else {
            while (i10 < this.e && !m5Var.e()) {
                m5Var.accept((m5) this.f9671d[i10]);
                i10++;
            }
        }
        m5Var.end();
        this.f9671d = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.f9671d;
        int i10 = this.e;
        this.e = i10 + 1;
        objArr[i10] = obj;
    }
}
