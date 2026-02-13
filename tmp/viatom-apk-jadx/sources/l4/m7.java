package l4;

import android.view.View;
import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m7 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10630a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f10631b;

    public /* synthetic */ m7(RepliesActivity repliesActivity, int i10) {
        this.f10630a = i10;
        this.f10631b = repliesActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10630a;
        RepliesActivity repliesActivity = this.f10631b;
        switch (i10) {
            case 0:
                int i11 = RepliesActivity.L;
                repliesActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i12 = RepliesActivity.L;
                if (repliesActivity.o0().f11039m.getValue() != null) {
                    Object value = repliesActivity.o0().f11039m.getValue();
                    value.getClass();
                    repliesActivity.Y(((h5.t0) value).e);
                    break;
                }
                break;
            case 2:
                int i13 = RepliesActivity.L;
                repliesActivity.Z(((Number) repliesActivity.o0().f11042p.getValue()).longValue(), (String) repliesActivity.o0().f11043q.getValue());
                break;
            case 3:
                int i14 = RepliesActivity.L;
                repliesActivity.p0();
                break;
            case 4:
                int i15 = RepliesActivity.L;
                repliesActivity.q0();
                break;
            default:
                int i16 = RepliesActivity.L;
                repliesActivity.l0();
                break;
        }
    }
}
