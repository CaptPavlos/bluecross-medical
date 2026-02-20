package y5;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final d5.w0 f13853b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.c f13854c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.d f13855d;

    /* JADX WARN: Illegal instructions before constructor call */
    public e1(d5.w0 w0Var, g5.c cVar, g5.d dVar) {
        cVar.getClass();
        dVar.getClass();
        RelativeLayout relativeLayout = w0Var.f7384a;
        relativeLayout.getClass();
        Context context = relativeLayout.getContext();
        context.getClass();
        super(relativeLayout, context);
        this.f13853b = w0Var;
        this.f13854c = cVar;
        this.f13855d = dVar;
        w0Var.h.setTypeface(o4.b.f11719r);
        w0Var.g.setTypeface(o4.b.f11720s);
        w0Var.f7389j.setTypeface(o4.b.f11720s);
        w0Var.f.setTypeface(o4.b.f11719r);
        w0Var.f7388i.setTypeface(o4.b.f11720s);
        w0Var.f7390k.setTypeface(o4.b.f11720s);
    }

    public final void g() {
        d5.w0 w0Var = this.f13853b;
        a.a.x(w0Var.f7387d, w0Var.f7386c);
        w0Var.e.setVisibility(8);
        w0Var.f7390k.setVisibility(8);
        w0Var.g.setVisibility(0);
        w0Var.f.setVisibility(0);
    }

    public final void h() {
        d5.w0 w0Var = this.f13853b;
        a.a.P(w0Var.f7387d, w0Var.f7386c);
        w0Var.f.setVisibility(8);
        w0Var.g.setVisibility(8);
        w0Var.f7385b.setVisibility(0);
        TextView textView = w0Var.f7388i;
        textView.setVisibility(0);
        w0Var.f7390k.setVisibility(0);
        textView.setText(this.itemView.getContext().getString(R.string.installing));
        w0Var.f7387d.setIndeterminate(true);
    }
}
