package l4;

import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class o6 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10689a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10690b;

    public /* synthetic */ o6(w wVar, int i10) {
        this.f10689a = i10;
        this.f10690b = wVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int i10 = this.f10689a;
        w wVar = this.f10690b;
        switch (i10) {
            case 0:
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) wVar;
                int i11 = PublicProfileActivity.K;
                int scrollY = publicProfileActivity.n0().f7251k.getScrollY();
                float dimension = publicProfileActivity.getResources().getDimension(R.dimen.public_profile_header_size) * 0.7f;
                int alphaComponent = ColorUtils.setAlphaComponent(ContextCompat.getColor(publicProfileActivity, R.color.background_color), (int) (com.google.android.gms.internal.measurement.l5.m(scrollY / dimension, 0.0f, 1.0f) * 255));
                if (scrollY >= dimension * 0.5d) {
                    publicProfileActivity.n0().f7252l.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.core_vector_back));
                } else {
                    publicProfileActivity.n0().f7252l.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, R.drawable.vector_arrow_left_white));
                }
                publicProfileActivity.n0().f7252l.setBackgroundColor(alphaComponent);
                break;
            default:
                RepliesActivity repliesActivity = (RepliesActivity) wVar;
                int i12 = RepliesActivity.L;
                if (!repliesActivity.o0().f11044r && !repliesActivity.o0().f11045s && repliesActivity.n0().f7285m.getLayoutManager() != null) {
                    RecyclerView.LayoutManager layoutManager = repliesActivity.n0().f7285m.getLayoutManager();
                    layoutManager.getClass();
                    int childCount = layoutManager.getChildCount();
                    RecyclerView.LayoutManager layoutManager2 = repliesActivity.n0().f7285m.getLayoutManager();
                    layoutManager2.getClass();
                    int itemCount = layoutManager2.getItemCount();
                    RecyclerView.LayoutManager layoutManager3 = repliesActivity.n0().f7285m.getLayoutManager();
                    layoutManager3.getClass();
                    if (((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition() + childCount >= itemCount - 10) {
                        n4.h0 h0Var = repliesActivity.J;
                        if (h0Var != null) {
                            h0Var.a(true);
                        }
                        y7 y7VarO0 = repliesActivity.o0();
                        Object value = repliesActivity.o0().f11039m.getValue();
                        value.getClass();
                        long j10 = ((h5.t0) value).f8739a;
                        n4.h0 h0Var2 = repliesActivity.J;
                        h0Var2.getClass();
                        int itemCount2 = h0Var2.getItemCount();
                        y7VarO0.getClass();
                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                        y7.e eVar = r7.i0.f12407a;
                        r7.y.q(viewModelScope, y7.d.f14116a, null, new w7(y7VarO0, repliesActivity, j10, itemCount2, null), 2);
                        break;
                    }
                }
                break;
        }
    }
}
