package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class q3 extends s3 implements l5 {
    public final long[] h;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    public q3(Spliterator spliterator, a aVar, long[] jArr) {
        super(spliterator, aVar, jArr.length);
        this.h = jArr;
    }

    public q3(q3 q3Var, Spliterator spliterator, long j10, long j11) {
        super(q3Var, spliterator, j10, j11, q3Var.h.length);
        this.h = q3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j10, long j11) {
        return new q3(this, spliterator, j10, j11);
    }

    @Override // j$.util.stream.s3, j$.util.stream.m5
    public final void accept(long j10) {
        int i10 = this.f;
        if (i10 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i10));
        }
        long[] jArr = this.h;
        this.f = i10 + 1;
        jArr[i10] = j10;
    }
}
