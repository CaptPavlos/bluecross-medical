package y5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final x4 f14029a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f14030b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f14031c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f14032d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f14033i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f14034j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f14035k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f14036l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f14037m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f14038n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f14039o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f14040p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f14041q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(View view, x4 x4Var, Context context) {
        super(view);
        x4Var.getClass();
        this.f14029a = x4Var;
        this.f14030b = context;
        View viewFindViewById = view.findViewById(R.id.tv_username_review);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f14031c = textView;
        View viewFindViewById2 = view.findViewById(R.id.iv_avatar_review);
        viewFindViewById2.getClass();
        this.f14032d = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_date_review);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.e = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_body_review);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.f = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_show_more_review);
        viewFindViewById5.getClass();
        this.g = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.tv_likes_counter_review);
        viewFindViewById6.getClass();
        TextView textView4 = (TextView) viewFindViewById6;
        this.h = textView4;
        View viewFindViewById7 = view.findViewById(R.id.ll_likes_review);
        viewFindViewById7.getClass();
        this.f14033i = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.ll_reviews_counter_review);
        viewFindViewById8.getClass();
        this.f14034j = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.tv_reviews_counter_review);
        viewFindViewById9.getClass();
        TextView textView5 = (TextView) viewFindViewById9;
        this.f14035k = textView5;
        View viewFindViewById10 = view.findViewById(R.id.iv_likes_counter_review);
        viewFindViewById10.getClass();
        this.f14036l = (ImageView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.iv_star1_review);
        viewFindViewById11.getClass();
        this.f14037m = (ImageView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.iv_star2_review);
        viewFindViewById12.getClass();
        this.f14038n = (ImageView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.iv_star3_review);
        viewFindViewById13.getClass();
        this.f14039o = (ImageView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.iv_star4_review);
        viewFindViewById14.getClass();
        this.f14040p = (ImageView) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.iv_star5_review);
        viewFindViewById15.getClass();
        this.f14041q = (ImageView) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.iv_follow_user_review);
        viewFindViewById16.getClass();
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        ((ImageView) viewFindViewById16).setVisibility(8);
    }
}
