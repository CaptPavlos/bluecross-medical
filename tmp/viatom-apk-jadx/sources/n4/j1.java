package n4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.j f11387b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f11388c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f11389d;
    public final String e;
    public final ImageView f;
    public final RelativeLayout g;
    public final ProgressBar h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f11390i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f11391j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f11392k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f11393l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f11394m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f11395n;

    /* renamed from: o, reason: collision with root package name */
    public final CardView f11396o;

    /* renamed from: p, reason: collision with root package name */
    public final View f11397p;

    /* renamed from: q, reason: collision with root package name */
    public final int f11398q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ k1 f11399r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, View view, g5.j jVar, g5.a aVar, Context context, String str) {
        super(view, context);
        jVar.getClass();
        aVar.getClass();
        context.getClass();
        str.getClass();
        this.f11399r = k1Var;
        this.f11387b = jVar;
        this.f11388c = aVar;
        this.f11389d = context;
        this.e = str;
        View viewFindViewById = view.findViewById(R.id.iv_image_video_featured_item);
        viewFindViewById.getClass();
        this.f = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.rl_video_card_info);
        viewFindViewById2.getClass();
        this.g = (RelativeLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.pb_progress_video_featured_item);
        viewFindViewById3.getClass();
        this.h = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.iv_logo_video_featured_item);
        viewFindViewById4.getClass();
        this.f11390i = (ImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.tv_name_video_featured_item);
        viewFindViewById5.getClass();
        TextView textView = (TextView) viewFindViewById5;
        this.f11391j = textView;
        View viewFindViewById6 = view.findViewById(R.id.tv_desc_video_featured_item);
        viewFindViewById6.getClass();
        TextView textView2 = (TextView) viewFindViewById6;
        this.f11392k = textView2;
        View viewFindViewById7 = view.findViewById(R.id.tv_status_video_featured_item);
        viewFindViewById7.getClass();
        this.f11393l = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.tv_progress_video_featured_item);
        viewFindViewById8.getClass();
        TextView textView3 = (TextView) viewFindViewById8;
        this.f11394m = textView3;
        View viewFindViewById9 = view.findViewById(R.id.tv_verified_video_featured_item);
        viewFindViewById9.getClass();
        View viewFindViewById10 = view.findViewById(R.id.ll_progress_video_featured_item);
        viewFindViewById10.getClass();
        this.f11395n = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.cv_youtube_player_view);
        viewFindViewById11.getClass();
        this.f11396o = (CardView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.v_player_controller);
        viewFindViewById12.getClass();
        this.f11397p = viewFindViewById12;
        this.f11398q = UptodownApp.S;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById9).setTypeface(o4.b.f11720s);
    }

    public static void h(ImageView imageView, h5.h hVar) {
        z5.f fVar = new z5.f((int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_m));
        String strE = hVar.e();
        if (strE == null || strE.length() == 0) {
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_bg_placeholder));
            return;
        }
        if (UptodownApp.Q <= 0) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            j4.d0 d0VarE = j4.y.d().e(hVar.d());
            d0VarE.f9931c = true;
            d0VarE.g(fVar);
            d0VarE.e(imageView, null);
            return;
        }
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, UptodownApp.Q));
        j4.d0 d0VarE2 = j4.y.d().e(hVar.d());
        d0VarE2.f9930b.e(UptodownApp.R, UptodownApp.Q);
        d0VarE2.g(fVar);
        d0VarE2.e(imageView, null);
    }

    public final void g(h5.h hVar, int i10) {
        this.f11396o.setVisibility(8);
        this.f11397p.setVisibility(8);
        ImageView imageView = this.f;
        imageView.setVisibility(0);
        y5.f.f(hVar, this.f11391j, this.f11392k);
        RelativeLayout relativeLayout = this.g;
        g5.j jVar = this.f11387b;
        y5.f.b(relativeLayout, jVar, hVar);
        h(imageView, hVar);
        e(this.f11390i, hVar.i());
        c(hVar, this.h, this.f11390i, this.f11392k, this.f11394m, this.f11393l, this.f11395n);
        relativeLayout.setOnLongClickListener(new i1(this, hVar, i10, 1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f11398q, -1);
        View view = this.itemView;
        y5.f.a(layoutParams, this.f11389d, i10, this.f11399r.f11418o);
        view.setLayoutParams(layoutParams);
        y5.f.b(imageView, jVar, hVar);
    }
}
