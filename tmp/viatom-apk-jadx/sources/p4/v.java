package p4;

import android.app.AlertDialog;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12020a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f12021b;

    public /* synthetic */ v(InstallerActivity installerActivity, int i10) {
        this.f12020a = i10;
        this.f12021b = installerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws XmlPullParserException, IOException {
        int i10 = this.f12020a;
        InstallerActivity installerActivity = this.f12021b;
        switch (i10) {
            case 0:
                int i11 = InstallerActivity.f6676m0;
                Application application = installerActivity.getApplication();
                application.getClass();
                ((o4.b) application).f11726a.send(225, null);
                installerActivity.finish();
                break;
            case 1:
                AlertDialog alertDialog = installerActivity.O;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                installerActivity.F();
                break;
            case 2:
                AlertDialog alertDialog2 = installerActivity.N;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                installerActivity.F();
                break;
            case 3:
                int i12 = InstallerActivity.f6676m0;
                Application application2 = installerActivity.getApplication();
                application2.getClass();
                ((o4.b) application2).f11726a.send(226, null);
                installerActivity.G();
                break;
            case 4:
                int i13 = InstallerActivity.f6676m0;
                installerActivity.F();
                break;
            case 5:
                TextView textView = installerActivity.f6685w;
                Bundle bundleF = com.mbridge.msdk.dycreator.baseview.a.f("appNameAndVersion", String.valueOf(textView != null ? textView.getText() : null));
                Application application3 = installerActivity.getApplication();
                application3.getClass();
                ((o4.b) application3).f11726a.send(222, bundleF);
                installerActivity.finish();
                break;
            case 6:
                TextView textView2 = installerActivity.E;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                installerActivity.N(installerActivity.K);
                break;
            case 7:
                int i14 = InstallerActivity.f6676m0;
                installerActivity.F();
                break;
            case 8:
                int i15 = InstallerActivity.f6676m0;
                view.getClass();
                Object tag = view.getTag();
                tag.getClass();
                String str = (String) tag;
                TextView textView3 = installerActivity.E;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                new File(str).delete();
                installerActivity.finish();
                break;
            default:
                installerActivity.finish();
                break;
        }
    }
}
