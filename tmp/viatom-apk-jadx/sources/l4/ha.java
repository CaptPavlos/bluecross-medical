package l4;

import com.uptodown.activities.UserActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ha extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10466a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f10467b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ha(UserActivity userActivity, int i10) {
        super(0);
        this.f10466a = i10;
        this.f10467b = userActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10466a) {
            case 0:
                return this.f10467b.getViewModelStore();
            case 1:
                return this.f10467b.getDefaultViewModelCreationExtras();
            case 2:
                return this.f10467b.getViewModelStore();
            default:
                return this.f10467b.getDefaultViewModelCreationExtras();
        }
    }
}
