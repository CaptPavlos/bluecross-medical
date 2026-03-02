package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        androidx.window.layout.c.g("Cannot find context from the provider.");
        return null;
    }
}
