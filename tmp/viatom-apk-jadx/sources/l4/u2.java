package l4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u2 extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10870a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10871b;

    public /* synthetic */ u2(w wVar, int i10) {
        this.f10870a = i10;
        this.f10871b = wVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        int i10 = this.f10870a;
        view.getClass();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i10 = this.f10870a;
        textPaint.getClass();
        switch (i10) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((MainActivity) this.f10871b, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                textPaint.setUnderlineText(false);
                break;
            case 1:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor((MainActivity) this.f10871b, R.color.turbo_text_featured));
                textPaint.setTypeface(o4.b.f11719r);
                textPaint.setUnderlineText(false);
                break;
            default:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f10871b, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
        }
    }
}
