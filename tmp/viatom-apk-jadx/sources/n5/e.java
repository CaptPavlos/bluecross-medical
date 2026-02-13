package n5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import g7.p;
import java.util.ArrayList;
import l4.p2;
import q5.q;
import r7.w;
import s5.k;
import s5.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p2 f11536b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f11537c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(p2 p2Var, ArrayList arrayList, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11535a = i10;
        this.f11536b = p2Var;
        this.f11537c = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11535a) {
            case 0:
                return new e(this.f11536b, this.f11537c, cVar, 0);
            default:
                return new e(this.f11536b, this.f11537c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11535a) {
            case 0:
                e eVar = (e) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                eVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                e eVar2 = (e) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                eVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f11535a) {
            case 0:
                s6.a.e(obj);
                m mVar = ((k) this.f11536b.f10717d).f12645a;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new q5.h());
                arrayObjectAdapter.addAll(0, this.f11537c);
                mVar.f12651b.add(new ListRow(arrayObjectAdapter));
                mVar.getMainFragmentAdapter().getFragmentHost().notifyDataReady(mVar.getMainFragmentAdapter());
                break;
            default:
                s6.a.e(obj);
                m mVar2 = ((k) this.f11536b.f10717d).f12645a;
                ArrayList arrayList = this.f11537c;
                if (!arrayList.isEmpty()) {
                    Object obj2 = arrayList.get(0);
                    obj2.getClass();
                    ArrayObjectAdapter arrayObjectAdapter2 = new ArrayObjectAdapter(new q());
                    arrayObjectAdapter2.add((h5.h) obj2);
                    mVar2.f12651b.add(new ListRow(arrayObjectAdapter2));
                    mVar2.getMainFragmentAdapter().getFragmentHost().notifyDataReady(mVar2.getMainFragmentAdapter());
                }
                break;
        }
        return s6.w.f12711a;
    }
}
