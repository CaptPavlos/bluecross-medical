package b;

import com.inmobi.cmp.ChoiceCmp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class e extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f780a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f781b;

    /* renamed from: c, reason: collision with root package name */
    public int f782c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ChoiceCmp choiceCmp, w6.c cVar) {
        super(cVar);
        this.f781b = choiceCmp;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f780a = obj;
        this.f782c |= Integer.MIN_VALUE;
        return this.f781b.d(this);
    }
}
