package s5;

import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12618a;

    /* renamed from: b, reason: collision with root package name */
    public int f12619b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f12620c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(TvAppDetailFragment tvAppDetailFragment, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12618a = i10;
        this.f12620c = tvAppDetailFragment;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12618a) {
            case 0:
                return new d(this.f12620c, cVar, 0);
            case 1:
                return new d(this.f12620c, cVar, 1);
            case 2:
                return new d(this.f12620c, cVar, 2);
            case 3:
                return new d(this.f12620c, cVar, 3);
            case 4:
                return new d(this.f12620c, cVar, 4);
            default:
                return new d(this.f12620c, cVar, 5);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12618a) {
        }
        return ((d) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
