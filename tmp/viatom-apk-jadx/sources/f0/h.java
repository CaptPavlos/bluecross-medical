package f0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static h f8008c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f8009a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f8010b;

    public h(Context context) {
        this.f8009a = context.getApplicationContext();
    }

    public static h a(Context context) {
        y.g(context);
        synchronized (h.class) {
            try {
                if (f8008c == null) {
                    p.a(context);
                    f8008c = new h(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8008c;
    }

    public static final m c(PackageInfo packageInfo, m... mVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            n nVar = new n(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < mVarArr.length; i10++) {
                if (mVarArr[i10].equals(nVar)) {
                    return mVarArr[i10];
                }
            }
        }
        return null;
    }

    public static final boolean d(PackageInfo packageInfo, boolean z9) {
        PackageInfo packageInfo2;
        if (!z9) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z9 = (applicationInfo == null || (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z9 ? c(packageInfo2, o.f8024a) : c(packageInfo2, o.f8024a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01e1 A[EDGE_INSN: B:121:0x01e1->B:97:0x01e1 BREAK  A[LOOP:0: B:8:0x001a->B:94:0x01ce], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ce A[LOOP:0: B:8:0x001a->B:94:0x01ce, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.h.b(int):boolean");
    }
}
