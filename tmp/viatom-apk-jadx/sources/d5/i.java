package d5;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7105a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f7106b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f7107c;

    /* renamed from: d, reason: collision with root package name */
    public final View f7108d;
    public final Toolbar e;
    public final TextView f;
    public final TextView g;

    public i(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f7105a = relativeLayout;
        this.f7106b = editText;
        this.f7107c = editText2;
        this.f7108d = view;
        this.e = toolbar;
        this.f = textView;
        this.g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7105a;
    }
}
