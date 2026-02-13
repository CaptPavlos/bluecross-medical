package l4;

import com.uptodown.activities.OldVersionsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g5 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldVersionsActivity f10429a;

    public g5(OldVersionsActivity oldVersionsActivity) {
        this.f10429a = oldVersionsActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean zA = kotlin.jvm.internal.l.a(mVar, v5.j.f13166a);
        OldVersionsActivity oldVersionsActivity = this.f10429a;
        if (zA) {
            int i10 = OldVersionsActivity.L;
            if (oldVersionsActivity.q0().f) {
                oldVersionsActivity.o0().f7042b.setVisibility(0);
            }
        } else if (mVar instanceof v5.l) {
            j5 j5Var = (j5) ((v5.l) mVar).f13168a;
            boolean z9 = j5Var.f10523c;
            h5.h hVar = j5Var.f10522b;
            if (z9) {
                int i11 = OldVersionsActivity.L;
                oldVersionsActivity.q0().f10551c.f(j5Var.f10521a);
                u7.m0 m0Var = oldVersionsActivity.q0().f10552d;
                m0Var.getClass();
                m0Var.g(null, hVar);
                if (hVar.C0 != null) {
                    n4.s sVar = oldVersionsActivity.J;
                    if (sVar == null) {
                        Object value = oldVersionsActivity.q0().f10552d.getValue();
                        value.getClass();
                        h5.h hVar2 = (h5.h) value;
                        h5.f fVar = (h5.f) oldVersionsActivity.q0().f10551c.getValue();
                        x4 x4Var = oldVersionsActivity.K;
                        Object value2 = oldVersionsActivity.q0().f10552d.getValue();
                        value2.getClass();
                        oldVersionsActivity.J = new n4.s(hVar2, fVar, oldVersionsActivity, x4Var, ((h5.h) value2).f8581o0);
                        oldVersionsActivity.o0().f7043c.setAdapter(oldVersionsActivity.J);
                    } else {
                        sVar.f = oldVersionsActivity.q0().h;
                        n4.s sVar2 = oldVersionsActivity.J;
                        sVar2.getClass();
                        sVar2.f11475a.C0 = hVar.C0;
                        n4.s sVar3 = oldVersionsActivity.J;
                        sVar3.getClass();
                        sVar3.f11476b = (h5.f) oldVersionsActivity.q0().f10551c.getValue();
                        oldVersionsActivity.o0().f7043c.scrollToPosition(0);
                        n4.s sVar4 = oldVersionsActivity.J;
                        if (sVar4 != null) {
                            sVar4.notifyDataSetChanged();
                        }
                    }
                } else {
                    oldVersionsActivity.o0().f7044d.setVisibility(0);
                }
                oldVersionsActivity.q0().f = false;
                oldVersionsActivity.o0().f7042b.setVisibility(8);
                oldVersionsActivity.q0().e = false;
            } else {
                int i12 = OldVersionsActivity.L;
                h5.h hVar3 = (h5.h) oldVersionsActivity.q0().f10552d.getValue();
                if (hVar3 != null) {
                    hVar3.C0 = null;
                }
                oldVersionsActivity.o0().f7044d.setVisibility(0);
                oldVersionsActivity.q0().f = false;
                oldVersionsActivity.o0().f7042b.setVisibility(8);
                oldVersionsActivity.q0().e = false;
            }
        } else if (!kotlin.jvm.internal.l.a(mVar, v5.k.f13167a)) {
            androidx.window.layout.c.b();
            return null;
        }
        return s6.w.f12711a;
    }
}
