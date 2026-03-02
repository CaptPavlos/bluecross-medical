package p4;

import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 implements t4.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f11935a;

    public /* synthetic */ d0(InstallerActivity installerActivity) {
        this.f11935a = installerActivity;
    }

    @Override // t4.b
    public void i() {
        InstallerActivity installerActivity = this.f11935a;
        installerActivity.runOnUiThread(new y(installerActivity, 0));
    }

    @Override // t4.b
    public void k(String str) {
        InstallerActivity installerActivity = this.f11935a;
        if (str != null && str.length() != 0) {
            installerActivity.C(str);
        }
        installerActivity.F();
    }
}
