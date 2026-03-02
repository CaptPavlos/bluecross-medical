package t5;

import android.view.View;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends ImageView {
    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (getDrawable() == null) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension((int) Math.ceil((r3 * getDrawable().getIntrinsicWidth()) / getDrawable().getIntrinsicHeight()), View.MeasureSpec.getSize(i11));
        }
    }
}
