package p4;

import android.app.AlertDialog;
import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11933a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11934b;

    public /* synthetic */ d(f fVar, int i10) {
        this.f11933a = i10;
        this.f11934b = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f11933a) {
            case 0:
                f fVar = this.f11934b;
                AlertDialog alertDialog = fVar.f11942a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                fVar.A();
                break;
            case 1:
                AlertDialog alertDialog2 = this.f11934b.f11942a;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            default:
                AlertDialog alertDialog3 = this.f11934b.f11942a;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
        }
    }
}
