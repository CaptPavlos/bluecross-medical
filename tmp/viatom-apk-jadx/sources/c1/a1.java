package c1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.g5;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.gms.internal.measurement.m6;
import com.google.android.gms.internal.measurement.n5;
import com.google.android.gms.internal.measurement.s5;
import com.google.android.gms.internal.measurement.t5;
import com.google.android.gms.internal.measurement.w5;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends q4 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1004d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(v4 v4Var, int i10) {
        super(v4Var);
        this.f1004d = i10;
    }

    public static boolean M(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean N(s5 s5Var, int i10) {
        if (i10 < s5Var.size() * 64) {
            return ((1 << (i10 % 64)) & ((Long) s5Var.get(i10 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static ArrayList O(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 * 64) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static n5 T(n5 n5Var, byte[] bArr) throws w5 {
        g5 g5VarS;
        g5 g5Var = g5.f1969a;
        if (g5Var == null) {
            synchronized (g5.class) {
                try {
                    g5VarS = g5.f1969a;
                    if (g5VarS == null) {
                        m6 m6Var = m6.f2086c;
                        g5VarS = l5.S();
                        g5.f1969a = g5VarS;
                    }
                } finally {
                }
            }
            g5Var = g5VarS;
        }
        if (g5Var != null) {
            n5Var.getClass();
            n5Var.f(bArr, bArr.length, g5Var);
            return n5Var;
        }
        n5Var.getClass();
        int length = bArr.length;
        g5 g5Var2 = g5.f1969a;
        m6 m6Var2 = m6.f2086c;
        n5Var.f(bArr, length, g5.f1970b);
        return n5Var;
    }

    public static int U(com.google.android.gms.internal.measurement.j3 j3Var, String str) {
        for (int i10 = 0; i10 < ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).V1(); i10++) {
            if (str.equals(((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).W1(i10).r())) {
                return i10;
            }
        }
        return -1;
    }

    public static Bundle[] V(t5 t5Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = t5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.f3 f3Var = (com.google.android.gms.internal.measurement.f3) it.next();
            if (f3Var != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.f3 f3Var2 : f3Var.z()) {
                    if (f3Var2.r()) {
                        bundle.putString(f3Var2.q(), f3Var2.s());
                    } else if (f3Var2.t()) {
                        bundle.putLong(f3Var2.q(), f3Var2.u());
                    } else if (f3Var2.x()) {
                        bundle.putDouble(f3Var2.q(), f3Var2.y());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static HashMap W(boolean z9, Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z10 = obj instanceof Parcelable[];
            if (z10 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z9) {
                    ArrayList arrayList = new ArrayList();
                    if (z10) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(W(false, (Bundle) parcelable));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Object obj2 = arrayList2.get(i10);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(W(false, (Bundle) obj2));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(W(false, (Bundle) obj));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static v k(com.google.android.gms.internal.measurement.b bVar) {
        Object obj;
        Bundle bundleL = l(bVar.f1885c, true);
        String string = (!bundleL.containsKey("_o") || (obj = bundleL.get("_o")) == null) ? MBridgeConstans.DYNAMIC_VIEW_WX_APP : obj.toString();
        String strG = l2.g(bVar.f1883a, l2.f1317a, l2.f1319c);
        if (strG == null) {
            strG = bVar.f1883a;
        }
        return new v(strG, new u(bundleL), string, bVar.f1884b);
    }

    public static Bundle l(Map map, boolean z9) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z9) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList2.add(l((Map) arrayList.get(i10), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static final void m(com.google.android.gms.internal.measurement.b3 b3Var, String str, Long l10) {
        List listG = b3Var.g();
        int i10 = 0;
        while (true) {
            if (i10 >= listG.size()) {
                i10 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.f3) listG.get(i10)).q())) {
                break;
            } else {
                i10++;
            }
        }
        com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
        e3VarB.g(str);
        e3VarB.i(l10.longValue());
        if (i10 < 0) {
            b3Var.k(e3VarB);
        } else {
            b3Var.b();
            ((com.google.android.gms.internal.measurement.c3) b3Var.f2102b).A(i10, (com.google.android.gms.internal.measurement.f3) e3VarB.d());
        }
    }

    public static final Bundle n(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.f3 f3Var = (com.google.android.gms.internal.measurement.f3) it.next();
            String strQ = f3Var.q();
            if (f3Var.x()) {
                bundle.putDouble(strQ, f3Var.y());
            } else if (f3Var.v()) {
                bundle.putFloat(strQ, f3Var.w());
            } else if (f3Var.r()) {
                bundle.putString(strQ, f3Var.s());
            } else if (f3Var.t()) {
                bundle.putLong(strQ, f3Var.u());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.f3 o(com.google.android.gms.internal.measurement.c3 c3Var, String str) {
        for (com.google.android.gms.internal.measurement.f3 f3Var : c3Var.p()) {
            if (f3Var.q().equals(str)) {
                return f3Var;
            }
        }
        return null;
    }

    public static final Serializable p(com.google.android.gms.internal.measurement.c3 c3Var, String str) {
        com.google.android.gms.internal.measurement.f3 f3VarO = o(c3Var, str);
        if (f3VarO == null) {
            return null;
        }
        return v(f3VarO);
    }

    public static final void s(int i10, StringBuilder sb) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("  ");
        }
    }

    public static final void t(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static final String u(boolean z9, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder();
        if (z9) {
            sb.append("Dynamic ");
        }
        if (z10) {
            sb.append("Sequence ");
        }
        if (z11) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable v(com.google.android.gms.internal.measurement.f3 f3Var) {
        if (f3Var.r()) {
            return f3Var.s();
        }
        if (f3Var.t()) {
            return Long.valueOf(f3Var.u());
        }
        if (f3Var.x()) {
            return Double.valueOf(f3Var.y());
        }
        if (f3Var.A() > 0) {
            return V((t5) f3Var.z());
        }
        return null;
    }

    public static final void w(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                t(builder, str3, string, set);
            }
        }
    }

    public static final void x(StringBuilder sb, String str, com.google.android.gms.internal.measurement.n3 n3Var) {
        if (n3Var == null) {
            return;
        }
        s(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (n3Var.s() != 0) {
            s(4, sb);
            sb.append("results: ");
            int i10 = 0;
            for (Long l10 : n3Var.r()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(l10);
                i10 = i11;
            }
            sb.append('\n');
        }
        if (n3Var.q() != 0) {
            s(4, sb);
            sb.append("status: ");
            int i12 = 0;
            for (Long l11 : n3Var.p()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb.append(", ");
                }
                sb.append(l11);
                i12 = i13;
            }
            sb.append('\n');
        }
        if (n3Var.u() != 0) {
            s(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i14 = 0;
            for (com.google.android.gms.internal.measurement.a3 a3Var : n3Var.t()) {
                int i15 = i14 + 1;
                if (i14 != 0) {
                    sb.append(", ");
                }
                sb.append(a3Var.p() ? Integer.valueOf(a3Var.q()) : null);
                sb.append(":");
                sb.append(a3Var.r() ? Long.valueOf(a3Var.s()) : null);
                i14 = i15;
            }
            sb.append("}\n");
        }
        if (n3Var.w() != 0) {
            s(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i16 = 0;
            for (com.google.android.gms.internal.measurement.p3 p3Var : n3Var.v()) {
                int i17 = i16 + 1;
                if (i16 != 0) {
                    sb.append(", ");
                }
                sb.append(p3Var.p() ? Integer.valueOf(p3Var.q()) : null);
                sb.append(": [");
                Iterator it = p3Var.r().iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i19 = i18 + 1;
                    if (i18 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i18 = i19;
                }
                sb.append("]");
                i16 = i17;
            }
            sb.append("}\n");
        }
        s(3, sb);
        sb.append("}\n");
    }

    public static final void y(StringBuilder sb, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        s(i10 + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void z(StringBuilder sb, int i10, String str, com.google.android.gms.internal.measurement.u1 u1Var) {
        if (u1Var == null) {
            return;
        }
        s(i10, sb);
        sb.append(str);
        sb.append(" {\n");
        if (u1Var.p()) {
            int iZ = u1Var.z();
            y(sb, i10, "comparison_type", iZ != 1 ? iZ != 2 ? iZ != 3 ? iZ != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (u1Var.q()) {
            y(sb, i10, "match_as_float", Boolean.valueOf(u1Var.r()));
        }
        if (u1Var.s()) {
            y(sb, i10, "comparison_value", u1Var.t());
        }
        if (u1Var.u()) {
            y(sb, i10, "min_comparison_value", u1Var.v());
        }
        if (u1Var.w()) {
            y(sb, i10, "max_comparison_value", u1Var.x());
        }
        s(i10, sb);
        sb.append("}\n");
    }

    public boolean A() {
        h();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f1149a.f1475a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void E(com.google.android.gms.internal.measurement.s3 s3Var, Object obj) {
        i0.y.g(obj);
        s3Var.b();
        ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).E();
        s3Var.b();
        ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).G();
        s3Var.b();
        ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).I();
        if (obj instanceof String) {
            s3Var.b();
            ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).D((String) obj);
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            s3Var.b();
            ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).F(jLongValue);
        } else if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            s3Var.b();
            ((com.google.android.gms.internal.measurement.t3) s3Var.f2102b).H(dDoubleValue);
        } else {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.c(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public void F(String str, r4 r4Var, com.google.android.gms.internal.measurement.i3 i3Var, y0 y0Var) {
        String str2;
        URL url;
        byte[] bArrA;
        r1 r1Var;
        Map map;
        String str3 = r4Var.f1436a;
        u1 u1Var = this.f1149a;
        g();
        h();
        try {
            url = new URI(str3).toURL();
            this.f1335b.j0();
            bArrA = i3Var.a();
            r1Var = u1Var.g;
            u1.m(r1Var);
            map = r4Var.f1437b;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            r1Var.s(new z0(this, str2, url, bArrA, map, y0Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.d(w0.o(str2), "Failed to parse URL. Not uploading MeasurementBatch. appId", str3);
        }
    }

    public void G(com.google.android.gms.internal.measurement.e3 e3Var, Object obj) {
        e3Var.b();
        ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).E();
        e3Var.b();
        ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).G();
        e3Var.b();
        ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).I();
        e3Var.b();
        ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).L();
        if (obj instanceof String) {
            e3Var.h((String) obj);
            return;
        }
        if (obj instanceof Long) {
            e3Var.i(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            e3Var.b();
            ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).H(dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.c(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.e3 e3VarB2 = com.google.android.gms.internal.measurement.f3.B();
                    e3VarB2.g(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        e3VarB2.i(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        e3VarB2.h((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        e3VarB2.b();
                        ((com.google.android.gms.internal.measurement.f3) e3VarB2.f2102b).H(dDoubleValue2);
                    }
                    e3VarB.b();
                    ((com.google.android.gms.internal.measurement.f3) e3VarB.f2102b).J((com.google.android.gms.internal.measurement.f3) e3VarB2.d());
                }
                if (((com.google.android.gms.internal.measurement.f3) e3VarB.f2102b).A() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.f3) e3VarB.d());
                }
            }
        }
        e3Var.b();
        ((com.google.android.gms.internal.measurement.f3) e3Var.f2102b).K(arrayList);
    }

    public k4 H(String str, com.google.android.gms.internal.measurement.j3 j3Var, com.google.android.gms.internal.measurement.b3 b3Var, String str2) {
        int iIndexOf;
        j8.a();
        u1 u1Var = this.f1149a;
        g gVar = u1Var.f1478d;
        if (!gVar.q(str, f0.Q0)) {
            return null;
        }
        u1Var.f1481k.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArrSplit = gVar.m(str, f0.f1202v0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                androidx.window.layout.c.j(str3, "duplicate element: ");
                return null;
            }
        }
        Set setUnmodifiableSet = DesugarCollections.unmodifiableSet(hashSet);
        v4 v4Var = this.f1335b;
        s4 s4Var = v4Var.f1523j;
        n1 n1Var = v4Var.f1518a;
        n1 n1Var2 = s4Var.f1335b.f1518a;
        v4.U(n1Var2);
        String strT = n1Var2.t(str);
        Uri.Builder builder = new Uri.Builder();
        g gVar2 = s4Var.f1149a.f1478d;
        builder.scheme(gVar2.m(str, f0.f1189o0));
        if (TextUtils.isEmpty(strT)) {
            builder.authority(gVar2.m(str, f0.f1191p0));
        } else {
            String strM = gVar2.m(str, f0.f1191p0);
            StringBuilder sb = new StringBuilder(String.valueOf(strT).length() + 1 + String.valueOf(strM).length());
            sb.append(strT);
            sb.append(".");
            sb.append(strM);
            builder.authority(sb.toString());
        }
        builder.path(gVar2.m(str, f0.f1193q0));
        t(builder, "gmp_app_id", ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).E(), setUnmodifiableSet);
        gVar.l();
        t(builder, "gmp_version", String.valueOf(133005L), setUnmodifiableSet);
        String strY = ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).y();
        e0 e0Var = f0.T0;
        if (gVar.q(str, e0Var)) {
            v4.U(n1Var);
            if (n1Var.z(str)) {
                strY = "";
            }
        }
        t(builder, "app_instance_id", strY, setUnmodifiableSet);
        t(builder, "rdid", ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).v(), setUnmodifiableSet);
        t(builder, "bundle_id", j3Var.n(), setUnmodifiableSet);
        String strM2 = b3Var.m();
        String strG = l2.g(strM2, l2.f1319c, l2.f1317a);
        if (true != TextUtils.isEmpty(strG)) {
            strM2 = strG;
        }
        t(builder, "app_event_name", strM2, setUnmodifiableSet);
        t(builder, "app_version", String.valueOf(((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).K()), setUnmodifiableSet);
        String strI2 = ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).i2();
        if (gVar.q(str, e0Var)) {
            v4.U(n1Var);
            if (n1Var.y(str) && !TextUtils.isEmpty(strI2) && (iIndexOf = strI2.indexOf(".")) != -1) {
                strI2 = strI2.substring(0, iIndexOf);
            }
        }
        t(builder, "os_version", strI2, setUnmodifiableSet);
        t(builder, CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(b3Var.n()), setUnmodifiableSet);
        if (((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).x()) {
            t(builder, "lat", "1", setUnmodifiableSet);
        }
        t(builder, "privacy_sandbox_version", String.valueOf(((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).G0()), setUnmodifiableSet);
        t(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        t(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        t(builder, "request_uuid", str2, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.f3> listG = b3Var.g();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.f3 f3Var : listG) {
            String strQ = f3Var.q();
            if (f3Var.x()) {
                bundle.putString(strQ, String.valueOf(f3Var.y()));
            } else if (f3Var.v()) {
                bundle.putString(strQ, String.valueOf(f3Var.w()));
            } else if (f3Var.r()) {
                bundle.putString(strQ, f3Var.s());
            } else if (f3Var.t()) {
                bundle.putString(strQ, String.valueOf(f3Var.u()));
            }
        }
        w(builder, gVar.m(str, f0.f1200u0).split("\\|"), bundle, setUnmodifiableSet);
        List<com.google.android.gms.internal.measurement.t3> listUnmodifiableList = DesugarCollections.unmodifiableList(((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).U1());
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.t3 t3Var : listUnmodifiableList) {
            String strR = t3Var.r();
            if (t3Var.y()) {
                bundle2.putString(strR, String.valueOf(t3Var.z()));
            } else if (t3Var.w()) {
                bundle2.putString(strR, String.valueOf(t3Var.x()));
            } else if (t3Var.s()) {
                bundle2.putString(strR, t3Var.t());
            } else if (t3Var.u()) {
                bundle2.putString(strR, String.valueOf(t3Var.v()));
            }
        }
        w(builder, gVar.m(str, f0.f1198t0).split("\\|"), bundle2, setUnmodifiableSet);
        t(builder, "dma", true != ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).D0() ? "0" : "1", setUnmodifiableSet);
        if (!((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).F0().isEmpty()) {
            t(builder, "dma_cps", ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).F0(), setUnmodifiableSet);
        }
        if (((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).L0()) {
            com.google.android.gms.internal.measurement.p2 p2VarM0 = ((com.google.android.gms.internal.measurement.k3) j3Var.f2102b).M0();
            if (!p2VarM0.z().isEmpty()) {
                t(builder, "dl_gclid", p2VarM0.z(), setUnmodifiableSet);
            }
            if (!p2VarM0.B().isEmpty()) {
                t(builder, "dl_gbraid", p2VarM0.B(), setUnmodifiableSet);
            }
            if (!p2VarM0.D().isEmpty()) {
                t(builder, "dl_gs", p2VarM0.D(), setUnmodifiableSet);
            }
            if (p2VarM0.F() > 0) {
                t(builder, "dl_ss_ts", String.valueOf(p2VarM0.F()), setUnmodifiableSet);
            }
            if (!p2VarM0.H().isEmpty()) {
                t(builder, "mr_gclid", p2VarM0.H(), setUnmodifiableSet);
            }
            if (!p2VarM0.J().isEmpty()) {
                t(builder, "mr_gbraid", p2VarM0.J(), setUnmodifiableSet);
            }
            if (!p2VarM0.L().isEmpty()) {
                t(builder, "mr_gs", p2VarM0.L(), setUnmodifiableSet);
            }
            if (p2VarM0.N() > 0) {
                t(builder, "mr_click_ts", String.valueOf(p2VarM0.N()), setUnmodifiableSet);
            }
        }
        return new k4(1, jCurrentTimeMillis, builder.build().toString());
    }

    public com.google.android.gms.internal.measurement.c3 I(r rVar) {
        com.google.android.gms.internal.measurement.b3 b3VarZ = com.google.android.gms.internal.measurement.c3.z();
        long j10 = rVar.e;
        b3VarZ.b();
        ((com.google.android.gms.internal.measurement.c3) b3VarZ.f2102b).H(j10);
        u uVar = rVar.f;
        Objects.requireNonNull(uVar);
        Bundle bundle = uVar.f1470a;
        for (String str : bundle.keySet()) {
            com.google.android.gms.internal.measurement.e3 e3VarB = com.google.android.gms.internal.measurement.f3.B();
            e3VarB.g(str);
            Object obj = bundle.get(str);
            i0.y.g(obj);
            G(e3VarB, obj);
            b3VarZ.k(e3VarB);
        }
        String str2 = rVar.f1422c;
        if (!TextUtils.isEmpty(str2) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.e3 e3VarB2 = com.google.android.gms.internal.measurement.f3.B();
            e3VarB2.g("_o");
            e3VarB2.h(str2);
            b3VarZ.j((com.google.android.gms.internal.measurement.f3) e3VarB2.d());
        }
        return (com.google.android.gms.internal.measurement.c3) b3VarZ.d();
    }

    public String J(com.google.android.gms.internal.measurement.i3 i3Var) {
        com.google.android.gms.internal.measurement.s2 s2VarI0;
        StringBuilder sbV = a3.a.v("\nbatch {\n");
        if (i3Var.u()) {
            y(sbV, 0, "upload_subdomain", i3Var.v());
        }
        if (i3Var.s()) {
            y(sbV, 0, "sgtm_join_id", i3Var.t());
        }
        for (com.google.android.gms.internal.measurement.k3 k3Var : i3Var.p()) {
            if (k3Var != null) {
                s(1, sbV);
                sbV.append("bundle {\n");
                if (k3Var.P()) {
                    y(sbV, 1, "protocol_version", Integer.valueOf(k3Var.P0()));
                }
                u1 u1Var = this.f1149a;
                g gVar = u1Var.f1478d;
                q0 q0Var = u1Var.f1480j;
                if (gVar.q(k3Var.p(), f0.N0) && k3Var.v0()) {
                    y(sbV, 1, "session_stitching_token", k3Var.w0());
                }
                y(sbV, 1, "platform", k3Var.h2());
                if (k3Var.r()) {
                    y(sbV, 1, "gmp_version", Long.valueOf(k3Var.s()));
                }
                if (k3Var.t()) {
                    y(sbV, 1, "uploading_gmp_version", Long.valueOf(k3Var.u()));
                }
                if (k3Var.r0()) {
                    y(sbV, 1, "dynamite_version", Long.valueOf(k3Var.s0()));
                }
                if (k3Var.L()) {
                    y(sbV, 1, "config_version", Long.valueOf(k3Var.M()));
                }
                y(sbV, 1, "gmp_app_id", k3Var.E());
                y(sbV, 1, MBridgeConstans.APP_ID, k3Var.p());
                y(sbV, 1, "app_version", k3Var.q());
                if (k3Var.J()) {
                    y(sbV, 1, "app_version_major", Integer.valueOf(k3Var.K()));
                }
                y(sbV, 1, "firebase_instance_id", k3Var.I());
                if (k3Var.z()) {
                    y(sbV, 1, "dev_cert_hash", Long.valueOf(k3Var.A()));
                }
                y(sbV, 1, "app_store", k3Var.n2());
                if (k3Var.X1()) {
                    y(sbV, 1, "upload_timestamp_millis", Long.valueOf(k3Var.Y1()));
                }
                if (k3Var.Z1()) {
                    y(sbV, 1, "start_timestamp_millis", Long.valueOf(k3Var.a2()));
                }
                if (k3Var.b2()) {
                    y(sbV, 1, "end_timestamp_millis", Long.valueOf(k3Var.c2()));
                }
                if (k3Var.d2()) {
                    y(sbV, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(k3Var.e2()));
                }
                if (k3Var.f2()) {
                    y(sbV, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(k3Var.g2()));
                }
                y(sbV, 1, "app_instance_id", k3Var.y());
                y(sbV, 1, "resettable_device_id", k3Var.v());
                y(sbV, 1, "ds_id", k3Var.O());
                if (k3Var.w()) {
                    y(sbV, 1, "limited_ad_tracking", Boolean.valueOf(k3Var.x()));
                }
                y(sbV, 1, "os_version", k3Var.i2());
                y(sbV, 1, "device_model", k3Var.j2());
                y(sbV, 1, "user_default_language", k3Var.k2());
                if (k3Var.l2()) {
                    y(sbV, 1, "time_zone_offset_minutes", Integer.valueOf(k3Var.m2()));
                }
                if (k3Var.B()) {
                    y(sbV, 1, "bundle_sequential_index", Integer.valueOf(k3Var.C()));
                }
                if (k3Var.J0()) {
                    y(sbV, 1, "delivery_index", Integer.valueOf(k3Var.K0()));
                }
                if (k3Var.F()) {
                    y(sbV, 1, "service_upload", Boolean.valueOf(k3Var.G()));
                }
                y(sbV, 1, "health_monitor", k3Var.D());
                if (k3Var.p0()) {
                    y(sbV, 1, "retry_counter", Integer.valueOf(k3Var.q0()));
                }
                if (k3Var.t0()) {
                    y(sbV, 1, "consent_signals", k3Var.u0());
                }
                if (k3Var.C0()) {
                    y(sbV, 1, "is_dma_region", Boolean.valueOf(k3Var.D0()));
                }
                if (k3Var.E0()) {
                    y(sbV, 1, "core_platform_services", k3Var.F0());
                }
                if (k3Var.A0()) {
                    y(sbV, 1, "consent_diagnostics", k3Var.B0());
                }
                if (k3Var.x0()) {
                    y(sbV, 1, "target_os_version", Long.valueOf(k3Var.y0()));
                }
                j8.a();
                if (u1Var.f1478d.q(k3Var.p(), f0.Q0)) {
                    y(sbV, 1, "ad_services_version", Integer.valueOf(k3Var.G0()));
                    if (k3Var.H0() && (s2VarI0 = k3Var.I0()) != null) {
                        s(2, sbV);
                        sbV.append("attribution_eligibility_status {\n");
                        y(sbV, 2, "eligible", Boolean.valueOf(s2VarI0.p()));
                        y(sbV, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(s2VarI0.q()));
                        y(sbV, 2, "pre_r", Boolean.valueOf(s2VarI0.r()));
                        y(sbV, 2, "r_extensions_too_old", Boolean.valueOf(s2VarI0.s()));
                        y(sbV, 2, "adservices_extension_too_old", Boolean.valueOf(s2VarI0.t()));
                        y(sbV, 2, "ad_storage_not_allowed", Boolean.valueOf(s2VarI0.u()));
                        y(sbV, 2, "measurement_manager_disabled", Boolean.valueOf(s2VarI0.v()));
                        s(2, sbV);
                        sbV.append("}\n");
                    }
                }
                if (k3Var.L0()) {
                    com.google.android.gms.internal.measurement.p2 p2VarM0 = k3Var.M0();
                    s(2, sbV);
                    sbV.append("ad_campaign_info {\n");
                    if (p2VarM0.y()) {
                        y(sbV, 2, "deep_link_gclid", p2VarM0.z());
                    }
                    if (p2VarM0.A()) {
                        y(sbV, 2, "deep_link_gbraid", p2VarM0.B());
                    }
                    if (p2VarM0.C()) {
                        y(sbV, 2, "deep_link_gad_source", p2VarM0.D());
                    }
                    if (p2VarM0.E()) {
                        y(sbV, 2, "deep_link_session_millis", Long.valueOf(p2VarM0.F()));
                    }
                    if (p2VarM0.G()) {
                        y(sbV, 2, "market_referrer_gclid", p2VarM0.H());
                    }
                    if (p2VarM0.I()) {
                        y(sbV, 2, "market_referrer_gbraid", p2VarM0.J());
                    }
                    if (p2VarM0.K()) {
                        y(sbV, 2, "market_referrer_gad_source", p2VarM0.L());
                    }
                    if (p2VarM0.M()) {
                        y(sbV, 2, "market_referrer_click_millis", Long.valueOf(p2VarM0.N()));
                    }
                    s(2, sbV);
                    sbV.append("}\n");
                }
                if (k3Var.Q()) {
                    y(sbV, 1, "batching_timestamp_millis", Long.valueOf(k3Var.R()));
                }
                if (k3Var.N0()) {
                    com.google.android.gms.internal.measurement.r3 r3VarO0 = k3Var.O0();
                    s(2, sbV);
                    sbV.append("sgtm_diagnostics {\n");
                    int iT = r3VarO0.t();
                    y(sbV, 2, "upload_type", iT != 1 ? iT != 2 ? iT != 3 ? iT != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    y(sbV, 2, "client_upload_eligibility", androidx.constraintlayout.core.widgets.analyzer.a.F(r3VarO0.p()));
                    int iU = r3VarO0.u();
                    y(sbV, 2, "service_upload_eligibility", iU != 1 ? iU != 2 ? iU != 3 ? iU != 4 ? iU != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    s(2, sbV);
                    sbV.append("}\n");
                }
                if (k3Var.S()) {
                    com.google.android.gms.internal.measurement.y2 y2VarT = k3Var.T();
                    s(2, sbV);
                    sbV.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.x2 x2Var : y2VarT.p()) {
                        s(3, sbV);
                        sbV.append("limited_data_modes {\n");
                        int iQ = x2Var.q();
                        y(sbV, 3, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, iQ != 1 ? iQ != 2 ? iQ != 3 ? iQ != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iR = x2Var.r();
                        y(sbV, 3, "mode", iR != 1 ? iR != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        s(3, sbV);
                        sbV.append("}\n");
                    }
                    s(2, sbV);
                    sbV.append("}\n");
                }
                t5<com.google.android.gms.internal.measurement.t3> t5VarU1 = k3Var.U1();
                if (t5VarU1 != null) {
                    for (com.google.android.gms.internal.measurement.t3 t3Var : t5VarU1) {
                        if (t3Var != null) {
                            s(2, sbV);
                            sbV.append("user_property {\n");
                            y(sbV, 2, "set_timestamp_millis", t3Var.p() ? Long.valueOf(t3Var.q()) : null);
                            y(sbV, 2, RewardPlus.NAME, q0Var.c(t3Var.r()));
                            y(sbV, 2, "string_value", t3Var.t());
                            y(sbV, 2, "int_value", t3Var.u() ? Long.valueOf(t3Var.v()) : null);
                            y(sbV, 2, "double_value", t3Var.y() ? Double.valueOf(t3Var.z()) : null);
                            s(2, sbV);
                            sbV.append("}\n");
                        }
                    }
                }
                t5<com.google.android.gms.internal.measurement.u2> t5VarH = k3Var.H();
                if (t5VarH != null) {
                    for (com.google.android.gms.internal.measurement.u2 u2Var : t5VarH) {
                        if (u2Var != null) {
                            s(2, sbV);
                            sbV.append("audience_membership {\n");
                            if (u2Var.p()) {
                                y(sbV, 2, "audience_id", Integer.valueOf(u2Var.q()));
                            }
                            if (u2Var.u()) {
                                y(sbV, 2, "new_audience", Boolean.valueOf(u2Var.v()));
                            }
                            x(sbV, "current_data", u2Var.r());
                            if (u2Var.s()) {
                                x(sbV, "previous_data", u2Var.t());
                            }
                            s(2, sbV);
                            sbV.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.c3> listP1 = k3Var.P1();
                if (listP1 != null) {
                    for (com.google.android.gms.internal.measurement.c3 c3Var : listP1) {
                        if (c3Var != null) {
                            s(2, sbV);
                            sbV.append("event {\n");
                            y(sbV, 2, RewardPlus.NAME, q0Var.a(c3Var.s()));
                            if (c3Var.t()) {
                                y(sbV, 2, "timestamp_millis", Long.valueOf(c3Var.u()));
                            }
                            if (c3Var.v()) {
                                y(sbV, 2, "previous_timestamp_millis", Long.valueOf(c3Var.w()));
                            }
                            if (c3Var.x()) {
                                y(sbV, 2, "count", Integer.valueOf(c3Var.y()));
                            }
                            if (c3Var.q() != 0) {
                                q(sbV, 2, (t5) c3Var.p());
                            }
                            s(2, sbV);
                            sbV.append("}\n");
                        }
                    }
                }
                s(1, sbV);
                sbV.append("}\n");
            }
        }
        sbV.append("} // End-of-batch\n");
        return sbV.toString();
    }

    public String K(com.google.android.gms.internal.measurement.w1 w1Var) {
        StringBuilder sbV = a3.a.v("\nproperty_filter {\n");
        if (w1Var.p()) {
            y(sbV, 0, "filter_id", Integer.valueOf(w1Var.q()));
        }
        y(sbV, 0, "property_name", this.f1149a.f1480j.c(w1Var.r()));
        String strU = u(w1Var.t(), w1Var.u(), w1Var.w());
        if (!strU.isEmpty()) {
            y(sbV, 0, "filter_type", strU);
        }
        r(sbV, 1, w1Var.s());
        sbV.append("}\n");
        return sbV.toString();
    }

    public Parcelable L(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (j0.b unused) {
                w0 w0Var = this.f1149a.f;
                u1.m(w0Var);
                w0Var.f.b("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public List P(s5 s5Var, List list) {
        int i10;
        ArrayList arrayList = new ArrayList(s5Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            u1 u1Var = this.f1149a;
            if (iIntValue < 0) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.c(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue2 = num.intValue() / 64;
                if (iIntValue2 >= arrayList.size()) {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f1540i.d(num, "Ignoring bit index greater than bitSet size", Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue2, Long.valueOf(((Long) arrayList.get(iIntValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    public boolean Q(long j10, long j11) {
        if (j10 == 0 || j11 <= 0) {
            return true;
        }
        this.f1149a.f1481k.getClass();
        return Math.abs(System.currentTimeMillis() - j10) > j11;
    }

    public long R(byte[] bArr) throws NoSuchAlgorithmException {
        i0.y.g(bArr);
        u1 u1Var = this.f1149a;
        b5 b5Var = u1Var.f1479i;
        u1.k(b5Var);
        b5Var.g();
        MessageDigest messageDigestX = b5.x();
        if (messageDigestX != null) {
            return b5.y(messageDigestX.digest(bArr));
        }
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f.b("Failed to get MD5");
        return 0L;
    }

    public byte[] S(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.c(e, "Failed to gzip content");
            throw e;
        }
    }

    @Override // c1.q4
    public final void j() {
        int i10 = this.f1004d;
    }

    public void q(StringBuilder sb, int i10, t5 t5Var) {
        if (t5Var == null) {
            return;
        }
        int i11 = i10 + 1;
        Iterator it = t5Var.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.f3 f3Var = (com.google.android.gms.internal.measurement.f3) it.next();
            if (f3Var != null) {
                s(i11, sb);
                sb.append("param {\n");
                y(sb, i11, RewardPlus.NAME, f3Var.p() ? this.f1149a.f1480j.b(f3Var.q()) : null);
                y(sb, i11, "string_value", f3Var.r() ? f3Var.s() : null);
                y(sb, i11, "int_value", f3Var.t() ? Long.valueOf(f3Var.u()) : null);
                y(sb, i11, "double_value", f3Var.x() ? Double.valueOf(f3Var.y()) : null);
                if (f3Var.A() > 0) {
                    q(sb, i11, (t5) f3Var.z());
                }
                s(i11, sb);
                sb.append("}\n");
            }
        }
    }

    public void r(StringBuilder sb, int i10, com.google.android.gms.internal.measurement.r1 r1Var) {
        String str;
        if (r1Var == null) {
            return;
        }
        s(i10, sb);
        sb.append("filter {\n");
        if (r1Var.t()) {
            y(sb, i10, "complement", Boolean.valueOf(r1Var.u()));
        }
        if (r1Var.v()) {
            y(sb, i10, "param_name", this.f1149a.f1480j.b(r1Var.w()));
        }
        if (r1Var.p()) {
            int i11 = i10 + 1;
            com.google.android.gms.internal.measurement.x1 x1VarQ = r1Var.q();
            if (x1VarQ != null) {
                s(i11, sb);
                sb.append("string_filter {\n");
                if (x1VarQ.p()) {
                    switch (x1VarQ.x()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    y(sb, i11, "match_type", str);
                }
                if (x1VarQ.q()) {
                    y(sb, i11, "expression", x1VarQ.r());
                }
                if (x1VarQ.s()) {
                    y(sb, i11, "case_sensitive", Boolean.valueOf(x1VarQ.t()));
                }
                if (x1VarQ.v() > 0) {
                    s(i10 + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : x1VarQ.u()) {
                        s(i10 + 3, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                s(i11, sb);
                sb.append("}\n");
            }
        }
        if (r1Var.r()) {
            z(sb, i10 + 1, "number_filter", r1Var.s());
        }
        s(i10, sb);
        sb.append("}\n");
    }

    private final void B() {
    }

    private final void C() {
    }

    private final void D() {
    }
}
