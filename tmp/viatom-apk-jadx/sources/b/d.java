package b;

import com.inmobi.cmp.ChoiceCmp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f778b;

    /* renamed from: c, reason: collision with root package name */
    public int f779c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ChoiceCmp choiceCmp, w6.c cVar) {
        super(cVar);
        this.f778b = choiceCmp;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f777a = obj;
        this.f779c |= Integer.MIN_VALUE;
        return this.f778b.c(this);
    }
}
