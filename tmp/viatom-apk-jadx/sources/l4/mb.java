package l4;

import com.uptodown.activities.UserDevicesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class mb extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10636a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f10637b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mb(UserDevicesActivity userDevicesActivity, int i10) {
        super(0);
        this.f10636a = i10;
        this.f10637b = userDevicesActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10636a) {
            case 0:
                return this.f10637b.getViewModelStore();
            default:
                return this.f10637b.getDefaultViewModelCreationExtras();
        }
    }
}
