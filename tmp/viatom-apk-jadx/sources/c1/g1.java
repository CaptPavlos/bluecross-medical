package c1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.documentfile.provider.DocumentFile;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import l4.kb;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1229a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1230b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1231c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1232d;

    public g1(Context context, String str, t4.d dVar, boolean z9) {
        str.getClass();
        dVar.getClass();
        this.f1231c = context;
        this.f1230b = str;
        this.f1232d = dVar;
        this.f1229a = z9;
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(r7.y.a(y7.d.f14116a), null, null, new kb(this, (w6.c) null, 8), 3);
    }

    public void a() {
        synchronized (((r8.f) this.f1232d)) {
            try {
                if (this.f1229a) {
                    throw new IllegalStateException();
                }
                if (((r8.d) this.f1230b).f == this) {
                    ((r8.f) this.f1232d).b(this, false);
                }
                this.f1229a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0179, code lost:
    
        if (r2 == r6) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(u4.b r23, y6.c r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.g1.b(u4.b, y6.c):java.lang.Object");
    }

    public void c() {
        synchronized (((r8.f) this.f1232d)) {
            try {
                if (this.f1229a) {
                    throw new IllegalStateException();
                }
                if (((r8.d) this.f1230b).f == this) {
                    ((r8.f) this.f1232d).b(this, true);
                }
                this.f1229a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00eb, code lost:
    
        r5 = r23;
        r7 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e7 -> B:34:0x00e9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.io.File r23, java.lang.Object r24, y6.c r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.g1.d(java.io.File, java.lang.Object, y6.c):java.lang.Object");
    }

    public void e() {
        r8.d dVar = (r8.d) this.f1230b;
        if (dVar.f != this) {
            return;
        }
        int i10 = 0;
        while (true) {
            r8.f fVar = (r8.f) this.f1232d;
            if (i10 >= fVar.h) {
                dVar.f = null;
                return;
            } else {
                try {
                    fVar.f12476a.a(dVar.f12470d[i10]);
                } catch (IOException unused) {
                }
                i10++;
            }
        }
    }

    public String f(u4.b bVar) {
        String strReplaceAll;
        PackageInfo packageInfoF;
        PackageInfo packageInfoF2;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        l4.a4 a4Var = (l4.a4) this.f1231c;
        boolean z9 = true;
        try {
            sharedPreferences2 = a4Var.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused) {
        }
        boolean z10 = sharedPreferences2.contains("app_name_included") ? sharedPreferences2.getBoolean("app_name_included", true) : true;
        if (z10) {
            String str = bVar.f12896b;
            str.getClass();
            Pattern patternCompile = Pattern.compile("[/\\\\:*?\"<>|]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str).replaceAll("");
            strReplaceAll.getClass();
        } else {
            String str2 = bVar.f12895a;
            str2.getClass();
            Pattern patternCompile2 = Pattern.compile("[/\\\\:*?\"<>|]");
            patternCompile2.getClass();
            strReplaceAll = patternCompile2.matcher(str2).replaceAll("");
            strReplaceAll.getClass();
        }
        try {
            SharedPreferences sharedPreferences3 = a4Var.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences3.contains("versioncode_included")) {
                z9 = sharedPreferences3.getBoolean("versioncode_included", true);
            }
        } catch (Exception unused2) {
        }
        if (z9) {
            try {
                PackageManager packageManager = a4Var.getPackageManager();
                packageManager.getClass();
                packageInfoF = l5.a.f(packageManager, bVar.f12895a, 0);
            } catch (Exception e) {
                e.printStackTrace();
                packageInfoF = null;
            }
            strReplaceAll = strReplaceAll + '_' + (packageInfoF != null ? x4.d.d(packageInfoF) : 0L);
        }
        try {
            sharedPreferences = a4Var.getSharedPreferences("CoreSettings", 0);
        } catch (Exception unused3) {
        }
        boolean z11 = sharedPreferences.contains("versionname_included") ? sharedPreferences.getBoolean("versionname_included", false) : false;
        if (!z11) {
            return strReplaceAll;
        }
        try {
            PackageManager packageManager2 = a4Var.getPackageManager();
            packageManager2.getClass();
            packageInfoF2 = l5.a.f(packageManager2, bVar.f12895a, 0);
        } catch (Exception e3) {
            e3.printStackTrace();
            packageInfoF2 = null;
        }
        return strReplaceAll + '_' + (packageInfoF2 != null ? packageInfoF2.versionName : null);
    }

    public OutputStream g(Object obj) throws Exception {
        if (obj instanceof File) {
            return new FileOutputStream((File) obj);
        }
        if (!(obj instanceof DocumentFile)) {
            throw new Exception("getOutputStream: Illegal parameter type");
        }
        DocumentFile documentFile = (DocumentFile) obj;
        if (documentFile.getName() == null) {
            throw new Exception("getOutputStream: DocumentFile name is null");
        }
        ContentResolver contentResolver = ((l4.a4) this.f1231c).getContentResolver();
        OutputStream outputStreamOpenOutputStream = contentResolver != null ? contentResolver.openOutputStream(documentFile.getUri()) : null;
        outputStreamOpenOutputStream.getClass();
        return outputStreamOpenOutputStream;
    }

    public synchronized void h() {
        try {
            if (this.f1229a) {
                return;
            }
            Boolean boolK = k();
            this.f1231c = boolK;
            if (boolK == null) {
                p8.u uVar = new p8.u(22);
                q1.k kVar = (q1.k) ((n2.c) this.f1230b);
                kVar.a(kVar.f12240c, uVar);
            }
            this.f1229a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean i() {
        Boolean bool;
        try {
            h();
            bool = (Boolean) this.f1231c;
        } catch (Throwable th) {
            throw th;
        }
        return bool != null ? bool.booleanValue() : ((FirebaseMessaging) this.f1232d).f2433a.h();
    }

    public z8.f0 j(int i10) {
        z8.b bVar;
        synchronized (((r8.f) this.f1232d)) {
            try {
                if (this.f1229a) {
                    throw new IllegalStateException();
                }
                r8.d dVar = (r8.d) this.f1230b;
                if (dVar.f != this) {
                    return new z8.e();
                }
                int i11 = 1;
                if (!dVar.e) {
                    ((boolean[]) this.f1231c)[i10] = true;
                }
                File file = dVar.f12470d[i10];
                try {
                    ((r8.f) this.f1232d).f12476a.getClass();
                    try {
                        Logger logger = z8.y.f14516a;
                        file.getClass();
                        bVar = new z8.b(i11, new FileOutputStream(file, false), new z8.j0());
                    } catch (FileNotFoundException unused) {
                        file.getParentFile().mkdirs();
                        Logger logger2 = z8.y.f14516a;
                        bVar = new z8.b(i11, new FileOutputStream(file, false), new z8.j0());
                    }
                    return new r8.c(this, bVar, i11);
                } catch (FileNotFoundException unused2) {
                    return new z8.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Boolean k() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        l1.g gVar = ((FirebaseMessaging) this.f1232d).f2433a;
        gVar.a();
        Context context = gVar.f10177a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public boolean l(String str, String str2) {
        synchronized (this) {
            try {
                if (!((y1.e) ((AtomicMarkableReference) this.f1230b).getReference()).c(str, str2)) {
                    return false;
                }
                AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) this.f1230b;
                atomicMarkableReference.set((y1.e) atomicMarkableReference.getReference(), true);
                androidx.constraintlayout.helper.widget.a aVar = new androidx.constraintlayout.helper.widget.a(this, 15);
                AtomicReference atomicReference = (AtomicReference) this.f1231c;
                while (!atomicReference.compareAndSet(null, aVar)) {
                    if (atomicReference.get() != null) {
                        return true;
                    }
                }
                ((x1.e) ((c2.d) this.f1232d).f1643d).f13577b.a(aVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01bb, code lost:
    
        r9 = r11;
        r3 = r18;
        r11 = r19;
        r17 = r26;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0153 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018f A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x021e A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0248 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024c A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:13:0x0053, B:62:0x020e, B:49:0x018f, B:51:0x01a2, B:57:0x01bd, B:63:0x021e, B:46:0x0153, B:64:0x0248, B:20:0x0088, B:44:0x0148, B:25:0x0098, B:27:0x00a2, B:29:0x00b5, B:40:0x0109, B:65:0x024c, B:66:0x0253, B:31:0x00e0, B:33:0x00e4, B:35:0x00ee, B:36:0x00fd, B:37:0x0104), top: B:70:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0153 -> B:47:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0202 -> B:61:0x0207). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(java.util.ArrayList r26, java.util.ArrayList r27, java.lang.String r28, long r29, y6.c r31) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.g1.m(java.util.ArrayList, java.util.ArrayList, java.lang.String, long, y6.c):java.lang.Object");
    }

    public String n() {
        if (!this.f1229a) {
            this.f1229a = true;
            h1 h1Var = (h1) this.f1232d;
            this.f1231c = h1Var.k().getString((String) this.f1230b, null);
        }
        return (String) this.f1231c;
    }

    public void o(String str) {
        SharedPreferences.Editor editorEdit = ((h1) this.f1232d).k().edit();
        editorEdit.putString((String) this.f1230b, str);
        editorEdit.apply();
        this.f1231c = str;
    }

    public g1(h1 h1Var, String str) {
        this.f1232d = h1Var;
        i0.y.d(str);
        this.f1230b = str;
    }

    public g1(l4.a4 a4Var, d0.i iVar) {
        this.f1231c = a4Var;
        this.f1232d = iVar;
    }

    public g1(c2.d dVar, boolean z9) {
        this.f1232d = dVar;
        this.f1231c = new AtomicReference(null);
        this.f1229a = z9;
        this.f1230b = new AtomicMarkableReference(new y1.e(z9 ? 8192 : 1024), false);
    }

    public g1(FirebaseMessaging firebaseMessaging, n2.c cVar) {
        this.f1232d = firebaseMessaging;
        this.f1230b = cVar;
    }

    public g1(r8.f fVar, r8.d dVar) {
        this.f1232d = fVar;
        this.f1230b = dVar;
        this.f1231c = dVar.e ? null : new boolean[fVar.h];
    }
}
