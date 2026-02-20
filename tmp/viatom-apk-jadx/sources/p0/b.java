package p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11875a;

    public b(Context context) {
        this.f11875a = context;
    }

    public final ApplicationInfo a(int i10, String str) {
        return this.f11875a.getPackageManager().getApplicationInfo(str, i10);
    }

    public final PackageInfo b(int i10, String str) {
        return this.f11875a.getPackageManager().getPackageInfo(str, i10);
    }

    public final boolean c() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.f11875a;
        if (callingUid == iMyUid) {
            return a.a(context);
        }
        if (!n0.b.a() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }
}
