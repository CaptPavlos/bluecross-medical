package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i10, int i11, int i12, boolean z9, boolean z10, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
