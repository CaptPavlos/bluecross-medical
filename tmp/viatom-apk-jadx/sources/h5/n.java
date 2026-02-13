package h5;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f8668b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5.f f8669c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f8670d;

    public /* synthetic */ n(o oVar, g5.f fVar, Context context, int i10) {
        this.f8667a = i10;
        this.f8668b = oVar;
        this.f8669c = fVar;
        this.f8670d = context;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Long l10;
        Long l11;
        int i10 = this.f8667a;
        g5.f fVar = this.f8669c;
        o oVar = this.f8668b;
        view.getClass();
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s() && (l10 = oVar.f8673c) != null) {
                    fVar.b(l10.longValue());
                    break;
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s() && (l11 = oVar.f8673c) != null) {
                    k kVar = new k((int) l11.longValue(), oVar.f8674d, 4);
                    kVar.f8635d = true;
                    fVar.d(kVar);
                    break;
                }
                break;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i10 = this.f8667a;
        textPaint.getClass();
        switch (i10) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8670d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
            default:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8670d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
        }
    }
}
