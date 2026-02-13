package p4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11980a;

    /* renamed from: b, reason: collision with root package name */
    public int f11981b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11982c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f11983d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(FileExplorerActivity fileExplorerActivity, String str, String str2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11980a = i10;
        this.f11982c = fileExplorerActivity;
        this.f11983d = str;
        this.e = str2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11980a) {
            case 0:
                return new k(this.f11982c, this.f11983d, this.e, cVar, 0);
            default:
                return new k(this.f11982c, this.f11983d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11980a) {
        }
        return ((k) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c3  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
