package i0;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f8903d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f8904a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8905b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8906c;

    public g0(String str, boolean z9) {
        y.d(str);
        this.f8904a = str;
        y.d("com.google.android.gms");
        this.f8905b = "com.google.android.gms";
        this.f8906c = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent a(android.content.Context r6) throws i0.z, android.os.RemoteException {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            r1 = 0
            java.lang.String r2 = r5.f8904a
            if (r2 == 0) goto L9f
            boolean r3 = r5.f8906c
            if (r3 == 0) goto L90
            java.lang.String r3 = "serviceActionBundleKey"
            android.os.Bundle r3 = com.mbridge.msdk.dycreator.baseview.a.f(r3, r2)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            android.net.Uri r4 = i0.g0.f8903d     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            if (r6 == 0) goto L34
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r3 = r6.call(r4, r1, r3)     // Catch: java.lang.Throwable -> L2b
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L27 android.os.RemoteException -> L29
            goto L4a
        L27:
            r6 = move-exception
            goto L3d
        L29:
            r6 = move-exception
            goto L3d
        L2b:
            r3 = move-exception
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            throw r3     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
        L30:
            r6 = move-exception
            goto L3c
        L32:
            r6 = move-exception
            goto L3c
        L34:
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            java.lang.String r3 = "Failed to acquire ContentProviderClient"
            r6.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
            throw r6     // Catch: java.lang.IllegalArgumentException -> L30 android.os.RemoteException -> L32
        L3c:
            r3 = r1
        L3d:
            java.lang.String r4 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r4.concat(r6)
            android.util.Log.w(r0, r6)
        L4a:
            if (r3 == 0) goto L85
            java.lang.String r6 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r3.getParcelable(r6)
            r1 = r6
            android.content.Intent r1 = (android.content.Intent) r1
            if (r1 != 0) goto L85
            java.lang.String r6 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r6 = r3.getParcelable(r6)
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            if (r6 != 0) goto L62
            goto L85
        L62:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Dynamic lookup for intent failed for action "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = " but has possible resolution"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            i0.z r0 = new i0.z
            f0.b r1 = new f0.b
            r2 = 25
            r1.<init>(r2, r6)
            r0.<init>(r1)
            throw r0
        L85:
            if (r1 != 0) goto L90
            java.lang.String r6 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = r6.concat(r2)
            android.util.Log.w(r0, r6)
        L90:
            if (r1 != 0) goto L9e
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r2)
            java.lang.String r0 = r5.f8905b
            android.content.Intent r6 = r6.setPackage(r0)
            return r6
        L9e:
            return r1
        L9f:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.Intent r6 = r6.setComponent(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.g0.a(android.content.Context):android.content.Intent");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return y.j(this.f8904a, g0Var.f8904a) && y.j(this.f8905b, g0Var.f8905b) && y.j(null, null) && this.f8906c == g0Var.f8906c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8904a, this.f8905b, null, 4225, Boolean.valueOf(this.f8906c)});
    }

    public final String toString() {
        String str = this.f8904a;
        if (str != null) {
            return str;
        }
        y.g(null);
        throw null;
    }
}
