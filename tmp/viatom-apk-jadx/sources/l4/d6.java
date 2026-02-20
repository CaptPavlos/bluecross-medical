package l4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d6 implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f10329b;

    public /* synthetic */ d6(PreregistrationActivity preregistrationActivity, int i10) {
        this.f10328a = i10;
        this.f10329b = preregistrationActivity;
    }

    @Override // g7.a
    public final Object invoke() {
        int i10 = this.f10328a;
        PreregistrationActivity preregistrationActivity = this.f10329b;
        switch (i10) {
            case 0:
                int i11 = PreregistrationActivity.M;
                View viewInflate = preregistrationActivity.getLayoutInflater().inflate(R.layout.preregistration_activity, (ViewGroup) null, false);
                int i12 = R.id.fl_top_by_cat_upcoming_releases;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(viewInflate, R.id.fl_top_by_cat_upcoming_releases);
                if (frameLayout != null) {
                    i12 = R.id.ll_upcoming_releases;
                    if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_upcoming_releases)) != null) {
                        i12 = R.id.loading_view_upcoming_releases;
                        View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_upcoming_releases);
                        if (viewFindChildViewById != null) {
                            i12 = R.id.nsv_upcoming_releases;
                            if (((NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.nsv_upcoming_releases)) != null) {
                                i12 = R.id.rv_upcoming_releases;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.rv_upcoming_releases);
                                if (recyclerView != null) {
                                    i12 = R.id.toolbar_upcoming_releases;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_upcoming_releases);
                                    if (toolbar != null) {
                                        i12 = R.id.tv_discover_upcoming_releases;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_discover_upcoming_releases);
                                        if (textView != null) {
                                            i12 = R.id.tv_no_items_upcoming_releases;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_items_upcoming_releases);
                                            if (textView2 != null) {
                                                i12 = R.id.tv_title_upcoming_releases;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_upcoming_releases);
                                                if (textView3 != null) {
                                                    return new d5.l0((RelativeLayout) viewInflate, frameLayout, viewFindChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i12)));
                return null;
            default:
                int i13 = PreregistrationActivity.M;
                i6 i6Var = (i6) preregistrationActivity.H.getValue();
                i6Var.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(i6Var);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.r(i6Var, true, preregistrationActivity, (w6.c) null), 2);
                return s6.w.f12711a;
        }
    }
}
