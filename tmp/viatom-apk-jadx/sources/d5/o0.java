package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7268a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7269b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f7270c;

    /* renamed from: d, reason: collision with root package name */
    public final SwitchCompat f7271d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f7272i;

    public o0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, SwitchCompat switchCompat, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7268a = relativeLayout;
        this.f7269b = view;
        this.f7270c = recyclerView;
        this.f7271d = switchCompat;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.f7272i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7268a;
    }
}
