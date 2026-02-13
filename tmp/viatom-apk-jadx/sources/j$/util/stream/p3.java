package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class p3 extends s3 implements k5 {
    public final int[] h;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    public p3(Spliterator spliterator, a aVar, int[] iArr) {
        super(spliterator, aVar, iArr.length);
        this.h = iArr;
    }

    public p3(p3 p3Var, Spliterator spliterator, long j10, long j11) {
        super(p3Var, spliterator, j10, j11, p3Var.h.length);
        this.h = p3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j10, long j11) {
        return new p3(this, spliterator, j10, j11);
    }

    @Override // j$.util.stream.s3, j$.util.stream.m5
    public final void accept(int i10) {
        int i11 = this.f;
        if (i11 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i11));
        }
        int[] iArr = this.h;
        this.f = i11 + 1;
        iArr[i11] = i10;
    }
}
