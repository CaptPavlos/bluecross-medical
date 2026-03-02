package l4;

import android.content.res.Resources;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j3 implements g5.b, g5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10517a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f10518b;

    public /* synthetic */ j3(MyApps myApps, int i10) {
        this.f10517a = i10;
        this.f10518b = myApps;
    }

    @Override // g5.b, g5.p
    public final void a(int i10) throws Resources.NotFoundException {
        int i11 = this.f10517a;
        MyApps myApps = this.f10518b;
        switch (i11) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    if (!MyApps.C0(myApps, i10)) {
                        if (MyApps.D0(myApps, i10)) {
                            n4.p pVar = myApps.W;
                            pVar.getClass();
                            Object obj = pVar.f11451d.get(i10);
                            obj.getClass();
                            myApps.p0(((n4.u0) obj).f11493a, i10);
                            break;
                        }
                    } else {
                        n4.p pVar2 = myApps.W;
                        pVar2.getClass();
                        Object obj2 = pVar2.f11451d.get(i10);
                        obj2.getClass();
                        myApps.p0((h5.f) obj2, i10);
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    if (!MyApps.C0(myApps, i10)) {
                        if (MyApps.D0(myApps, i10)) {
                            n4.p pVar3 = myApps.W;
                            pVar3.getClass();
                            Object obj3 = pVar3.f11451d.get(i10);
                            obj3.getClass();
                            myApps.p0(((n4.u0) obj3).f11493a, i10);
                            break;
                        }
                    } else {
                        n4.p pVar4 = myApps.W;
                        pVar4.getClass();
                        Object obj4 = pVar4.f11451d.get(i10);
                        obj4.getClass();
                        myApps.p0((h5.f) obj4, i10);
                        break;
                    }
                }
                break;
        }
    }

    @Override // g5.p
    public void b(int i10) {
        MyApps myApps = this.f10518b;
        if (MyApps.C0(myApps, i10)) {
            n4.p pVar = myApps.W;
            pVar.getClass();
            Object obj = pVar.f11451d.get(i10);
            obj.getClass();
            ((h5.f) obj).f8540v = true;
            n4.p pVar2 = myApps.W;
            pVar2.getClass();
            pVar2.notifyItemChanged(i10);
            return;
        }
        if (MyApps.D0(myApps, i10)) {
            n4.p pVar3 = myApps.W;
            pVar3.getClass();
            Object obj2 = pVar3.f11451d.get(i10);
            obj2.getClass();
            ((n4.u0) obj2).f11493a.f8540v = true;
            n4.p pVar4 = myApps.W;
            pVar4.getClass();
            pVar4.notifyItemChanged(i10);
        }
    }

    @Override // g5.p
    public void c(int i10) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            MyApps myApps = this.f10518b;
            if (!MyApps.C0(myApps, i10)) {
                if (MyApps.D0(myApps, i10)) {
                    n4.p pVar = myApps.W;
                    pVar.getClass();
                    Object obj = pVar.f11451d.get(i10);
                    obj.getClass();
                    myApps.w0(((n4.u0) obj).f11493a);
                    return;
                }
                return;
            }
            n4.p pVar2 = myApps.W;
            pVar2.getClass();
            Object obj2 = pVar2.f11451d.get(i10);
            obj2.getClass();
            h5.f fVar = (h5.f) obj2;
            if (fVar.g == h5.e.f8506a) {
                myApps.w0(fVar);
            }
        }
    }

    @Override // g5.b, g5.p
    public final void d(int i10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i11 = this.f10517a;
        MyApps myApps = this.f10518b;
        h5.f fVar = null;
        switch (i11) {
            case 0:
                float f = UptodownApp.E;
                if (k4.c.s()) {
                    if (MyApps.C0(myApps, i10)) {
                        n4.p pVar = myApps.W;
                        pVar.getClass();
                        Object obj = pVar.f11451d.get(i10);
                        obj.getClass();
                        fVar = (h5.f) obj;
                    } else if (MyApps.D0(myApps, i10)) {
                        n4.p pVar2 = myApps.W;
                        pVar2.getClass();
                        Object obj2 = pVar2.f11451d.get(i10);
                        obj2.getClass();
                        fVar = ((n4.u0) obj2).f11493a;
                    }
                    if (fVar != null) {
                        long j10 = fVar.f8541w;
                        if (j10 > 0) {
                            myApps.Y(j10);
                            break;
                        }
                    }
                }
                break;
            default:
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    n4.p pVar3 = myApps.W;
                    boolean z9 = ((pVar3 == null || (arrayList2 = pVar3.f11451d) == null) ? null : arrayList2.get(i10)) instanceof n4.u0;
                    n4.p pVar4 = myApps.W;
                    if (z9) {
                        pVar4.getClass();
                        Object obj3 = pVar4.f11451d.get(i10);
                        obj3.getClass();
                        fVar = ((n4.u0) obj3).f11493a;
                    } else {
                        if (((pVar4 == null || (arrayList = pVar4.f11451d) == null) ? null : arrayList.get(i10)) instanceof h5.f) {
                            n4.p pVar5 = myApps.W;
                            pVar5.getClass();
                            Object obj4 = pVar5.f11451d.get(i10);
                            obj4.getClass();
                            fVar = (h5.f) obj4;
                        }
                    }
                    if (fVar != null) {
                        long j11 = fVar.f8541w;
                        if (j11 > 0) {
                            myApps.Y(j11);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // g5.p
    public void e(int i10) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            MyApps myApps = this.f10518b;
            if (MyApps.C0(myApps, i10)) {
                n4.p pVar = myApps.W;
                pVar.getClass();
                Object obj = pVar.f11451d.get(i10);
                obj.getClass();
                myApps.v0((h5.f) obj);
            } else if (MyApps.D0(myApps, i10)) {
                n4.p pVar2 = myApps.W;
                pVar2.getClass();
                Object obj2 = pVar2.f11451d.get(i10);
                obj2.getClass();
                myApps.v0(((n4.u0) obj2).f11493a);
            }
            n4.p pVar3 = myApps.W;
            if (pVar3 != null) {
                pVar3.notifyItemChanged(i10);
            }
        }
    }

    @Override // g5.p
    public void f(int i10) {
        MyApps myApps = this.f10518b;
        if (MyApps.C0(myApps, i10)) {
            n4.p pVar = myApps.W;
            pVar.getClass();
            Object obj = pVar.f11451d.get(i10);
            obj.getClass();
            ((h5.f) obj).f8540v = false;
            n4.p pVar2 = myApps.W;
            pVar2.getClass();
            pVar2.notifyItemChanged(i10);
            return;
        }
        if (MyApps.D0(myApps, i10)) {
            n4.p pVar3 = myApps.W;
            pVar3.getClass();
            Object obj2 = pVar3.f11451d.get(i10);
            obj2.getClass();
            ((n4.u0) obj2).f11493a.f8540v = false;
            n4.p pVar4 = myApps.W;
            pVar4.getClass();
            pVar4.notifyItemChanged(i10);
        }
    }
}
