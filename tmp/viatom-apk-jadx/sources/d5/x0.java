package d5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7395a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7396b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f7397c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7398d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f7399i;

    public x0(RelativeLayout relativeLayout, View view, LinearLayout linearLayout, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7395a = relativeLayout;
        this.f7396b = view;
        this.f7397c = linearLayout;
        this.f7398d = recyclerView;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.f7399i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7395a;
    }
}
