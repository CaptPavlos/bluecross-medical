package b9;

import com.uptodown.activities.PreregistrationActivity;
import l4.i6;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f932a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f933b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f934c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f935d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String str, d dVar, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f935d = str;
        this.e = dVar;
        this.f934c = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f932a) {
            case 0:
                return new r((String) this.f935d, (d) this.e, this.f934c, cVar);
            default:
                return new r((i6) this.f935d, this.f934c, (PreregistrationActivity) this.e, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f932a) {
        }
        return ((r) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i6 i6Var, boolean z9, PreregistrationActivity preregistrationActivity, w6.c cVar) {
        super(2, cVar);
        this.f935d = i6Var;
        this.f934c = z9;
        this.e = preregistrationActivity;
    }
}
