package j$.util.stream;

/* loaded from: classes2.dex */
public abstract class c5 extends e5 {
    @Override // j$.util.stream.a
    public final boolean L() {
        return true;
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new a5(this, z6.f9828r);
    }
}
