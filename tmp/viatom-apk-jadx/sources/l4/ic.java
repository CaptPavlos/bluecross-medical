package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class ic implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10507a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WishlistActivity f10508b;

    public /* synthetic */ ic(WishlistActivity wishlistActivity, int i10) {
        this.f10507a = i10;
        this.f10508b = wishlistActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f10507a;
        s6.w wVar = s6.w.f12711a;
        WishlistActivity wishlistActivity = this.f10508b;
        switch (i10) {
            case 0:
                int i11 = WishlistActivity.Z;
                View viewInflate = wishlistActivity.getLayoutInflater().inflate(R.layout.wishlist_activity, (ViewGroup) null, false);
                int i12 = R.id.loading_view_wishlist;
                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_wishlist);
                if (viewFindChildViewById != null) {
                    i12 = R.id.rv_wishlist;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_wishlist);
                    if (recyclerView != null) {
                        i12 = R.id.toolbar_wishlist;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_wishlist);
                        if (toolbar != null) {
                            i12 = R.id.tv_explore_wishlist;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_explore_wishlist);
                            if (textView != null) {
                                i12 = R.id.tv_no_items_wishlist;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_items_wishlist);
                                if (textView2 != null) {
                                    i12 = R.id.tv_title_wishlist;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_wishlist);
                                    if (textView3 != null) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
                break;
            case 1:
                int i13 = WishlistActivity.Z;
                Intent intent = new Intent(wishlistActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = wishlistActivity.Y;
                float f = UptodownApp.E;
                activityResultLauncher.launch(intent, k4.c.b(wishlistActivity));
                AlertDialog alertDialog = wishlistActivity.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i14 = WishlistActivity.Z;
                wishlistActivity.finish();
                break;
        }
        return wVar;
    }
}
