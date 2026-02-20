package l4;

import com.uptodown.activities.AppInstalledDetailsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10477a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f10478b;

    /* renamed from: c, reason: collision with root package name */
    public int f10479c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(AppInstalledDetailsActivity appInstalledDetailsActivity, y6.c cVar) {
        super(cVar);
        this.f10478b = appInstalledDetailsActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10477a = obj;
        this.f10479c |= Integer.MIN_VALUE;
        return AppInstalledDetailsActivity.B0(this.f10478b, this);
    }
}
