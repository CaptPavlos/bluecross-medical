package androidx.leanback.graphics;

import a3.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ColorOverlayDimmer {
    private final float mActiveLevel;
    private int mAlpha;
    private float mAlphaFloat;
    private final float mDimmedLevel;
    private final Paint mPaint;

    private ColorOverlayDimmer(int i10, float f, float f10) {
        f = f > 1.0f ? 1.0f : f;
        f = f < 0.0f ? 0.0f : f;
        f10 = f10 > 1.0f ? 1.0f : f10;
        float f11 = f10 >= 0.0f ? f10 : 0.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.rgb(Color.red(i10), Color.green(i10), Color.blue(i10)));
        this.mActiveLevel = f;
        this.mDimmedLevel = f11;
        setActiveLevel(1.0f);
    }

    public static ColorOverlayDimmer createColorOverlayDimmer(int i10, float f, float f10) {
        return new ColorOverlayDimmer(i10, f, f10);
    }

    public static ColorOverlayDimmer createDefault(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        typedArrayObtainStyledAttributes.recycle();
        return new ColorOverlayDimmer(color, fraction, fraction2);
    }

    public int applyToColor(int i10) {
        float f = 1.0f - this.mAlphaFloat;
        return Color.argb(Color.alpha(i10), (int) (Color.red(i10) * f), (int) (Color.green(i10) * f), (int) (Color.blue(i10) * f));
    }

    public void drawColorOverlay(Canvas canvas, View view, boolean z9) {
        Canvas canvas2;
        canvas.save();
        float translationX = view.getTranslationX() + view.getLeft();
        float translationY = view.getTranslationY() + view.getTop();
        canvas.translate(translationX, translationY);
        canvas.concat(view.getMatrix());
        canvas.translate(-translationX, -translationY);
        if (z9) {
            canvas2 = canvas;
            canvas2.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), this.mPaint);
        } else {
            canvas2 = canvas;
            canvas2.drawRect(view.getPaddingLeft() + view.getLeft(), view.getPaddingTop() + view.getTop(), view.getRight() - view.getPaddingRight(), view.getBottom() - view.getPaddingBottom(), this.mPaint);
        }
        canvas2.restore();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getAlphaFloat() {
        return this.mAlphaFloat;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public boolean needsDraw() {
        return this.mAlpha != 0;
    }

    public void setActiveLevel(float f) {
        float f10 = this.mDimmedLevel;
        float fD = a.d(this.mActiveLevel, f10, f, f10);
        this.mAlphaFloat = fD;
        int i10 = (int) (fD * 255.0f);
        this.mAlpha = i10;
        this.mPaint.setAlpha(i10);
    }
}
