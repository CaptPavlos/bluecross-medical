package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v9 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.u f10923a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10924b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y9 f10925c;

    /* renamed from: d, reason: collision with root package name */
    public int f10926d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v9(y9 y9Var, y6.c cVar) {
        super(cVar);
        this.f10925c = y9Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10924b = obj;
        this.f10926d |= Integer.MIN_VALUE;
        return y9.a(this.f10925c, null, null, false, this);
    }
}
