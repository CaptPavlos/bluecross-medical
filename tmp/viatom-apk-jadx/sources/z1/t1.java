package z1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.activities.MainActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.logging.Logger;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14361a = true;

    public static String A(Context context, String str) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getString(str, null);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String B(Context context, String str, String str2) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                String string = sharedPreferences.getString(str, str2);
                string.getClass();
                return string;
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    public static String C(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    public static final boolean D(AssertionError assertionError) {
        Logger logger = z8.y.f14516a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? o7.m.d0(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final boolean F(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    public static boolean G(int i10, MainActivity mainActivity) {
        return r(mainActivity, "wizard_step_" + i10 + "_shown", false);
    }

    public static ArrayList H(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        context.getClass();
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getSystemService("storage");
        systemService.getClass();
        StorageManager storageManager = (StorageManager) systemService;
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", (Class[]) Arrays.copyOf(new Class[0], 0));
            method.setAccessible(true);
            Object objInvoke2 = method.invoke(storageManager, Arrays.copyOf(new Object[0], 0));
            objInvoke2.getClass();
            for (Object obj : (Object[]) objInvoke2) {
                if (obj != null) {
                    try {
                        objInvoke = obj.getClass().getMethod("getPath", null).invoke(obj, null);
                    } catch (NoSuchMethodException unused) {
                    }
                    String absolutePath = objInvoke != null ? (String) objInvoke : null;
                    if (absolutePath == null) {
                        try {
                            Object objInvoke3 = obj.getClass().getMethod("getDirectory", null).invoke(obj, null);
                            if (objInvoke3 != null) {
                                absolutePath = ((File) objInvoke3).getAbsolutePath();
                            }
                        } catch (NoSuchMethodException unused2) {
                        }
                    }
                    if (absolutePath != null) {
                        u4.f fVar = new u4.f();
                        fVar.f12908a = absolutePath;
                        File file = new File(absolutePath);
                        if (file.exists() && file.isDirectory()) {
                            fVar.f12911d = file.getUsableSpace();
                            try {
                                Object objInvoke4 = StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, absolutePath);
                                objInvoke4.getClass();
                                fVar.f12909b = (String) objInvoke4;
                            } catch (Exception unused3) {
                            }
                            try {
                                Object objInvoke5 = obj.getClass().getMethod("isRemovable", null).invoke(obj, null);
                                objInvoke5.getClass();
                                fVar.f12910c = ((Boolean) objInvoke5).booleanValue();
                            } catch (Exception unused4) {
                            }
                            arrayList.add(fVar);
                        }
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused5) {
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static ArrayList I(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayListH = H(context);
            int size = arrayListH.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!o7.m.d0(((u4.f) arrayListH.get(i10)).f12908a, "/emulated/", false) && ((u4.f) arrayListH.get(i10)).f12910c && "mounted".equals(((u4.f) arrayListH.get(i10)).f12909b)) {
                    File file = new File(((u4.f) arrayListH.get(i10)).f12908a + ("/Android/data/" + context.getPackageName()));
                    if (file.exists()) {
                        if (file.canWrite()) {
                            arrayList.add(arrayListH.get(i10));
                        }
                    } else if (file.mkdirs()) {
                        arrayList.add(arrayListH.get(i10));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static h5.a0 J(Context context) {
        context.getClass();
        h5.a0 a0Var = new h5.a0();
        a0Var.f8460a = -1L;
        a0Var.f8462c = -1;
        a0Var.f8460a = w(-1L, context, "fcm_app_id");
        a0Var.f8461b = A(context, "fcm_packagename");
        a0Var.f8462c = v(context, -1, "fcm_download_id");
        a0Var.f8463d = w(-1L, context, "fcm_received_timestamp");
        a0Var.e = w(-1L, context, "fcm_shown_timestamp");
        if (a0Var.f8460a <= -1 || a0Var.f8461b == null) {
            a0Var = null;
        }
        if (a0Var != null) {
            if (a0Var.f8460a > -1 && a0Var.f8461b != null) {
                long j10 = a0Var.f8463d;
                if (j10 > 0 && j10 + 86400000 > System.currentTimeMillis()) {
                    return a0Var;
                }
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.remove("fcm_app_id");
            editorEdit.remove("fcm_packagename");
            editorEdit.remove("fcm_download_id");
            editorEdit.remove("fcm_received_timestamp");
            editorEdit.remove("fcm_shown_timestamp");
            editorEdit.apply();
        }
        return null;
    }

    public static w6.h K(w6.f fVar, w6.g gVar) {
        gVar.getClass();
        return kotlin.jvm.internal.l.a(fVar.getKey(), gVar) ? w6.i.f13523a : fVar;
    }

    public static String L(long j10) {
        return j10 < 10485760 ? "<10MB" : j10 < 104857600 ? "<100MB" : j10 < 524288000 ? "<500MB" : j10 < 1073741824 ? "<1GB" : j10 < 10737418240L ? "<10GB" : "<10MB";
    }

    public static w6.h M(w6.f fVar, w6.h hVar) {
        hVar.getClass();
        return hVar == w6.i.f13523a ? fVar : (w6.h) hVar.fold(fVar, new e5.u0(13));
    }

    public static void N(Context context, String str, boolean z9) {
        context.getClass();
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putBoolean(str, z9);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void O(Context context, int i10, String str) {
        context.getClass();
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putInt(str, i10);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void P(Context context, String str) {
        str.getClass();
        R(context, "Language", str);
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("CoreSettings", 0).edit();
            editorEdit.putString("language", str);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Q(long j10, Context context, String str) {
        context.getClass();
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putLong(str, j10);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void R(Context context, String str, String str2) {
        context.getClass();
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final z8.c S(File file) {
        Logger logger = z8.y.f14516a;
        file.getClass();
        return new z8.c(new FileInputStream(file), z8.j0.f14480d);
    }

    public static final z8.c T(InputStream inputStream) {
        Logger logger = z8.y.f14516a;
        inputStream.getClass();
        return new z8.c(inputStream, new z8.j0());
    }

    public static final Object U(w7.r rVar, w7.r rVar2, g7.p pVar) throws Throwable {
        Object pVar2;
        Object objQ;
        try {
            if (pVar instanceof y6.a) {
                kotlin.jvm.internal.a0.b(2, pVar);
                pVar2 = pVar.invoke(rVar2, rVar);
            } else {
                pVar2 = r0.f.N(pVar, rVar2, rVar);
            }
        } catch (Throwable th) {
            pVar2 = new r7.p(false, th);
        }
        x6.a aVar = x6.a.f13718a;
        if (pVar2 == aVar || (objQ = rVar.Q(pVar2)) == r7.y.e) {
            return aVar;
        }
        if (objQ instanceof r7.p) {
            throw ((r7.p) objQ).f12426a;
        }
        return r7.y.x(objQ);
    }

    public static int V(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 == 2) {
            return 3;
        }
        if (i10 != 3) {
            return i10 != 4 ? 0 : 5;
        }
        return 4;
    }

    public static boolean W(byte b10) {
        return b10 > -65;
    }

    public static f6.g a(String str) throws h6.e, NumberFormatException {
        str.getClass();
        List listS0 = o7.m.s0(str, new String[]{"-"});
        if (listS0.size() != 2) {
            throw new h6.e("f.k: TCModelError, hash: ".concat(str));
        }
        int i10 = Integer.parseInt((String) listS0.get(0));
        int i11 = Integer.parseInt((String) listS0.get(1));
        return new f6.g(i10, i11 != 1 ? i11 != 2 ? f6.i.NOT_ALLOWED : f6.i.REQUIRE_LI : f6.i.REQUIRE_CONSENT);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        com.google.gson.internal.a.n(str);
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.google.gson.internal.a.n(str2);
        }
    }

    public static void d(t3.j jVar) {
        if (jVar.f) {
            i(jVar);
        } else {
            androidx.window.layout.c.g("AdSession is not started");
        }
    }

    public static void e(Bundle bundle) {
        bundle.putString("connectionType", a.a.f3d ? "wifi" : "mobile");
        bundle.putLong("downBandwidthKbps", a.a.f1b);
        bundle.putLong("upBandwidthKbps", a.a.f2c);
    }

    public static h5.j1 f(JSONObject jSONObject) {
        h5.j1 j1Var = new h5.j1();
        if (!jSONObject.isNull("id")) {
            j1Var.f8628a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            j1Var.f8629b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("isInstalled")) {
            j1Var.f8631d = jSONObject.optInt("isInstalled");
        }
        if (!jSONObject.isNull("isCompatible")) {
            j1Var.e = jSONObject.optInt("isCompatible");
        }
        if (!jSONObject.isNull("isCurrentDevice")) {
            j1Var.f8630c = jSONObject.optInt("isCurrentDevice");
        }
        if (!jSONObject.isNull("isLinked")) {
            j1Var.f = jSONObject.optInt("isLinked");
        }
        return j1Var;
    }

    public static final Object g(h1.p pVar, a3.b0 b0Var) throws Exception {
        if (!pVar.h()) {
            r7.g gVar = new r7.g(1, r0.f.F(b0Var));
            gVar.s();
            pVar.a(b8.a.f856a, new y2.c(gVar, 3));
            return gVar.q();
        }
        Exception excF = pVar.f();
        if (excF != null) {
            throw excF;
        }
        if (!pVar.f8438d) {
            return pVar.g();
        }
        throw new CancellationException("Task " + pVar + " was cancelled normally.");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(t7.s r4, g7.a r5, y6.c r6) {
        /*
            boolean r0 = r6 instanceof t7.p
            if (r0 == 0) goto L13
            r0 = r6
            t7.p r0 = (t7.p) r0
            int r1 = r0.f12857c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12857c = r1
            goto L18
        L13:
            t7.p r0 = new t7.p
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f12856b
            int r1 = r0.f12857c
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            g7.a r5 = r0.f12855a
            s6.a.e(r6)     // Catch: java.lang.Throwable -> L27
            goto L62
        L27:
            r4 = move-exception
            goto L68
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L30:
            s6.a.e(r6)
            w6.h r6 = r0.getContext()
            r7.t r1 = r7.t.f12437b
            w6.f r6 = r6.get(r1)
            if (r6 != r4) goto L6c
            r0.f12855a = r5     // Catch: java.lang.Throwable -> L27
            r0.f12857c = r2     // Catch: java.lang.Throwable -> L27
            r7.g r6 = new r7.g     // Catch: java.lang.Throwable -> L27
            w6.c r0 = r0.f.F(r0)     // Catch: java.lang.Throwable -> L27
            r6.<init>(r2, r0)     // Catch: java.lang.Throwable -> L27
            r6.s()     // Catch: java.lang.Throwable -> L27
            t7.q r0 = new t7.q     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            t7.r r4 = (t7.r) r4     // Catch: java.lang.Throwable -> L27
            r4.f0(r0)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r6.q()     // Catch: java.lang.Throwable -> L27
            x6.a r6 = x6.a.f13718a
            if (r4 != r6) goto L62
            return r6
        L62:
            r5.invoke()
            s6.w r4 = s6.w.f12711a
            return r4
        L68:
            r5.invoke()
            throw r4
        L6c:
            java.lang.String r4 = "awaitClose() can only be invoked from the producer context"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.t1.h(t7.s, g7.a, y6.c):java.lang.Object");
    }

    public static void i(t3.j jVar) {
        if (jVar.g) {
            androidx.window.layout.c.g("AdSession is finished");
        }
    }

    public static void j(int i10, Object[] objArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (objArr[i11] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i11);
                throw new NullPointerException(sb.toString());
            }
        }
    }

    public static void k(int i10) {
        if (2 > i10 || i10 >= 37) {
            StringBuilder sbR = a3.a.r(i10, "radix ", " was not in valid range ");
            sbR.append(new l7.d(2, 36, 1));
            throw new IllegalArgumentException(sbR.toString());
        }
    }

    public static void l(Object obj, String str, String str2) {
        String strC = C(str);
        if (Log.isLoggable(strC, 3)) {
            Log.d(strC, String.format(str2, obj));
        }
    }

    public static void m(String str, String str2, Exception exc) {
        String strC = C(str);
        if (Log.isLoggable(strC, 6)) {
            Log.e(strC, str2, exc);
        }
    }

    public static final boolean n(char c10, char c11, boolean z9) {
        if (c10 == c11) {
            return true;
        }
        if (!z9) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static Object o(w6.f fVar, Object obj, g7.p pVar) {
        pVar.getClass();
        return pVar.invoke(obj, fVar);
    }

    public static w6.f p(w6.f fVar, w6.g gVar) {
        gVar.getClass();
        if (kotlin.jvm.internal.l.a(fVar.getKey(), gVar)) {
            return fVar;
        }
        return null;
    }

    public static boolean r(Context context, String str, boolean z9) {
        context.getClass();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z9);
            }
        } catch (Exception unused) {
        }
        return z9;
    }

    public static final m7.c t(e8.e eVar) {
        eVar.getClass();
        if (eVar instanceof e8.b) {
            return ((e8.b) eVar).f7955b;
        }
        if (eVar instanceof g8.w0) {
            return t(((g8.w0) eVar).f8339a);
        }
        return null;
    }

    public static void u(k1.b bVar) {
        boolean z9 = false;
        if (!bVar.isDone()) {
            androidx.window.layout.c.g(r0.f.H("Future was expected to be done: %s", bVar));
            return;
        }
        while (true) {
            try {
                bVar.get();
                break;
            } catch (InterruptedException unused) {
                z9 = true;
            } catch (Throwable th) {
                if (z9) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
    }

    public static int v(Context context, int i10, String str) {
        context.getClass();
        return context.getSharedPreferences("SettingsPreferences", 0).getInt(str, i10);
    }

    public static long w(long j10, Context context, String str) {
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        try {
            return sharedPreferences.getLong(str, j10);
        } catch (ClassCastException unused) {
            try {
                long j11 = sharedPreferences.getInt(str, -1);
                Q(j11, context, str);
                return j11;
            } catch (ClassCastException unused2) {
                return j10;
            }
        }
    }

    public static String x(Context context) {
        context.getClass();
        String strB = B(context, "notifications_frecuency", "1");
        if (!strB.equals("0")) {
            return strB;
        }
        R(context, "notifications_frecuency", "1");
        return "1";
    }

    public static ArrayList y(String str) {
        File[] fileArrListFiles;
        str.getClass();
        ArrayList arrayList = new ArrayList();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/Obb/" + str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            int i10 = 0;
            while (i10 < fileArrListFiles.length) {
                int i11 = i10 + 1;
                try {
                    File file2 = fileArrListFiles[i10];
                    if (file2.isFile()) {
                        String name = file2.getName();
                        name.getClass();
                        if (o7.u.X(name, ".obb", false)) {
                            arrayList.add(file2);
                        }
                    }
                    i10 = i11;
                } catch (ArrayIndexOutOfBoundsException e) {
                    com.google.gson.internal.a.o(e.getMessage());
                    return null;
                }
            }
        }
        return arrayList;
    }

    public abstract boolean E(Class cls);

    public abstract Method q(Class cls, Field field);

    public abstract Constructor s(Class cls);

    public abstract String[] z(Class cls);
}
