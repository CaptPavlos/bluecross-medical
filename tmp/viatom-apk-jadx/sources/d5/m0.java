package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7217a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7218b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7219c;

    /* renamed from: d, reason: collision with root package name */
    public final Toolbar f7220d;
    public final TextView e;
    public final TextView f;

    public m0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f7217a = relativeLayout;
        this.f7218b = view;
        this.f7219c = recyclerView;
        this.f7220d = toolbar;
        this.e = textView;
        this.f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7217a;
    }
}
