package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f6842a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.x f6843b;

    /* renamed from: c, reason: collision with root package name */
    public final View f6844c;

    /* renamed from: d, reason: collision with root package name */
    public final NestedScrollView f6845d;
    public final RecyclerView e;
    public final SearchView f;
    public final Toolbar g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f6846i;

    public a0(RelativeLayout relativeLayout, a3.x xVar, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f6842a = relativeLayout;
        this.f6843b = xVar;
        this.f6844c = view;
        this.f6845d = nestedScrollView;
        this.e = recyclerView;
        this.f = searchView;
        this.g = toolbar;
        this.h = textView;
        this.f6846i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6842a;
    }
}
