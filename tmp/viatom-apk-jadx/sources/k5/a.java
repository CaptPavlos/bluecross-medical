package k5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Locale;
import l5.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f10056a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10057b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10058c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10059d;
    public final int e;
    public final int f;
    public final String g;

    public a(Context context) {
        long j10;
        context.getClass();
        this.f10056a = -1L;
        this.f10057b = -1L;
        try {
            j10 = context.getSharedPreferences("sp_uptodown_services", 0).getLong("versioncode_registered", -1L);
        } catch (ClassCastException unused) {
            j10 = -1;
        }
        this.f10056a = j10;
        String country = Locale.getDefault().getCountry();
        this.f10058c = country;
        if (country == null || country.length() == 0) {
            Object systemService = context.getSystemService("phone");
            systemService.getClass();
            this.f10058c = ((TelephonyManager) systemService).getNetworkCountryIso();
        }
        String packageName = context.getPackageName();
        packageName.getClass();
        this.f10059d = b.a(context, packageName);
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String packageName2 = context.getPackageName();
            packageName2.getClass();
            PackageInfo packageInfoE = l5.a.e(packageManager, packageName2, 0);
            this.f10057b = b.c(packageInfoE);
            ApplicationInfo applicationInfo = packageInfoE.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                this.f = 0;
            } else {
                this.f = 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        long j11 = this.f10057b;
        long j12 = this.f10056a;
        if (j11 <= j12 || j12 == -1) {
            this.e = 0;
        } else {
            this.e = 1;
        }
        this.g = Locale.getDefault().getLanguage();
    }
}
