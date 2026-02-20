package s4;

import java.io.File;
import kotlin.jvm.internal.x;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12587a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f12588b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f12589c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(n nVar, x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12587a = i10;
        this.f12588b = nVar;
        this.f12589c = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12587a) {
            case 0:
                return new l(this.f12588b, this.f12589c, cVar, 0);
            default:
                return new l(this.f12588b, this.f12589c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12587a) {
        }
        return ((l) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12587a) {
            case 0:
                s6.a.e(obj);
                t4.a aVar = this.f12588b.f12596c;
                if (aVar != null) {
                    aVar.D((File) this.f12589c.f10138a);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.a aVar2 = this.f12588b.f12596c;
                if (aVar2 != null) {
                    aVar2.t((File) this.f12589c.f10138a);
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }
}
