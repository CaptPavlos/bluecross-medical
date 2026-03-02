package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.collection.ScatterMapKt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11) {
        return ColorUtils.setAlphaComponent(i10, (Color.alpha(i10) * i11) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i10) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i10));
    }

    @Nullable
    @ColorInt
    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i10);
        if (typedValueResolve != null) {
            return Integer.valueOf(resolveColor(context, typedValueResolve));
        }
        return null;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = 100) int i11, int i12) {
        Hct hctFromInt = Hct.fromInt(getColorRole(i10, i11));
        hctFromInt.setChroma(i12);
        return hctFromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i10, boolean z9) {
        return z9 ? new ColorRoles(getColorRole(i10, 40), getColorRole(i10, 100), getColorRole(i10, 90), getColorRole(i10, 10)) : new ColorRoles(getColorRole(i10, 80), getColorRole(i10, 20), getColorRole(i10, 30), getColorRole(i10, 90));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i10, @NonNull ColorStateList colorStateList) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i10);
        ColorStateList colorStateListResolveColorStateList = typedValueResolve != null ? resolveColorStateList(context, typedValueResolve) : null;
        return colorStateListResolveColorStateList == null ? colorStateList : colorStateListResolveColorStateList;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i10) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i10);
        if (typedValueResolve == null) {
            return null;
        }
        int i11 = typedValueResolve.resourceId;
        if (i11 != 0) {
            return ContextCompat.getColorStateList(context, i11);
        }
        int i12 = typedValueResolve.data;
        if (i12 != 0) {
            return ColorStateList.valueOf(i12);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i10) {
        return getColorRole(i10, isLightTheme(context) ? 94 : 12, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i10) {
        return getColorRole(i10, isLightTheme(context) ? 92 : 17, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i10, @ColorInt int i11) {
        return Blend.harmonize(i10, i11);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i10) {
        return harmonize(i10, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i10) {
        return i10 != 0 && ColorUtils.calculateLuminance(i10) > 0.5d;
    }

    public static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        return layer(i10, ColorUtils.setAlphaComponent(i11, Math.round(Color.alpha(i11) * f)));
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        return i10 != 0 ? ContextCompat.getColor(context, i10) : typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        return i10 != 0 ? ContextCompat.getColorStateList(context, i10) : ColorStateList.valueOf(typedValue.data);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i10, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i10, str));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i10, @ColorInt int i11) {
        return getColor(view.getContext(), i10, i11);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i10, @ColorInt int i11) {
        Integer colorOrNull = getColorOrNull(context, i10);
        return colorOrNull != null ? colorOrNull.intValue() : i11;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = 100) int i11) {
        Hct hctFromInt = Hct.fromInt(i10);
        hctFromInt.setTone(i11);
        return hctFromInt.toInt();
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i10, @AttrRes int i11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        return layer(getColor(view, i10), getColor(view, i11), f);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i10, @AttrRes int i11) {
        return layer(view, i10, i11, 1.0f);
    }

    @ColorInt
    public static int layer(@ColorInt int i10, @ColorInt int i11) {
        return ColorUtils.compositeColors(i11, i10);
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i10) {
        return getColorRoles(i10, isLightTheme(context));
    }
}
