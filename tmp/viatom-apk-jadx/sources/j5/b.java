package j5;

import c5.b0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public b0 f10021a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10022b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f10023c;

    /* renamed from: d, reason: collision with root package name */
    public int f10024d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, y6.c cVar) {
        super(cVar);
        this.f10023c = aVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10022b = obj;
        this.f10024d |= Integer.MIN_VALUE;
        return a.a(this.f10023c, null, null, this);
    }
}
