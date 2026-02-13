package l4;

import com.uptodown.R;
import com.uptodown.activities.RecommendedActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f7 implements g5.u, g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f10398a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10399b;

    public /* synthetic */ f7(RecommendedActivity recommendedActivity, int i10) {
        this.f10398a = recommendedActivity;
        this.f10399b = i10;
    }

    @Override // g5.u
    public void M() {
        ArrayList arrayList;
        RecommendedActivity recommendedActivity = this.f10398a;
        n4.d1 d1Var = recommendedActivity.W;
        int i10 = this.f10399b;
        if (d1Var != null && (arrayList = d1Var.f11324a) != null) {
        }
        n4.d1 d1Var2 = recommendedActivity.W;
        if (d1Var2 != null) {
            d1Var2.notifyItemRemoved(i10);
        }
    }

    @Override // g5.i
    public void f(int i10) {
        String str;
        RecommendedActivity recommendedActivity = this.f10398a;
        n4.d1 d1Var = recommendedActivity.W;
        d1Var.getClass();
        Object obj = d1Var.f11324a.get(this.f10399b);
        obj.getClass();
        h5.i1 i1Var = (h5.i1) obj;
        if (i1Var.f == 13 || (str = i1Var.f8620i) == null || str.length() == 0) {
            String string = recommendedActivity.getString(R.string.error_cant_enqueue_download);
            string.getClass();
            recommendedActivity.C(string);
        } else {
            String str2 = i1Var.f8620i;
            str2.getClass();
            v5.c.e(recommendedActivity, str2, null);
        }
    }

    @Override // g5.v
    public void i() {
        RecommendedActivity recommendedActivity = this.f10398a;
        String string = recommendedActivity.getString(R.string.error_generico);
        string.getClass();
        recommendedActivity.C(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        RecommendedActivity recommendedActivity = this.f10398a;
        l1.b.h(recommendedActivity, recommendedActivity, hVar, new x4(recommendedActivity, 5), true);
    }
}
