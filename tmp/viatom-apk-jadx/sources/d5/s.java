package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7326a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7327b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f7328c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f7329d;
    public final TextView e;

    public s(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7326a = 2;
        this.f7327b = relativeLayout;
        this.f7328c = imageView;
        this.f7329d = textView;
        this.e = textView2;
    }

    public static s a(View view) {
        int i10 = R.id.iv_preference_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_preference_item);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i10 = R.id.tv_preference_item_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_description);
            if (textView != null) {
                i10 = R.id.tv_preference_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_preference_item_title);
                if (textView2 != null) {
                    return new s(relativeLayout, imageView, textView, textView2, 1);
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    public static s b(LayoutInflater layoutInflater) {
        return a(layoutInflater.inflate(R.layout.preference_item, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f7326a) {
        }
        return this.f7327b;
    }

    public /* synthetic */ s(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, int i10) {
        this.f7326a = i10;
        this.f7327b = relativeLayout;
        this.f7328c = imageView;
        this.f7329d = textView;
        this.e = textView2;
    }
}
