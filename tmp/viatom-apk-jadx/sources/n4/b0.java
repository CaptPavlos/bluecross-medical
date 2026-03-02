package n4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.views.FullWidthImageView;
import java.util.ArrayList;
import l4.f5;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public n5 f11303a;

    /* renamed from: b, reason: collision with root package name */
    public String f11304b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11305c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11306d;

    public final void a(boolean z9) {
        this.f11306d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11305c.size() + (this.f11306d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        if (i10 == this.f11305c.size()) {
            return 6;
        }
        return ((t) this.f11305c.get(i10)).f11485b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (!(viewHolder instanceof x)) {
            if (viewHolder instanceof a0) {
                ArrayList arrayList = (ArrayList) ((t) this.f11305c.get(i10)).a();
                z zVar = ((a0) viewHolder).f11295b;
                zVar.getClass();
                zVar.f11522c = arrayList;
                zVar.notifyDataSetChanged();
                return;
            }
            if (viewHolder instanceof w) {
                ArrayList arrayList2 = (ArrayList) ((t) this.f11305c.get(i10)).a();
                v vVar = ((w) viewHolder).f11501b;
                vVar.getClass();
                vVar.f11499c = arrayList2;
                vVar.notifyDataSetChanged();
                return;
            }
            if (viewHolder instanceof y5.k1) {
                ((y5.k1) viewHolder).g((h5.h) ((t) this.f11305c.get(i10)).a(), i10);
                return;
            } else {
                if (viewHolder instanceof y5.f1) {
                    ((y5.f1) viewHolder).a();
                    return;
                }
                return;
            }
        }
        x xVar = (x) viewHolder;
        h5.h hVar = (h5.h) ((t) this.f11305c.get(i10)).a();
        Context context = xVar.f11509d;
        d5.g gVar = xVar.f11507b;
        String strE = hVar.e();
        PackageInfo packageInfoF = null;
        if (strE == null || strE.length() == 0) {
            ((FullWidthImageView) gVar.f7054i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.shape_bg_placeholder));
        } else {
            j4.d0 d0VarE = j4.y.d().e(hVar.e());
            float f = UptodownApp.E;
            d0VarE.g(k4.c.x(context));
            d0VarE.e((FullWidthImageView) gVar.f7054i, null);
        }
        View view = xVar.itemView;
        view.getClass();
        y5.f.b(view, xVar.f11508c, hVar);
        TextView textView = (TextView) gVar.f7056k;
        ImageView imageView = gVar.f7052c;
        TextView textView2 = gVar.f;
        y5.f.f(hVar, textView, textView2);
        ((TextView) gVar.f7059n).setText(String.valueOf(hVar.f8582p / 10.0d));
        gVar.h.setText(context.getString(R.string.downloads_counter_multiple, l1.b.G(hVar.f8570i)));
        xVar.e(imageView, hVar.i());
        String str = hVar.f8595w;
        if (str != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfoF = l5.a.f(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        TextView textView3 = gVar.g;
        if (packageInfoF != null) {
            textView3.setVisibility(8);
        } else {
            textView3.setOnClickListener(new f5(13, xVar, hVar));
        }
        xVar.c(hVar, (ProgressBar) gVar.f7055j, imageView, textView2, gVar.e, (TextView) gVar.f7057l, gVar.f7053d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        n5 n5Var = this.f11303a;
        viewGroup.getClass();
        boolean z9 = false;
        switch (i10) {
            case 1:
                View viewB = c.i.b(viewGroup, R.layout.organization_main_app_card, viewGroup, false);
                int i11 = R.id.iv_top_app_feature_organization;
                FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(viewB, R.id.iv_top_app_feature_organization);
                if (fullWidthImageView != null) {
                    i11 = R.id.iv_top_app_logo_organization;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewB, R.id.iv_top_app_logo_organization);
                    if (imageView != null) {
                        i11 = R.id.ll_progress_top_organization;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewB, R.id.ll_progress_top_organization);
                        if (linearLayout != null) {
                            i11 = R.id.ll_top_app_desc_organization;
                            if (((LinearLayout) ViewBindings.findChildViewById(viewB, R.id.ll_top_app_desc_organization)) != null) {
                                i11 = R.id.pb_progress_logo_organization;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(viewB, R.id.pb_progress_logo_organization);
                                if (progressBar != null) {
                                    i11 = R.id.rl_logo_organization;
                                    if (((RelativeLayout) ViewBindings.findChildViewById(viewB, R.id.rl_logo_organization)) != null) {
                                        i11 = R.id.tv_progress_top_organization;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_progress_top_organization);
                                        if (textView != null) {
                                            i11 = R.id.tv_top_app_desc_organization;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_desc_organization);
                                            if (textView2 != null) {
                                                i11 = R.id.tv_top_app_download_organization;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_download_organization);
                                                if (textView3 != null) {
                                                    i11 = R.id.tv_top_app_downloads_counter_organization;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_downloads_counter_organization);
                                                    if (textView4 != null) {
                                                        i11 = R.id.tv_top_app_name_organization;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_name_organization);
                                                        if (textView5 != null) {
                                                            i11 = R.id.tv_top_app_status_organization;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_status_organization);
                                                            if (textView6 != null) {
                                                                i11 = R.id.tv_top_app_title_organization;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_title_organization);
                                                                if (textView7 != null) {
                                                                    i11 = R.id.tv_top_app_valoration_organization;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_app_valoration_organization);
                                                                    if (textView8 != null) {
                                                                        i11 = R.id.tv_verified_top_organization;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_verified_top_organization);
                                                                        if (textView9 != null) {
                                                                            d5.g gVar = new d5.g((RelativeLayout) viewB, fullWidthImageView, imageView, linearLayout, progressBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                                                            Context context = viewGroup.getContext();
                                                                            context.getClass();
                                                                            return new x(gVar, n5Var, context);
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
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB.getResources().getResourceName(i11)));
                return null;
            case 2:
                View viewB2 = c.i.b(viewGroup, R.layout.organization_top_download_rv, viewGroup, false);
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewB2, R.id.rv_top_downloads_organization);
                if (recyclerView == null) {
                    androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB2.getResources().getResourceName(R.id.rv_top_downloads_organization)));
                    return null;
                }
                a4.f fVar = new a4.f((LinearLayout) viewB2, recyclerView, 12, z9);
                Context context2 = viewGroup.getContext();
                context2.getClass();
                return new a0(this, fVar, n5Var, context2);
            case 3:
                View viewB3 = c.i.b(viewGroup, R.layout.organization_carousel_apps_rv, viewGroup, false);
                int i12 = R.id.rv_most_popular_apps_organization;
                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewB3, R.id.rv_most_popular_apps_organization);
                if (recyclerView2 != null) {
                    i12 = R.id.tv_most_popular_apps_organization;
                    TextView textView10 = (TextView) ViewBindings.findChildViewById(viewB3, R.id.tv_most_popular_apps_organization);
                    if (textView10 != null) {
                        a3.x xVar = new a3.x((LinearLayout) viewB3, recyclerView2, textView10, 17);
                        n5 n5Var2 = this.f11303a;
                        Context context3 = viewGroup.getContext();
                        context3.getClass();
                        return new w(this, xVar, n5Var2, context3, this.f11304b);
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB3.getResources().getResourceName(i12)));
                return null;
            case 4:
                View viewB4 = c.i.b(viewGroup, R.layout.title_organization_apps, viewGroup, false);
                viewB4.getClass();
                String string = viewGroup.getContext().getString(R.string.organization_more_apps_title, this.f11304b);
                string.getClass();
                return new y5.f1(viewB4, string);
            case 5:
                View viewB5 = c.i.b(viewGroup, R.layout.app_info_vertical_top_item, viewGroup, false);
                viewB5.getClass();
                return new y5.k1(viewB5, n5Var, null);
            case 6:
                View viewB6 = c.i.b(viewGroup, R.layout.pb_loading_more_content, viewGroup, false);
                viewB6.getClass();
                return new y5.h0(viewB6);
            default:
                com.google.gson.internal.a.n("viewType unknown");
                return null;
        }
    }
}
