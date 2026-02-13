package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7404a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7405b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f7406c;

    /* renamed from: d, reason: collision with root package name */
    public final View f7407d;
    public final RecyclerView e;
    public final Toolbar f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f7408i;

    public y0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f7404a = relativeLayout;
        this.f7405b = imageView;
        this.f7406c = imageView2;
        this.f7407d = view;
        this.e = recyclerView;
        this.f = toolbar;
        this.g = textView;
        this.h = textView2;
        this.f7408i = textView3;
    }

    public static y0 a(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.top_by_category_fragment, (ViewGroup) null, false);
        int i10 = R.id.iv_fav_top_by_cat;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_fav_top_by_cat);
        if (imageView != null) {
            i10 = R.id.iv_share_top_by_cat;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_share_top_by_cat);
            if (imageView2 != null) {
                i10 = R.id.loading_view_top_by_cat_fragment;
                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_top_by_cat_fragment);
                if (viewFindChildViewById != null) {
                    i10 = R.id.recyclerview_top_cat;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.recyclerview_top_cat);
                    if (recyclerView != null) {
                        i10 = R.id.toolbar_top_by_cat;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_top_by_cat);
                        if (toolbar != null) {
                            i10 = R.id.tv_no_data_top_cat;
                            TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_data_top_cat);
                            if (textView != null) {
                                i10 = R.id.tv_reload_top_by_category_fragment;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_reload_top_by_category_fragment);
                                if (textView2 != null) {
                                    i10 = R.id.tv_toolbar_title_top_by_cat;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_top_by_cat);
                                    if (textView3 != null) {
                                        return new y0((RelativeLayout) viewInflate, imageView, imageView2, viewFindChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i10)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7404a;
    }
}
