package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f13902b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.d f13903c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.a f13904d;
    public final RelativeLayout e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f13905i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13906j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13907k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f13908l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f13909m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f13910n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f13911o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f13912p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f13913q;

    /* JADX WARN: Illegal instructions before constructor call */
    public j1(View view, g5.c cVar, g5.d dVar, g5.a aVar) {
        cVar.getClass();
        dVar.getClass();
        aVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f13902b = cVar;
        this.f13903c = dVar;
        this.f13904d = aVar;
        View viewFindViewById = view.findViewById(R.id.rl_app_info_top_by_cat_item);
        viewFindViewById.getClass();
        this.e = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_logo_app_info_top_by_cat_item);
        viewFindViewById2.getClass();
        this.f = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_name_app_info_top_by_cat_item);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        this.g = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_number_app_info_top_by_cat_item);
        this.h = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_desc_app_info_top_by_cat_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.f13905i = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_action_app_info_top_by_cat_info_item);
        viewFindViewById5.getClass();
        TextView textView4 = (TextView) viewFindViewById5;
        this.f13906j = textView4;
        TextView textView5 = (TextView) view.findViewById(R.id.tv_valoration_app_info_top_by_cat_info_item);
        this.f13907k = textView5;
        TextView textView6 = (TextView) view.findViewById(R.id.tv_downloads_counter_app_info_top_by_cat_info_item);
        this.f13908l = textView6;
        this.f13909m = (LinearLayout) view.findViewById(R.id.ll_info_app_info_top_by_cat_info_item);
        View viewFindViewById6 = view.findViewById(R.id.ll_download_app_info_top_by_cat_info_item);
        viewFindViewById6.getClass();
        this.f13910n = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.tv_progress_app_info_top_by_cat_info_item);
        viewFindViewById7.getClass();
        TextView textView7 = (TextView) viewFindViewById7;
        this.f13911o = textView7;
        View viewFindViewById8 = view.findViewById(R.id.pb_progress_app_info_top_by_cat_item);
        viewFindViewById8.getClass();
        this.f13912p = (ProgressBar) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.tv_verified_app_info_top_by_cat_info_item);
        viewFindViewById9.getClass();
        TextView textView8 = (TextView) viewFindViewById9;
        TextView textView9 = (TextView) view.findViewById(R.id.tv_badge_promoted);
        this.f13913q = (ImageView) view.findViewById(R.id.iv_alternative_compare);
        textView.setTypeface(o4.b.f11719r);
        if (textView2 != null) {
            textView2.setTypeface(o4.b.f11719r);
        }
        if (textView5 != null) {
            textView5.setTypeface(o4.b.f11720s);
        }
        if (textView6 != null) {
            textView6.setTypeface(o4.b.f11720s);
        }
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11719r);
        textView8.setTypeface(o4.b.f11720s);
        textView7.setTypeface(o4.b.f11720s);
        if (textView9 != null) {
            textView9.setTypeface(o4.b.f11720s);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(h5.h r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.j1.g(h5.h, int, int):void");
    }

    public final void h(h5.h hVar, int i10) {
        a.a.x(this.f13912p, this.f);
        i1 i1Var = new i1(this, hVar, i10, 3);
        TextView textView = this.f13906j;
        textView.setOnClickListener(i1Var);
        this.f13910n.setVisibility(8);
        this.f13905i.setVisibility(0);
        textView.setVisibility(0);
    }

    public final void i(h5.q qVar, h5.h hVar, int i10) {
        ImageView imageView = this.f;
        ProgressBar progressBar = this.f13912p;
        a.a.P(progressBar, imageView);
        LinearLayout linearLayout = this.f13909m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.f13906j;
        textView.setText(R.string.option_button_cancel);
        textView.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_stroke_blue_primary));
        textView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.blue_primary));
        textView.setOnClickListener(new i1(this, hVar, i10, 2));
        this.f13905i.setVisibility(8);
        this.f13910n.setVisibility(0);
        int i11 = qVar.i();
        TextView textView2 = this.f13911o;
        if (i11 == 0) {
            textView2.setText(this.itemView.getContext().getString(R.string.status_download_update_pending));
            progressBar.setIndeterminate(true);
            return;
        }
        progressBar.setIndeterminate(false);
        Context context = this.itemView.getContext();
        Integer numValueOf = Integer.valueOf(qVar.i());
        long jK = qVar.k();
        Context context2 = this.itemView.getContext();
        context2.getClass();
        textView2.setText(context.getString(R.string.percent_of_total_size, numValueOf, l1.b.M(context2, jK)));
        progressBar.setProgress(qVar.i());
    }

    public final void j() {
        ImageView imageView = this.f;
        ProgressBar progressBar = this.f13912p;
        a.a.P(progressBar, imageView);
        LinearLayout linearLayout = this.f13909m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f13906j.setVisibility(8);
        this.f13905i.setVisibility(8);
        this.f13910n.setVisibility(0);
        this.f13911o.setText(this.itemView.getContext().getString(R.string.installing));
        progressBar.setIndeterminate(true);
    }
}
