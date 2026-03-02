package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f6954a;

    /* renamed from: b, reason: collision with root package name */
    public final View f6955b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f6956c;

    /* renamed from: d, reason: collision with root package name */
    public final Toolbar f6957d;
    public final TextView e;
    public final TextView f;

    public c1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f6954a = relativeLayout;
        this.f6955b = view;
        this.f6956c = recyclerView;
        this.f6957d = toolbar;
        this.e = textView;
        this.f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6954a;
    }
}
