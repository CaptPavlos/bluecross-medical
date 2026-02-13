package i5;

import com.uptodown.activities.MyApps;
import g7.p;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9027a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f9028b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(MyApps myApps, w6.c cVar, int i10) {
        super(2, cVar);
        this.f9027a = i10;
        this.f9028b = myApps;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f9027a) {
            case 0:
                return new h(this.f9028b, cVar, 0);
            default:
                return new h(this.f9028b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f9027a) {
            case 0:
                h hVar = (h) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                h hVar2 = (h) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                hVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f9027a;
        s6.w wVar = s6.w.f12711a;
        MyApps myApps = this.f9028b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                myApps.G0(false);
                break;
            default:
                s6.a.e(obj);
                int i11 = MyApps.f6655j0;
                myApps.E0().f6844c.setVisibility(0);
                break;
        }
        return wVar;
    }
}
