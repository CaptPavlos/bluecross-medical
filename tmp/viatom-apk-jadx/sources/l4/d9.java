package l4;

import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.activities.SecurityActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d9 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10335a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f10336b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d9(SecurityActivity securityActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10335a = i10;
        this.f10336b = securityActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10335a) {
            case 0:
                return new d9(this.f10336b, cVar, 0);
            default:
                return new d9(this.f10336b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10335a) {
            case 0:
                d9 d9Var = (d9) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                d9Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                d9 d9Var2 = (d9) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                d9Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10335a;
        s6.w wVar = s6.w.f12711a;
        SecurityActivity securityActivity = this.f10336b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                int i11 = SecurityActivity.Z;
                securityActivity.B0().f7396b.setVisibility(8);
                TextView textView = securityActivity.B0().g;
                long jW = z1.t1.w(0L, securityActivity, "last_analysis_timestamp");
                textView.setText(securityActivity.getString(R.string.uptodown_last_analysis, String.valueOf(jW <= 0 ? null : new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(jW)))));
                break;
            default:
                s6.a.e(obj);
                if (securityActivity.B0().f7396b.getVisibility() == 8) {
                    securityActivity.u0();
                    securityActivity.C0();
                    break;
                }
                break;
        }
        return wVar;
    }
}
