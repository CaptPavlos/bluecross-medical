package l4;

import com.uptodown.R;
import com.uptodown.activities.WishlistActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class kc implements g5.u, g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WishlistActivity f10576a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10577b;

    public /* synthetic */ kc(WishlistActivity wishlistActivity, int i10) {
        this.f10576a = wishlistActivity;
        this.f10577b = i10;
    }

    @Override // g5.u
    public void M() {
        ArrayList arrayList;
        WishlistActivity wishlistActivity = this.f10576a;
        n4.d1 d1Var = wishlistActivity.W;
        int i10 = this.f10577b;
        if (d1Var != null && (arrayList = d1Var.f11324a) != null) {
        }
        n4.d1 d1Var2 = wishlistActivity.W;
        if (d1Var2 != null) {
            d1Var2.notifyItemRemoved(i10);
        }
    }

    @Override // g5.i
    public void f(int i10) {
        String str;
        WishlistActivity wishlistActivity = this.f10576a;
        n4.d1 d1Var = wishlistActivity.W;
        d1Var.getClass();
        Object obj = d1Var.f11324a.get(this.f10577b);
        obj.getClass();
        h5.i1 i1Var = (h5.i1) obj;
        if (i1Var.f == 13 || (str = i1Var.f8620i) == null || str.length() == 0) {
            String string = wishlistActivity.getString(R.string.error_cant_enqueue_download);
            string.getClass();
            wishlistActivity.C(string);
        } else {
            String str2 = i1Var.f8620i;
            str2.getClass();
            v5.c.e(wishlistActivity, str2, null);
        }
    }

    @Override // g5.v
    public void i() {
        WishlistActivity wishlistActivity = this.f10576a;
        String string = wishlistActivity.getString(R.string.error_generico);
        string.getClass();
        wishlistActivity.C(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        WishlistActivity wishlistActivity = this.f10576a;
        l1.b.h(wishlistActivity, wishlistActivity, hVar, new n5(wishlistActivity, 13), true);
    }
}
