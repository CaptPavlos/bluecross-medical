package c5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.x f1719a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1720b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w2.r f1721c;

    /* renamed from: d, reason: collision with root package name */
    public int f1722d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(w2.r rVar, y6.c cVar) {
        super(cVar);
        this.f1721c = rVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f1720b = obj;
        this.f1722d |= Integer.MIN_VALUE;
        return this.f1721c.G(this);
    }
}
