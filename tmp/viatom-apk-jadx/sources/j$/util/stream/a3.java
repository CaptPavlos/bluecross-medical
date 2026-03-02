package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public abstract class a3 implements h2 {
    @Override // j$.util.stream.h2
    public final long count() {
        return 0L;
    }

    public final void g(Object obj) {
    }

    @Override // j$.util.stream.h2
    public /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.w(this, j10, j11, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public h2 a(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    public final void f(int i10, Object obj) {
    }
}
