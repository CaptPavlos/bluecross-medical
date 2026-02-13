package androidx.leanback.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PermissionHelper {
    private PermissionHelper() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void requestPermissions(Fragment fragment, String[] strArr, int i10) {
        fragment.requestPermissions(strArr, i10);
    }
}
