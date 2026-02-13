package d5;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7081a = 3;

    /* renamed from: b, reason: collision with root package name */
    public Object f7082b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7083c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7084d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public Object f7085i;

    /* renamed from: j, reason: collision with root package name */
    public Object f7086j;

    /* renamed from: k, reason: collision with root package name */
    public Object f7087k;

    public h(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.f7082b = linearLayout;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.f7085i = imageView4;
        this.f7086j = imageView5;
        this.f7087k = imageView6;
        this.e = linearLayout2;
        this.f7083c = textView;
        this.f7084d = textView2;
    }

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.f7086j;
        if (map != null) {
            map.put(str, str2);
        } else {
            androidx.window.layout.c.g("Property \"autoMetadata\" has not been set");
        }
    }

    public p.h b() {
        String strConcat = ((String) this.f7082b) == null ? " transportName" : "";
        if (((p.k) this.g) == null) {
            strConcat = strConcat.concat(" encodedPayload");
        }
        if (((Long) this.h) == null) {
            strConcat = strConcat.concat(" eventMillis");
        }
        if (((Long) this.f7085i) == null) {
            strConcat = strConcat.concat(" uptimeMillis");
        }
        if (((HashMap) this.f7086j) == null) {
            strConcat = strConcat.concat(" autoMetadata");
        }
        if (strConcat.isEmpty()) {
            return new p.h((String) this.f7082b, (Integer) this.f, (p.k) this.g, ((Long) this.h).longValue(), ((Long) this.f7085i).longValue(), (HashMap) this.f7086j, (Integer) this.f7087k, (String) this.f7083c, (byte[]) this.f7084d, (byte[]) this.e);
        }
        androidx.window.layout.c.g("Missing required properties:".concat(strConcat));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f7081a) {
        }
        return (LinearLayout) this.f7082b;
    }

    public /* synthetic */ h() {
    }

    public h(LinearLayout linearLayout, CheckBox checkBox, EditText editText, EditText editText2, EditText editText3, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f7082b = linearLayout;
        this.f = checkBox;
        this.g = editText;
        this.h = editText2;
        this.f7085i = editText3;
        this.f7086j = relativeLayout;
        this.f7083c = textView;
        this.f7084d = textView2;
        this.e = textView3;
        this.f7087k = textView4;
    }

    public h(LinearLayout linearLayout, View view, View view2, View view3, View view4, View view5, View view6, TextView textView, TextView textView2, TextView textView3) {
        this.f7082b = linearLayout;
        this.f = view;
        this.g = view2;
        this.h = view3;
        this.f7085i = view4;
        this.f7086j = view5;
        this.f7087k = view6;
        this.f7083c = textView;
        this.f7084d = textView2;
        this.e = textView3;
    }
}
