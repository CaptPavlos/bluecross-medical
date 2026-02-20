package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.SecurityActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c9 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f10301b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.f f10302c;

    public /* synthetic */ c9(h5.f fVar, SecurityActivity securityActivity) {
        this.f10300a = 3;
        this.f10302c = fVar;
        this.f10301b = securityActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10300a;
        SecurityActivity securityActivity = this.f10301b;
        h5.f fVar = this.f10302c;
        switch (i10) {
            case 0:
                int i11 = SecurityActivity.Z;
                securityActivity.Y(fVar.f8541w);
                AlertDialog alertDialog = securityActivity.f10935w;
                alertDialog.getClass();
                alertDialog.dismiss();
                break;
            case 1:
                int i12 = SecurityActivity.Z;
                securityActivity.c0(fVar.f8538s);
                AlertDialog alertDialog2 = securityActivity.f10935w;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            case 2:
                int i13 = SecurityActivity.Z;
                long j10 = fVar.f8541w;
                SecurityActivity securityActivity2 = this.f10301b;
                new c1.l(securityActivity2, j10, new i0.k(15, securityActivity2, fVar), LifecycleOwnerKt.getLifecycleScope(securityActivity2));
                AlertDialog alertDialog3 = securityActivity2.f10935w;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
            default:
                int i14 = SecurityActivity.Z;
                String str = fVar.f8526c;
                if (str != null) {
                    str.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                    intent.addFlags(268435456);
                    securityActivity.startActivity(intent);
                }
                AlertDialog alertDialog4 = securityActivity.f10935w;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
        }
    }

    public /* synthetic */ c9(SecurityActivity securityActivity, h5.f fVar, int i10) {
        this.f10300a = i10;
        this.f10301b = securityActivity;
        this.f10302c = fVar;
    }
}
