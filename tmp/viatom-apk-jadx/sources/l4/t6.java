package l4;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t6 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10846a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10847b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.e1 f10848c;

    public t6(PublicProfileActivity publicProfileActivity, kotlin.jvm.internal.x xVar, h5.e1 e1Var) {
        this.f10846a = publicProfileActivity;
        this.f10847b = xVar;
        this.f10848c = e1Var;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        if (!(mVar instanceof v5.j)) {
            if (mVar instanceof v5.l) {
                Object obj2 = ((v5.l) mVar).f13168a;
                boolean zIsEmpty = ((Collection) obj2).isEmpty();
                PublicProfileActivity publicProfileActivity = this.f10846a;
                if (zIsEmpty) {
                    h5.e1 e1Var = (h5.e1) this.f10847b.f10138a;
                    String str = e1Var != null ? e1Var.f8512a : null;
                    h5.e1 e1Var2 = this.f10848c;
                    if (kotlin.jvm.internal.l.a(str, e1Var2 != null ? e1Var2.f8512a : null)) {
                        int i10 = PublicProfileActivity.K;
                        ((LinearLayout) publicProfileActivity.n0().f7263x.f1641b).setVisibility(0);
                        ((RecyclerView) publicProfileActivity.n0().f7263x.e).setVisibility(8);
                        ((RelativeLayout) publicProfileActivity.n0().f7263x.f1642c).setVisibility(0);
                        ((TextView) publicProfileActivity.n0().f7263x.f).setOnClickListener(new n6(publicProfileActivity, 5));
                    }
                } else {
                    int i11 = PublicProfileActivity.K;
                    ((RecyclerView) publicProfileActivity.n0().f7263x.e).setAdapter(new n4.g0((ArrayList) obj2, new q6(publicProfileActivity, mVar, 1)));
                    ((LinearLayout) publicProfileActivity.n0().f7263x.f1641b).setVisibility(0);
                    ((RecyclerView) publicProfileActivity.n0().f7263x.e).setVisibility(0);
                    ((RelativeLayout) publicProfileActivity.n0().f7263x.f1642c).setVisibility(8);
                    ((RelativeLayout) publicProfileActivity.n0().f7263x.f1643d).setOnClickListener(new n6(publicProfileActivity, 4));
                }
                int i12 = PublicProfileActivity.K;
                publicProfileActivity.n0().h.setVisibility(8);
            } else if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}
