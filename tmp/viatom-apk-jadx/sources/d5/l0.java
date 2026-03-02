package d5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7201a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f7202b;

    /* renamed from: c, reason: collision with root package name */
    public final View f7203c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7204d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    public l0(RelativeLayout relativeLayout, FrameLayout frameLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f7201a = relativeLayout;
        this.f7202b = frameLayout;
        this.f7203c = view;
        this.f7204d = recyclerView;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7201a;
    }
}
