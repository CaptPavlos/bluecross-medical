package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f11419b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f11420c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f11421d;
    public final ProgressBar e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f11422i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f11423j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearLayout f11424k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f11425l;

    /* JADX WARN: Illegal instructions before constructor call */
    public l(View view, g5.c cVar, g5.a aVar) {
        cVar.getClass();
        aVar.getClass();
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f11419b = cVar;
        this.f11420c = aVar;
        this.f11421d = (ImageView) view.findViewById(R.id.iv_home_top_card_featured_item);
        View viewFindViewById = view.findViewById(R.id.pb_progress_home_card_top_featured_item);
        viewFindViewById.getClass();
        this.e = (ProgressBar) viewFindViewById;
        this.f = (ImageView) view.findViewById(R.id.iv_logo_home_card_top_featured_item);
        TextView textView = (TextView) view.findViewById(R.id.tv_name_home_card_top_featured_item);
        this.g = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_number_card_top_featured_download);
        this.h = textView2;
        TextView textView3 = (TextView) view.findViewById(R.id.tv_desc_home_card_top_featured_item);
        this.f11422i = textView3;
        View viewFindViewById2 = view.findViewById(R.id.tv_progress_home_card_top_featured_item);
        viewFindViewById2.getClass();
        TextView textView4 = (TextView) viewFindViewById2;
        this.f11423j = textView4;
        View viewFindViewById3 = view.findViewById(R.id.tv_verified_home_card_top_featured_item);
        viewFindViewById3.getClass();
        View viewFindViewById4 = view.findViewById(R.id.ll_progress_home_card_top_featured_item);
        viewFindViewById4.getClass();
        this.f11424k = (LinearLayout) viewFindViewById4;
        this.f11425l = (TextView) view.findViewById(R.id.tv_status_home_card_top_featured_item);
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById3).setTypeface(o4.b.f11720s);
    }

    public final void g(h5.h hVar, int i10, int i11, boolean z9) {
        int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z9) {
            layoutParams.setMargins(dimension, 0, dimension, dimension);
        } else {
            layoutParams.setMargins(dimension, 0, 0, dimension);
        }
        ImageView imageView = this.f11421d;
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.getClass();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (i10 >= 10) {
            marginLayoutParams.setMarginStart((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_xl));
        } else {
            marginLayoutParams.setMarginStart(0);
        }
        imageView.setLayoutParams(marginLayoutParams);
        this.itemView.setLayoutParams(layoutParams);
        this.h.setText(String.valueOf(i10));
        String strE = hVar.e();
        if (strE == null || strE.length() == 0) {
            com.mbridge.msdk.dycreator.baseview.a.p(this.itemView, R.drawable.shape_bg_placeholder, imageView);
        } else {
            j4.d0 d0VarE = j4.y.d().e(hVar.f());
            float f = UptodownApp.E;
            Context context = this.itemView.getContext();
            context.getClass();
            d0VarE.g(k4.c.x(context));
            j4.c0 c0Var = d0VarE.f9930b;
            c0Var.f = true;
            c0Var.g = 17;
            d0VarE.f9931c = true;
            d0VarE.f(R.drawable.shape_bg_placeholder);
            d0VarE.e(imageView, null);
        }
        View view = this.itemView;
        view.getClass();
        y5.f.b(view, this.f11419b, hVar);
        this.itemView.setOnLongClickListener(new b5.c(this, hVar, i11, 4));
        TextView textView = this.g;
        textView.getClass();
        TextView textView2 = this.f11422i;
        textView2.getClass();
        y5.f.f(hVar, textView, textView2);
        ImageView imageView2 = this.f;
        imageView2.getClass();
        e(imageView2, hVar.i());
        c(hVar, this.e, imageView2, textView2, this.f11423j, this.f11425l, this.f11424k);
    }
}
