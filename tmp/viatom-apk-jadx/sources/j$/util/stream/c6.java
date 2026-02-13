package j$.util.stream;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c6 extends y5 {

    /* renamed from: c, reason: collision with root package name */
    public r6 f9545c;

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j10) {
        r6 r6Var;
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return;
        }
        if (j10 <= 0) {
            r6Var = new r6();
        } else {
            r6Var = new r6((int) j10);
        }
        this.f9545c = r6Var;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void end() {
        int[] iArr = (int[]) this.f9545c.b();
        Arrays.sort(iArr);
        long length = iArr.length;
        m5 m5Var = this.f9586a;
        m5Var.c(length);
        int i10 = 0;
        if (!this.f9808b) {
            int length2 = iArr.length;
            while (i10 < length2) {
                m5Var.accept(iArr[i10]);
                i10++;
            }
        } else {
            int length3 = iArr.length;
            while (i10 < length3) {
                int i11 = iArr[i10];
                if (m5Var.e()) {
                    break;
                }
                m5Var.accept(i11);
                i10++;
            }
        }
        m5Var.end();
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        this.f9545c.accept(i10);
    }
}
