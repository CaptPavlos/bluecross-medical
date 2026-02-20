package n4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s0 extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final g5.c f11479b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f11480c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f11481d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f11482i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t0 f11483j;

    /* JADX WARN: Illegal instructions before constructor call */
    public s0(t0 t0Var, View view, g5.c cVar) {
        cVar.getClass();
        this.f11483j = t0Var;
        Context context = view.getContext();
        context.getClass();
        super(view, context);
        this.f11479b = cVar;
        View viewFindViewById = view.findViewById(R.id.iv_logo_card);
        viewFindViewById.getClass();
        this.f11480c = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.pb_progress_card);
        viewFindViewById2.getClass();
        this.f11481d = (ProgressBar) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_titulo_card);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        this.e = textView;
        View viewFindViewById4 = view.findViewById(R.id.tv_resumen_card);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        this.f = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_progress_card);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.g = textView3;
        View viewFindViewById6 = view.findViewById(R.id.tv_verified_card);
        viewFindViewById6.getClass();
        View viewFindViewById7 = view.findViewById(R.id.ll_progress_card);
        viewFindViewById7.getClass();
        this.h = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.tv_status_card);
        viewFindViewById8.getClass();
        TextView textView4 = (TextView) viewFindViewById8;
        this.f11482i = textView4;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        ((TextView) viewFindViewById6).setTypeface(o4.b.f11720s);
    }
}
