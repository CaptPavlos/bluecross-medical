package x4;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f13670a;

    /* renamed from: b, reason: collision with root package name */
    public ZipInputStream f13671b;

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.v f13672c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13673d;
    public FileOutputStream e;
    public kotlin.jvm.internal.v f;
    public long g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f13674i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ File f13675j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ y f13676k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d5.j f13677l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String str, File file, y yVar, d5.j jVar, w6.c cVar) {
        super(2, cVar);
        this.f13674i = str;
        this.f13675j = file;
        this.f13676k = yVar;
        this.f13677l = jVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new v(this.f13674i, this.f13675j, this.f13676k, this.f13677l, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x017e, code lost:
    
        if (r7.y.z(r3, r0, r20) == r9) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: all -> 0x0023, IOException -> 0x0185, EOFException -> 0x0189, TryCatch #2 {all -> 0x0023, blocks: (B:8:0x001e, B:60:0x0185, B:61:0x0189, B:53:0x0144, B:43:0x00ed, B:45:0x00f5, B:47:0x010a, B:54:0x014e, B:55:0x0155, B:34:0x00af, B:36:0x00c3, B:37:0x00c9, B:39:0x00cf, B:41:0x00d5, B:42:0x00d8, B:56:0x0161, B:32:0x00a8, B:29:0x0089), top: B:69:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: all -> 0x0023, IOException -> 0x0185, EOFException -> 0x0189, TryCatch #2 {all -> 0x0023, blocks: (B:8:0x001e, B:60:0x0185, B:61:0x0189, B:53:0x0144, B:43:0x00ed, B:45:0x00f5, B:47:0x010a, B:54:0x014e, B:55:0x0155, B:34:0x00af, B:36:0x00c3, B:37:0x00c9, B:39:0x00cf, B:41:0x00d5, B:42:0x00d8, B:56:0x0161, B:32:0x00a8, B:29:0x0089), top: B:69:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014e A[Catch: all -> 0x0023, IOException -> 0x0185, EOFException -> 0x0189, TryCatch #2 {all -> 0x0023, blocks: (B:8:0x001e, B:60:0x0185, B:61:0x0189, B:53:0x0144, B:43:0x00ed, B:45:0x00f5, B:47:0x010a, B:54:0x014e, B:55:0x0155, B:34:0x00af, B:36:0x00c3, B:37:0x00c9, B:39:0x00cf, B:41:0x00d5, B:42:0x00d8, B:56:0x0161, B:32:0x00a8, B:29:0x0089), top: B:69:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161 A[Catch: all -> 0x0023, IOException -> 0x0185, EOFException -> 0x0189, TRY_LEAVE, TryCatch #2 {all -> 0x0023, blocks: (B:8:0x001e, B:60:0x0185, B:61:0x0189, B:53:0x0144, B:43:0x00ed, B:45:0x00f5, B:47:0x010a, B:54:0x014e, B:55:0x0155, B:34:0x00af, B:36:0x00c3, B:37:0x00c9, B:39:0x00cf, B:41:0x00d5, B:42:0x00d8, B:56:0x0161, B:32:0x00a8, B:29:0x0089), top: B:69:0x0011 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c3 -> B:55:0x0155). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d8 -> B:43:0x00ed). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0132 -> B:51:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0140 -> B:53:0x0144). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.v.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
