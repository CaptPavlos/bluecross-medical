package l4;

import com.uptodown.activities.UsernameEditActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class zb extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11080a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UsernameEditActivity f11081b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zb(UsernameEditActivity usernameEditActivity, int i10) {
        super(0);
        this.f11080a = i10;
        this.f11081b = usernameEditActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f11080a) {
            case 0:
                return this.f11081b.getViewModelStore();
            default:
                return this.f11081b.getDefaultViewModelCreationExtras();
        }
    }
}
