package d5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f7345a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f7346b;

    /* renamed from: c, reason: collision with root package name */
    public final View f7347c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7348d;
    public final TextView e;
    public final TextView f;

    public t(FrameLayout frameLayout, LinearLayout linearLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f7345a = frameLayout;
        this.f7346b = linearLayout;
        this.f7347c = view;
        this.f7348d = recyclerView;
        this.e = textView;
        this.f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7345a;
    }
}
