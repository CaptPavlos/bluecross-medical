package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ObservableScrollView extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private a f5897a;

    public ObservableScrollView(Context context) {
        super(context);
        this.f5897a = null;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i10) {
        super.fling(i10 / 4);
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        a aVar = this.f5897a;
        if (aVar != null) {
            aVar.a(this, i10, i11, i12, i13);
        }
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5897a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5897a = null;
    }
}
