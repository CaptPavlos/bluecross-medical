package d5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f7310a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7311b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7312c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f7313d;
    public final TextView e;

    public r(FrameLayout frameLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f7310a = frameLayout;
        this.f7311b = view;
        this.f7312c = recyclerView;
        this.f7313d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7310a;
    }
}
