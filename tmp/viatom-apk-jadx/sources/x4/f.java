package x4;

import com.google.android.gms.internal.measurement.j4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13606a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j4 f13607b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f13608c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(j4 j4Var, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13606a = i10;
        this.f13607b = j4Var;
        this.f13608c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13606a) {
            case 0:
                return new f(this.f13607b, this.f13608c, cVar, 0);
            default:
                return new f(this.f13607b, this.f13608c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13606a) {
        }
        return ((f) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13606a) {
            case 0:
                s6.a.e(obj);
                t4.b bVar = (t4.b) this.f13607b.f2009c;
                if (bVar != null) {
                    bVar.k(this.f13608c);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.b bVar2 = (t4.b) this.f13607b.f2009c;
                if (bVar2 != null) {
                    bVar2.k(this.f13608c);
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }
}
