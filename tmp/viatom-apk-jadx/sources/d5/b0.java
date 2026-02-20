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
public final class b0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f6902a;

    /* renamed from: b, reason: collision with root package name */
    public final View f6903b;

    /* renamed from: c, reason: collision with root package name */
    public final j f6904c;

    /* renamed from: d, reason: collision with root package name */
    public final NestedScrollView f6905d;
    public final RecyclerView e;
    public final SearchView f;
    public final Toolbar g;
    public final TextView h;

    public b0(RelativeLayout relativeLayout, View view, j jVar, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView) {
        this.f6902a = relativeLayout;
        this.f6903b = view;
        this.f6904c = jVar;
        this.f6905d = nestedScrollView;
        this.e = recyclerView;
        this.f = searchView;
        this.g = toolbar;
        this.h = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6902a;
    }
}
