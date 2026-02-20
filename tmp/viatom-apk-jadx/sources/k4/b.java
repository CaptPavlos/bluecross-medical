package k4;

import g7.p;
import kotlin.jvm.internal.x;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10049a = 1;

    /* renamed from: b, reason: collision with root package name */
    public x f10050b;

    /* renamed from: c, reason: collision with root package name */
    public int f10051c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10052d;
    public final /* synthetic */ boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(x xVar, String str, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f10050b = xVar;
        this.f10052d = str;
        this.e = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10049a) {
            case 0:
                return new b(this.f10050b, this.f10052d, this.e, cVar);
            default:
                return new b(this.f10052d, this.e, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10049a) {
        }
        return ((b) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ed, code lost:
    
        if (r4 == r5) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[PHI: r1
      0x005e: PHI (r1v55 kotlin.jvm.internal.x) = 
      (r1v53 kotlin.jvm.internal.x)
      (r1v53 kotlin.jvm.internal.x)
      (r1v54 kotlin.jvm.internal.x)
      (r1v58 kotlin.jvm.internal.x)
     binds: [B:14:0x003e, B:16:0x0042, B:21:0x005b, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f10052d = str;
        this.e = z9;
    }
}
