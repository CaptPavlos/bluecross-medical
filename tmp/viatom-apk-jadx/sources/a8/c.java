package a8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f304b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f305c;

    public /* synthetic */ c(i iVar, Object obj, int i10) {
        this.f303a = i10;
        this.f304b = iVar;
        this.f305c = obj;
    }

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f303a) {
            case 0:
                this.f304b.unlock(this.f305c);
                break;
            default:
                e eVar = (e) this.f305c;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.h;
                Object obj4 = eVar.f310b;
                i iVar = this.f304b;
                atomicReferenceFieldUpdater.set(iVar, obj4);
                iVar.unlock(obj4);
                break;
        }
        return w.f12711a;
    }
}
