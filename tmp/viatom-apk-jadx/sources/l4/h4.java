package l4;

import android.app.AlertDialog;
import android.view.View;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.UserActivity;
import com.uptodown.workers.DownloadWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10456b;

    public /* synthetic */ h4(kotlin.jvm.internal.x xVar, int i10) {
        this.f10455a = i10;
        this.f10456b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10455a;
        kotlin.jvm.internal.x xVar = this.f10456b;
        switch (i10) {
            case 0:
                int i11 = MyDownloads.O;
                if (DownloadWorker.f) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                } else {
                    DownloadWorker.f = true;
                }
                AlertDialog alertDialog = (AlertDialog) xVar.f10138a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i12 = UserActivity.Q;
                Object obj = xVar.f10138a;
                obj.getClass();
                ((AlertDialog) obj).dismiss();
                break;
        }
    }
}
