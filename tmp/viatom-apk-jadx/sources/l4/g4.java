package l4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.R;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10425a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10426b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f10427c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10428d;

    public /* synthetic */ g4(MyDownloads myDownloads, int i10, kotlin.jvm.internal.x xVar) {
        this.f10425a = 0;
        this.f10427c = myDownloads;
        this.f10428d = i10;
        this.f10426b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10425a;
        int i11 = this.f10428d;
        MyDownloads myDownloads = this.f10427c;
        kotlin.jvm.internal.x xVar = this.f10426b;
        switch (i10) {
            case 0:
                n4.b bVar = myDownloads.J;
                bVar.getClass();
                bVar.c(true);
                n4.b bVar2 = myDownloads.J;
                bVar2.getClass();
                bVar2.b(i11);
                myDownloads.t0();
                myDownloads.s0();
                AlertDialog alertDialog = (AlertDialog) xVar.f10138a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 1:
                int i12 = MyDownloads.O;
                AlertDialog alertDialog2 = (AlertDialog) xVar.f10138a;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                myDownloads.o0(i11);
                break;
            default:
                int i13 = MyDownloads.O;
                AlertDialog alertDialog3 = (AlertDialog) xVar.f10138a;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                n4.b bVar3 = myDownloads.J;
                bVar3.getClass();
                String str = ((h5.r) ((h5.q) bVar3.f11300b.get(i11)).f8716v.get(0)).h;
                if (str != null && str.length() != 0) {
                    n4.b bVar4 = myDownloads.J;
                    bVar4.getClass();
                    String str2 = ((h5.r) ((h5.q) bVar4.f11300b.get(i11)).f8716v.get(0)).h;
                    str2.getClass();
                    File parentFile = new File(str2).getParentFile();
                    String absolutePath = parentFile != null ? parentFile.getAbsolutePath() : null;
                    if (absolutePath == null) {
                        String string = myDownloads.getString(R.string.installable_files_not_found);
                        string.getClass();
                        myDownloads.C(string);
                        break;
                    } else {
                        Intent intent = new Intent(myDownloads.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                        intent.putExtra("subdir", absolutePath);
                        myDownloads.startActivity(intent);
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ g4(kotlin.jvm.internal.x xVar, MyDownloads myDownloads, int i10, int i11) {
        this.f10425a = i11;
        this.f10426b = xVar;
        this.f10427c = myDownloads;
        this.f10428d = i10;
    }
}
