package t3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import c5.k0;
import com.mbridge.msdk.out.SDKInitStatusListener;
import h1.p;
import h5.k;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import o7.m;
import o7.u;
import r7.i0;
import r7.y;
import s6.w;
import w7.n;
import z1.t1;
import z8.l;
import z8.z;

/* loaded from: classes3.dex */
public final class h implements r.b, u1.a, g5.f, SDKInitStatusListener, h1.h, y1.d, z7.a {

    /* renamed from: b, reason: collision with root package name */
    public static h f12786b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12787a;

    public /* synthetic */ h(int i10) {
        this.f12787a = i10;
    }

    public static boolean f(File file) {
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(file).entries();
            while (enumerationEntries.hasMoreElements()) {
                String name = enumerationEntries.nextElement().getName();
                name.getClass();
                if (u.X(name, ".obb", false)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object g(Context context, String str, x4.c cVar) throws Throwable {
        y7.e eVar = i0.f12407a;
        Object objZ = y.z(new k0(context, str, null, 1), n.f13548a, cVar);
        return objZ == x6.a.f13718a ? objZ : w.f12711a;
    }

    public static z i(String str, boolean z9) {
        str.getClass();
        l lVar = a9.c.f331a;
        z8.i iVar = new z8.i();
        iVar.q(str);
        return a9.c.d(iVar, z9);
    }

    public static long j(File file) {
        File[] fileArrListFiles;
        file.getClass();
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            fileArrListFiles = file.listFiles();
        } catch (SecurityException e) {
            e.printStackTrace();
            fileArrListFiles = null;
        }
        long j10 = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        int i10 = 0;
        while (true) {
            if (!(i10 < fileArrListFiles.length)) {
                return j10;
            }
            int i11 = i10 + 1;
            try {
                j10 += j(fileArrListFiles[i10]);
                i10 = i11;
            } catch (ArrayIndexOutOfBoundsException e3) {
                com.google.gson.internal.a.o(e3.getMessage());
                return 0L;
            }
        }
    }

    public static ArrayList m(Context context, File file) {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            String packageName = context.getPackageName();
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String absolutePath = file2.getAbsolutePath();
                    absolutePath.getClass();
                    if (!u.X(absolutePath, "Android/data/" + packageName, false)) {
                        String name = file2.getName();
                        name.getClass();
                        if (!m.d0(name, "Backups", true)) {
                            arrayList.addAll(m(context, file2));
                        }
                    }
                } else {
                    String name2 = file2.getName();
                    name2.getClass();
                    if ((u.X(name2, ".apk", false) || u.X(name2, ".xapk", true) || u.X(name2, ".apks", true) || u.X(name2, ".apkm", true)) && !u.c0(name2, ".", false)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean o(java.io.File r4) {
        /*
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Exception -> L2b
            r1.<init>(r4)     // Catch: java.lang.Exception -> L2b
            java.util.Enumeration r4 = r1.entries()     // Catch: java.lang.Exception -> L2b
            r1 = r0
        Lb:
            boolean r2 = r4.hasMoreElements()     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L30
            java.lang.Object r2 = r4.nextElement()     // Catch: java.lang.Exception -> L29
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L29
            r2.getClass()     // Catch: java.lang.Exception -> L29
            java.lang.String r3 = ".apk"
            boolean r2 = o7.u.X(r2, r3, r0)     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto Lb
            int r1 = r1 + 1
            goto Lb
        L29:
            r4 = move-exception
            goto L2d
        L2b:
            r4 = move-exception
            r1 = r0
        L2d:
            r4.printStackTrace()
        L30:
            if (r1 <= 0) goto L33
            r0 = 1
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.h.o(java.io.File):boolean");
    }

    public static ArrayList p(Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayListH = t1.H(context);
        if (arrayListH.size() > 0) {
            Iterator it = arrayListH.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = new File(((u4.f) next).f12908a);
                if (file.exists() && file.isDirectory()) {
                    arrayList2.addAll(m(context, file));
                }
            }
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            externalStorageDirectory.getClass();
            arrayList2.addAll(m(context, externalStorageDirectory));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        packageManager.getClass();
        Iterator it2 = arrayList.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            next2.getClass();
            File file2 = (File) next2;
            String name = file2.getName();
            name.getClass();
            boolean z9 = false;
            if (!u.c0(name, ".", false)) {
                String name2 = file2.getName();
                name2.getClass();
                if (u.X(name2, ".apk", false)) {
                    String absolutePath = file2.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo packageInfoD = l5.a.d(packageManager, absolutePath, 128);
                    if (packageInfoD != null) {
                        try {
                            ApplicationInfo applicationInfo = packageInfoD.applicationInfo;
                            if ((applicationInfo != null ? applicationInfo.metaData : null) != null) {
                                applicationInfo.getClass();
                                if (applicationInfo.metaData.containsKey("com.android.vending.splits.required")) {
                                    ApplicationInfo applicationInfo2 = packageInfoD.applicationInfo;
                                    applicationInfo2.getClass();
                                    z9 = applicationInfo2.metaData.getBoolean("com.android.vending.splits.required");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!z9) {
                            arrayList3.add(file2);
                        }
                    } else {
                        String name3 = file2.getName();
                        name3.getClass();
                        if (!u.c0(name3, "split_config", false)) {
                            arrayList3.add(file2);
                        }
                    }
                } else {
                    String name4 = file2.getName();
                    name4.getClass();
                    if (u.X(name4, ".xapk", true) || u.X(name4, ".apks", true) || u.X(name4, ".apkm", true)) {
                        arrayList3.add(file2);
                    }
                }
            }
        }
        return arrayList3;
    }

    public static boolean q(File file, File file2) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String name = zipEntryNextElement.getName();
                name.getClass();
                if (u.X(name, ".apk", false)) {
                    if (zipEntryNextElement.getSize() >= file2.getUsableSpace()) {
                        return false;
                    }
                    File file3 = new File(file2, name);
                    InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int i10 = inputStream.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i10);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override // y1.d
    public String c() {
        return null;
    }

    @Override // p6.a
    public Object get() {
        h hVar = new h(17);
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            androidx.window.layout.c.k("Null flags");
            return null;
        }
        map.put(m.d.f11154a, new v.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, 86400000L, set));
        if (set == null) {
            androidx.window.layout.c.k("Null flags");
            return null;
        }
        map.put(m.d.f11156c, new v.b(1000L, 86400000L, set));
        if (set == null) {
            androidx.window.layout.c.k("Null flags");
            return null;
        }
        Set setUnmodifiableSet = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(v.c.f13096b)));
        if (setUnmodifiableSet == null) {
            androidx.window.layout.c.k("Null flags");
            return null;
        }
        map.put(m.d.f11155b, new v.b(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() >= m.d.values().length) {
            new HashMap();
            return new v.a(hVar, map);
        }
        androidx.window.layout.c.g("Not all priorities have been configured");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ae, code lost:
    
        if (r14 == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
    
        if (g(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
    
        if (g(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011d, code lost:
    
        if (r14 == r9) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0131, code lost:
    
        if (g(r19, r0, r7) == r9) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(java.lang.Object r17, java.lang.String r18, android.content.Context r19, final g7.a r20, y6.c r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.h.h(java.lang.Object, java.lang.String, android.content.Context, g7.a, y6.c):java.lang.Object");
    }

    @Override // u1.a
    public void k(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", null);
        }
    }

    public synchronized v5.g l(Context context) {
        v5.g gVar;
        try {
            context.getClass();
            if (v5.g.f13149v == null) {
                v5.g.f13149v = new v5.g(context.getApplicationContext());
            }
            gVar = v5.g.f13149v;
            gVar.getClass();
        } catch (Throwable th) {
            throw th;
        }
        return gVar;
    }

    public long n() {
        switch (this.f12787a) {
            case 16:
                return SystemClock.elapsedRealtime();
            default:
                return System.currentTimeMillis();
        }
    }

    @Override // com.mbridge.msdk.out.SDKInitStatusListener
    public void onInitFail(String str) {
        str.getClass();
    }

    @Override // h1.h
    public p y(Object obj) {
        return r0.f.x(Boolean.TRUE);
    }

    @Override // y1.d
    public void a() {
    }

    @Override // com.mbridge.msdk.out.SDKInitStatusListener
    public void onInitSuccess() {
    }

    @Override // g5.f
    public void b(long j10) {
    }

    @Override // g5.f
    public void d(k kVar) {
    }

    @Override // y1.d
    public void e(long j10, String str) {
    }
}
