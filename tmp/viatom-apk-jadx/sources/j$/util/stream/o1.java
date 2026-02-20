package j$.util.stream;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class o1 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9691a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1 f9692b;

    public /* synthetic */ o1(u1 u1Var, int i10) {
        this.f9691a = i10;
        this.f9692b = u1Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9691a) {
            case 0:
                return new r1(this.f9692b);
            case 1:
                return new q1(this.f9692b);
            default:
                return new s1(this.f9692b);
        }
    }
}
