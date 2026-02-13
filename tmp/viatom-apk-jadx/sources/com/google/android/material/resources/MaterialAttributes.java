package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.a;
import com.google.android.material.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class MaterialAttributes {
    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i10, boolean z9) {
        TypedValue typedValueResolve = resolve(context, i10);
        return (typedValueResolve == null || typedValueResolve.type != 18) ? z9 : typedValueResolve.data != 0;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        return resolveOrThrow(context, i10, str) != 0;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i10, @DimenRes int i11) {
        TypedValue typedValueResolve = resolve(context, i10);
        return (int) ((typedValueResolve == null || typedValueResolve.type != 5) ? context.getResources().getDimension(i11) : typedValueResolve.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int resolveInteger(@NonNull Context context, @AttrRes int i10, int i11) {
        TypedValue typedValueResolve = resolve(context, i10);
        return (typedValueResolve == null || typedValueResolve.type != 16) ? i11 : typedValueResolve.data;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        return resolveTypedValueOrThrow(context, i10, str).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull Context context, @AttrRes int i10, @NonNull String str) {
        TypedValue typedValueResolve = resolve(context, i10);
        if (typedValueResolve != null) {
            return typedValueResolve;
        }
        a.r("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i10)});
        return null;
    }

    public static int resolveOrThrow(@NonNull View view, @AttrRes int i10) {
        return resolveTypedValueOrThrow(view, i10).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull View view, @AttrRes int i10) {
        return resolveTypedValueOrThrow(view.getContext(), i10, view.getClass().getCanonicalName());
    }
}
