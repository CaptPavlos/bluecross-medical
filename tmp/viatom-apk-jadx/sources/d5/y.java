package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7400a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7401b;

    /* renamed from: c, reason: collision with root package name */
    public final b9.h f7402c;

    /* renamed from: d, reason: collision with root package name */
    public final h f7403d;
    public final Toolbar e;
    public final TextView f;

    public y(RelativeLayout relativeLayout, View view, b9.h hVar, h hVar2, Toolbar toolbar, TextView textView) {
        this.f7400a = relativeLayout;
        this.f7401b = view;
        this.f7402c = hVar;
        this.f7403d = hVar2;
        this.e = toolbar;
        this.f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7400a;
    }
}
