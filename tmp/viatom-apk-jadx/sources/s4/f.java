package s4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.Iterator;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12564a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f12565b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(n nVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12564a = i10;
        this.f12565b = nVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12564a) {
            case 0:
                return new f(this.f12565b, cVar, 0);
            case 1:
                return new f(this.f12565b, cVar, 1);
            case 2:
                return new f(this.f12565b, cVar, 2);
            default:
                return new f(this.f12565b, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12564a) {
        }
        return ((f) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f12564a) {
            case 0:
                s6.a.e(obj);
                Iterator it = this.f12565b.f12594a.iterator();
                it.getClass();
                long jH = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    jH += next instanceof File ? n.h((File) next) : next instanceof DocumentFile ? n.g((DocumentFile) next) : 0L;
                }
                return new Long(jH);
            case 1:
                s6.a.e(obj);
                t4.a aVar = this.f12565b.f12596c;
                if (aVar == null) {
                    return null;
                }
                aVar.L();
                return s6.w.f12711a;
            case 2:
                s6.a.e(obj);
                if (this.f12565b.f12596c != null) {
                    return s6.w.f12711a;
                }
                return null;
            default:
                s6.a.e(obj);
                if (this.f12565b.f12596c != null) {
                    return s6.w.f12711a;
                }
                return null;
        }
    }
}
