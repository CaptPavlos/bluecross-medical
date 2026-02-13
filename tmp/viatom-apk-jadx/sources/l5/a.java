package l5;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {
    public static final Parcelable a(Bundle bundle, String str, Class cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, cls);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor(null).newInstance(null);
            }
        } else {
            parcelable = bundle.getParcelable(str);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor(null).newInstance(null);
            }
        }
        if (parcelable != null) {
            return parcelable;
        }
        Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
        objNewInstance.getClass();
        return (Parcelable) objNewInstance;
    }

    public static final ApplicationInfo b(PackageManager packageManager, String str, int i10) throws PackageManager.NameNotFoundException {
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(i10));
            applicationInfo.getClass();
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(str, i10);
        applicationInfo2.getClass();
        return applicationInfo2;
    }

    public static final List c(PackageManager packageManager) {
        if (Build.VERSION.SDK_INT >= 33) {
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
            installedApplications.getClass();
            return installedApplications;
        }
        List<ApplicationInfo> installedApplications2 = packageManager.getInstalledApplications(128);
        installedApplications2.getClass();
        return installedApplications2;
    }

    public static final PackageInfo d(PackageManager packageManager, String str, int i10) {
        str.getClass();
        try {
            return Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageArchiveInfo(str, PackageManager.PackageInfoFlags.of(i10)) : packageManager.getPackageArchiveInfo(str, i10);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final PackageInfo e(PackageManager packageManager, String str, int i10) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i10));
            packageInfo.getClass();
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i10);
        packageInfo2.getClass();
        return packageInfo2;
    }

    public static final PackageInfo f(PackageManager packageManager, String str, int i10) throws PackageManager.NameNotFoundException {
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i10));
            packageInfo.getClass();
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i10);
        packageInfo2.getClass();
        return packageInfo2;
    }
}
