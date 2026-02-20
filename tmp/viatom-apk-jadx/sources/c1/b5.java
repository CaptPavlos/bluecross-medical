package c1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b5 extends f2 {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f1064i = {"firebase_", "google_", "ga_"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f1065j = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f1066c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f1067d;
    public int e;
    public MeasurementManagerFutures f;
    public Boolean g;
    public Integer h;

    public b5(u1 u1Var) {
        super(u1Var);
        this.h = null;
        this.f1067d = new AtomicLong(0L);
    }

    public static boolean A(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static int B() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static boolean D(String str) {
        String str2 = (String) f0.f1197s0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean F(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean G(String str, String[] strArr) {
        i0.y.g(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] L(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList W(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.APP_ID, eVar.f1134a);
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, eVar.f1135b);
            bundle.putLong("creation_timestamp", eVar.f1137d);
            bundle.putString(RewardPlus.NAME, eVar.f1136c.f1610b);
            Object objB = eVar.f1136c.b();
            i0.y.g(objB);
            l2.c(bundle, objB);
            bundle.putBoolean("active", eVar.e);
            String str = eVar.f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            v vVar = eVar.g;
            if (vVar != null) {
                bundle.putString("timed_out_event_name", vVar.f1505a);
                u uVar = vVar.f1506b;
                if (uVar != null) {
                    bundle.putBundle("timed_out_event_params", uVar.e());
                }
            }
            bundle.putLong("trigger_timeout", eVar.h);
            v vVar2 = eVar.f1138i;
            if (vVar2 != null) {
                bundle.putString("triggered_event_name", vVar2.f1505a);
                u uVar2 = vVar2.f1506b;
                if (uVar2 != null) {
                    bundle.putBundle("triggered_event_params", uVar2.e());
                }
            }
            bundle.putLong("triggered_timestamp", eVar.f1136c.f1611c);
            bundle.putLong("time_to_live", eVar.f1139j);
            v vVar3 = eVar.f1140k;
            if (vVar3 != null) {
                bundle.putString("expired_event_name", vVar3.f1505a);
                u uVar3 = vVar3.f1506b;
                if (uVar3 != null) {
                    bundle.putBundle("expired_event_params", uVar3.e());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean X(Context context) {
        ActivityInfo receiverInfo;
        i0.y.g(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void Y(k3 k3Var, Bundle bundle, boolean z9) {
        if (bundle != null && k3Var != null) {
            if (!bundle.containsKey("_sc") || z9) {
                String str = k3Var.f1304a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = k3Var.f1305b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", k3Var.f1306c);
                return;
            }
            z9 = false;
        }
        if (bundle != null && k3Var == null && z9) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean a0(int i10, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    public static boolean f0(String str) {
        i0.y.d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static String l(int i10, String str, boolean z9) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z9) {
            return str.substring(0, str.offsetByCodePoints(0, i10)).concat("...");
        }
        return null;
    }

    public static boolean p0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static void w(a5 a5Var, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        a0(i10, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        a5Var.b(str, "_err", bundle);
    }

    public static MessageDigest x() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long y(byte[] bArr) {
        i0.y.g(bArr);
        int length = bArr.length;
        if (length <= 0) {
            p8.u.e();
            return 0L;
        }
        int i10 = 0;
        long j10 = 0;
        for (int i11 = length - 1; i11 >= 0 && i11 >= bArr.length - 8; i11--) {
            j10 += (bArr[i11] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static boolean z(Context context) {
        i0.y.g(context);
        return Build.VERSION.SDK_INT >= 24 ? A(context, "com.google.android.gms.measurement.AppMeasurementJobService") : A(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long C() {
        /*
            r11 = this;
            r11.g()
            c1.u1 r0 = r11.f1149a
            c1.n0 r1 = r0.r()
            c1.w0 r2 = r0.f
            java.lang.String r1 = r1.m()
            boolean r1 = D(r1)
            r3 = 0
            if (r1 != 0) goto L18
            return r3
        L18:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 0
            r6 = 30
            if (r1 >= r6) goto L22
            r6 = 4
            goto L42
        L22:
            int r1 = android.os.ext.SdkExtensions.getExtensionVersion(r6)
            r6 = 4
            if (r1 >= r6) goto L2c
            r6 = 8
            goto L42
        L2c:
            int r1 = B()
            c1.e0 r6 = c1.f0.f1185m0
            java.lang.Object r6 = r6.a(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r1 >= r6) goto L41
            r6 = 16
            goto L42
        L41:
            r6 = r3
        L42:
            java.lang.String r1 = "android.permission.ACCESS_ADSERVICES_ATTRIBUTION"
            boolean r1 = r11.E(r1)
            if (r1 != 0) goto L4d
            r8 = 2
            long r6 = r6 | r8
        L4d:
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 != 0) goto Lbd
            java.lang.Boolean r1 = r11.g
            if (r1 != 0) goto Lb3
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r1 = r11.f
            if (r1 != 0) goto L61
            android.content.Context r0 = r0.f1475a
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r0 = androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures.from(r0)
            r11.f = r0
        L61:
            androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures r0 = r11.f
            r1 = 0
            if (r0 != 0) goto L67
            goto Lb9
        L67:
            k1.b r0 = r0.getMeasurementApiStatusAsync()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            r9 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r0 = r0.get(r9, r8)     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.util.concurrent.TimeoutException -> L91 java.lang.InterruptedException -> L94 java.util.concurrent.ExecutionException -> L96 java.util.concurrent.CancellationException -> L98
            if (r0 == 0) goto L88
            int r5 = r0.intValue()     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            r8 = 1
            if (r5 != r8) goto L88
            r1 = r8
            goto L88
        L80:
            r1 = move-exception
            goto L8f
        L82:
            r1 = move-exception
            goto L8f
        L84:
            r1 = move-exception
            goto L8f
        L86:
            r1 = move-exception
            goto L8f
        L88:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            r11.g = r1     // Catch: java.util.concurrent.TimeoutException -> L80 java.lang.InterruptedException -> L82 java.util.concurrent.ExecutionException -> L84 java.util.concurrent.CancellationException -> L86
            goto La9
        L8f:
            r5 = r0
            goto L9a
        L91:
            r0 = move-exception
        L92:
            r1 = r0
            goto L9a
        L94:
            r0 = move-exception
            goto L92
        L96:
            r0 = move-exception
            goto L92
        L98:
            r0 = move-exception
            goto L92
        L9a:
            c1.u1.m(r2)
            c1.u0 r0 = r2.f1540i
            java.lang.String r8 = "Measurement manager api exception"
            r0.c(r1, r8)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.g = r0
            r0 = r5
        La9:
            c1.u1.m(r2)
            c1.u0 r1 = r2.f1545n
            java.lang.String r2 = "Measurement manager api status result"
            r1.c(r0, r2)
        Lb3:
            java.lang.Boolean r0 = r11.g
            boolean r1 = r0.booleanValue()
        Lb9:
            if (r1 != 0) goto Lbd
            r6 = 64
        Lbd:
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto Lc4
            r0 = 1
            return r0
        Lc4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.b5.C():long");
    }

    public final boolean E(String str) {
        g();
        u1 u1Var = this.f1149a;
        if (p0.c.a(u1Var.f1475a).f11875a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1544m.c(str, "Permission not granted");
        return false;
    }

    public final boolean H(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f1149a.f1478d.k("debug.firebase.analytics.app").equals(str);
    }

    public final Bundle I(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objN = n(bundle.get(str), str);
                if (objN == null) {
                    u1 u1Var = this.f1149a;
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.f1542k.c(u1Var.f1480j.b(str), "Param value can't be null");
                } else {
                    v(objN, str, bundle2);
                }
            }
        }
        return bundle2;
    }

    public final v J(String str, Bundle bundle, String str2, long j10, boolean z9) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (l0(str) != 0) {
            u1 u1Var = this.f1149a;
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(u1Var.f1480j.c(str), "Invalid conditional property event name");
            z8.f.a();
            return null;
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleO = o(str, bundle2, Collections.singletonList("_o"), true);
        if (z9) {
            bundleO = I(bundleO);
        }
        i0.y.g(bundleO);
        return new v(str, new u(bundleO), str2, j10);
    }

    public final boolean K(Context context, String str) {
        Signature[] signatureArr;
        u1 u1Var = this.f1149a;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoB = p0.c.a(context).b(64, str);
            if (packageInfoB == null || (signatureArr = packageInfoB.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(e, "Package name not found");
            return true;
        } catch (CertificateException e3) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(e3, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean M(int i10) {
        Boolean bool = this.f1149a.p().e;
        if (N() < i10 / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int N() {
        if (this.h == null) {
            f0.f fVar = f0.f.f8003b;
            Context context = this.f1149a.f1475a;
            fVar.getClass();
            int i10 = f0.g.e;
            int i11 = 0;
            try {
                i11 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.h = Integer.valueOf(i11 / 1000);
        }
        return this.h.intValue();
    }

    public final void O(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(Long.valueOf(j11), "Params already contained engagement");
        } else {
            j11 = 0;
        }
        bundle.putLong("_et", j10 + j11);
    }

    public final void P(String str, com.google.android.gms.internal.measurement.n0 n0Var) {
        try {
            n0Var.u(com.mbridge.msdk.dycreator.baseview.a.f(CampaignEx.JSON_KEY_AD_R, str));
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning string value to wrapper");
        }
    }

    public final void Q(com.google.android.gms.internal.measurement.n0 n0Var, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong(CampaignEx.JSON_KEY_AD_R, j10);
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning long value to wrapper");
        }
    }

    public final void R(com.google.android.gms.internal.measurement.n0 n0Var, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(CampaignEx.JSON_KEY_AD_R, i10);
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning int value to wrapper");
        }
    }

    public final void S(com.google.android.gms.internal.measurement.n0 n0Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(CampaignEx.JSON_KEY_AD_R, bArr);
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning byte array to wrapper");
        }
    }

    public final void T(com.google.android.gms.internal.measurement.n0 n0Var, boolean z9) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CampaignEx.JSON_KEY_AD_R, z9);
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning boolean value to wrapper");
        }
    }

    public final void U(com.google.android.gms.internal.measurement.n0 n0Var, Bundle bundle) {
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning bundle value to wrapper");
        }
    }

    public final void V(com.google.android.gms.internal.measurement.n0 n0Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CampaignEx.JSON_KEY_AD_R, arrayList);
        try {
            n0Var.u(bundle);
        } catch (RemoteException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Error returning bundle list to wrapper");
        }
    }

    public final String Z() {
        byte[] bArr = new byte[16];
        e0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object b0(int i10, Object obj, boolean z9, boolean z10) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return l(i10, obj.toString(), z9);
        }
        if (!z10) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleI = I((Bundle) parcelable);
                if (!bundleI.isEmpty()) {
                    arrayList.add(bundleI);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int c0(String str) {
        boolean zEquals = "_ldl".equals(str);
        u1 u1Var = this.f1149a;
        if (zEquals) {
            u1Var.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            u1Var.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            u1Var.getClass();
            return 100;
        }
        u1Var.getClass();
        return 36;
    }

    public final long d0() {
        long andIncrement;
        long j10;
        AtomicLong atomicLong = this.f1067d;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f1067d;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNanoTime = System.nanoTime();
            this.f1149a.f1481k.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i10 = this.e + 1;
            this.e = i10;
            j10 = jNextLong + i10;
        }
        return j10;
    }

    public final SecureRandom e0() {
        g();
        if (this.f1066c == null) {
            this.f1066c = new SecureRandom();
        }
        return this.f1066c;
    }

    public final Bundle g0(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            for (String str2 : uri.getQueryParameterNames()) {
                if (str2.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str2, queryParameter19);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1540i.c(e, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    @Override // c1.f2
    public final boolean h() {
        return true;
    }

    public final boolean h0(String str, String str2) {
        u1 u1Var = this.f1149a;
        if (str2 == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.h.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.h.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            w0 w0Var3 = u1Var.f;
            u1.m(w0Var3);
            w0Var3.h.d(str, "Name must start with a letter. Type, name", str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                w0 w0Var4 = u1Var.f;
                u1.m(w0Var4);
                w0Var4.h.d(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean i0(String str, String str2) {
        u1 u1Var = this.f1149a;
        if (str2 == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.h.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.h.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                w0 w0Var3 = u1Var.f;
                u1.m(w0Var3);
                w0Var3.h.d(str, "Name must start with a letter or _ (underscore). Type, name", str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                w0 w0Var4 = u1Var.f;
                u1.m(w0Var4);
                w0Var4.h.d(str, "Name must consist of letters, digits or _ (underscores). Type, name", str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean j0(String str, String[] strArr, String[] strArr2, String str2) {
        u1 u1Var = this.f1149a;
        if (str2 == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.h.c(str, "Name is required and can't be null. Type");
            return false;
        }
        for (int i10 = 0; i10 < 3; i10++) {
            if (str2.startsWith(f1064i[i10])) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.h.d(str, "Name starts with reserved prefix. Type, name", str2);
                return false;
            }
        }
        if (strArr == null || !G(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && G(str2, strArr2)) {
            return true;
        }
        w0 w0Var3 = u1Var.f;
        u1.m(w0Var3);
        w0Var3.h.d(str, "Name is reserved. Type, name", str2);
        return false;
    }

    public final boolean k(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        u1 u1Var = this.f1149a;
        if (zIsEmpty) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.h.b("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        i0.y.g(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        w0 w0Var2 = u1Var.f;
        u1.m(w0Var2);
        w0Var2.h.c(w0.o(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
        return false;
    }

    public final boolean k0(int i10, String str, String str2) {
        u1 u1Var = this.f1149a;
        if (str2 == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.h.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        w0 w0Var2 = u1Var.f;
        u1.m(w0Var2);
        w0Var2.h.e("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    public final int l0(String str) {
        if (!i0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!j0(NotificationCompat.CATEGORY_EVENT, l2.f1317a, l2.f1318b, str)) {
            return 13;
        }
        this.f1149a.getClass();
        return !k0(40, NotificationCompat.CATEGORY_EVENT, str) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.b5.m(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int m0(String str) {
        if (!i0("user property", str)) {
            return 6;
        }
        if (!j0("user property", l2.f1321i, null, str)) {
            return 15;
        }
        this.f1149a.getClass();
        return !k0(24, "user property", str) ? 6 : 0;
    }

    public final Object n(Object obj, String str) {
        boolean zEquals = "_ev".equals(str);
        int iMax = 500;
        u1 u1Var = this.f1149a;
        if (zEquals) {
            u1Var.f1478d.getClass();
            return b0(Math.max(500, 256), obj, true, true);
        }
        if (F(str)) {
            u1Var.f1478d.getClass();
            iMax = Math.max(500, 256);
        } else {
            u1Var.f1478d.getClass();
        }
        return b0(iMax, obj, false, true);
    }

    public final int n0(String str) {
        if (!h0("event param", str)) {
            return 3;
        }
        if (!j0("event param", null, null, str)) {
            return 14;
        }
        this.f1149a.getClass();
        return !k0(40, "event param", str) ? 3 : 0;
    }

    public final Bundle o(String str, Bundle bundle, List list, boolean z9) {
        int iN0;
        String str2;
        List list2 = list;
        boolean zG = G(str, l2.f1320d);
        String str3 = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        u1 u1Var = this.f1149a;
        g gVar = u1Var.f1478d;
        q0 q0Var = u1Var.f1480j;
        b5 b5Var = gVar.f1149a.f1479i;
        u1.k(b5Var);
        int i10 = b5Var.M(201500000) ? 100 : 25;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i11 = 0;
        boolean z10 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                iN0 = !z9 ? n0(str4) : 0;
                if (iN0 == 0) {
                    iN0 = o0(str4);
                }
            } else {
                iN0 = 0;
            }
            if (iN0 != 0) {
                s(bundle2, iN0, str4, iN0 == 3 ? str4 : str3);
                bundle2.remove(str4);
            } else {
                int iM = m(str, str4, bundle.get(str4), bundle2, list2, z9, zG);
                if (iM == 17) {
                    s(bundle2, 17, str4, Boolean.FALSE);
                } else if (iM != 0 && !"_ev".equals(str4)) {
                    s(bundle2, iM, iM == 21 ? str : str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (f0(str4)) {
                    i11++;
                    if (i11 > i10) {
                        if (u1Var.f1478d.q(str3, f0.f1168f1) && z10) {
                            str2 = str3;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(i10);
                            sb.append(" params");
                            String string = sb.toString();
                            w0 w0Var = u1Var.f;
                            u1.m(w0Var);
                            str2 = str3;
                            w0Var.h.d(q0Var.a(str), string, q0Var.e(bundle));
                        }
                        a0(5, bundle2);
                        bundle2.remove(str4);
                        z10 = true;
                        list2 = list;
                        str3 = str2;
                    } else {
                        list2 = list;
                    }
                }
            }
            str2 = str3;
            list2 = list;
            str3 = str2;
        }
        return bundle2;
    }

    public final int o0(String str) {
        if (!i0("event param", str)) {
            return 3;
        }
        if (!j0("event param", null, null, str)) {
            return 14;
        }
        this.f1149a.getClass();
        return !k0(40, "event param", str) ? 3 : 0;
    }

    public final void p(x0 x0Var, int i10) {
        Bundle bundle = (Bundle) x0Var.e;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i11 = 0;
        boolean z9 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (f0(str) && (i11 = i11 + 1) > i10) {
                u1 u1Var = this.f1149a;
                g gVar = u1Var.f1478d;
                q0 q0Var = u1Var.f1480j;
                if (!gVar.q(null, f0.f1168f1) || !z9) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i10);
                    sb.append(" params");
                    String string = sb.toString();
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.h.d(q0Var.a((String) x0Var.f1561c), string, q0Var.e(bundle));
                    a0(5, bundle);
                }
                bundle.remove(str);
                z9 = true;
            }
        }
    }

    public final void q(Parcelable[] parcelableArr, int i10) {
        i0.y.g(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i11 = 0;
            boolean z9 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (f0(str) && !G(str, l2.h) && (i11 = i11 + 1) > i10) {
                    u1 u1Var = this.f1149a;
                    g gVar = u1Var.f1478d;
                    q0 q0Var = u1Var.f1480j;
                    if (!gVar.q(null, f0.f1168f1) || !z9) {
                        w0 w0Var = u1Var.f;
                        u1.m(w0Var);
                        u0 u0Var = w0Var.h;
                        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i10);
                        sb.append(" item-scoped custom parameters");
                        u0Var.d(q0Var.b(str), sb.toString(), q0Var.e(bundle));
                    }
                    a0(28, bundle);
                    bundle.remove(str);
                    z9 = true;
                }
            }
        }
    }

    public final boolean q0(String str, String str2, int i10, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String string = obj.toString();
        if (string.codePointCount(0, string.length()) > i10) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1542k.e("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
            return false;
        }
        return true;
    }

    public final void r(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                b5 b5Var = this.f1149a.f1479i;
                u1.k(b5Var);
                b5Var.v(bundle2.get(str), str, bundle);
            }
        }
    }

    public final void r0(String str, String str2, Bundle bundle, List list, boolean z9) {
        int iN0;
        String str3;
        int iM;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        u1 u1Var = this.f1149a;
        g gVar = u1Var.f1478d;
        w0 w0Var = u1Var.f;
        q0 q0Var = u1Var.f1480j;
        b5 b5Var = gVar.f1149a.f1479i;
        u1.k(b5Var);
        int i10 = true != b5Var.M(231100000) ? 0 : 35;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i11 = 0;
        boolean z10 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                iN0 = !z9 ? n0(str4) : 0;
                if (iN0 == 0) {
                    iN0 = o0(str4);
                }
            } else {
                iN0 = 0;
            }
            if (iN0 != 0) {
                s(bundle, iN0, str4, iN0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (p0(bundle.get(str4))) {
                    u1.m(w0Var);
                    w0Var.f1542k.e("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    iM = 22;
                    str3 = null;
                } else {
                    str3 = null;
                    iM = m(str, str4, bundle.get(str4), bundle, list2, z9, false);
                }
                if (iM != 0 && !"_ev".equals(str4)) {
                    s(bundle, iM, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (f0(str4) && !G(str4, l2.h)) {
                    int i12 = i11 + 1;
                    if (!M(231100000)) {
                        u1.m(w0Var);
                        w0Var.h.d(q0Var.a(str), "Item array not supported on client's version of Google Play Services (Android Only)", q0Var.e(bundle));
                        a0(23, bundle);
                        bundle.remove(str4);
                    } else if (i12 > i10) {
                        if (!u1Var.f1478d.q(str3, f0.f1168f1) || !z10) {
                            u1.m(w0Var);
                            u0 u0Var = w0Var.h;
                            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i10);
                            sb.append(" item-scoped custom params");
                            u0Var.d(q0Var.a(str), sb.toString(), q0Var.e(bundle));
                        }
                        a0(28, bundle);
                        bundle.remove(str4);
                        list2 = list;
                        i11 = i12;
                        z10 = true;
                    }
                    list2 = list;
                    i11 = i12;
                }
            }
            list2 = list;
        }
    }

    public final void s(Bundle bundle, int i10, String str, Object obj) {
        if (a0(i10, bundle)) {
            this.f1149a.getClass();
            bundle.putString("_ev", l(40, str, true));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int t(Object obj, String str) {
        return "_ldl".equals(str) ? q0("user property referrer", str, c0(str), obj) : q0("user property", str, c0(str), obj) ? 0 : 7;
    }

    public final Object u(Object obj, String str) {
        return "_ldl".equals(str) ? b0(c0(str), obj, true, false) : b0(c0(str), obj, false, false);
    }

    public final void v(Object obj, String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            u1 u1Var = this.f1149a;
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1542k.d(u1Var.f1480j.b(str), "Not putting event parameter. Invalid value type. name, type", simpleName);
        }
    }
}
