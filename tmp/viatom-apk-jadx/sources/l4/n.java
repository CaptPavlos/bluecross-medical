package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10639a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10640b;

    public /* synthetic */ n(w wVar, int i10) {
        this.f10639a = i10;
        this.f10640b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10639a) {
            case 0:
                this.f10640b.Q();
                break;
            case 1:
                this.f10640b.Q();
                break;
            case 2:
                this.f10640b.Q();
                break;
            case 3:
                w wVar = this.f10640b;
                AlertDialog alertDialog = wVar.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                wVar.startActivity(new Intent(wVar, (Class<?>) LoginActivity.class));
                break;
            case 4:
                AlertDialog alertDialog2 = this.f10640b.f10935w;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            default:
                AlertDialog alertDialog3 = this.f10640b.f10935w;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
        }
    }
}
