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
public final class h1 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f13874b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.d f13875c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.a f13876d;
    public final RelativeLayout e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f13877i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f13878j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f13879k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f13880l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f13881m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f13882n;

    /* renamed from: o, reason: collision with root package name */
    public final ProgressBar f13883o;

    /* JADX WARN: Illegal instructions before constructor call */
    public h1(View view, g5.c cVar, g5.d dVar, g5.a aVar) {
        cVar.getClass();
        dVar.getClass();
        aVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f13874b = cVar;
        this.f13875c = dVar;
        this.f13876d = aVar;
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
        this.f13877i = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_action_app_info_top_by_cat_info_item);
        viewFindViewById5.getClass();
        TextView textView4 = (TextView) viewFindViewById5;
        this.f13878j = textView4;
        TextView textView5 = (TextView) view.findViewById(R.id.tv_valoration_app_info_top_by_cat_info_item);
        this.f13879k = textView5;
        TextView textView6 = (TextView) view.findViewById(R.id.tv_downloads_counter_app_info_top_by_cat_info_item);
        this.f13880l = textView6;
        this.f13881m = (LinearLayout) view.findViewById(R.id.ll_info_app_info_top_by_cat_info_item);
        View viewFindViewById6 = view.findViewById(R.id.ll_download_app_info_top_by_cat_info_item);
        viewFindViewById6.getClass();
        this.f13882n = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.tv_progress_app_info_top_by_cat_info_item);
        viewFindViewById7.getClass();
        TextView textView7 = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.pb_progress_app_info_top_by_cat_item);
        viewFindViewById8.getClass();
        this.f13883o = (ProgressBar) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.tv_verified_app_info_top_by_cat_info_item);
        viewFindViewById9.getClass();
        TextView textView8 = (TextView) viewFindViewById9;
        TextView textView9 = (TextView) view.findViewById(R.id.tv_badge_promoted);
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
}
