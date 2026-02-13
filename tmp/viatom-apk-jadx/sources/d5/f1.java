package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7045a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7046b;

    /* renamed from: c, reason: collision with root package name */
    public final NestedScrollView f7047c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7048d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final d1 f7049i;

    public f1(RelativeLayout relativeLayout, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, d1 d1Var) {
        this.f7045a = relativeLayout;
        this.f7046b = view;
        this.f7047c = nestedScrollView;
        this.f7048d = recyclerView;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.f7049i = d1Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7045a;
    }
}
