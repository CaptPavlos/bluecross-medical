package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class o3 extends s3 implements j5 {
    public final double[] h;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        w3.d(this, d8);
    }

    public o3(Spliterator spliterator, a aVar, double[] dArr) {
        super(spliterator, aVar, dArr.length);
        this.h = dArr;
    }

    public o3(o3 o3Var, Spliterator spliterator, long j10, long j11) {
        super(o3Var, spliterator, j10, j11, o3Var.h.length);
        this.h = o3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j10, long j11) {
        return new o3(this, spliterator, j10, j11);
    }

    @Override // j$.util.stream.s3, j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        int i10 = this.f;
        if (i10 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i10));
        }
        double[] dArr = this.h;
        this.f = i10 + 1;
        dArr[i10] = d8;
    }
}
