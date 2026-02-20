package v5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.UptodownApp;
import e5.u0;
import h5.w;
import java.io.File;
import java.lang.Character;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import o7.u;
import t6.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public static long a(ApplicationInfo applicationInfo) {
        File parentFile;
        long j10;
        applicationInfo.getClass();
        long j11 = 0;
        if (applicationInfo.sourceDir == null || (parentFile = new File(applicationInfo.sourceDir).getParentFile()) == null || !parentFile.isDirectory()) {
            return 0L;
        }
        long j12 = t3.h.j(parentFile);
        String str = applicationInfo.packageName;
        str.getClass();
        try {
            j10 = t3.h.j(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + str + '/'));
        } catch (Exception e) {
            e.printStackTrace();
            j10 = 0;
        }
        long j13 = j12 + j10;
        String str2 = applicationInfo.packageName;
        str2.getClass();
        try {
            j11 = t3.h.j(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str2 + '/'));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return j13 + j11;
    }

    public static String b(Context context, String str) {
        context.getClass();
        str.getClass();
        try {
            return Build.VERSION.SDK_INT >= 30 ? context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName() : context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a9 A[EDGE_INSN: B:66:0x00a9->B:53:0x00a9 BREAK  A[LOOP:1: B:24:0x0057->B:31:0x0063], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList c(android.content.pm.PackageManager r6, java.lang.String r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L49
            r3 = 28
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L77
            r2 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r6 = l5.a.f(r6, r7, r2)     // Catch: java.lang.Exception -> L49
            android.content.pm.SigningInfo r6 = r6.signingInfo     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            boolean r7 = r6.hasPastSigningCertificates()     // Catch: java.lang.Exception -> L49
            if (r7 == 0) goto L4c
            android.content.pm.Signature[] r7 = r6.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L49
            r7.getClass()     // Catch: java.lang.Exception -> L49
            int r7 = r7.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L2d
            goto L4c
        L2d:
            android.content.pm.Signature[] r6 = r6.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L49
            kotlin.jvm.internal.b r6 = kotlin.jvm.internal.a0.d(r6)     // Catch: java.lang.Exception -> L49
        L35:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Exception -> L49
            if (r7 == 0) goto La9
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Exception -> L49
            android.content.pm.Signature r7 = (android.content.pm.Signature) r7     // Catch: java.lang.Exception -> L49
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            goto L35
        L49:
            r6 = move-exception
            goto La6
        L4c:
            android.content.pm.Signature[] r6 = r6.getApkContentsSigners()     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            int r7 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L56
            goto La9
        L56:
            r7 = r5
        L57:
            int r2 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 >= r2) goto L5c
            r2 = r4
            goto L5d
        L5c:
            r2 = r5
        L5d:
            if (r2 == 0) goto La9
            int r2 = r7 + 1
            r7 = r6[r7]     // Catch: java.lang.Exception -> L49 java.lang.ArrayIndexOutOfBoundsException -> L6c
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            r7 = r2
            goto L57
        L6c:
            r6 = move-exception
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException     // Catch: java.lang.Exception -> L49
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Exception -> L49
            r7.<init>(r6)     // Catch: java.lang.Exception -> L49
            throw r7     // Catch: java.lang.Exception -> L49
        L77:
            r2 = 64
            android.content.pm.PackageInfo r6 = l5.a.f(r6, r7, r2)     // Catch: java.lang.Exception -> L49
            android.content.pm.Signature[] r6 = r6.signatures     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            int r7 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L85
            goto La9
        L85:
            r7 = r5
        L86:
            int r2 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 >= r2) goto L8b
            r2 = r4
            goto L8c
        L8b:
            r2 = r5
        L8c:
            if (r2 == 0) goto La9
            int r2 = r7 + 1
            r7 = r6[r7]     // Catch: java.lang.Exception -> L49 java.lang.ArrayIndexOutOfBoundsException -> L9b
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            r7 = r2
            goto L86
        L9b:
            r6 = move-exception
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException     // Catch: java.lang.Exception -> L49
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Exception -> L49
            r7.<init>(r6)     // Catch: java.lang.Exception -> L49
            throw r7     // Catch: java.lang.Exception -> L49
        La6:
            r6.printStackTrace()
        La9:
            java.util.Iterator r6 = r1.iterator()
            r6.getClass()
        Lb0:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Lc9
            java.lang.Object r7 = r6.next()
            r7.getClass()
            byte[] r7 = (byte[]) r7
            java.lang.String r7 = com.google.android.gms.internal.measurement.l5.B(r7)
            if (r7 == 0) goto Lb0
            r0.add(r7)
            goto Lb0
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.a.c(android.content.pm.PackageManager, java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x005d -> B:29:0x0060). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.pm.PackageManager r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L35
            r2 = 28
            r3 = 0
            if (r1 < r2) goto L48
            r1 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r4 = l5.a.f(r4, r5, r1)     // Catch: java.lang.Exception -> L35
            android.content.pm.SigningInfo r4 = r4.signingInfo     // Catch: java.lang.Exception -> L35
            if (r4 == 0) goto L60
            boolean r5 = r4.hasPastSigningCertificates()     // Catch: java.lang.Exception -> L35
            if (r5 == 0) goto L37
            android.content.pm.Signature[] r5 = r4.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L35
            r5.getClass()     // Catch: java.lang.Exception -> L35
            int r5 = r5.length     // Catch: java.lang.Exception -> L35
            if (r5 != 0) goto L23
            goto L37
        L23:
            android.content.pm.Signature[] r5 = r4.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L35
            int r5 = r5.length     // Catch: java.lang.Exception -> L35
            int r5 = r5 + (-1)
            android.content.pm.Signature[] r4 = r4.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L35
            r4 = r4[r5]     // Catch: java.lang.Exception -> L35
            byte[] r4 = r4.toByteArray()     // Catch: java.lang.Exception -> L35
            goto L61
        L35:
            r4 = move-exception
            goto L5d
        L37:
            android.content.pm.Signature[] r4 = r4.getApkContentsSigners()     // Catch: java.lang.Exception -> L35
            if (r4 == 0) goto L60
            int r5 = r4.length     // Catch: java.lang.Exception -> L35
            if (r5 != 0) goto L41
            goto L60
        L41:
            r4 = r4[r3]     // Catch: java.lang.Exception -> L35
            byte[] r4 = r4.toByteArray()     // Catch: java.lang.Exception -> L35
            goto L61
        L48:
            r1 = 64
            android.content.pm.PackageInfo r4 = l5.a.f(r4, r5, r1)     // Catch: java.lang.Exception -> L35
            android.content.pm.Signature[] r4 = r4.signatures     // Catch: java.lang.Exception -> L35
            if (r4 == 0) goto L60
            int r5 = r4.length     // Catch: java.lang.Exception -> L35
            if (r5 != 0) goto L56
            goto L60
        L56:
            r4 = r4[r3]     // Catch: java.lang.Exception -> L35
            byte[] r4 = r4.toByteArray()     // Catch: java.lang.Exception -> L35
            goto L61
        L5d:
            r4.printStackTrace()
        L60:
            r4 = r0
        L61:
            if (r4 == 0) goto L7c
            java.lang.String r5 = "MD5"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L70
            java.lang.String r0 = com.google.android.gms.internal.measurement.l5.B(r4)
            goto L7c
        L70:
            java.lang.String r5 = "SHA256"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L7c
            java.lang.String r0 = com.google.android.gms.internal.measurement.l5.x(r4)
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.a.d(android.content.pm.PackageManager, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String e(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            h5.f fVar = (h5.f) next;
            String str = fVar.f8538s;
            if (str != null) {
                arrayList2.add(str);
                ArrayList arrayList3 = fVar.f8543z;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    ArrayList arrayList4 = fVar.f8543z;
                    arrayList4.getClass();
                    Iterator it2 = arrayList4.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        String str2 = ((w) next2).f8781a;
                        if (str2 != null) {
                            arrayList2.add(str2);
                        }
                    }
                }
                ArrayList arrayList5 = fVar.A;
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    ArrayList arrayList6 = fVar.A;
                    arrayList6.getClass();
                    Iterator it3 = arrayList6.iterator();
                    it3.getClass();
                    while (it3.hasNext()) {
                        Object next3 = it3.next();
                        next3.getClass();
                        String str3 = ((w) next3).f8781a;
                        if (str3 != null) {
                            arrayList2.add(str3);
                        }
                    }
                }
            }
        }
        q.W(arrayList2, new com.google.android.material.button.a(new u0(7), 5));
        Iterator it4 = arrayList2.iterator();
        it4.getClass();
        String str4 = null;
        while (it4.hasNext()) {
            Object next4 = it4.next();
            next4.getClass();
            String str5 = (String) next4;
            str4 = str4 == null ? str5 : String.format("%s%s", Arrays.copyOf(new Object[]{str4, str5}, 2));
        }
        if (str4 == null) {
            return str4;
        }
        StringBuilder sbV = a3.a.v(str4);
        sbV.append(Build.VERSION.SDK_INT);
        byte[] bytes = sbV.toString().getBytes(o7.a.f11749a);
        bytes.getClass();
        return l5.B(bytes);
    }

    public static boolean f(Context context) {
        context.getClass();
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (!u.Z(str, "Xiaomi", true) && !u.Z(str2, "Xiaomi", true) && !u.Z(str, "Poco", true)) {
            g gVarL = g.f13148u.l(context);
            gVarL.a();
            ArrayList arrayListU = gVarL.u();
            gVarL.b();
            Iterator it = arrayListU.iterator();
            it.getClass();
            int i10 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                h5.f fVar = (h5.f) next;
                if (fVar.f8526c != null && (fVar.c() || fVar.d())) {
                    String str3 = fVar.f8526c;
                    str3.getClass();
                    if (u.c0(str3, "com.miui.", false) || u.c0(str3, "com.xiaomi.", false)) {
                        i10++;
                        if (i10 > 5) {
                            break;
                        }
                    }
                }
            }
            if (i10 <= 5) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h5.f g(android.content.pm.ApplicationInfo r23, h5.f r24, android.content.pm.PackageInfo r25, v5.g r26, android.content.Context r27, android.content.pm.PackageManager r28, boolean r29, boolean r30) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.a.g(android.content.pm.ApplicationInfo, h5.f, android.content.pm.PackageInfo, v5.g, android.content.Context, android.content.pm.PackageManager, boolean, boolean):h5.f");
    }

    public static h5.f h(Context context, String str) {
        PackageInfo packageInfoF;
        ApplicationInfo applicationInfoB;
        SharedPreferences sharedPreferences;
        context.getClass();
        synchronized (UptodownApp.f6637o0) {
            h5.f fVarG = null;
            if (str == null) {
                return null;
            }
            g gVarL = g.f13148u.l(context);
            gVarL.a();
            PackageManager packageManager = context.getPackageManager();
            boolean z9 = false;
            try {
                PackageManager packageManager2 = context.getPackageManager();
                packageManager2.getClass();
                packageInfoF = l5.a.f(packageManager2, str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfoF = null;
            }
            if (packageInfoF != null) {
                try {
                    sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception unused2) {
                }
                boolean z10 = sharedPreferences.contains("show_system_apps") ? sharedPreferences.getBoolean("show_system_apps", false) : false;
                try {
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences2.contains("show_system_services")) {
                        z9 = sharedPreferences2.getBoolean("show_system_services", false);
                    }
                } catch (Exception unused3) {
                }
                boolean z11 = z9;
                try {
                    PackageManager packageManager3 = context.getPackageManager();
                    packageManager3.getClass();
                    applicationInfoB = l5.a.b(packageManager3, str, 128);
                } catch (PackageManager.NameNotFoundException unused4) {
                    applicationInfoB = null;
                }
                if (applicationInfoB != null) {
                    String str2 = applicationInfoB.packageName;
                    str2.getClass();
                    h5.f fVarR = gVarL.r(str2);
                    packageManager.getClass();
                    fVarG = g(applicationInfoB, fVarR, packageInfoF, gVarL, context, packageManager, z10, z11);
                }
            }
            gVarL.b();
            return fVarG;
        }
    }

    public static ArrayList i(Context context) {
        ArrayList arrayList;
        PackageInfo packageInfoF;
        Iterator it;
        int i10;
        h5.f fVar;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        Context context2 = context;
        context2.getClass();
        synchronized (UptodownApp.f6637o0) {
            arrayList = new ArrayList();
            g gVarL = g.f13148u.l(context2);
            gVarL.a();
            PackageManager packageManager = context2.getPackageManager();
            packageManager.getClass();
            List listC = l5.a.c(packageManager);
            ArrayList arrayListU = gVarL.u();
            int i11 = 0;
            try {
                sharedPreferences2 = context2.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused) {
            }
            boolean z9 = sharedPreferences2.contains("show_system_apps") ? sharedPreferences2.getBoolean("show_system_apps", false) : false;
            try {
                sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
            } catch (Exception unused2) {
            }
            boolean z10 = sharedPreferences.contains("show_system_services") ? sharedPreferences.getBoolean("show_system_services", false) : false;
            Iterator it2 = listC.iterator();
            while (it2.hasNext()) {
                ApplicationInfo applicationInfo = (ApplicationInfo) it2.next();
                try {
                    String str = applicationInfo.packageName;
                    str.getClass();
                    packageInfoF = l5.a.f(packageManager, str, i11);
                } catch (PackageManager.NameNotFoundException unused3) {
                    packageInfoF = null;
                }
                if (packageInfoF != null) {
                    Iterator it3 = arrayListU.iterator();
                    int i12 = i11;
                    while (true) {
                        if (!it3.hasNext()) {
                            it = it2;
                            i10 = i11;
                            i12 = -1;
                            fVar = null;
                            break;
                        }
                        int i13 = i12 + 1;
                        h5.f fVar2 = (h5.f) it3.next();
                        it = it2;
                        i10 = 0;
                        if (u.Z(fVar2.f8526c, applicationInfo.packageName, false)) {
                            fVar = fVar2;
                            break;
                        }
                        i11 = 0;
                        i12 = i13;
                        it2 = it;
                    }
                    if (i12 >= 0) {
                        arrayListU.remove(i12);
                    }
                    arrayList.add(g(applicationInfo, fVar, packageInfoF, gVarL, context2, packageManager, z9, z10));
                    context2 = context;
                    i11 = i10;
                    it2 = it;
                } else {
                    context2 = context;
                }
            }
            Iterator it4 = arrayListU.iterator();
            it4.getClass();
            while (it4.hasNext()) {
                Object next = it4.next();
                next.getClass();
                h5.f fVar3 = (h5.f) next;
                gVarL.e(fVar3);
                String str2 = fVar3.f8526c;
                if (str2 != null) {
                    gVarL.m(str2);
                }
            }
            gVarL.b();
        }
        return arrayList;
    }

    public static void j(h5.f fVar, PackageInfo packageInfo, Context context) throws PackageManager.NameNotFoundException {
        fVar.getClass();
        context.getClass();
        try {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                fVar.f8525b = applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (Exception unused) {
            fVar.f8525b = fVar.f8526c;
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setLocale(new Locale("xx"));
            if (packageInfo.applicationInfo != null) {
                PackageManager packageManager = context.getPackageManager();
                ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                applicationInfo2.getClass();
                Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo2.packageName);
                resourcesForApplication.getClass();
                resourcesForApplication.updateConfiguration(configuration, context.getResources().getDisplayMetrics());
                ApplicationInfo applicationInfo3 = packageInfo.applicationInfo;
                applicationInfo3.getClass();
                fVar.f8536q = resourcesForApplication.getString(applicationInfo3.labelRes);
            }
        } catch (Exception unused2) {
            fVar.f8536q = fVar.f8525b;
        }
        String str = fVar.f8536q;
        str.getClass();
        int length = str.length();
        boolean z9 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = str.charAt(i10);
            if (Build.VERSION.SDK_INT >= 24 ? Character.UnicodeScript.of(cCharAt) == Character.UnicodeScript.HAN : Character.isIdeographic(cCharAt)) {
                z9 = true;
                break;
            }
            i10++;
        }
        if (z9) {
            fVar.f8536q = fVar.f8526c;
        } else {
            String strReplaceAll = fVar.f8536q;
            strReplaceAll.getClass();
            Normalizer.Form form = Normalizer.Form.NFD;
            if (!Normalizer.isNormalized(strReplaceAll, form)) {
                String strNormalize = Normalizer.normalize(strReplaceAll, form);
                strNormalize.getClass();
                Pattern patternCompile = Pattern.compile("[\\p{InCombiningDiacriticalMarks}]");
                patternCompile.getClass();
                strReplaceAll = patternCompile.matcher(strNormalize).replaceAll("");
                strReplaceAll.getClass();
            }
            fVar.f8536q = strReplaceAll;
        }
        if (u.Z(fVar.f8536q, "null", true)) {
            fVar.f8535p = 1;
        }
    }
}
