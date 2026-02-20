package g8;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class t0 extends o {

    /* renamed from: b, reason: collision with root package name */
    public final s0 f8330b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(c8.b bVar) {
        super(bVar);
        bVar.getClass();
        this.f8330b = new s0(bVar.getDescriptor());
    }

    @Override // g8.a
    public final Object a() {
        return (r0) i(l());
    }

    @Override // g8.a
    public final int b(Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        return r0Var.d();
    }

    @Override // g8.a
    public final void c(int i10, Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        r0Var.b(i10);
    }

    @Override // g8.a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // g8.a, c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        return f(eVar);
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return this.f8330b;
    }

    @Override // g8.a
    public final Object j(Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        return r0Var.a();
    }

    @Override // g8.o
    public final void k(int i10, Object obj, Object obj2) {
        ((r0) obj).getClass();
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object l();

    public abstract void m(f8.d dVar, Object obj, int i10);

    @Override // g8.o, c8.g
    public final void serialize(f8.f fVar, Object obj) {
        int iE = e(obj);
        s0 s0Var = this.f8330b;
        f8.d dVarBeginCollection = fVar.beginCollection(s0Var, iE);
        m(dVarBeginCollection, obj, iE);
        dVarBeginCollection.endStructure(s0Var);
    }
}
