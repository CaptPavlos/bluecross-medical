package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public abstract class r2 extends j2 implements g2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return w3.m(this, intFunction);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        ((g2) this.f9618a).g(obj);
        ((g2) this.f9619b).g(obj);
    }

    @Override // j$.util.stream.g2
    public final void f(int i10, Object obj) {
        h2 h2Var = this.f9618a;
        ((g2) h2Var).f(i10, obj);
        ((g2) this.f9619b).f(i10 + ((int) ((g2) h2Var).count()), obj);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        long j10 = this.f9620c;
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object objNewArray = newArray((int) j10);
        f(0, objNewArray);
        return objNewArray;
    }

    public final String toString() {
        long j10 = this.f9620c;
        return j10 < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.f9618a, this.f9619b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(j10));
    }
}
