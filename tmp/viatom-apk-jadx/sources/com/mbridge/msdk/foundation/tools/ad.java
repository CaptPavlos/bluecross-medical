package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ad extends l {
    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + File.separator + "template_config.json");
                if (file.isFile() && file.exists()) {
                    String strB = b(file);
                    if (!TextUtils.isEmpty(strB)) {
                        try {
                            JSONArray jSONArray = new JSONArray(strB);
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                                if (jSONObject != null && str2.equals(jSONObject.optString("xml_type"))) {
                                    arrayList.add(str + File.separator + jSONObject.optString(RewardPlus.NAME));
                                    if (jSONObject.has("ext_template")) {
                                        jSONObject.put("folder_dir", str);
                                        arrayList.add(jSONObject.toString());
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            af.b("SameFileTool", e.getMessage());
                        }
                    }
                } else {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Exception e3) {
            af.b("SameFileTool", e3.getMessage());
            return arrayList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0123, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0127, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0128, code lost:
    
        com.mbridge.msdk.foundation.tools.af.b("SameFileTool", com.mbridge.msdk.newreward.function.common.MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0109, code lost:
    
        if (r12 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x010b, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x010f, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0110, code lost:
    
        com.mbridge.msdk.foundation.tools.af.b("SameFileTool", com.mbridge.msdk.newreward.function.common.MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x011e, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0121, code lost:
    
        if (r12 == null) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static ArrayList<File> c(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() { // from class: com.mbridge.msdk.foundation.tools.ad.3
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                return !file3.isHidden() || file3.isDirectory();
            }
        })) {
            if (file2.isDirectory()) {
                arrayList.addAll(c(file2));
            } else {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x002b A[EXC_TOP_SPLITTER, PHI: r0 r2
      0x002b: PHI (r0v2 long) = (r0v0 long), (r0v4 long) binds: [B:23:0x0037, B:17:0x0029] A[DONT_GENERATE, DONT_INLINE]
      0x002b: PHI (r2v3 java.io.FileInputStream) = (r2v2 java.io.FileInputStream), (r2v4 java.io.FileInputStream) binds: [B:23:0x0037, B:17:0x0029] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long d(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L1f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            long r0 = (long) r4
            r2 = r3
            goto L29
        L15:
            r4 = move-exception
            r2 = r3
            goto L3b
        L18:
            r4 = move-exception
            r2 = r3
            goto L34
        L1b:
            r4 = move-exception
            goto L3b
        L1d:
            r4 = move-exception
            goto L34
        L1f:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            java.lang.String r4 = "获取文件大小"
            java.lang.String r3 = "文件不存在!"
            com.mbridge.msdk.foundation.tools.af.b(r4, r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
        L29:
            if (r2 == 0) goto L3a
        L2b:
            r2.close()     // Catch: java.lang.Exception -> L2f
            goto L3a
        L2f:
            r4 = move-exception
            r4.printStackTrace()
            goto L3a
        L34:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L3a
            goto L2b
        L3a:
            return r0
        L3b:
            if (r2 == 0) goto L45
            r2.close()     // Catch: java.lang.Exception -> L41
            goto L45
        L41:
            r0 = move-exception
            r0.printStackTrace()
        L45:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.d(java.io.File):long");
    }

    private static void e(String str) {
        try {
            ArrayList<File> arrayListC = c(new File(str));
            Collections.sort(arrayListC, new Comparator<File>() { // from class: com.mbridge.msdk.foundation.tools.ad.4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    long jLastModified = file.lastModified() - file2.lastModified();
                    if (jLastModified > 0) {
                        return 1;
                    }
                    return jLastModified == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (arrayListC.size() - 1) / 2;
            for (int i10 = 0; i10 < size; i10++) {
                File file = arrayListC.get(i10);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            af.b("SameFileTool", "del memory failed");
        }
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return SameMD5.getMD5(aq.b(str.trim()));
        }
        return "";
    }

    private static long e(File file) throws Exception {
        long jD;
        File[] fileArrListFiles = file.listFiles();
        long j10 = 0;
        if (fileArrListFiles != null) {
            for (int i10 = 0; i10 < fileArrListFiles.length; i10++) {
                if (fileArrListFiles[i10].isDirectory()) {
                    jD = e(fileArrListFiles[i10]);
                } else {
                    jD = d(fileArrListFiles[i10]);
                }
                j10 += jD;
            }
        }
        return j10;
    }

    public static boolean d(String str) {
        if (com.mbridge.msdk.foundation.same.c.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static void a() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ad.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (gVarB == null) {
                        com.mbridge.msdk.c.h.a();
                        gVarB = com.mbridge.msdk.c.i.a();
                    }
                    ad.a(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR), gVarB.T());
                    ad.a(System.currentTimeMillis() - (gVarB.l() * 1000));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
    }

    public static void a(long j10) {
        try {
            ArrayList<File> arrayListC = c(new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR)));
            int size = arrayListC.size();
            int i10 = 0;
            while (i10 < size) {
                File file = arrayListC.get(i10);
                i10++;
                File file2 = file;
                if (file2.lastModified() < j10 && file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
        } catch (Throwable th) {
            af.b("SameFileTool", th.getMessage(), th);
        }
    }

    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        a(file2);
                    }
                    file.delete();
                    return "";
                }
                file.delete();
            }
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - (gVarB.l() * 1000);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.lastModified() + jCurrentTimeMillis < jCurrentTimeMillis2) {
                            a(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    a(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (IOException e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static /* synthetic */ void a(String str, int i10) {
        try {
            if (e(new File(str)) > i10 * 1048576) {
                e(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            af.b("SameFileTool", "clean memory failed");
        }
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:39|7|(1:9)(0))|37) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L37
            r4.<init>()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L37
        L13:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            if (r2 == 0) goto L33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            r4.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            goto L13
        L2e:
            r4 = move-exception
            r0 = r1
            goto L4d
        L31:
            r2 = move-exception
            goto L3f
        L33:
            r1.close()     // Catch: java.io.IOException -> L45
            goto L45
        L37:
            r2 = move-exception
            r4 = r0
            goto L3f
        L3a:
            r4 = move-exception
            goto L4d
        L3c:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L3f:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L45
            goto L33
        L45:
            if (r4 == 0) goto L4c
            java.lang.String r4 = r4.toString()
            return r4
        L4c:
            return r0
        L4d:
            if (r0 == 0) goto L52
            r0.close()     // Catch: java.io.IOException -> L52
        L52:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ad.b(java.io.File):java.lang.String");
    }

    public static void b() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ad.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC);
                        try {
                            File file = new File(strA);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : ad.b(strA)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
