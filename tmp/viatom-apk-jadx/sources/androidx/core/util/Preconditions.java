package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.window.layout.c;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Locale;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z9, @NonNull Object obj) {
        if (!z9) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static float checkArgumentFinite(float f, @NonNull String str) {
        if (Float.isNaN(f)) {
            com.google.gson.internal.a.n(a3.a.C(str, " must not be NaN"));
            return 0.0f;
        }
        if (!Float.isInfinite(f)) {
            return f;
        }
        com.google.gson.internal.a.n(a3.a.C(str, " must not be infinite"));
        return 0.0f;
    }

    public static int checkArgumentInRange(int i10, int i11, int i12, @NonNull String str) {
        if (i10 < i11) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i11 + ", " + i12 + "] (too low)");
        }
        if (i10 <= i12) {
            return i10;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i11 + ", " + i12 + "] (too high)");
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public static int checkArgumentNonnegative(int i10, @Nullable String str) {
        if (i10 >= 0) {
            return i10;
        }
        com.google.gson.internal.a.n(str);
        return 0;
    }

    public static int checkFlagsArgument(int i10, int i11) {
        if ((i10 & i11) == i10) {
            return i10;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(i11) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t, @NonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z9, @Nullable String str) {
        if (z9) {
            return;
        }
        c.g(str);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t, @NonNull Object obj) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t;
    }

    public static void checkState(boolean z9) {
        checkState(z9, null);
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public static int checkArgumentNonnegative(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        f.a();
        return 0;
    }

    public static void checkArgument(boolean z9) {
        if (z9) {
            return;
        }
        f.a();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t) {
        t.getClass();
        return t;
    }

    public static void checkArgument(boolean z9, @NonNull String str, @NonNull Object... objArr) {
        if (!z9) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        f.a();
        return null;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    public static long checkArgumentInRange(long j10, long j11, long j12, @NonNull String str) {
        if (j10 < j11) {
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is out of range of [");
            sb.append(j11);
            sb.append(", ");
            com.google.gson.internal.a.n(a3.a.l(sb, j12, "] (too low)"));
            return 0L;
        }
        if (j10 <= j12) {
            return j10;
        }
        Locale locale2 = Locale.US;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" is out of range of [");
        sb2.append(j11);
        sb2.append(", ");
        com.google.gson.internal.a.n(a3.a.l(sb2, j12, "] (too high)"));
        return 0L;
    }

    public static float checkArgumentInRange(float f, float f10, float f11, @NonNull String str) {
        if (f < f10) {
            com.google.gson.internal.a.n(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f10), Float.valueOf(f11)));
            return 0.0f;
        }
        if (f <= f11) {
            return f;
        }
        com.google.gson.internal.a.n(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f10), Float.valueOf(f11)));
        return 0.0f;
    }

    public static double checkArgumentInRange(double d8, double d10, double d11, @NonNull String str) {
        if (d8 < d10) {
            com.google.gson.internal.a.n(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d10), Double.valueOf(d11)));
            return 0.0d;
        }
        if (d8 <= d11) {
            return d8;
        }
        com.google.gson.internal.a.n(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d10), Double.valueOf(d11)));
        return 0.0d;
    }
}
