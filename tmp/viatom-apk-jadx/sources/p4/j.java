package p4;

import android.app.AlertDialog;
import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import r7.a1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11975a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f11976b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11977c;

    public /* synthetic */ j(kotlin.jvm.internal.x xVar, FileExplorerActivity fileExplorerActivity, int i10) {
        this.f11975a = i10;
        this.f11976b = xVar;
        this.f11977c = fileExplorerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f11975a;
        FileExplorerActivity fileExplorerActivity = this.f11977c;
        kotlin.jvm.internal.x xVar = this.f11976b;
        switch (i10) {
            case 0:
                int i11 = FileExplorerActivity.f6665q0;
                a1 a1Var = (a1) xVar.f10138a;
                if (a1Var != null) {
                    a1Var.a(null);
                }
                AlertDialog alertDialog = fileExplorerActivity.J;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i12 = FileExplorerActivity.f6665q0;
                a1 a1Var2 = (a1) xVar.f10138a;
                if (a1Var2 != null) {
                    a1Var2.a(null);
                }
                AlertDialog alertDialog2 = fileExplorerActivity.J;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
        }
    }
}
