package p4;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import c1.w4;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class w implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12022a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12023b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f12024c;

    public /* synthetic */ w(Object obj, Serializable serializable, int i10) {
        this.f12022a = i10;
        this.f12023b = obj;
        this.f12024c = serializable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f12022a;
        Serializable serializable = this.f12024c;
        Object obj = this.f12023b;
        switch (i11) {
            case 0:
                InstallerActivity installerActivity = (InstallerActivity) obj;
                int i12 = InstallerActivity.f6676m0;
                w4 w4Var = new w4(installerActivity, 3, false);
                w4Var.R(true);
                w4Var.N("install_apk_as_root_system", true);
                installerActivity.J(installerActivity, (ArrayList) serializable);
                break;
            case 1:
                InstallerActivity installerActivity2 = (InstallerActivity) obj;
                int i13 = InstallerActivity.f6676m0;
                w4 w4Var2 = new w4(installerActivity2, 3, false);
                w4Var2.R(true);
                w4Var2.N("install_apk_as_root_system", false);
                installerActivity2.J(installerActivity2, (ArrayList) serializable);
                break;
            default:
                TvOldVersionsFragment tvOldVersionsFragment = (TvOldVersionsFragment) obj;
                String str = (String) serializable;
                dialogInterface.getClass();
                dialogInterface.dismiss();
                if (tvOldVersionsFragment.getActivity() != null) {
                    FragmentActivity fragmentActivityRequireActivity = tvOldVersionsFragment.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    str.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                    intent.addFlags(268435456);
                    fragmentActivityRequireActivity.startActivity(intent);
                    break;
                }
                break;
        }
    }
}
