package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f6958a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f6959b;

    /* renamed from: c, reason: collision with root package name */
    public final View f6960c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f6961d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f6962i;

    public d(RelativeLayout relativeLayout, ImageView imageView, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f6958a = relativeLayout;
        this.f6959b = imageView;
        this.f6960c = view;
        this.f6961d = recyclerView;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.f6962i = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6958a;
    }
}
