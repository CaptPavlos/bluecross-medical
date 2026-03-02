package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import y5.a2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11324a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11325b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.x f11326c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11327d;
    public int e;

    public d1(ArrayList arrayList, Context context, g5.x xVar) {
        arrayList.getClass();
        context.getClass();
        xVar.getClass();
        this.f11324a = arrayList;
        this.f11325b = context;
        this.f11326c = xVar;
        this.e = -1;
    }

    public final void a(Context context, File file) {
        file.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        Iterator it = this.f11324a.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            h5.i1 i1Var = (h5.i1) it.next();
            String str = i1Var.f8619d;
            if (str != null && str.length() != 0) {
                String str2 = i1Var.f8619d;
                str2.getClass();
                h5.y0 y0VarM = gVarL.M(str2);
                h5.q qVarA = y0VarM != null ? y0VarM.a(context) : null;
                if (qVarA != null && qVarA.f8716v.size() == 1 && o7.u.Z(((h5.r) qVarA.f8716v.get(0)).h, file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i10 = i11;
        }
        gVarL.b();
        if (i10 >= 0) {
            notifyItemChanged(i10);
        }
    }

    public final void b() {
        this.e = -1;
        notifyDataSetChanged();
    }

    public final void c(Context context, File file) {
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        Iterator it = this.f11324a.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i11 = i10 + 1;
            h5.i1 i1Var = (h5.i1) it.next();
            String str = i1Var.f8619d;
            if (str != null && str.length() != 0) {
                String str2 = i1Var.f8619d;
                str2.getClass();
                h5.y0 y0VarM = gVarL.M(str2);
                h5.q qVarA = y0VarM != null ? y0VarM.a(context) : null;
                if (qVarA != null && qVarA.f8716v.size() == 1 && o7.u.Z(((h5.r) qVarA.f8716v.get(0)).h, file.getAbsolutePath(), true)) {
                    this.e = i10;
                    break;
                }
            }
            i10 = i11;
        }
        gVarL.b();
        int i12 = this.e;
        if (i12 >= 0) {
            notifyItemChanged(i12);
        }
    }

    public final void d(boolean z9) {
        this.f11327d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11324a.size() + (this.f11327d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11324a.size() ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0254  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r20, int r21) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.d1.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
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
        Context context = this.f11325b;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_list_item, viewGroup, false);
        int i11 = R.id.hsv_floating_tags_user_list_item;
        if (((HorizontalScrollView) ViewBindings.findChildViewById(viewInflate, R.id.hsv_floating_tags_user_list_item)) != null) {
            i11 = R.id.iv_cancel_user_list_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_cancel_user_list_item);
            if (imageView != null) {
                i11 = R.id.iv_icon_platform_user_list_item;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon_platform_user_list_item);
                if (imageView2 != null) {
                    i11 = R.id.iv_icon_user_list_item;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon_user_list_item);
                    if (imageView3 != null) {
                        i11 = R.id.ll_info_user_list_item;
                        if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_info_user_list_item)) != null) {
                            i11 = R.id.ll_user_list_item_floating_categories;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_user_list_item_floating_categories);
                            if (linearLayout != null) {
                                i11 = R.id.pb_progress_user_list_item;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewInflate, R.id.pb_progress_user_list_item);
                                if (progressBar != null) {
                                    i11 = R.id.rl_actions_user_list_item;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_actions_user_list_item);
                                    if (relativeLayout != null) {
                                        i11 = R.id.rl_cancel_user_list_item;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_cancel_user_list_item);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.rl_container_user_list_item;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_user_list_item);
                                            if (relativeLayout3 != null) {
                                                i11 = R.id.rl_icon_progress_user_list_item;
                                                if (((RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_icon_progress_user_list_item)) != null) {
                                                    i11 = R.id.tv_action_user_list_item;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_action_user_list_item);
                                                    if (textView != null) {
                                                        i11 = R.id.tv_date_user_list_item;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_date_user_list_item);
                                                        if (textView2 != null) {
                                                            i11 = R.id.tv_name_user_list_item;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_name_user_list_item);
                                                            if (textView3 != null) {
                                                                i11 = R.id.tv_pending_user_list_item;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_pending_user_list_item);
                                                                if (textView4 != null) {
                                                                    i11 = R.id.user_list_item_floating_tag;
                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.user_list_item_floating_tag);
                                                                    if (viewFindChildViewById != null) {
                                                                        return new a2(new d5.h1((RelativeLayout) viewInflate, imageView, imageView2, imageView3, linearLayout, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4), context, this.f11326c);
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
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }
}
