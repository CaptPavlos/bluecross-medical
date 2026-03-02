package l5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {
    public static String a(Context context, String str) {
        context.getClass();
        try {
            return Build.VERSION.SDK_INT >= 30 ? context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName() : context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = a.e(packageManager, str, 134217728).signingInfo;
                if (signingInfo.hasPastSigningCertificates()) {
                    Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    signingCertificateHistory.getClass();
                    if (signingCertificateHistory.length != 0) {
                        byte[] byteArray = signingInfo.getSigningCertificateHistory()[0].toByteArray();
                        byteArray.getClass();
                        return a4.y(byteArray);
                    }
                }
                Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                if (apkContentsSigners != null && apkContentsSigners.length != 0) {
                    byte[] byteArray2 = apkContentsSigners[0].toByteArray();
                    byteArray2.getClass();
                    return a4.y(byteArray2);
                }
            } else {
                Signature[] signatureArr = a.e(packageManager, str, 64).signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    byte[] byteArray3 = signatureArr[0].toByteArray();
                    byteArray3.getClass();
                    return a4.y(byteArray3);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long c(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }
}
