package com.uptodown.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class InstantAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
    }

    @Override // android.widget.AutoCompleteTextView
    public final boolean enoughToFilter() {
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z9, int i10, Rect rect) {
        super.onFocusChanged(z9, i10, rect);
        if (!z9 || getAdapter() == null) {
            return;
        }
        performFiltering(getText(), 0);
    }
}
