package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7376a;

    /* renamed from: b, reason: collision with root package name */
    public final w2.r f7377b;

    /* renamed from: c, reason: collision with root package name */
    public final View f7378c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7379d;
    public final TextView e;

    public v0(RelativeLayout relativeLayout, w2.r rVar, View view, RecyclerView recyclerView, TextView textView) {
        this.f7376a = relativeLayout;
        this.f7377b = rVar;
        this.f7378c = view;
        this.f7379d = recyclerView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7376a;
    }
}
