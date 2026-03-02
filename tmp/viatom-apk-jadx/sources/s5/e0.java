package s5;

import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TvOldVersionsFragment f12624b;

    /* renamed from: c, reason: collision with root package name */
    public int f12625c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(TvOldVersionsFragment tvOldVersionsFragment, y6.c cVar) {
        super(cVar);
        this.f12624b = tvOldVersionsFragment;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12623a = obj;
        this.f12625c |= Integer.MIN_VALUE;
        return TvOldVersionsFragment.b(this.f12624b, this);
    }
}
