package com.uptodown.tv.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public final class FullWidthImageViewTv extends ImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullWidthImageViewTv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (getDrawable() == null) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i10), (int) Math.ceil((r3 * getDrawable().getIntrinsicHeight()) / getDrawable().getIntrinsicWidth()));
        }
    }
}
