package r7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c1 extends i1 implements n {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12392c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(a1 a1Var) {
        super(true);
        boolean z9 = true;
        L(a1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i1.f12409b;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        k kVar = jVar instanceof k ? (k) jVar : null;
        if (kVar == null) {
            z9 = false;
            break;
        }
        i1 i1VarH = kVar.h();
        while (!i1VarH.G()) {
            j jVar2 = (j) atomicReferenceFieldUpdater.get(i1VarH);
            k kVar2 = jVar2 instanceof k ? (k) jVar2 : null;
            if (kVar2 == null) {
                z9 = false;
                break;
            }
            i1VarH = kVar2.h();
        }
        this.f12392c = z9;
    }

    @Override // r7.i1
    public final boolean G() {
        return this.f12392c;
    }

    @Override // r7.i1
    public final boolean H() {
        return true;
    }
}
