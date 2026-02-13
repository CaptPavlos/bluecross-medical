package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7364a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f7365b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f7366c;

    public /* synthetic */ u(LinearLayout linearLayout, TextView textView, int i10) {
        this.f7364a = i10;
        this.f7365b = linearLayout;
        this.f7366c = textView;
    }

    public static u a(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.permission_item, (ViewGroup) null, false);
        TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_name_permission_item);
        if (textView != null) {
            return new u((LinearLayout) viewInflate, textView, 1);
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.tv_name_permission_item)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f7364a) {
        }
        return this.f7365b;
    }
}
