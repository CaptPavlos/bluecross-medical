package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7380a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7381b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7382c;

    /* renamed from: d, reason: collision with root package name */
    public final Toolbar f7383d;
    public final TextView e;

    public w(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f7380a = relativeLayout;
        this.f7381b = view;
        this.f7382c = recyclerView;
        this.f7383d = toolbar;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7380a;
    }
}
