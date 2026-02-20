package a8;

import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g extends kotlin.jvm.internal.k implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public static final g f315a = new g(3, i.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int andDecrement;
        i iVar = (i) obj;
        f fVar = (f) obj2;
        w wVar = w.f12711a;
        if (obj3 == null) {
            iVar.getClass();
        } else if (iVar.holdsLock(obj3)) {
            fVar.b(j.f318b);
            return wVar;
        }
        fVar.getClass();
        f fVar2 = new f(iVar, fVar, obj3);
        do {
            iVar.getClass();
            do {
                andDecrement = n.g.getAndDecrement(iVar);
            } while (andDecrement > iVar.f323a);
            if (andDecrement > 0) {
                fVar2.b(wVar);
                return wVar;
            }
        } while (!iVar.a(fVar2));
        return wVar;
    }
}
