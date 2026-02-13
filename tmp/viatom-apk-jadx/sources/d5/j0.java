package d5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7137a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7138b;

    /* renamed from: c, reason: collision with root package name */
    public final SwitchCompat f7139c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f7140d;
    public final TextView e;

    public /* synthetic */ j0(RelativeLayout relativeLayout, SwitchCompat switchCompat, TextView textView, TextView textView2, int i10) {
        this.f7137a = i10;
        this.f7138b = relativeLayout;
        this.f7139c = switchCompat;
        this.f7140d = textView;
        this.e = textView2;
    }

    public static j0 a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i10 = R.id.sc_preference_switch;
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.sc_preference_switch);
        if (switchCompat != null) {
            i10 = R.id.tv_preference_switch_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_description);
            if (textView != null) {
                i10 = R.id.tv_preference_switch_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_switch_title);
                if (textView2 != null) {
                    return new j0(relativeLayout, switchCompat, textView, textView2, 0);
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f7137a) {
        }
        return this.f7138b;
    }
}
