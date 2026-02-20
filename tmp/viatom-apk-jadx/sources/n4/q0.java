package n4;

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
public final class q0 extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f11463b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f11464c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f11465d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f11466i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f11467j;

    /* renamed from: k, reason: collision with root package name */
    public final RelativeLayout f11468k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ r0 f11469l;

    /* JADX WARN: Illegal instructions before constructor call */
    public q0(r0 r0Var, View view, g5.c cVar) {
        cVar.getClass();
        this.f11469l = r0Var;
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f11463b = cVar;
        View viewFindViewById = view.findViewById(R.id.iv_logo_card_top_download);
        viewFindViewById.getClass();
        this.f11464c = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.pb_progress_card_top_download);
        viewFindViewById2.getClass();
        this.f11465d = (ProgressBar) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_titulo_card_top_download);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        this.e = textView;
        View viewFindViewById4 = view.findViewById(R.id.tv_number_card_top_download);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        this.f = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_resumen_card_top_download);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.g = textView3;
        View viewFindViewById6 = view.findViewById(R.id.tv_status_card_top_download);
        viewFindViewById6.getClass();
        TextView textView4 = (TextView) viewFindViewById6;
        this.h = textView4;
        View viewFindViewById7 = view.findViewById(R.id.tv_progress_card_top_download);
        viewFindViewById7.getClass();
        TextView textView5 = (TextView) viewFindViewById7;
        this.f11466i = textView5;
        View viewFindViewById8 = view.findViewById(R.id.tv_verified_card_top_download);
        viewFindViewById8.getClass();
        View viewFindViewById9 = view.findViewById(R.id.ll_progress_card_top_download);
        viewFindViewById9.getClass();
        this.f11467j = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.rl_card_details_top_download);
        viewFindViewById10.getClass();
        this.f11468k = (RelativeLayout) viewFindViewById10;
        textView2.setTypeface(o4.b.f11719r);
        textView.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById8).setTypeface(o4.b.f11720s);
    }
}
