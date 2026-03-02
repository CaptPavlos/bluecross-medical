package v5;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends MetricAffectingSpan {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13145c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13146a;

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f13147b;

    public /* synthetic */ f(Typeface typeface, int i10) {
        this.f13146a = i10;
        this.f13147b = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i10 = this.f13146a;
        textPaint.getClass();
        switch (i10) {
            case 0:
                textPaint.setTypeface(this.f13147b);
                break;
            default:
                textPaint.setTypeface(this.f13147b);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        int i10 = this.f13146a;
        textPaint.getClass();
        switch (i10) {
            case 0:
                textPaint.setTypeface(this.f13147b);
                break;
            default:
                textPaint.setTypeface(this.f13147b);
                break;
        }
    }
}
