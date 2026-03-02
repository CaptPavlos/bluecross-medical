package p4;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import l4.kb;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f12029b;

    public /* synthetic */ y(InstallerActivity installerActivity, int i10) {
        this.f12028a = i10;
        this.f12029b = installerActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        long length;
        int i10 = this.f12028a;
        Drawable drawableLoadIcon = null;
        Object[] objArr = 0;
        InstallerActivity installerActivity = this.f12029b;
        int i11 = 1;
        switch (i10) {
            case 0:
                String str = installerActivity.K;
                if (str != null && o7.u.X(str, ".apk", false)) {
                    PackageManager packageManager = installerActivity.getPackageManager();
                    packageManager.getClass();
                    String str2 = installerActivity.K;
                    str2.getClass();
                    PackageInfo packageInfoD = l5.a.d(packageManager, str2, 128);
                    if ((packageInfoD != null ? packageInfoD.applicationInfo : null) != null) {
                        LinearLayout linearLayout = installerActivity.f6686x;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                        ApplicationInfo applicationInfo = packageInfoD.applicationInfo;
                        applicationInfo.getClass();
                        String str3 = installerActivity.K;
                        str3.getClass();
                        applicationInfo.sourceDir = str3;
                        applicationInfo.publicSourceDir = str3;
                        String string = packageManager.getApplicationLabel(applicationInfo).toString();
                        long jD = x4.d.d(packageInfoD);
                        String str4 = installerActivity.K;
                        str4.getClass();
                        try {
                            length = new File(str4).length();
                        } catch (Exception unused) {
                            length = -1;
                        }
                        Activity activity = o4.b.g;
                        String str5 = packageInfoD.packageName;
                        str5.getClass();
                        r0.f.J(jD, length, str5, string);
                        if (!installerActivity.Y) {
                            String str6 = installerActivity.K;
                            str6.getClass();
                            File file = new File(str6);
                            ImageView imageView = installerActivity.G;
                            if (imageView != null) {
                                String str7 = installerActivity.K;
                                str7.getClass();
                                PackageManager packageManager2 = installerActivity.getPackageManager();
                                packageManager2.getClass();
                                PackageInfo packageInfoD2 = l5.a.d(packageManager2, str7, 128);
                                if ((packageInfoD2 != null ? packageInfoD2.applicationInfo : null) != null) {
                                    ApplicationInfo applicationInfo2 = packageInfoD2.applicationInfo;
                                    applicationInfo2.getClass();
                                    applicationInfo2.sourceDir = str7;
                                    ApplicationInfo applicationInfo3 = packageInfoD2.applicationInfo;
                                    applicationInfo3.getClass();
                                    applicationInfo3.publicSourceDir = str7;
                                    ApplicationInfo applicationInfo4 = packageInfoD2.applicationInfo;
                                    applicationInfo4.getClass();
                                    drawableLoadIcon = applicationInfo4.loadIcon(installerActivity.getPackageManager());
                                }
                                imageView.setImageDrawable(drawableLoadIcon);
                            }
                            TextView textView = installerActivity.f6685w;
                            if (textView != null) {
                                textView.setText(string);
                            }
                            TextView textView2 = installerActivity.f6685w;
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            }
                            TextView textView3 = installerActivity.y;
                            if (textView3 != null) {
                                textView3.setText(file.getName());
                            }
                            TextView textView4 = installerActivity.y;
                            if (textView4 != null) {
                                textView4.setVisibility(0);
                            }
                            TextView textView5 = installerActivity.f6687z;
                            if (textView5 != null) {
                                textView5.setText(l1.b.L(length));
                            }
                            TextView textView6 = installerActivity.f6687z;
                            if (textView6 != null) {
                                textView6.setVisibility(0);
                            }
                            TextView textView7 = installerActivity.A;
                            if (textView7 != null) {
                                textView7.setText(packageInfoD.versionName);
                            }
                            TextView textView8 = installerActivity.A;
                            if (textView8 != null) {
                                textView8.setVisibility(0);
                            }
                        }
                    }
                }
                if (!installerActivity.Y) {
                    installerActivity.runOnUiThread(new y(installerActivity, i11));
                    break;
                } else {
                    installerActivity.finish();
                    break;
                }
                break;
            default:
                int i12 = InstallerActivity.f6676m0;
                if (installerActivity.Q == null) {
                    y7.e eVar = r7.i0.f12407a;
                    installerActivity.Q = r7.y.q(r7.y.a(y7.d.f14116a), null, null, new kb((Object) installerActivity, (w6.c) (objArr == true ? 1 : 0), 7), 3);
                }
                LinearLayout linearLayout2 = installerActivity.U;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView9 = installerActivity.D;
                if (textView9 != null) {
                    textView9.setText(R.string.installing);
                }
                ProgressBar progressBar = installerActivity.f6679p;
                if (progressBar != null) {
                    progressBar.setIndeterminate(true);
                }
                installerActivity.getWindow().addFlags(128);
                ImageView imageView2 = installerActivity.H;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                TextView textView10 = installerActivity.F;
                if (textView10 != null) {
                    textView10.setVisibility(8);
                    break;
                }
                break;
        }
    }
}
