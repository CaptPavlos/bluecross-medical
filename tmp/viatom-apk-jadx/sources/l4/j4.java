package l4;

import com.uptodown.activities.MyDownloads;
import com.uptodown.workers.DownloadWorker;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j4 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f10519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10520b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4(MyDownloads myDownloads, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f10519a = myDownloads;
        this.f10520b = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new j4(this.f10519a, this.f10520b, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        j4 j4Var = (j4) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        j4Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        s6.a.e(obj);
        MyDownloads myDownloads = this.f10519a;
        n4.b bVar = myDownloads.J;
        if (bVar != null && bVar.f11300b.size() > 0) {
            n4.b bVar2 = myDownloads.J;
            if (this.f10520b) {
                bVar2.getClass();
                Iterator it = bVar2.f11300b.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    n4.b bVar3 = myDownloads.J;
                    bVar3.getClass();
                    myDownloads.o0(bVar3.f11300b.indexOf((h5.q) next));
                }
            } else {
                bVar2.getClass();
                Iterator it2 = bVar2.f11300b.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    h5.q qVar = (h5.q) next2;
                    if (!qVar.m()) {
                        long j10 = qVar.h;
                        long j11 = qVar.e;
                        h5.q qVar2 = DownloadWorker.f6738d;
                        if (qVar2 != null && qVar2.h == j10) {
                            qVar2.getClass();
                            if (qVar2.e == j11) {
                            }
                        }
                        n4.b bVar4 = myDownloads.J;
                        bVar4.getClass();
                        myDownloads.o0(bVar4.f11300b.indexOf(qVar));
                    }
                }
            }
            myDownloads.u0();
            myDownloads.r0(false);
        }
        return s6.w.f12711a;
    }
}
