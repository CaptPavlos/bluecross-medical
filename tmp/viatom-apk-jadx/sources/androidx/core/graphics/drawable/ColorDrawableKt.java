package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ColorDrawableKt {
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorDrawable toDrawable(Color color) {
        return new ColorDrawable(color.toArgb());
    }

    public static final ColorDrawable toDrawable(@ColorInt int i10) {
        return new ColorDrawable(i10);
    }
}
