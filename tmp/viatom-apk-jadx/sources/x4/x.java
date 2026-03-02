package x4;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import java.io.Serializable;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13688a = 1;

    /* renamed from: b, reason: collision with root package name */
    public ZipInputStream f13689b;

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.v f13690c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.w f13691d;
    public long e;
    public int f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ DocumentFile h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d5.j f13692i;

    /* renamed from: j, reason: collision with root package name */
    public Serializable f13693j;

    /* renamed from: k, reason: collision with root package name */
    public Object f13694k;

    /* renamed from: l, reason: collision with root package name */
    public Object f13695l;

    /* renamed from: m, reason: collision with root package name */
    public Serializable f13696m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f13697n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, Context context, DocumentFile documentFile, y yVar, d5.j jVar, w6.c cVar) {
        super(2, cVar);
        this.f13696m = str;
        this.g = context;
        this.h = documentFile;
        this.f13697n = yVar;
        this.f13692i = jVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13688a) {
            case 0:
                return new x((String) this.f13696m, this.g, this.h, (y) this.f13697n, this.f13692i, cVar);
            default:
                return new x(this.g, this.h, (Uri) this.f13697n, this.f13692i, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13688a) {
        }
        return ((x) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x02fd, code lost:
    
        if (r7.y.z(r3, r2, r25) == r15) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x034d, code lost:
    
        if (r7.y.z(r2, r1, r25) == r15) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03db, code lost:
    
        if (r7.y.z(r6, r5, r25) == r8) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0468, code lost:
    
        if (r7.y.z(r13, r12, r25) == r8) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04a5, code lost:
    
        if (r7.y.z(r2, r1, r25) == r8) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0319, code lost:
    
        r15 = r8;
        r19 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        if (r7.y.z(r4, r1, r25) == r8) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARN: Type inference failed for: r19v1, types: [androidx.documentfile.provider.DocumentFile] */
    /* JADX WARN: Type inference failed for: r9v13, types: [androidx.documentfile.provider.DocumentFile[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x02a6 -> B:115:0x02b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x02fd -> B:122:0x0300). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0302 -> B:124:0x0306). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x0402 -> B:172:0x047b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0417 -> B:162:0x0428). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x0468 -> B:170:0x046d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x046b -> B:170:0x046d). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, DocumentFile documentFile, Uri uri, d5.j jVar, w6.c cVar) {
        super(2, cVar);
        this.g = context;
        this.h = documentFile;
        this.f13697n = uri;
        this.f13692i = jVar;
    }
}
