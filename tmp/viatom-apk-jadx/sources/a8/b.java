package a8;

import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f302b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f301a = i10;
        this.f302b = obj;
    }

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f301a) {
            case 0:
                break;
            case 1:
                ((n) this.f302b).b();
                break;
            default:
                ((d) this.f302b).invoke((Throwable) obj);
                break;
        }
        return w.f12711a;
    }
}
