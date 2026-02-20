package a3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f169a = new v0();

    /* renamed from: b, reason: collision with root package name */
    public static final y2.c f170b;

    static {
        l2.d dVar = new l2.d();
        dVar.a(u0.class, h.f76a);
        dVar.a(c1.class, i.f85a);
        dVar.a(l.class, f.f61a);
        dVar.a(c.class, e.f52a);
        dVar.a(b.class, d.f44a);
        dVar.a(k0.class, g.f67a);
        dVar.f10197d = true;
        f170b = new y2.c(dVar, 21);
    }

    public static c a(l1.g gVar) throws PackageManager.NameNotFoundException {
        gVar.a();
        Context context = gVar.f10177a;
        context.getClass();
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        gVar.a();
        String str = gVar.f10179c.f10188b;
        str.getClass();
        Build.MODEL.getClass();
        Build.VERSION.RELEASE.getClass();
        packageName.getClass();
        String str2 = packageInfo.versionName;
        if (str2 == null) {
            str2 = strValueOf;
        }
        Build.MANUFACTURER.getClass();
        gVar.a();
        k0 k0VarB = l0.b(context);
        gVar.a();
        return new c(str, new b(packageName, str2, strValueOf, k0VarB, l0.a(context)));
    }
}
