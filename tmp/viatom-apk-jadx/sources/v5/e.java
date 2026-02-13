package v5;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends MetricAffectingSpan {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f13141d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final float f13142a;

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f13143b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13144c;

    public e(float f, Typeface typeface, int i10) {
        this.f13142a = f;
        this.f13143b = typeface;
        this.f13144c = i10;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setTextSize(this.f13142a);
        textPaint.setTypeface(this.f13143b);
        textPaint.setColor(this.f13144c);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setTextSize(this.f13142a);
        textPaint.setTypeface(this.f13143b);
        textPaint.setColor(this.f13144c);
    }
}
