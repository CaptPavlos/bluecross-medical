package x4;

import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13632a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t4.d f13633b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f13634c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(t4.d dVar, kotlin.jvm.internal.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13632a = i10;
        this.f13633b = dVar;
        this.f13634c = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13632a) {
            case 0:
                return new n(this.f13633b, this.f13634c, cVar, 0);
            default:
                return new n(this.f13633b, this.f13634c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13632a) {
        }
        return ((n) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13632a) {
            case 0:
                s6.a.e(obj);
                t4.d dVar = this.f13633b;
                if (dVar != null) {
                    dVar.f((File) this.f13634c.f10138a);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.d dVar2 = this.f13633b;
                if (dVar2 != null) {
                    dVar2.e((File) this.f13634c.f10138a);
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }
}
