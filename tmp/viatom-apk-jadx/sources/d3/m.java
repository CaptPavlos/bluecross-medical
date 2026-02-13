package d3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6831a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f6832b;

    /* renamed from: c, reason: collision with root package name */
    public int f6833c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, y6.c cVar) {
        super(cVar);
        this.f6832b = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f6831a = obj;
        this.f6833c |= Integer.MIN_VALUE;
        return this.f6832b.c(null, this);
    }
}
