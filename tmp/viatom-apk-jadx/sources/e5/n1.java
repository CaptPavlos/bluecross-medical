package e5;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 extends h1 {

    /* renamed from: l, reason: collision with root package name */
    public String f7821l;

    /* renamed from: m, reason: collision with root package name */
    public final s6.m f7822m = new s6.m(new a3.i0(this, 12));

    public n1(String str) {
        this.f7821l = str;
    }

    @Override // e5.h1
    public final ViewBinding a() {
        return (d5.r) this.f7822m.getValue();
    }

    @Override // e5.h1
    public final String b() {
        return this.f7821l;
    }

    @Override // e5.h1
    public final View d() {
        return ((d5.r) this.f7822m.getValue()).f7311b;
    }

    @Override // e5.h1
    public final TextView e() {
        return ((d5.r) this.f7822m.getValue()).f7313d;
    }

    @Override // e5.h1
    public final RecyclerView f() {
        return ((d5.r) this.f7822m.getValue()).f7312c;
    }

    @Override // e5.h1
    public final TextView i() {
        return ((d5.r) this.f7822m.getValue()).e;
    }

    @Override // e5.h1
    public final void j(h5.k kVar) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        ((MainActivity) activity).h1(kVar);
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
        this.f7821l = str;
    }
}
