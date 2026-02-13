package l4;

import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x6 extends kotlin.jvm.internal.m implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10991a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10992b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x6(PublicProfileActivity publicProfileActivity, int i10) {
        super(0);
        this.f10991a = i10;
        this.f10992b = publicProfileActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f10991a) {
            case 0:
                return this.f10992b.getViewModelStore();
            default:
                return this.f10992b.getDefaultViewModelCreationExtras();
        }
    }
}
