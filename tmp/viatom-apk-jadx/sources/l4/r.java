package l4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.o0 f10780b;

    public r(w wVar, h5.o0 o0Var) {
        this.f10779a = wVar;
        this.f10780b = o0Var;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        view.getClass();
        this.f10779a.c0(this.f10780b.f8675a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.getClass();
        super.updateDrawState(textPaint);
        textPaint.setColor(ContextCompat.getColor(this.f10779a, R.color.main_blue));
        textPaint.setTypeface(o4.b.f11719r);
        textPaint.setUnderlineText(false);
    }
}
