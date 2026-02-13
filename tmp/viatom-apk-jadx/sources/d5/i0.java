package d5;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7109a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f7110b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f7111c;

    /* renamed from: d, reason: collision with root package name */
    public final View f7112d;
    public final TextView e;

    public i0(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, TextView textView) {
        this.f7109a = relativeLayout;
        this.f7110b = editText;
        this.f7111c = editText2;
        this.f7112d = view;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7109a;
    }
}
