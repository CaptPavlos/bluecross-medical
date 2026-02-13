package l4;

import android.content.res.Resources;
import android.view.View;
import com.inmobi.cmp.ChoiceCmp;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import com.uptodown.R;
import com.uptodown.activities.GdprPrivacySettings;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f10239b;

    public /* synthetic */ b1(GdprPrivacySettings gdprPrivacySettings, int i10) {
        this.f10238a = i10;
        this.f10239b = gdprPrivacySettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f10238a;
        GdprPrivacySettings gdprPrivacySettings = this.f10239b;
        switch (i10) {
            case 0:
                int i11 = GdprPrivacySettings.I;
                gdprPrivacySettings.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i12 = GdprPrivacySettings.I;
                ChoiceCmp.forceDisplayUI(gdprPrivacySettings);
                ChoiceCmp.showUSRegulationScreen(gdprPrivacySettings);
                break;
            case 2:
                int i13 = GdprPrivacySettings.I;
                if (!gdprPrivacySettings.isFinishing()) {
                    String string = gdprPrivacySettings.getString(R.string.url_contact);
                    string.getClass();
                    v5.c.e(gdprPrivacySettings, string, null);
                    break;
                }
                break;
            case 3:
                int i14 = GdprPrivacySettings.I;
                MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
                mBridgeSDK.getClass();
                mBridgeSDK.setConsentStatus(gdprPrivacySettings, 1);
                MBridgeSDKImpl mBridgeSDK2 = MBridgeSDKFactory.getMBridgeSDK();
                mBridgeSDK2.getClass();
                mBridgeSDK2.setDoNotTrackStatus(false);
                gdprPrivacySettings.n0().f.setChecked(true);
                gdprPrivacySettings.n0().e.setChecked(true);
                gdprPrivacySettings.n0().g.setChecked(true);
                gdprPrivacySettings.o0();
                gdprPrivacySettings.finish();
                break;
            case 4:
                int i15 = GdprPrivacySettings.I;
                gdprPrivacySettings.p0();
                gdprPrivacySettings.n0().f.setChecked(false);
                gdprPrivacySettings.n0().e.setChecked(false);
                gdprPrivacySettings.n0().g.setChecked(false);
                break;
            default:
                int i16 = GdprPrivacySettings.I;
                gdprPrivacySettings.o0();
                gdprPrivacySettings.finish();
                break;
        }
    }
}
