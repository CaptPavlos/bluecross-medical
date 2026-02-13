package u7;

import l4.xb;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public xb f13052a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13053b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f13054c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ xb f13055d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(xb xbVar, w6.c cVar) {
        super(cVar);
        this.f13055d = xbVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13054c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.f13055d.emit(null, this);
    }
}
