package l4;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r6 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10793a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10794b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.e1 f10795c;

    public r6(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, h5.e1 e1Var) {
        this.f10793a = publicProfileActivity;
        this.f10794b = xVar;
        this.f10795c = e1Var;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        int i10 = 0;
        PublicProfileActivity publicProfileActivity = this.f10793a;
        if (z9) {
            int i11 = PublicProfileActivity.K;
            publicProfileActivity.n0().h.setVisibility(0);
        } else {
            if (mVar instanceof v5.l) {
                y6 y6Var = (y6) ((v5.l) mVar).f13168a;
                ArrayList arrayList = y6Var.f11029a;
                ArrayList arrayList2 = y6Var.f11030b;
                boolean zIsEmpty = arrayList.isEmpty();
                h5.e1 e1Var = this.f10795c;
                kotlin.jvm.internal.x xVar = this.f10794b;
                if (zIsEmpty) {
                    h5.e1 e1Var2 = (h5.e1) xVar.f10138a;
                    if (kotlin.jvm.internal.l.a(e1Var2 != null ? e1Var2.f8512a : null, e1Var != null ? e1Var.f8512a : null)) {
                        int i12 = PublicProfileActivity.K;
                        ((RecyclerView) publicProfileActivity.n0().f7249i.e).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.n0().f7249i.f1642c).setVisibility(0);
                        ((TextView) publicProfileActivity.n0().f7249i.f).setOnClickListener(new n6(publicProfileActivity, 2));
                    }
                } else {
                    int i13 = PublicProfileActivity.K;
                    ((RecyclerView) publicProfileActivity.n0().f7249i.e).setAdapter(new n4.g0(y6Var.f11029a, new q6(publicProfileActivity, mVar, i10)));
                    ((LinearLayout) publicProfileActivity.n0().f7249i.f1641b).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.n0().f7249i.f1643d).setOnClickListener(new e5.j(xVar, e1Var, publicProfileActivity, 7));
                }
                int i14 = 3;
                if (arrayList2.isEmpty()) {
                    h5.e1 e1Var3 = (h5.e1) xVar.f10138a;
                    if (kotlin.jvm.internal.l.a(e1Var3 != null ? e1Var3.f8512a : null, e1Var != null ? e1Var.f8512a : null)) {
                        int i15 = PublicProfileActivity.K;
                        ((LinearLayout) publicProfileActivity.n0().f7250j.f1641b).setVisibility(0);
                        ((RecyclerView) publicProfileActivity.n0().f7250j.e).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.n0().f7250j.f1642c).setVisibility(0);
                        ((TextView) publicProfileActivity.n0().f7250j.f).setOnClickListener(new n6(publicProfileActivity, i14));
                    }
                } else {
                    int i16 = PublicProfileActivity.K;
                    RecyclerView recyclerView = (RecyclerView) publicProfileActivity.n0().f7250j.e;
                    p2 p2Var = new p2(mVar, xVar, publicProfileActivity, 3);
                    arrayList2.getClass();
                    n4.h1 h1Var = new n4.h1();
                    h1Var.f11367a = arrayList2;
                    h1Var.f11368b = p2Var;
                    h1Var.f11369c = arrayList2.size() - 1;
                    recyclerView.setAdapter(h1Var);
                    ((LinearLayout) publicProfileActivity.n0().f7250j.f1641b).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.n0().f7250j.f1643d).setOnClickListener(new f5(4, publicProfileActivity, xVar));
                }
                int i17 = PublicProfileActivity.K;
                publicProfileActivity.n0().h.setVisibility(8);
            } else if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}
