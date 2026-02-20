package l4;

import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f3 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.v f10386a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10387b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10388c;

    /* renamed from: d, reason: collision with root package name */
    public int f10389d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f3(MoreInfo moreInfo, y6.c cVar) {
        super(cVar);
        this.f10388c = moreInfo;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10387b = obj;
        this.f10389d |= Integer.MIN_VALUE;
        return MoreInfo.o0(this.f10388c, this);
    }
}
