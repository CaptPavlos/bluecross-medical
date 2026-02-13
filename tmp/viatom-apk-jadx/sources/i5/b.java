package i5;

import android.content.BroadcastReceiver;
import c1.e5;
import g7.p;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9016a;

    /* renamed from: b, reason: collision with root package name */
    public int f9017b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e5 f9018c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f9019d;
    public final /* synthetic */ BroadcastReceiver.PendingResult e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(e5 e5Var, String str, BroadcastReceiver.PendingResult pendingResult, w6.c cVar, int i10) {
        super(2, cVar);
        this.f9016a = i10;
        this.f9018c = e5Var;
        this.f9019d = str;
        this.e = pendingResult;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f9016a) {
            case 0:
                return new b(this.f9018c, this.f9019d, this.e, cVar, 0);
            default:
                return new b(this.f9018c, this.f9019d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f9016a) {
        }
        return ((b) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0174, code lost:
    
        if (r7.y.z(r0, r13, r12) == r3) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
