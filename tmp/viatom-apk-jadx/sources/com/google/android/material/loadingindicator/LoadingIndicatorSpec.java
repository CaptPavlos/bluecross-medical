package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class LoadingIndicatorSpec {

    @ColorInt
    int containerColor;

    @Px
    int containerHeight;

    @Px
    int containerWidth;

    @NonNull
    int[] indicatorColors;

    @Px
    int indicatorSize;
    boolean scaleToFit;

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) throws Resources.NotFoundException {
        this.scaleToFit = false;
        this.indicatorColors = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_shape_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_container_size);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.LoadingIndicator, i10, i11, new int[0]);
        this.indicatorSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_indicatorSize, dimensionPixelSize);
        this.containerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerWidth, dimensionPixelSize2);
        this.containerHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerHeight, dimensionPixelSize2);
        loadIndicatorColors(context, typedArrayObtainStyledAttributes);
        this.containerColor = typedArrayObtainStyledAttributes.getColor(R.styleable.LoadingIndicator_containerColor, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void loadIndicatorColors(@NonNull Context context, @NonNull TypedArray typedArray) throws Resources.NotFoundException {
        int i10 = R.styleable.LoadingIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.indicatorColors = intArray;
        if (intArray.length != 0) {
            return;
        }
        a.n("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    public void setScaleToFit(boolean z9) {
        this.scaleToFit = z9;
    }

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        this(context, attributeSet, i10, LoadingIndicator.DEF_STYLE_RES);
    }

    public LoadingIndicatorSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }
}
