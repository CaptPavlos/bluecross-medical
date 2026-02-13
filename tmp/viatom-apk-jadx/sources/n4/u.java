package n4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends y5.f {

    /* renamed from: b, reason: collision with root package name */
    public final d5.j f11490b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.c f11491c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v f11492d;

    /* JADX WARN: Illegal instructions before constructor call */
    public u(v vVar, d5.j jVar, g5.c cVar, Context context) {
        cVar.getClass();
        context.getClass();
        this.f11492d = vVar;
        RelativeLayout relativeLayout = (RelativeLayout) jVar.f7134b;
        relativeLayout.getClass();
        super(relativeLayout, context);
        this.f11490b = jVar;
        this.f11491c = cVar;
        ((TextView) jVar.f7136d).setTypeface(o4.b.f11719r);
        ((TextView) jVar.f7135c).setTypeface(o4.b.f11720s);
        ((TextView) jVar.e).setTypeface(o4.b.f11720s);
    }

    public final void g(h5.h hVar, boolean z9) {
        Context context = this.f11492d.f11498b;
        int dimension = (int) context.getResources().getDimension(R.dimen.margin_m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z9) {
            layoutParams.setMargins(dimension, 0, dimension, dimension);
        } else {
            layoutParams.setMargins(dimension, 0, 0, dimension);
        }
        this.itemView.setLayoutParams(layoutParams);
        String strE = hVar.e();
        d5.j jVar = this.f11490b;
        if (strE != null && strE.length() != 0) {
            j4.d0 d0VarE = j4.y.d().e(hVar.f());
            float f = UptodownApp.E;
            d0VarE.g(k4.c.x(context));
            j4.c0 c0Var = d0VarE.f9930b;
            c0Var.f = true;
            c0Var.g = 17;
            d0VarE.f9931c = true;
            d0VarE.f(R.drawable.shape_bg_placeholder);
            d0VarE.e((ImageView) jVar.f, null);
        }
        View view = this.itemView;
        view.getClass();
        y5.f.b(view, this.f11491c, hVar);
        TextView textView = (TextView) jVar.f7136d;
        TextView textView2 = (TextView) jVar.f7135c;
        y5.f.f(hVar, textView, textView2);
        d(hVar.f8595w, (TextView) jVar.e, textView2);
        e((ImageView) jVar.g, hVar.i());
    }
}
