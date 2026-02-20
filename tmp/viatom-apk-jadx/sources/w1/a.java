package w1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13317a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13318b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13319c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13320d;
    public final String e;
    public final String f;
    public final String g;
    public final t1.c h;

    public a(String str, String str2, ArrayList arrayList, String str3, String str4, String str5, String str6, t1.c cVar) {
        this.f13317a = str;
        this.f13318b = str2;
        this.f13319c = arrayList;
        this.f13320d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = cVar;
    }

    public static a a(Context context, w wVar, String str, String str2, ArrayList arrayList, t1.c cVar) {
        String packageName = context.getPackageName();
        String strD = wVar.d();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String string = Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, arrayList, strD, packageName, string, str3, cVar);
    }
}
