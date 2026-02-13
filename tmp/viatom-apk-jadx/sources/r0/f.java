package r0;

import a3.k1;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteStatement;
import androidx.work.PeriodicWorkRequest;
import c1.w4;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.c5;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.t;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import h1.k;
import h1.o;
import h1.p;
import h5.i1;
import h5.q;
import h5.v;
import h5.y0;
import i0.y;
import j$.util.Objects;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.l;
import o7.m;
import o7.u;
import org.json.JSONArray;
import org.json.JSONObject;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static ClassLoader f12309a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Thread f12310b = null;

    /* renamed from: c, reason: collision with root package name */
    public static k1 f12311c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f12312d = null;
    public static int e = 2;

    public static u4.a A() {
        if (o4.b.f11717p == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        u4.a aVar = o4.b.f11717p;
        aVar.getClass();
        if (jCurrentTimeMillis - aVar.f12894d > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            o4.b.f11717p = null;
        }
        return o4.b.f11717p;
    }

    public static int B() {
        return o4.b.f11710i;
    }

    public static String C(String str) {
        int iM0;
        if (!u.c0(str, "uptodown-", false) || m.s0(str, new String[]{"-"}).size() != 2) {
            return null;
        }
        int iK0 = m.k0(str, " ", 0, false, 6);
        if (iK0 > 0) {
            str = str.substring(0, iK0).concat(".apk");
        }
        if (m.d0(str, "(", false) && u.X(str, ").apk", true)) {
            return str.substring(0, m.k0(str, "(", 0, false, 6)).substring(9);
        }
        if (u.X(str, ".apk", true) && (iM0 = m.m0(".apk", str, 6)) > 0 && str.length() == iM0 + 4) {
            return str.substring(0, iM0).substring(9);
        }
        return null;
    }

    public static ArrayList D(Context context) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory()) {
            Iterator it = t3.h.m(context, externalStoragePublicDirectory).iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                String name = file.getName();
                name.getClass();
                if (u.X(name, ".apk", true)) {
                    packageManager.getClass();
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo packageInfoD = l5.a.d(packageManager, absolutePath, 128);
                    if (packageInfoD != null && packageInfoD.packageName.equals("com.uptodown")) {
                        arrayList.add(file);
                    }
                }
            }
        }
        return arrayList;
    }

    public static long E(Context context, File file) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        Iterator it = gVarL.F().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            q qVar = (q) next;
            if (qVar.m()) {
                arrayList.add(qVar);
            }
        }
        gVarL.b();
        int size = arrayList.size();
        long jK = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            jK += ((q) obj).k();
        }
        return file.getUsableSpace() - jK;
    }

    public static w6.c F(w6.c cVar) {
        w6.c cVarIntercepted;
        cVar.getClass();
        y6.c cVar2 = cVar instanceof y6.c ? (y6.c) cVar : null;
        return (cVar2 == null || (cVarIntercepted = cVar2.intercepted()) == null) ? cVar : cVarIntercepted;
    }

    public static boolean G() {
        HashSet hashSet = new HashSet();
        try {
            a4.x("Checking for Root access");
            y4.a aVar = new y4.a(new String[]{"id"}, hashSet);
            a5.d dVarE = a5.d.e(0);
            if (dVarE.f233j) {
                androidx.window.layout.c.g("Unable to add commands to a closed shell");
            } else if (aVar.f13792d) {
                androidx.window.layout.c.g("This command has already been executed. (Don't re-use command instances.)");
            } else {
                while (dVarE.f241r) {
                }
                dVarE.f232i.add(aVar);
                new a0.c(dVarE, 1).start();
            }
            a4.k(a5.d.e(0), aVar);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                a4.x(str);
                if (str.toLowerCase().contains("uid=0")) {
                    a4.x("Access Given");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String H(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i10 = 0;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e3) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, string2.length() != 0 ? "Exception during lenientFormat for ".concat(string2) : new String("Exception during lenientFormat for "), (Throwable) e3);
                    String name2 = e3.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + string2.length() + 9);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i11] = string;
        }
        StringBuilder sb3 = new StringBuilder((objArr.length * 16) + str.length());
        int i12 = 0;
        while (i10 < objArr.length && (iIndexOf = str.indexOf("%s", i12)) != -1) {
            sb3.append((CharSequence) str, i12, iIndexOf);
            sb3.append(objArr[i10]);
            i12 = iIndexOf + 2;
            i10++;
        }
        sb3.append((CharSequence) str, i12, str.length());
        if (i10 < objArr.length) {
            sb3.append(" [");
            sb3.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb3.append(", ");
                sb3.append(objArr[i13]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static final void I() {
        try {
            if (f12311c == null) {
                k1 k1Var = (k1) ((a3.j) ((a3.u) l1.g.c().b(a3.u.class))).f104o.get();
                k1Var.getClass();
                f12311c = k1Var;
            }
            k1 k1Var2 = f12311c;
            if (k1Var2 == null) {
                l.i("sharedSessionRepository");
                throw null;
            }
            if (k1Var2.f126i) {
                if (k1Var2 != null) {
                    k1Var2.b();
                } else {
                    l.i("sharedSessionRepository");
                    throw null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void J(long j10, long j11, String str, String str2) {
        str.getClass();
        str2.getClass();
        u4.a aVar = new u4.a();
        aVar.f12892b = -1L;
        aVar.e = -1L;
        o4.b.f11717p = aVar;
        aVar.f12891a = str;
        aVar.f12892b = j10;
        aVar.f12893c = str2;
        aVar.f12894d = System.currentTimeMillis();
        aVar.e = j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e5  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean K(android.content.Context r26, java.io.File r27, java.lang.String r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.f.K(android.content.Context, java.io.File, java.lang.String, boolean):boolean");
    }

    public static void L(int i10) {
        o4.b.f11710i = i10;
    }

    public static p M(List list) {
        if (list == null || list.isEmpty()) {
            return x(null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((p) it.next()) == null) {
                androidx.window.layout.c.k("null tasks are not accepted");
                return null;
            }
        }
        p pVar = new p();
        k kVar = new k(list.size(), pVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            p pVar2 = (p) it2.next();
            o oVar = h1.j.f8420b;
            pVar2.c(oVar, kVar);
            pVar2.b(oVar, kVar);
            pVar2.f8436b.o(new h1.m((Executor) oVar, (h1.c) kVar));
            pVar2.p();
        }
        return pVar;
    }

    public static Object N(g7.p pVar, Object obj, w6.c cVar) {
        pVar.getClass();
        w6.h context = cVar.getContext();
        Object dVar = context == w6.i.f13523a ? new x6.d(cVar) : new x6.e(cVar, context);
        a0.b(2, pVar);
        return pVar.invoke(obj, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab A[Catch: all -> 0x00a7, PHI: r1
      0x00ab: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:47:0x00a4] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x00a2, B:61:0x00d1, B:12:0x001f, B:52:0x00aa, B:53:0x00ab, B:64:0x00d5, B:65:0x00d6, B:54:0x00ac, B:60:0x00d0, B:59:0x00b6, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:43:0x0086, B:44:0x00a0, B:18:0x003c), top: B:77:0x0003, inners: #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader O() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.f.O():java.lang.ClassLoader");
    }

    public static Object P(p pVar) throws ExecutionException {
        if (pVar.i()) {
            return pVar.g();
        }
        if (pVar.f8438d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(pVar.f());
    }

    public static String Q(c5 c5Var) {
        StringBuilder sb = new StringBuilder(c5Var.d());
        for (int i10 = 0; i10 < c5Var.d(); i10++) {
            byte b10 = c5Var.b(i10);
            if (b10 == 34) {
                sb.append("\\\"");
            } else if (b10 == 39) {
                sb.append("\\'");
            } else if (b10 != 92) {
                switch (b10) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b10 < 32 || b10 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b10 >>> 6) & 3) + 48));
                            sb.append((char) (((b10 >>> 3) & 7) + 48));
                            sb.append((char) ((b10 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) b10);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static n R(com.google.android.gms.internal.measurement.d dVar, r rVar, ArrayList arrayList, boolean z9) {
        n nVarA;
        a.a.V(arrayList, "reduce", 1);
        a.a.W(2, "reduce", arrayList);
        n nVarC = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(0));
        if (!(nVarC instanceof com.google.android.gms.internal.measurement.h)) {
            com.google.gson.internal.a.n("Callback should be a method");
            return null;
        }
        if (arrayList.size() == 2) {
            nVarA = ((t) rVar.f13463c).c(rVar, (n) arrayList.get(1));
            if (nVarA instanceof com.google.android.gms.internal.measurement.f) {
                com.google.gson.internal.a.n("Failed to parse initial value");
                return null;
            }
        } else {
            if (dVar.o() == 0) {
                androidx.window.layout.c.g("Empty array with no initial value error");
                return null;
            }
            nVarA = null;
        }
        com.google.android.gms.internal.measurement.h hVar = (com.google.android.gms.internal.measurement.h) nVarC;
        int iO = dVar.o();
        int i10 = z9 ? 0 : iO - 1;
        int i11 = z9 ? iO - 1 : 0;
        int i12 = true == z9 ? 1 : -1;
        if (nVarA == null) {
            nVarA = dVar.p(i10);
            i10 += i12;
        }
        while ((i11 - i10) * i12 >= 0) {
            if (dVar.r(i10)) {
                nVarA = hVar.a(rVar, Arrays.asList(nVarA, dVar.p(i10), new com.google.android.gms.internal.measurement.g(Double.valueOf(i10)), dVar));
                if (nVarA instanceof com.google.android.gms.internal.measurement.f) {
                    androidx.window.layout.c.g("Reduce operation failed");
                    return null;
                }
                i10 += i12;
            } else {
                i10 += i12;
            }
        }
        return nVarA;
    }

    public static com.google.android.gms.internal.measurement.d S(com.google.android.gms.internal.measurement.d dVar, r rVar, com.google.android.gms.internal.measurement.m mVar, Boolean bool, Boolean bool2) {
        com.google.android.gms.internal.measurement.d dVar2 = new com.google.android.gms.internal.measurement.d();
        Iterator itN = dVar.n();
        while (itN.hasNext()) {
            int iIntValue = ((Integer) itN.next()).intValue();
            if (dVar.r(iIntValue)) {
                n nVarA = mVar.a(rVar, Arrays.asList(dVar.p(iIntValue), new com.google.android.gms.internal.measurement.g(Double.valueOf(iIntValue)), dVar));
                if (nVarA.e().equals(bool)) {
                    break;
                }
                if (bool2 == null || nVarA.e().equals(bool2)) {
                    dVar2.q(iIntValue, nVarA);
                }
            }
        }
        return dVar2;
    }

    public static t7.e a(int i10, t7.a aVar, int i11) {
        int i12 = i11 & 2;
        t7.a aVar2 = t7.a.f12813a;
        if (i12 != 0) {
            aVar = aVar2;
        }
        if (i10 == -2) {
            if (aVar != aVar2) {
                return new t7.o(1, aVar);
            }
            t7.i.f12850i0.getClass();
            return new t7.e(t7.h.f12849b);
        }
        if (i10 != -1) {
            return i10 != 0 ? i10 != Integer.MAX_VALUE ? aVar == aVar2 ? new t7.e(i10) : new t7.o(i10, aVar) : new t7.e(Integer.MAX_VALUE) : aVar == aVar2 ? new t7.e(0) : new t7.o(1, aVar);
        }
        if (aVar == aVar2) {
            return new t7.o(1, t7.a.f12814b);
        }
        com.google.gson.internal.a.n("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Iterable, java.lang.Object, java.util.Collection] */
    public static int b() {
        int i10;
        ?? r02 = i9.a.f().f11239d;
        if (r02 == 0) {
            i10 = 0;
        } else if (r02.isEmpty()) {
            i10 = 1;
        } else {
            Iterator it = r02.iterator();
            while (it.hasNext()) {
                if (!((m8.b) it.next()).f11241b.equals(Boolean.FALSE)) {
                    if (r02.isEmpty()) {
                        i10 = 3;
                    } else {
                        Iterator it2 = r02.iterator();
                        while (it2.hasNext()) {
                            if (!((m8.b) it2.next()).f11241b.equals(Boolean.TRUE)) {
                                i10 = 2;
                                break;
                            }
                        }
                        i10 = 3;
                    }
                }
            }
            i10 = 1;
        }
        if (i10 == 0) {
            return 4;
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, java.util.Map] */
    public static Vector c(String str) throws h6.e {
        int iIntValue;
        int i10 = 1;
        Vector vector = new Vector(null, i10, 0 == true ? 1 : 0);
        Object obj = h6.c.f8810a;
        ?? r12 = h6.c.f8811b;
        h6.d dVar = h6.d.f8815c;
        Integer num = (Integer) r12.get(dVar);
        String strSubstring = str.substring(0, num == null ? 0 : num.intValue());
        Integer num2 = (Integer) r12.get(dVar);
        int iA = l5.a(num2 == null ? 0 : num2.intValue(), strSubstring);
        Integer num3 = (Integer) r12.get(dVar);
        int iIntValue2 = num3 == null ? 0 : num3.intValue();
        String strValueOf = String.valueOf(str.charAt(iIntValue2));
        h6.d dVar2 = h6.d.f8814b;
        Integer num4 = (Integer) r12.get(dVar2);
        int iA2 = l5.a(num4 == null ? 0 : num4.intValue(), strValueOf);
        if (iA2 != 0) {
            if (iA2 != 1) {
                throw new h6.e(l.g(": Too large value to encode into VectorEncodingType", "h.m"));
            }
            i10 = 2;
        }
        Integer num5 = (Integer) r12.get(dVar2);
        int iIntValue3 = iIntValue2 + (num5 == null ? 0 : num5.intValue());
        if (i10 == 2) {
            h6.d dVar3 = h6.d.e;
            Integer num6 = (Integer) r12.get(dVar3);
            String strSubstring2 = str.substring(iIntValue3, num6 == null ? 0 : num6.intValue());
            Integer num7 = (Integer) r12.get(dVar3);
            int iA3 = l5.a(num7 == null ? 0 : num7.intValue(), strSubstring2);
            Integer num8 = (Integer) r12.get(dVar3);
            iIntValue = iIntValue3 + (num8 == null ? 0 : num8.intValue());
            if (iA3 >= 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    String strValueOf2 = String.valueOf(str.charAt(iIntValue));
                    strValueOf2.getClass();
                    boolean zEquals = strValueOf2.equals("1");
                    Object obj2 = h6.c.f8810a;
                    ?? r72 = h6.c.f8811b;
                    Integer num9 = (Integer) r72.get(h6.d.f8818j);
                    int iIntValue4 = iIntValue + (num9 == null ? 0 : num9.intValue());
                    h6.d dVar4 = h6.d.f8819k;
                    Integer num10 = (Integer) r72.get(dVar4);
                    String strSubstring3 = str.substring(iIntValue4, num10 == null ? 0 : num10.intValue());
                    Integer num11 = (Integer) r72.get(dVar4);
                    int iA4 = l5.a(num11 == null ? 0 : num11.intValue(), strSubstring3);
                    Integer num12 = (Integer) r72.get(dVar4);
                    iIntValue = iIntValue4 + (num12 == null ? 0 : num12.intValue());
                    if (zEquals) {
                        Integer num13 = (Integer) r72.get(dVar4);
                        String strSubstring4 = str.substring(iIntValue, num13 == null ? 0 : num13.intValue());
                        Integer num14 = (Integer) r72.get(dVar4);
                        int iA5 = l5.a(num14 == null ? 0 : num14.intValue(), strSubstring4);
                        Integer num15 = (Integer) r72.get(dVar4);
                        iIntValue += num15 == null ? 0 : num15.intValue();
                        if (iA4 <= iA5) {
                            while (true) {
                                int i13 = iA4 + 1;
                                vector.set(iA4);
                                if (iA4 == iA5) {
                                    break;
                                }
                                iA4 = i13;
                            }
                        }
                    } else {
                        vector.set(iA4);
                    }
                    if (i11 == iA3) {
                        break;
                    }
                    i11 = i12;
                }
            }
        } else {
            int i14 = iIntValue3 + iA;
            Vector vectorA = a4.a(iA, str.substring(iIntValue3, i14));
            iIntValue = i14;
            vector = vectorA;
        }
        vector.setBitLength(iIntValue);
        return vector;
    }

    public static String d(b9.d dVar, d0.i iVar) {
        iVar.getClass();
        SharedPreferences sharedPreferences = (SharedPreferences) iVar.f6781b;
        int iOrdinal = dVar.ordinal();
        if (iOrdinal == 0) {
            return (sharedPreferences.getBoolean("CCPAShown", false) && sharedPreferences.getBoolean("CCPAConsentGivenExplicitly", false) && iVar.c(2, 3).equals("Y")) ? "Reject" : "All";
        }
        if (iOrdinal == 1) {
            String strT = iVar.t(76);
            return strT.length() == 0 ? sharedPreferences.getBoolean("GDPRShown", false) ? "Bounce" : "NA" : strT;
        }
        if (iOrdinal != 2) {
            return null;
        }
        return m8.e.f11252d ? sharedPreferences.getBoolean("MSPAConsentGivenExplicitly", false) ? iVar.t(73) : androidx.constraintlayout.core.widgets.analyzer.a.k(b()) : androidx.constraintlayout.core.widgets.analyzer.a.k(b());
    }

    public static List e(int i10, Vector vector) {
        boolean[] zArr = new boolean[i10];
        Iterator<T> it = vector.getAcceptedItems().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (1 <= iIntValue && iIntValue < i10 + 1) {
                zArr[iIntValue - 1] = true;
            }
        }
        if (i10 == 0) {
            return t6.t.f12808a;
        }
        if (i10 == 1) {
            return a4.u(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(Boolean.valueOf(zArr[i11]));
        }
        return arrayList;
    }

    public static l9.j f(String str, String str2, String str3, String str4, String str5, int i10, int i11, boolean z9, int i12) {
        String str6;
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        if (i11 == 0 || i12 == 0) {
            throw null;
        }
        l9.j jVar = new l9.j();
        Bundle bundleC = r1.i.c(CampaignEx.JSON_KEY_TITLE, str, "description", str2);
        bundleC.putString("legal_description", str3);
        bundleC.putString("legal_description_label", str4);
        bundleC.putString("close_button_label", str5);
        bundleC.putBoolean("legitimate_interest", z9);
        if (i12 == 1) {
            str6 = "ALL_VENDORS";
        } else if (i12 == 2) {
            str6 = "IAB_VENDORS";
        } else if (i12 == 3) {
            str6 = "NON_IAB_VENDORS";
        } else {
            if (i12 != 4) {
                throw null;
            }
            str6 = "GOOGLE_VENDORS";
        }
        bundleC.putString("vendor_type_selected", str6);
        l9.j.y = i10;
        l9.j.f11122z = i11;
        jVar.setArguments(bundleC);
        return jVar;
    }

    public static v g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        v vVar = new v();
        if (!jSONObject.isNull("eventID")) {
            vVar.f8758a = jSONObject.optLong("eventID");
        }
        if (!jSONObject.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            vVar.f8759b = jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        }
        if (!jSONObject.isNull("header") && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("header")) != null) {
            if (!jSONObjectOptJSONObject3.isNull("userID")) {
                vVar.f8760c = jSONObjectOptJSONObject3.optLong("userID");
            }
            if (!jSONObjectOptJSONObject3.isNull("username")) {
                vVar.f8761d = jSONObjectOptJSONObject3.optString("username");
            }
            if (!jSONObjectOptJSONObject3.isNull("languageID")) {
                vVar.e = jSONObjectOptJSONObject3.optInt("languageID");
            }
            if (!jSONObjectOptJSONObject3.isNull("action")) {
                vVar.f = jSONObjectOptJSONObject3.optString("action");
            }
            if (!jSONObjectOptJSONObject3.isNull("isTurbo")) {
                vVar.g = jSONObjectOptJSONObject3.optInt("isTurbo");
            }
            if (!jSONObjectOptJSONObject3.isNull("avatarURL")) {
                vVar.h = jSONObjectOptJSONObject3.optString("avatarURL");
            }
            if (!jSONObjectOptJSONObject3.isNull("timeAgo")) {
                vVar.f8762i = jSONObjectOptJSONObject3.optString("timeAgo");
            }
            if (!jSONObjectOptJSONObject3.isNull("usernameFormat")) {
                vVar.f8763j = jSONObjectOptJSONObject3.optString("usernameFormat");
            }
        }
        if (!jSONObject.isNull("content") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("content")) != null) {
            if (!jSONObjectOptJSONObject.isNull("userID")) {
                vVar.f8764k = jSONObjectOptJSONObject.optLong("userID");
            }
            if (!jSONObjectOptJSONObject.isNull("shortDescription")) {
                vVar.f8767n = jSONObjectOptJSONObject.optString("shortDescription");
            }
            if (!jSONObjectOptJSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                vVar.f8765l = jSONObjectOptJSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
            }
            if (!jSONObjectOptJSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                vVar.f8766m = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_STAR);
            }
            if (!jSONObjectOptJSONObject.isNull("userListID")) {
                vVar.f8768o = jSONObjectOptJSONObject.optLong("userListID");
            }
            if (!jSONObjectOptJSONObject.isNull("targetName")) {
                vVar.f8769p = jSONObjectOptJSONObject.optString("targetName");
            }
            if (!jSONObjectOptJSONObject.isNull("targetURL")) {
                vVar.f8770q = jSONObjectOptJSONObject.optString("targetURL");
            }
            if (!jSONObjectOptJSONObject.isNull("targetID")) {
                vVar.f8771r = jSONObjectOptJSONObject.optLong("targetID");
            }
            if (!jSONObjectOptJSONObject.isNull("likes")) {
                vVar.f8776x = jSONObjectOptJSONObject.optInt("likes");
            }
            if (!jSONObjectOptJSONObject.isNull(MBridgeConstans.DYNAMIC_VIEW_WX_APP) && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) != null) {
                if (!jSONObjectOptJSONObject2.isNull("appID")) {
                    vVar.f8772s = jSONObjectOptJSONObject2.optLong("appID");
                }
                if (!jSONObjectOptJSONObject2.isNull(RewardPlus.NAME)) {
                    vVar.t = jSONObjectOptJSONObject2.optString(RewardPlus.NAME);
                }
                if (!jSONObjectOptJSONObject2.isNull("appURL")) {
                    vVar.f8773u = jSONObjectOptJSONObject2.optString("appURL");
                }
                if (!jSONObjectOptJSONObject2.isNull("shortDescription")) {
                    vVar.f8774v = jSONObjectOptJSONObject2.optString("shortDescription");
                }
                if (!jSONObjectOptJSONObject2.isNull("iconURL")) {
                    vVar.f8775w = jSONObjectOptJSONObject2.optString("iconURL");
                }
            }
        }
        return vVar;
    }

    public static Context h(Context context) {
        context.getClass();
        String string = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("language")) {
                string = sharedPreferences.getString("language", null);
            }
        } catch (Exception unused) {
        }
        if (string == null) {
            return context;
        }
        Locale locale = new Locale(string);
        int i10 = x4.a.f13597a;
        return k4.d(context, locale);
    }

    public static Object i(p pVar) throws InterruptedException {
        y.f("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            androidx.window.layout.c.g("Must not be called on GoogleApiHandler thread.");
            return null;
        }
        y.h(pVar, "Task must not be null");
        if (pVar.h()) {
            return P(pVar);
        }
        y2.c cVar = new y2.c(15);
        Executor executor = h1.j.f8420b;
        pVar.c(executor, cVar);
        pVar.b(executor, cVar);
        pVar.f8436b.o(new h1.m(executor, (h1.c) cVar));
        pVar.p();
        ((CountDownLatch) cVar.f13781b).await();
        return P(pVar);
    }

    public static Object j(p pVar, long j10, TimeUnit timeUnit) throws TimeoutException {
        y.f("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            androidx.window.layout.c.g("Must not be called on GoogleApiHandler thread.");
            return null;
        }
        y.h(pVar, "Task must not be null");
        y.h(timeUnit, "TimeUnit must not be null");
        if (pVar.h()) {
            return P(pVar);
        }
        y2.c cVar = new y2.c(15);
        Executor executor = h1.j.f8420b;
        pVar.c(executor, cVar);
        pVar.b(executor, cVar);
        pVar.f8436b.o(new h1.m(executor, (h1.c) cVar));
        pVar.p();
        if (((CountDownLatch) cVar.f13781b).await(j10, timeUnit)) {
            return P(pVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, java.util.List] */
    public static String k() {
        String str = f12312d;
        if (str != null) {
            return str;
        }
        String lowerCase = i9.a.h().f11814b.f11788o;
        if (lowerCase.equals("autoDetectedLanguage")) {
            Locale localeA = i9.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append((Object) localeA.getLanguage());
            sb.append('-');
            sb.append((Object) localeA.getCountry());
            lowerCase = sb.toString().toLowerCase(localeA);
            lowerCase.getClass();
            ?? r12 = i9.a.h().f11814b.Z;
            String lowerCase2 = ((String) t6.l.c0(m.s0(lowerCase, new String[]{"-"}))).toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            if (!r12.contains(lowerCase)) {
                lowerCase = r12.contains(lowerCase2) ? lowerCase2 : "en";
            }
        }
        f12312d = lowerCase;
        return lowerCase;
    }

    public static boolean l() {
        return i9.a.h().f11814b.V.f11799b.equals(Boolean.TRUE);
    }

    public static p m(Executor executor, Callable callable) {
        y.h(executor, "Executor must not be null");
        p pVar = new p();
        executor.execute(new k1.a(25, pVar, callable));
        return pVar;
    }

    public static void n(String str) {
        File file = new File(z().getExternalFilesDir(null), "tmp");
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (!(i10 < fileArrListFiles.length)) {
                return;
            }
            int i11 = i10 + 1;
            try {
                File file2 = fileArrListFiles[i10];
                if (!u.Z(file2.getAbsolutePath(), str, true) && file2.lastModified() < System.currentTimeMillis() - 3600000) {
                    l1.b.w(file2);
                }
                i10 = i11;
            } catch (ArrayIndexOutOfBoundsException e3) {
                com.google.gson.internal.a.o(e3.getMessage());
                return;
            }
        }
    }

    public static void o(Context context) {
        File externalFilesDir;
        q qVar;
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        ArrayList arrayListO = gVarL.O();
        gVarL.b();
        w4 w4Var = new w4(context, 3, false);
        if (w4Var.D()) {
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                File externalFilesDir2 = context.getExternalFilesDir(null);
                w4Var.P();
                w4Var.O();
                externalFilesDir = externalFilesDir2;
            }
        } else {
            externalFilesDir = context.getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Updates");
        if (!file.exists()) {
            file.mkdirs();
        }
        Iterator it = t3.h.m(context, file).iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            File file2 = (File) next;
            Iterator it2 = arrayListO.iterator();
            it2.getClass();
            boolean z9 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                next2.getClass();
                y0 y0Var = (y0) next2;
                if (!y0Var.b() && (qVar = y0Var.f8798i) != null && !qVar.f8716v.isEmpty()) {
                    q qVar2 = y0Var.f8798i;
                    qVar2.getClass();
                    Iterator it3 = qVar2.f8716v.iterator();
                    it3.getClass();
                    while (true) {
                        if (it3.hasNext()) {
                            Object next3 = it3.next();
                            next3.getClass();
                            if (u.Z(((h5.r) next3).h, file2.getAbsolutePath(), false)) {
                                z9 = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!z9) {
                file2.delete();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(SQLiteStatement sQLiteStatement, Throwable th) {
        if (sQLiteStatement != 0) {
            if (th != null) {
                try {
                    com.mbridge.msdk.dycreator.baseview.a.q(sQLiteStatement);
                    return;
                } catch (Throwable th2) {
                    s6.a.a(th, th2);
                    return;
                }
            }
            if (sQLiteStatement instanceof AutoCloseable) {
                sQLiteStatement.close();
                return;
            }
            if (sQLiteStatement instanceof ExecutorService) {
                androidx.core.provider.b.e((ExecutorService) sQLiteStatement);
                return;
            }
            if (sQLiteStatement instanceof TypedArray) {
                ((TypedArray) sQLiteStatement).recycle();
                return;
            }
            if (sQLiteStatement instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) sQLiteStatement).release();
                return;
            }
            if (sQLiteStatement instanceof MediaDrm) {
                ((MediaDrm) sQLiteStatement).release();
                return;
            }
            if (sQLiteStatement instanceof DrmManagerClient) {
                ((DrmManagerClient) sQLiteStatement).release();
            } else if (sQLiteStatement instanceof ContentProviderClient) {
                ((ContentProviderClient) sQLiteStatement).release();
            } else {
                z8.f.a();
            }
        }
    }

    public static void q(Context context, EditText editText) {
        Object systemService = context.getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static final double r(double d8, p7.c cVar, p7.c cVar2) {
        long jConvert = cVar2.f12044a.convert(1L, cVar.f12044a);
        return jConvert > 0 ? d8 * jConvert : d8 / r8.convert(1L, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static w6.c s(g7.p pVar, w6.c cVar, w6.c cVar2) {
        pVar.getClass();
        if (pVar instanceof y6.a) {
            return ((y6.a) pVar).create(cVar, cVar2);
        }
        w6.h context = cVar2.getContext();
        return context == w6.i.f13523a ? new x6.b(pVar, cVar2, cVar) : new x6.c(cVar2, context, pVar, cVar);
    }

    public static boolean t() {
        if (!i9.a.h().f11814b.V.f11800c.equals(Boolean.TRUE)) {
            return false;
        }
        ArrayList arrayList = i9.a.h().f11814b.X.f11776a;
        String upperCase = i9.a.f9114n.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        return arrayList.contains(upperCase);
    }

    public static z8.l u(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(o7.a.f11749a);
        bytes.getClass();
        z8.l lVar = new z8.l(bytes);
        lVar.f14490c = str;
        return lVar;
    }

    public static int v(int i10, int i11) {
        if (i11 < 0) {
            p8.u.h("cannot store more than MAX_VALUE elements");
            return 0;
        }
        int iHighestOneBit = i10 + (i10 >> 1) + 1;
        if (iHighestOneBit < i11) {
            iHighestOneBit = Integer.highestOneBit(i11 - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            return Integer.MAX_VALUE;
        }
        return iHighestOneBit;
    }

    public static p w(Exception exc) {
        p pVar = new p();
        pVar.k(exc);
        return pVar;
    }

    public static p x(Object obj) {
        p pVar = new p();
        pVar.l(obj);
        return pVar;
    }

    public static i1 y(JSONObject jSONObject) {
        i1 i1Var = new i1();
        i1Var.f8616a = -1L;
        i1Var.f = -1L;
        i1Var.h = new ArrayList();
        if (!jSONObject.isNull("appID")) {
            i1Var.f8616a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            i1Var.f8617b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull(RewardPlus.ICON)) {
            i1Var.f8618c = jSONObject.optString(RewardPlus.ICON);
        }
        if (!jSONObject.isNull("packagename")) {
            i1Var.f8619d = jSONObject.optString("packagename");
        }
        if (!jSONObject.isNull("wishlistAdded")) {
            i1Var.e = jSONObject.optString("wishlistAdded");
        }
        if (!jSONObject.isNull("platformID")) {
            i1Var.f = jSONObject.optLong("platformID");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            i1Var.g = jSONObject.optString("downloadStatus");
        }
        if (!jSONObject.isNull("url")) {
            i1Var.f8620i = jSONObject.optString("url");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("floatingCategories");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                h5.k kVar = new h5.k(0, (String) null, 7);
                jSONObjectOptJSONObject.getClass();
                kVar.b(jSONObjectOptJSONObject);
                i1Var.h.add(kVar);
            }
        }
        return i1Var;
    }

    public static Context z() {
        Context context = o4.b.f11711j;
        if (context != null) {
            return context;
        }
        l.i("appContext");
        throw null;
    }
}
