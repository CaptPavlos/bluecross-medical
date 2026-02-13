package e5;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7755a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7756b;

    public /* synthetic */ g0(Object obj, int i10) {
        this.f7755a = i10;
        this.f7756b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f7755a) {
            case 0:
                d5.q0 q0Var = (d5.q0) this.f7756b;
                TextView textView = q0Var.f7308r;
                TextView textView2 = q0Var.f7303m;
                textView2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (a4.t(textView2)) {
                    textView.setVisibility(0);
                    textView.setTypeface(o4.b.f11719r);
                    break;
                }
                break;
            case 1:
                d5.s0 s0Var = (d5.s0) this.f7756b;
                TextView textView3 = s0Var.f7344s;
                TextView textView4 = s0Var.f7339n;
                textView4.getViewTreeObserver().removeOnPreDrawListener(this);
                if (a4.t(textView4)) {
                    textView3.setVisibility(0);
                    textView3.setTypeface(o4.b.f11719r);
                    break;
                }
                break;
            case 2:
                n4.g1 g1Var = (n4.g1) this.f7756b;
                g1Var.f11350b.f7321l.getViewTreeObserver().removeOnPreDrawListener(this);
                d5.r0 r0Var = g1Var.f11350b;
                if (a4.t(r0Var.f7321l)) {
                    r0Var.f7325p.setVisibility(0);
                    r0Var.f7325p.setTypeface(o4.b.f11719r);
                    break;
                }
                break;
            default:
                y5.u1 u1Var = (y5.u1) this.f7756b;
                TextView textView5 = u1Var.f;
                TextView textView6 = u1Var.g;
                textView5.getViewTreeObserver().removeOnPreDrawListener(this);
                if (a4.t(u1Var.f)) {
                    textView6.setVisibility(0);
                    textView6.setTypeface(o4.b.f11719r);
                    break;
                }
                break;
        }
        return true;
    }
}
