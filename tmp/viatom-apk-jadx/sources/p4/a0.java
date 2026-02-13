package p4;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uptodown.R;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 implements t4.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f11920a;

    public /* synthetic */ a0(InstallerActivity installerActivity) {
        this.f11920a = installerActivity;
    }

    @Override // t4.d
    public void a(File file, ArrayList arrayList) throws XmlPullParserException, IOException {
        this.f11920a.M(file, arrayList);
    }

    @Override // t4.d
    public void c(int i10) {
        InstallerActivity installerActivity = this.f11920a;
        installerActivity.runOnUiThread(new androidx.core.content.res.a(installerActivity, i10, 2));
    }

    @Override // t4.d
    public void e(File file) {
        long length;
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            InstallerActivity installerActivity = this.f11920a;
            installerActivity.K = absolutePath;
            PackageManager packageManager = installerActivity.getPackageManager();
            packageManager.getClass();
            String str = installerActivity.K;
            str.getClass();
            PackageInfo packageInfoD = l5.a.d(packageManager, str, 128);
            Drawable drawableLoadIcon = null;
            if ((packageInfoD != null ? packageInfoD.applicationInfo : null) != null) {
                if (!installerActivity.Z) {
                    ImageView imageView = installerActivity.G;
                    if (imageView != null) {
                        String absolutePath2 = file.getAbsolutePath();
                        absolutePath2.getClass();
                        PackageManager packageManager2 = installerActivity.getPackageManager();
                        packageManager2.getClass();
                        PackageInfo packageInfoD2 = l5.a.d(packageManager2, absolutePath2, 128);
                        if ((packageInfoD2 != null ? packageInfoD2.applicationInfo : null) != null) {
                            ApplicationInfo applicationInfo = packageInfoD2.applicationInfo;
                            applicationInfo.getClass();
                            applicationInfo.sourceDir = absolutePath2;
                            ApplicationInfo applicationInfo2 = packageInfoD2.applicationInfo;
                            applicationInfo2.getClass();
                            applicationInfo2.publicSourceDir = absolutePath2;
                            ApplicationInfo applicationInfo3 = packageInfoD2.applicationInfo;
                            applicationInfo3.getClass();
                            drawableLoadIcon = applicationInfo3.loadIcon(installerActivity.getPackageManager());
                        }
                        imageView.setImageDrawable(drawableLoadIcon);
                    }
                    installerActivity.Z = true;
                }
                LinearLayout linearLayout = installerActivity.f6686x;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ApplicationInfo applicationInfo4 = packageInfoD.applicationInfo;
                applicationInfo4.getClass();
                String str2 = installerActivity.K;
                str2.getClass();
                applicationInfo4.sourceDir = str2;
                applicationInfo4.publicSourceDir = str2;
                String string = packageManager.getApplicationLabel(applicationInfo4).toString();
                long jD = x4.d.d(packageInfoD);
                String str3 = installerActivity.K;
                str3.getClass();
                try {
                    length = new File(str3).length();
                } catch (Exception unused) {
                    length = -1;
                }
                Activity activity = o4.b.g;
                String str4 = packageInfoD.packageName;
                str4.getClass();
                r0.f.J(jD, length, str4, string);
                if (installerActivity.Y) {
                    return;
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

    @Override // t4.d
    public void f(File file) {
        InstallerActivity installerActivity = this.f11920a;
        if (installerActivity.J == null) {
            installerActivity.J = new ArrayList();
        }
        ArrayList arrayList = installerActivity.J;
        arrayList.getClass();
        arrayList.add(file);
    }

    @Override // t4.d
    public void g() {
        InstallerActivity installerActivity = this.f11920a;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.D;
        if (textView != null) {
            textView.setText(R.string.error_not_enough_space);
        }
    }

    @Override // t4.d
    public void l() {
        o4.b.f11717p = null;
        InstallerActivity installerActivity = this.f11920a;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.f6680q;
        if (textView != null) {
            textView.setText(installerActivity.getString(R.string.core_kill_this_app, installerActivity.getString(R.string.app_name)));
        }
        TextView textView2 = installerActivity.f6680q;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = installerActivity.F;
        if (textView3 != null) {
            textView3.setOnClickListener(new v(installerActivity, 9));
        }
    }

    @Override // t4.d
    public void n() {
        InstallerActivity installerActivity = this.f11920a;
        installerActivity.runOnUiThread(new androidx.core.content.res.a(installerActivity, 0, 2));
    }

    @Override // t4.d
    public void o() {
        TextView textView = this.f11920a.D;
        if (textView != null) {
            textView.setText(R.string.error_unzipping);
        }
    }

    @Override // t4.d
    public void r() {
        o4.b.f11717p = null;
        InstallerActivity installerActivity = this.f11920a;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.f6680q;
        if (textView != null) {
            textView.setText(installerActivity.getString(R.string.msg_install_from_unknown_source, installerActivity.getString(R.string.app_name)));
        }
        installerActivity.k();
    }
}
