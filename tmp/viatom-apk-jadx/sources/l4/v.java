package l4;

import com.uptodown.activities.MyDownloads;
import java.io.File;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10894a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10895b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10896c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10897d;
    public Serializable e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, String str, File file, String str2, boolean z9, h5.q qVar, w6.c cVar) {
        super(2, cVar);
        this.f10897d = wVar;
        this.e = str;
        this.g = file;
        this.f = str2;
        this.f10896c = z9;
        this.h = qVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10894a) {
            case 0:
                return new v((w) this.f10897d, (String) this.e, (File) this.g, (String) this.f, this.f10896c, (h5.q) this.h, cVar);
            default:
                return new v(this.f10896c, (q4) this.f, (MyDownloads) this.g, (p4) this.h, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10894a) {
        }
        return ((v) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0300  */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v34, types: [java.lang.Object, r7.x, w6.c] */
    /* JADX WARN: Type inference failed for: r14v38 */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.v.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(boolean z9, q4 q4Var, MyDownloads myDownloads, p4 p4Var, w6.c cVar) {
        super(2, cVar);
        this.f10896c = z9;
        this.f = q4Var;
        this.g = myDownloads;
        this.h = p4Var;
    }
}
