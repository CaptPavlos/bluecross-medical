package e5;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 extends h1 {

    /* renamed from: l, reason: collision with root package name */
    public String f7723l;

    /* renamed from: m, reason: collision with root package name */
    public final s6.m f7724m = new s6.m(new a3.i0(this, 10));

    public d1(String str) {
        this.f7723l = str;
    }

    @Override // e5.h1
    public final ViewBinding a() {
        return (d5.f) this.f7724m.getValue();
    }

    @Override // e5.h1
    public final String b() {
        return this.f7723l;
    }

    @Override // e5.h1
    public final View d() {
        return ((d5.f) this.f7724m.getValue()).f7038b;
    }

    @Override // e5.h1
    public final TextView e() {
        return ((d5.f) this.f7724m.getValue()).f7040d;
    }

    @Override // e5.h1
    public final RecyclerView f() {
        return ((d5.f) this.f7724m.getValue()).f7039c;
    }

    @Override // e5.h1
    public final TextView i() {
        return ((d5.f) this.f7724m.getValue()).e;
    }

    @Override // e5.h1
    public final void j(h5.k kVar) {
        int i10 = kVar.f;
        if (i10 != 0 && i10 != 831) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            ((MainActivity) activity).h1(kVar);
        } else if (i10 != 0) {
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            ((MainActivity) activity2).g1(kVar);
        } else {
            FragmentActivity activity3 = getActivity();
            activity3.getClass();
            ((MainActivity) activity3).h1(kVar);
        }
    }

    @Override // e5.h1
    public final void k(h5.x0 x0Var) {
        x0Var.getClass();
        FragmentActivity activity = getActivity();
        activity.getClass();
        ((MainActivity) activity).h1(x0Var.f8788a);
    }

    @Override // e5.h1
    public final void l(String str) {
        this.f7723l = str;
    }
}
