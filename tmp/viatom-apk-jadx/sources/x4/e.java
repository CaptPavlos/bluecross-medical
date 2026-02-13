package x4;

import com.google.android.gms.internal.measurement.j4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13604a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j4 f13605b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(j4 j4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13604a = i10;
        this.f13605b = j4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13604a) {
            case 0:
                return new e(this.f13605b, cVar, 0);
            case 1:
                return new e(this.f13605b, cVar, 1);
            case 2:
                return new e(this.f13605b, cVar, 2);
            case 3:
                return new e(this.f13605b, cVar, 3);
            case 4:
                return new e(this.f13605b, cVar, 4);
            case 5:
                return new e(this.f13605b, cVar, 5);
            default:
                return new e(this.f13605b, cVar, 6);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13604a) {
        }
        return ((e) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13604a) {
            case 0:
                s6.a.e(obj);
                t4.b bVar = (t4.b) this.f13605b.f2009c;
                if (bVar != null) {
                    bVar.k("noEnoughSpace");
                    break;
                }
                break;
            case 1:
                s6.a.e(obj);
                t4.b bVar2 = (t4.b) this.f13605b.f2009c;
                if (bVar2 != null) {
                    bVar2.k("fileNotFoundException");
                    break;
                }
                break;
            case 2:
                s6.a.e(obj);
                t4.b bVar3 = (t4.b) this.f13605b.f2009c;
                if (bVar3 != null) {
                    bVar3.k("securityException");
                    break;
                }
                break;
            case 3:
                s6.a.e(obj);
                t4.b bVar4 = (t4.b) this.f13605b.f2009c;
                if (bVar4 != null) {
                    bVar4.k("fileNotFoundException");
                    break;
                }
                break;
            case 4:
                s6.a.e(obj);
                t4.b bVar5 = (t4.b) this.f13605b.f2009c;
                if (bVar5 != null) {
                    bVar5.k("securityException");
                    break;
                }
                break;
            case 5:
                s6.a.e(obj);
                t4.b bVar6 = (t4.b) this.f13605b.f2009c;
                if (bVar6 != null) {
                    bVar6.i();
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.b bVar7 = (t4.b) this.f13605b.f2009c;
                if (bVar7 != null) {
                    bVar7.i();
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }
}
