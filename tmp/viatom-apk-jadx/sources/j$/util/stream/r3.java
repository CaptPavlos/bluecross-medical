package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public final class r3 extends s3 {
    public final Object[] h;

    public r3(Spliterator spliterator, a aVar, Object[] objArr) {
        super(spliterator, aVar, objArr.length);
        this.h = objArr;
    }

    public r3(r3 r3Var, Spliterator spliterator, long j10, long j11) {
        super(r3Var, spliterator, j10, j11, r3Var.h.length);
        this.h = r3Var.h;
    }

    @Override // j$.util.stream.s3
    public final s3 a(Spliterator spliterator, long j10, long j11) {
        return new r3(this, spliterator, j10, j11);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i10 = this.f;
        if (i10 >= this.g) {
            throw new IndexOutOfBoundsException(Integer.toString(i10));
        }
        Object[] objArr = this.h;
        this.f = i10 + 1;
        objArr[i10] = obj;
    }
}
