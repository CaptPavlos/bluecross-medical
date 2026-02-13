package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f13925b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f13926c;

    /* renamed from: d, reason: collision with root package name */
    public final RelativeLayout f13927d;
    public final ImageView e;
    public final ProgressBar f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f13928i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13929j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13930k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f13931l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f13932m;

    /* JADX WARN: Illegal instructions before constructor call */
    public k1(View view, g5.c cVar, g5.a aVar) {
        cVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f13925b = cVar;
        this.f13926c = aVar;
        View viewFindViewById = view.findViewById(R.id.rl_app_info_top_by_cat_small_item);
        viewFindViewById.getClass();
        this.f13927d = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_logo_app_info_top_by_cat_small_item);
        viewFindViewById2.getClass();
        this.e = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.pb_progress_app_info_top_by_cat_small_item);
        viewFindViewById3.getClass();
        this.f = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_name_app_info_top_by_cat_small_item);
        viewFindViewById4.getClass();
        TextView textView = (TextView) viewFindViewById4;
        this.g = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_number_app_info_top_by_cat_small_item);
        this.h = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_desc_app_info_top_by_cat_small_item);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.f13928i = textView3;
        View viewFindViewById6 = view.findViewById(R.id.tv_status_app_info_top_by_cat_small_item);
        viewFindViewById6.getClass();
        TextView textView4 = (TextView) viewFindViewById6;
        this.f13929j = textView4;
        View viewFindViewById7 = view.findViewById(R.id.tv_progress_app_info_top_by_cat_small_item);
        viewFindViewById7.getClass();
        TextView textView5 = (TextView) viewFindViewById7;
        this.f13930k = textView5;
        View viewFindViewById8 = view.findViewById(R.id.tv_verified_app_info_top_by_cat_small_item);
        viewFindViewById8.getClass();
        TextView textView6 = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.ll_progress_app_info_top_by_cat_small_item);
        viewFindViewById9.getClass();
        this.f13931l = (LinearLayout) viewFindViewById9;
        this.f13932m = (ImageView) view.findViewById(R.id.iv_alternative_compare);
        textView.setTypeface(o4.b.f11719r);
        if (textView2 != null) {
            textView2.setTypeface(o4.b.f11719r);
        }
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        textView6.setTypeface(o4.b.f11720s);
    }

    public final void g(h5.h hVar, int i10) {
        hVar.getClass();
        g5.c cVar = this.f13925b;
        RelativeLayout relativeLayout = this.f13927d;
        f.b(relativeLayout, cVar, hVar);
        relativeLayout.setOnLongClickListener(new b5.c(this, hVar, i10, 11));
        TextView textView = this.h;
        if (i10 > 0) {
            if (textView != null) {
                textView.setText(this.itemView.getContext().getResources().getString(R.string.top_index_format, String.valueOf(i10)));
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f13932m;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (imageView != null) {
            imageView.setOnClickListener(new i0(this, hVar, i10, 5));
        }
        f.f(hVar, this.g, this.f13928i);
        e(this.e, hVar.i());
        c(hVar, this.f, this.e, this.f13928i, this.f13930k, this.f13929j, this.f13931l);
    }
}
