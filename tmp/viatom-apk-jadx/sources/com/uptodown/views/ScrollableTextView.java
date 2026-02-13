package com.uptodown.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ScrollableTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        if (getText().toString().length() > 0) {
            setSingleLine();
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setMarqueeRepeatLimit(1);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setHorizontallyScrolling(true);
            postDelayed(new a(this, 16), 3000L);
        }
    }
}
