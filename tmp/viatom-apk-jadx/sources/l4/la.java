package l4;

import com.uptodown.R;
import com.uptodown.activities.UserAvatarActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class la implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAvatarActivity f10606b;

    public /* synthetic */ la(UserAvatarActivity userAvatarActivity, int i10) {
        this.f10605a = i10;
        this.f10606b = userAvatarActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        ArrayList arrayList;
        int i10 = this.f10605a;
        s6.w wVar = s6.w.f12711a;
        UserAvatarActivity userAvatarActivity = this.f10606b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                int i11 = 0;
                if (mVar instanceof v5.j) {
                    int i12 = UserAvatarActivity.O;
                    userAvatarActivity.n0().f6909d.setVisibility(0);
                    return wVar;
                }
                if (!(mVar instanceof v5.l)) {
                    if (mVar instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                int i13 = UserAvatarActivity.O;
                userAvatarActivity.n0().f6909d.setVisibility(8);
                userAvatarActivity.n0().f6911j.setVisibility(0);
                oa oaVar = (oa) ((v5.l) mVar).f13168a;
                ArrayList arrayList2 = oaVar.f10696a;
                ArrayList arrayList3 = oaVar.f10697b;
                if (userAvatarActivity.J == null) {
                    userAvatarActivity.J = new n4.z0(arrayList2, userAvatarActivity.N, 0, userAvatarActivity.L, false, 16);
                    userAvatarActivity.n0().e.setAdapter(userAvatarActivity.J);
                    userAvatarActivity.n0().h.setVisibility(0);
                }
                userAvatarActivity.n0().f6908c.setVisibility(8);
                if (arrayList3.isEmpty()) {
                    arrayList = arrayList3;
                    userAvatarActivity.n0().f6908c.setVisibility(8);
                    userAvatarActivity.n0().f.setVisibility(8);
                } else {
                    userAvatarActivity.n0().f6908c.setVisibility(0);
                    h5.e1 e1VarH = h5.c1.h(userAvatarActivity);
                    boolean zD = e1VarH != null ? e1VarH.d() : false;
                    if (userAvatarActivity.K == null) {
                        arrayList = arrayList3;
                        userAvatarActivity.K = new n4.z0(arrayList, userAvatarActivity.N, 1, 0, zD, 8);
                        userAvatarActivity.n0().f.setAdapter(userAvatarActivity.K);
                        userAvatarActivity.n0().f.setVisibility(0);
                    } else {
                        arrayList = arrayList3;
                    }
                }
                int size = arrayList2.size();
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (i15 < size) {
                        Object obj2 = arrayList2.get(i15);
                        i15++;
                        if (((h5.j) obj2).f8622b != 1) {
                            i14++;
                        }
                    } else {
                        i14 = -1;
                    }
                }
                int size2 = arrayList.size();
                int i16 = 0;
                while (true) {
                    if (i16 < size2) {
                        Object obj3 = arrayList.get(i16);
                        i16++;
                        if (((h5.j) obj3).f8622b != 1) {
                            i11++;
                        }
                    } else {
                        i11 = -1;
                    }
                }
                if (i14 > -1) {
                    n4.z0 z0Var = userAvatarActivity.J;
                    if (z0Var != null) {
                        z0Var.f = i14;
                    }
                    if (z0Var == null) {
                        return wVar;
                    }
                    z0Var.notifyItemChanged(i14);
                    return wVar;
                }
                if (i11 <= -1) {
                    return wVar;
                }
                n4.z0 z0Var2 = userAvatarActivity.K;
                if (z0Var2 != null) {
                    z0Var2.f = i11;
                }
                if (z0Var2 == null) {
                    return wVar;
                }
                z0Var2.notifyItemChanged(i11);
                return wVar;
            default:
                if (((Boolean) obj).booleanValue()) {
                    String string = userAvatarActivity.getString(R.string.avatar_activity_changed_success);
                    string.getClass();
                    userAvatarActivity.C(string);
                    userAvatarActivity.setResult(10);
                    userAvatarActivity.finish();
                }
                return wVar;
        }
    }
}
