package kotlin.jvm.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q extends t implements m7.j {
    @Override // kotlin.jvm.internal.d
    public m7.b computeReflected() {
        y.f10139a.getClass();
        return this;
    }

    @Override // m7.j
    public Object getDelegate(Object obj) {
        return ((m7.j) getReflected()).getDelegate(obj);
    }

    @Override // m7.j
    /* renamed from: getGetter */
    public m7.i mo246getGetter() {
        ((m7.j) getReflected()).mo246getGetter();
        return null;
    }

    @Override // g7.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public /* bridge */ /* synthetic */ m7.h getGetter() {
        mo246getGetter();
        return null;
    }
}
