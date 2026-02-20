package v5;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends CharacterStyle implements UpdateAppearance {

    /* renamed from: a, reason: collision with root package name */
    public final LinearGradient f13138a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13139b;

    public b(LinearGradient linearGradient, float f) {
        this.f13138a = linearGradient;
        this.f13139b = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setShader(this.f13138a);
        textPaint.setTextSize(this.f13139b);
        textPaint.setColor(textPaint.linkColor);
    }
}
