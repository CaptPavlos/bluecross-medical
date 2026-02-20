package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class MediaRowFocusView extends View {
    private final Paint mPaint;
    private final RectF mRoundRectF;
    private int mRoundRectRadius;

    public MediaRowFocusView(Context context) {
        super(context);
        this.mRoundRectF = new RectF();
        this.mPaint = createPaint(context);
    }

    private Paint createPaint(Context context) {
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(androidx.leanback.R.color.lb_playback_media_row_highlight_color));
        return paint;
    }

    public int getRoundRectRadius() {
        return this.mRoundRectRadius;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.mRoundRectRadius = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        this.mRoundRectF.set(0.0f, -height2, getWidth(), getHeight() + height2);
        RectF rectF = this.mRoundRectF;
        int i10 = this.mRoundRectRadius;
        canvas.drawRoundRect(rectF, i10, i10, this.mPaint);
    }

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRoundRectF = new RectF();
        this.mPaint = createPaint(context);
    }

    public MediaRowFocusView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mRoundRectF = new RectF();
        this.mPaint = createPaint(context);
    }
}
