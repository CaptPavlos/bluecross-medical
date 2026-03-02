package h5;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import e5.b2;
import e5.w1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8652a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f8653b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w1 f8654c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f8655d;

    public /* synthetic */ m(o oVar, w1 w1Var, Context context, int i10) {
        this.f8652a = i10;
        this.f8653b = oVar;
        this.f8654c = w1Var;
        this.f8655d = context;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Long l10;
        Long l11;
        Long l12;
        String str;
        int i10 = this.f8652a;
        w1 w1Var = this.f8654c;
        o oVar = this.f8653b;
        view.getClass();
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s() && (l10 = oVar.f8673c) != null) {
                    long jLongValue = l10.longValue();
                    b2 b2Var = w1Var.f7896a;
                    if (b2Var.getActivity() instanceof l4.w) {
                        FragmentActivity activity = b2Var.getActivity();
                        activity.getClass();
                        ((l4.w) activity).Y(jLongValue);
                        break;
                    }
                }
                break;
            case 1:
                float f10 = UptodownApp.E;
                if (k4.c.s() && (l11 = oVar.f8673c) != null) {
                    k kVar = new k((int) l11.longValue(), oVar.f8674d, 4);
                    kVar.f8635d = true;
                    w1Var.a(kVar);
                    break;
                }
                break;
            case 2:
                float f11 = UptodownApp.E;
                if (k4.c.s() && (l12 = oVar.f8673c) != null) {
                    w1Var.a(new k((int) l12.longValue(), oVar.f8674d, 4));
                    break;
                }
                break;
            default:
                float f12 = UptodownApp.E;
                if (k4.c.s() && (str = oVar.f) != null && str.length() != 0) {
                    String str2 = oVar.f;
                    str2.getClass();
                    w1Var.getClass();
                    b2 b2Var2 = w1Var.f7896a;
                    if (b2Var2.getActivity() instanceof l4.w) {
                        FragmentActivity fragmentActivityRequireActivity = b2Var2.requireActivity();
                        fragmentActivityRequireActivity.getClass();
                        v5.c.e(fragmentActivityRequireActivity, str2, null);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        int i10 = this.f8652a;
        textPaint.getClass();
        switch (i10) {
            case 0:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8655d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
            case 1:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8655d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
            case 2:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8655d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
            default:
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f8655d, R.color.main_blue));
                textPaint.setTypeface(o4.b.f11719r);
                break;
        }
    }
}
