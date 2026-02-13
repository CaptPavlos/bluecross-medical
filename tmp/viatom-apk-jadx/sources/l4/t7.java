package l4;

import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t7 extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10849a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f10850b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t7(RepliesActivity repliesActivity, int i10) {
        super(0);
        this.f10849a = i10;
        this.f10850b = repliesActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10849a) {
            case 0:
                return this.f10850b.getViewModelStore();
            default:
                return this.f10850b.getDefaultViewModelCreationExtras();
        }
    }
}
