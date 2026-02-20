package s4;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import o7.u;
import r7.i0;
import r7.y;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12594a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12595b;

    /* renamed from: c, reason: collision with root package name */
    public final t4.a f12596c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12597d;
    public final Context e;
    public long f;
    public long g;
    public int h;

    public n(ArrayList arrayList, Object obj, t4.a aVar, boolean z9, Context context) {
        arrayList.getClass();
        obj.getClass();
        context.getClass();
        this.f12594a = arrayList;
        this.f12595b = obj;
        this.f12596c = aVar;
        this.f12597d = z9;
        this.e = context;
        y7.e eVar = i0.f12407a;
        y.q(y.a(y7.d.f14116a), null, null, new p4.i0(this, null, 3), 3);
    }

    public static DocumentFile e(DocumentFile documentFile, DocumentFile documentFile2) throws Exception {
        if (documentFile.isDirectory()) {
            throw new Exception("Trying copying a directory into a file");
        }
        if (documentFile.getName() == null) {
            throw new Exception("Source name unknown");
        }
        if (documentFile.getType() == null) {
            throw new Exception("Source mimetype unknown");
        }
        String type = documentFile.getType();
        type.getClass();
        String name = documentFile.getName();
        name.getClass();
        String name2 = documentFile.getName();
        name2.getClass();
        if (u.X(name2, ".xapk", false)) {
            type = "application/vnd.android.package-archive";
        } else if (o7.m.d0(name, ".", false)) {
            name = name.substring(0, o7.m.m0(".", name, 6));
        }
        return documentFile2.createFile(type, name);
    }

    public static void f(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            int i10 = 0;
            while (true) {
                if (!(i10 < fileArrListFiles.length)) {
                    break;
                }
                int i11 = i10 + 1;
                try {
                    File file2 = fileArrListFiles[i10];
                    file2.getClass();
                    f(file2);
                    i10 = i11;
                } catch (ArrayIndexOutOfBoundsException e) {
                    com.google.gson.internal.a.o(e.getMessage());
                    return;
                }
            }
        }
        file.delete();
    }

    public static long g(DocumentFile documentFile) {
        if (documentFile.isFile()) {
            return documentFile.length();
        }
        long jG = 0;
        if (documentFile.isDirectory()) {
            DocumentFile[] documentFileArrListFiles = documentFile.listFiles();
            documentFileArrListFiles.getClass();
            for (DocumentFile documentFile2 : documentFileArrListFiles) {
                documentFile2.getClass();
                jG += g(documentFile2);
            }
        }
        return jG;
    }

    public static long h(File file) {
        File[] fileArrListFiles;
        if (file.isFile()) {
            return file.length();
        }
        long jH = 0;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            int i10 = 0;
            while (true) {
                if (!(i10 < fileArrListFiles.length)) {
                    break;
                }
                int i11 = i10 + 1;
                try {
                    File file2 = fileArrListFiles[i10];
                    file2.getClass();
                    jH += h(file2);
                    i10 = i11;
                } catch (ArrayIndexOutOfBoundsException e) {
                    com.google.gson.internal.a.o(e.getMessage());
                    return 0L;
                }
            }
        }
        return jH;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ab -> B:39:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(androidx.documentfile.provider.DocumentFile r9, androidx.documentfile.provider.DocumentFile r10, y6.c r11) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.n.a(androidx.documentfile.provider.DocumentFile, androidx.documentfile.provider.DocumentFile, y6.c):java.lang.Object");
    }

    public final Object b(InputStream inputStream, OutputStream outputStream, String str, y6.c cVar) throws Throwable {
        y7.e eVar = i0.f12407a;
        Object objZ = y.z(new j(this, inputStream, outputStream, str, null), y7.d.f14116a, cVar);
        return objZ == x6.a.f13718a ? objZ : w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x010f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.io.File r16, androidx.documentfile.provider.DocumentFile r17, y6.c r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.n.c(java.io.File, androidx.documentfile.provider.DocumentFile, y6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.io.File r10, java.io.File r11, y6.c r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.n.d(java.io.File, java.io.File, y6.c):java.lang.Object");
    }
}
