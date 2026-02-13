package a8;

import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h extends kotlin.jvm.internal.k implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public static final h f316a = new h(3, i.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        i iVar = (i) obj;
        iVar.getClass();
        if (!kotlin.jvm.internal.l.a(obj3, j.f318b)) {
            return iVar;
        }
        u.i(obj2, "This mutex is already locked by the specified owner: ");
        return null;
    }
}
