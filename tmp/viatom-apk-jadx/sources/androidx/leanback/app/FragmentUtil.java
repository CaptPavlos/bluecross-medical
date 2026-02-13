package androidx.leanback.app;

import android.app.Fragment;
import android.content.Context;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class FragmentUtil {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Context getContext(Fragment fragment) {
            return fragment.getContext();
        }
    }

    private FragmentUtil() {
    }

    public static Context getContext(Fragment fragment) {
        return Api23Impl.getContext(fragment);
    }
}
