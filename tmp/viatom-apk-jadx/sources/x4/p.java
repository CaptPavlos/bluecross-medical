package x4;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public DocumentFile[] f13651a;

    /* renamed from: b, reason: collision with root package name */
    public int f13652b;

    /* renamed from: c, reason: collision with root package name */
    public int f13653c;

    /* renamed from: d, reason: collision with root package name */
    public int f13654d;
    public final /* synthetic */ DocumentFile e;
    public final /* synthetic */ ZipOutputStream f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ y h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(DocumentFile documentFile, ZipOutputStream zipOutputStream, Context context, y yVar, w6.c cVar) {
        super(2, cVar);
        this.e = documentFile;
        this.f = zipOutputStream;
        this.g = context;
        this.h = yVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new p(this.e, this.f, this.g, this.h, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x009f -> B:37:0x00a0). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            x4.y r4 = r11.h
            byte[] r0 = r4.f13698a
            int r1 = r11.f13654d
            s6.w r6 = s6.w.f12711a
            r2 = 0
            android.content.Context r3 = r11.g
            r7 = 1
            r5 = r2
            java.util.zip.ZipOutputStream r2 = r11.f
            if (r1 == 0) goto L26
            if (r1 != r7) goto L20
            int r0 = r11.f13653c
            int r1 = r11.f13652b
            androidx.documentfile.provider.DocumentFile[] r5 = r11.f13651a
            s6.a.e(r12)
            r12 = r0
            r9 = r5
            goto La0
        L20:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r12)
            return r5
        L26:
            s6.a.e(r12)
            androidx.documentfile.provider.DocumentFile r12 = r11.e
            boolean r1 = r12.isFile()
            r8 = 0
            if (r1 == 0) goto L69
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry
            java.lang.String r4 = r12.getName()
            r1.<init>(r4)
            r2.putNextEntry(r1)
            android.content.ContentResolver r1 = r3.getContentResolver()
            if (r1 == 0) goto L4d
            android.net.Uri r12 = r12.getUri()
            java.io.InputStream r12 = r1.openInputStream(r12)
            goto L4e
        L4d:
            r12 = r5
        L4e:
            if (r12 == 0) goto L62
        L50:
            int r1 = r12.read(r0)     // Catch: java.lang.Throwable -> L5a
            if (r1 <= 0) goto L62
            r2.write(r0, r8, r1)     // Catch: java.lang.Throwable -> L5a
            goto L50
        L5a:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch: java.lang.Throwable -> L5d
        L5d:
            r0 = move-exception
            com.google.android.gms.internal.measurement.a4.j(r12, r1)
            throw r0
        L62:
            com.google.android.gms.internal.measurement.a4.j(r12, r5)
            r2.closeEntry()
            goto La3
        L69:
            boolean r0 = r12.isDirectory()
            if (r0 == 0) goto La3
            androidx.documentfile.provider.DocumentFile[] r12 = r12.listFiles()
            r12.getClass()
            int r0 = r12.length
            r9 = r12
            r12 = r0
        L79:
            if (r8 >= r12) goto La3
            r1 = r9[r8]
            r1.getClass()
            r11.f13651a = r9
            r11.f13652b = r8
            r11.f13653c = r12
            r11.f13654d = r7
            y7.e r0 = r7.i0.f12407a
            y7.d r10 = y7.d.f14116a
            x4.p r0 = new x4.p
            r5 = 0
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Object r0 = r7.y.z(r0, r10, r11)
            x6.a r1 = x6.a.f13718a
            if (r0 != r1) goto L9b
            goto L9c
        L9b:
            r0 = r6
        L9c:
            if (r0 != r1) goto L9f
            return r1
        L9f:
            r1 = r8
        La0:
            int r8 = r1 + 1
            goto L79
        La3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.p.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
