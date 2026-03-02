package j5;

import a3.o;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import c5.b0;
import r7.i0;
import r7.y;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10020a;

    public a(Context context) {
        context.getClass();
        this.f10020a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(j5.a r16, b2.a r17, c5.b0 r18, y6.c r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.a(j5.a, b2.a, c5.b0, y6.c):java.lang.Object");
    }

    public final void b(b0 b0Var) {
        long longVersionCode;
        Context context = this.f10020a;
        context.getClass();
        long j10 = -1;
        try {
            j10 = context.getSharedPreferences("sp_uptodown_services", 0).getLong("versioncode_registered", -1L);
        } catch (ClassCastException unused) {
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String packageName = context.getPackageName();
            packageName.getClass();
            longVersionCode = Build.VERSION.SDK_INT >= 28 ? l5.a.e(packageManager, packageName, 0).getLongVersionCode() : r0.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            longVersionCode = 0;
        }
        if (j10 == longVersionCode) {
            return;
        }
        e eVar = i0.f12407a;
        y.q(y.a(d.f14116a), null, null, new o(this, b0Var, (w6.c) null, 13), 3);
    }
}
