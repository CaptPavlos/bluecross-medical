package l4;

import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class na extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10664a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAvatarActivity f10665b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ na(UserAvatarActivity userAvatarActivity, int i10) {
        super(0);
        this.f10664a = i10;
        this.f10665b = userAvatarActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10664a) {
            case 0:
                return this.f10665b.getViewModelStore();
            default:
                return this.f10665b.getDefaultViewModelCreationExtras();
        }
    }
}
