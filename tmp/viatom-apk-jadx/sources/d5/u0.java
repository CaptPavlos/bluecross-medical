package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7367a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7368b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7369c;

    /* renamed from: d, reason: collision with root package name */
    public final Toolbar f7370d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public u0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7367a = relativeLayout;
        this.f7368b = view;
        this.f7369c = recyclerView;
        this.f7370d = toolbar;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7367a;
    }
}
