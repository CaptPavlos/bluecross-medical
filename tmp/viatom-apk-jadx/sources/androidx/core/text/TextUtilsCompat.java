package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TextUtilsCompat {
    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
