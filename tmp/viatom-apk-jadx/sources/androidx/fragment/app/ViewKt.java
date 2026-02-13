package androidx.fragment.app;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        view.getClass();
        F f = (F) FragmentManager.findFragment(view);
        f.getClass();
        return f;
    }
}
