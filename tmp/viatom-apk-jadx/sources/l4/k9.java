package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k9 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.u f10568b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Updates f10569c;

    public /* synthetic */ k9(kotlin.jvm.internal.u uVar, Updates updates, int i10) {
        this.f10567a = i10;
        this.f10568b = uVar;
        this.f10569c = updates;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10567a;
        Updates updates = this.f10569c;
        kotlin.jvm.internal.u uVar = this.f10568b;
        switch (i10) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    uVar.f10135a = true;
                    int i11 = Updates.f6656p0;
                    updates.E0();
                    updates.P0();
                    updates.startActivity(new Intent(updates.getApplicationContext(), (Class<?>) PreferencesActivity.class), k4.c.a(updates));
                    AlertDialog alertDialog = updates.f10935w;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            case 1:
                uVar.f10135a = true;
                AlertDialog alertDialog2 = updates.f10935w;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                int i12 = Updates.f6656p0;
                updates.E0();
                updates.P0();
                break;
            case 2:
                uVar.f10135a = true;
                AlertDialog alertDialog3 = updates.f10935w;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                updates.Z = true;
                updates.N0();
                break;
            case 3:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    uVar.f10135a = true;
                    int i13 = Updates.f6656p0;
                    updates.E0();
                    updates.P0();
                    updates.startActivity(new Intent(updates.getApplicationContext(), (Class<?>) PreferencesActivity.class), k4.c.a(updates));
                    AlertDialog alertDialog4 = updates.f10935w;
                    if (alertDialog4 != null) {
                        alertDialog4.dismiss();
                        break;
                    }
                }
                break;
            default:
                uVar.f10135a = true;
                AlertDialog alertDialog5 = updates.f10935w;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                }
                int i14 = Updates.f6656p0;
                updates.E0();
                updates.P0();
                break;
        }
    }
}
