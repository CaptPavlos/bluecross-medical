package l4;

import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class w4 implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10950b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10951c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10952d;

    public /* synthetic */ w4(File file, NotificationsRegistryActivity notificationsRegistryActivity, int i10) {
        this.f10949a = 0;
        this.f10951c = file;
        this.f10952d = notificationsRegistryActivity;
        this.f10950b = i10;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f10949a;
        s6.w wVar = s6.w.f12711a;
        Object obj = this.f10952d;
        int i11 = this.f10950b;
        Object obj2 = this.f10951c;
        switch (i10) {
            case 0:
                File file = (File) obj2;
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj;
                int i12 = NotificationsRegistryActivity.M;
                if (file.delete()) {
                    String string = notificationsRegistryActivity.getString(R.string.snackbar_message_apk_deleted, file.getName());
                    string.getClass();
                    notificationsRegistryActivity.C(string);
                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new b.n(notificationsRegistryActivity, i11, (w6.c) null), 3);
                    break;
                }
                break;
            case 1:
                RecommendedActivity recommendedActivity = (RecommendedActivity) obj2;
                h5.i1 i1Var = (h5.i1) obj;
                int i13 = RecommendedActivity.Z;
                f7 f7Var = new f7(recommendedActivity, i11);
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    r7.y.q(LifecycleOwnerKt.getLifecycleScope(recommendedActivity), null, null, new b9.p(recommendedActivity, i1Var, f7Var, (w6.c) null, 13), 3);
                    break;
                }
                break;
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) obj2;
                h5.i1 i1Var2 = (h5.i1) obj;
                int i14 = WishlistActivity.Z;
                kc kcVar = new kc(wishlistActivity, i11);
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    r7.y.q(LifecycleOwnerKt.getLifecycleScope(wishlistActivity), null, null, new b9.p(wishlistActivity, i1Var2, kcVar, (w6.c) null, 21), 3);
                    break;
                }
                break;
        }
        return wVar;
    }

    public /* synthetic */ w4(a4 a4Var, int i10, h5.i1 i1Var, int i11) {
        this.f10949a = i11;
        this.f10951c = a4Var;
        this.f10950b = i10;
        this.f10952d = i1Var;
    }
}
