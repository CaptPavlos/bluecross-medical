package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6982a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f6983b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f6984c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f6985d;
    public final TextView e;
    public final TextView f;

    public /* synthetic */ d1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, int i10) {
        this.f6982a = i10;
        this.f6983b = relativeLayout;
        this.f6984c = imageView;
        this.f6985d = imageView2;
        this.e = textView;
        this.f = textView2;
    }

    public static d1 a(View view) {
        int i10 = R.id.iv_device_user_device_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_device_user_device_item);
        if (imageView != null) {
            i10 = R.id.iv_enter_user_device_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_enter_user_device_item);
            if (imageView2 != null) {
                i10 = R.id.ll_info_user_device_item;
                if (((LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_info_user_device_item)) != null) {
                    i10 = R.id.tv_last_update_user_device_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_update_user_device_item);
                    if (textView != null) {
                        i10 = R.id.tv_name_user_device_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_user_device_item);
                        if (textView2 != null) {
                            return new d1((RelativeLayout) view, imageView, imageView2, textView, textView2, 1);
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f6982a) {
        }
        return this.f6983b;
    }
}
