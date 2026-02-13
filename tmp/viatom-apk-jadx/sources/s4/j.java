package s4;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.v;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f12577a;

    /* renamed from: b, reason: collision with root package name */
    public v f12578b;

    /* renamed from: c, reason: collision with root package name */
    public int f12579c;

    /* renamed from: d, reason: collision with root package name */
    public long f12580d;
    public long e;
    public int f;
    public final /* synthetic */ n g;
    public final /* synthetic */ InputStream h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ OutputStream f12581i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f12582j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n nVar, InputStream inputStream, OutputStream outputStream, String str, w6.c cVar) {
        super(2, cVar);
        this.g = nVar;
        this.h = inputStream;
        this.f12581i = outputStream;
        this.f12582j = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new j(this.g, this.h, this.f12581i, this.f12582j, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Path cross not found for [B:36:0x0099, B:38:0x009f], limit reached: 77 */
    /* JADX WARN: Path cross not found for [B:38:0x009f, B:36:0x0099], limit reached: 77 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #3 {all -> 0x0027, blocks: (B:6:0x0019, B:14:0x0047, B:16:0x004f, B:13:0x0038), top: B:63:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[Catch: all -> 0x008d, TRY_ENTER, TryCatch #5 {all -> 0x008d, blocks: (B:18:0x005d, B:20:0x0066, B:24:0x0075, B:26:0x0079, B:33:0x008f, B:36:0x0099, B:39:0x00a2), top: B:67:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb A[SYNTHETIC] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
