package com.uptodown.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public int f6727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        this.f6727a = (int) context.getResources().getDimension(R.dimen.remote_install_devices_rv_max_height);
    }

    public final int getMaxHeightPx() {
        return this.f6727a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12 = this.f6727a;
        if (i12 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
    }

    public final void setMaxHeightPx(int i10) {
        this.f6727a = i10;
    }
}
