package l4;

import android.content.Intent;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z3 implements g5.i, g5.z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f11060a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.f f11061b;

    public /* synthetic */ z3(a4 a4Var, h5.f fVar) {
        this.f11060a = a4Var;
        this.f11061b = fVar;
    }

    @Override // g5.i
    public void f(int i10) {
        Object[] objArr = {this.f11061b.f8525b};
        a4 a4Var = this.f11060a;
        String string = a4Var.getString(R.string.rollback_not_available, objArr);
        string.getClass();
        a4Var.C(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        boolean zB = hVar.b();
        a4 a4Var = this.f11060a;
        if (!zB) {
            String string = a4Var.getString(R.string.rollback_not_available, hVar.f8567b);
            string.getClass();
            a4Var.C(string);
        } else {
            Intent intent = new Intent(a4Var.getApplicationContext(), (Class<?>) OldVersionsActivity.class);
            intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f11061b);
            intent.putExtra("appInfo", hVar);
            float f = UptodownApp.E;
            a4Var.startActivity(intent, k4.c.a(a4Var));
        }
    }

    @Override // g5.z
    public void m(h5.o0 o0Var) {
        a4 a4Var = this.f11060a;
        Intent intent = new Intent(a4Var, (Class<?>) VirusTotalReport.class);
        intent.putExtra("app_selected", this.f11061b);
        intent.putExtra("appReportVT", o0Var);
        float f = UptodownApp.E;
        a4Var.startActivity(intent, k4.c.a(a4Var));
    }

    @Override // g5.z
    public void q() {
        h5.f fVar = this.f11061b;
        long j10 = fVar.f8533n;
        a4 a4Var = this.f11060a;
        if (j10 <= 650000000) {
            a4Var.c0(fVar.f8538s);
            return;
        }
        Intent intent = new Intent(a4Var, (Class<?>) VirusTotalReport.class);
        intent.putExtra("app_selected", fVar);
        intent.putExtra("isVirusTotalReportAvaialable", false);
        float f = UptodownApp.E;
        a4Var.startActivity(intent, k4.c.a(a4Var));
    }
}
