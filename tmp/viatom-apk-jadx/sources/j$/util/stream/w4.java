package j$.util.stream;

/* loaded from: classes2.dex */
public final class w4 extends x4 {
    @Override // j$.util.stream.s4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f9802b);
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f9802b += ((x4) r4Var).f9802b;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f9802b++;
    }
}
