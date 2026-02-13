package x4;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public ZipInputStream f13678a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.x f13679b;

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.internal.v f13680c;

    /* renamed from: d, reason: collision with root package name */
    public kotlin.jvm.internal.w f13681d;
    public OutputStream e;
    public byte[] f;
    public kotlin.jvm.internal.v g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public long f13682i;

    /* renamed from: j, reason: collision with root package name */
    public int f13683j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ File f13684k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Uri f13685l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f13686m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d5.j f13687n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(File file, Uri uri, Context context, d5.j jVar, w6.c cVar) {
        super(2, cVar);
        this.f13684k = file;
        this.f13685l = uri;
        this.f13686m = context;
        this.f13687n = jVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new w(this.f13684k, this.f13685l, this.f13686m, this.f13687n, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((w) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        if (r7.y.z(r2, r1, r22) == r13) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a4  */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [byte[], java.io.OutputStream, kotlin.jvm.internal.v, w6.c] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x013f -> B:94:0x0298). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x020a -> B:82:0x021e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x026f -> B:90:0x0270). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x0274 -> B:92:0x027c). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
