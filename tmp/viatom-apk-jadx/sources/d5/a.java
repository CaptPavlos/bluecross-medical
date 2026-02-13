package d5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f6838a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f6839b;

    /* renamed from: c, reason: collision with root package name */
    public final Toolbar f6840c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6841d;

    public a(LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView) {
        this.f6838a = linearLayout;
        this.f6839b = linearLayout2;
        this.f6840c = toolbar;
        this.f6841d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6838a;
    }
}
