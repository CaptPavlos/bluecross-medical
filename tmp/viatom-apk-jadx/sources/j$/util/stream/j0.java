package j$.util.stream;

/* loaded from: classes2.dex */
public final class j0 extends k0 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f9616c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f9617d;

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f9635a) {
            return new j$.util.b0(this.f9636b);
        }
        return null;
    }

    static {
        a7 a7Var = a7.REFERENCE;
        q qVar = new q(13);
        q qVar2 = new q(14);
        j$.util.b0 b0Var = j$.util.b0.f9349b;
        f9616c = new f0(true, a7Var, b0Var, qVar, qVar2);
        f9617d = new f0(false, a7Var, b0Var, new q(13), new q(14));
    }
}
