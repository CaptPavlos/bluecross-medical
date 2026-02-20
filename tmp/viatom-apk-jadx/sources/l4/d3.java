package l4;

import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d3 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.x f10319a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10320b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10321c;

    /* renamed from: d, reason: collision with root package name */
    public int f10322d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(MoreInfo moreInfo, y6.c cVar) {
        super(cVar);
        this.f10321c = moreInfo;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10320b = obj;
        this.f10322d |= Integer.MIN_VALUE;
        return MoreInfo.n0(this.f10321c, this);
    }
}
