package j$.util.stream;

import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final class p1 extends t1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u1 f9702c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Predicate f9703d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(u1 u1Var, Predicate predicate) {
        super(u1Var);
        this.f9702c = u1Var;
        this.f9703d = predicate;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (this.f9744a) {
            return;
        }
        boolean zTest = this.f9703d.test(obj);
        u1 u1Var = this.f9702c;
        if (zTest == u1Var.f9761a) {
            this.f9744a = true;
            this.f9745b = u1Var.f9762b;
        }
    }
}
