package n4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11426a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f11427b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.d f11428c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11429d;

    public l0(ArrayList arrayList, g5.c cVar, g5.d dVar) {
        cVar.getClass();
        dVar.getClass();
        this.f11426a = arrayList;
        this.f11427b = cVar;
        this.f11428c = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11426a.size() + (this.f11429d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11426a.size() ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0122  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r20, final int r21) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.l0.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 != 0) {
            if (i10 != 1) {
                com.google.gson.internal.a.n("viewType unknown");
                return null;
            }
            View viewB = c.i.b(viewGroup, R.layout.pb_loading_more_content, viewGroup, false);
            viewB.getClass();
            return new y5.h0(viewB);
        }
        View viewB2 = c.i.b(viewGroup, R.layout.search_app_info_item, null, false);
        int i11 = R.id.iv_cancel_search_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewB2, R.id.iv_cancel_search_item);
        if (imageView != null) {
            i11 = R.id.iv_icon_search_app_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewB2, R.id.iv_icon_search_app_item);
            if (imageView2 != null) {
                i11 = R.id.pb_progress_search_app_item;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewB2, R.id.pb_progress_search_app_item);
                if (progressBar != null) {
                    i11 = R.id.rl_actions_search_item;
                    if (((RelativeLayout) ViewBindings.findChildViewById(viewB2, R.id.rl_actions_search_item)) != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewB2;
                        i11 = R.id.rl_cancel_search_item;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewB2, R.id.rl_cancel_search_item);
                        if (relativeLayout2 != null) {
                            i11 = R.id.rl_icon_progress_search_app_item;
                            if (((RelativeLayout) ViewBindings.findChildViewById(viewB2, R.id.rl_icon_progress_search_app_item)) != null) {
                                i11 = R.id.tv_action_search_item;
                                TextView textView = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_action_search_item);
                                if (textView != null) {
                                    i11 = R.id.tv_desc_search_app_item;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_desc_search_app_item);
                                    if (textView2 != null) {
                                        i11 = R.id.tv_name_search_app_item;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_name_search_app_item);
                                        if (textView3 != null) {
                                            i11 = R.id.tv_pending_search_item;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_pending_search_item);
                                            if (textView4 != null) {
                                                i11 = R.id.tv_status_search_app_item;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_status_search_app_item);
                                                if (textView5 != null) {
                                                    i11 = R.id.tv_verified_by_uptodown_search_app_item;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(viewB2, R.id.tv_verified_by_uptodown_search_app_item);
                                                    if (textView6 != null) {
                                                        return new y5.e1(new d5.w0(relativeLayout, imageView, imageView2, progressBar, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6), this.f11427b, this.f11428c);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB2.getResources().getResourceName(i11)));
        return null;
    }
}
