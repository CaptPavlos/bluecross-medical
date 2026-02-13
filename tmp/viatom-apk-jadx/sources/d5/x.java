package d5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7391a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f7392b;

    /* renamed from: c, reason: collision with root package name */
    public final c2.d f7393c;

    /* renamed from: d, reason: collision with root package name */
    public final c2.d f7394d;
    public final c2.d e;
    public final View f;
    public final Toolbar g;
    public final TextView h;

    public x(RelativeLayout relativeLayout, LinearLayout linearLayout, c2.d dVar, c2.d dVar2, c2.d dVar3, View view, Toolbar toolbar, TextView textView) {
        this.f7391a = relativeLayout;
        this.f7392b = linearLayout;
        this.f7393c = dVar;
        this.f7394d = dVar2;
        this.e = dVar3;
        this.f = view;
        this.g = toolbar;
        this.h = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7391a;
    }
}
