package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7041a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7042b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7043c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f7044d;

    public f0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, TextView textView) {
        this.f7041a = relativeLayout;
        this.f7042b = view;
        this.f7043c = recyclerView;
        this.f7044d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7041a;
    }
}
