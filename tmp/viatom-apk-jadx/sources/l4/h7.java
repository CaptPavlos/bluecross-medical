package l4;

import android.content.res.Resources;
import com.uptodown.R;
import com.uptodown.activities.RecommendedActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h7 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f10463b;

    public /* synthetic */ h7(RecommendedActivity recommendedActivity, int i10) {
        this.f10462a = i10;
        this.f10463b = recommendedActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) throws Resources.NotFoundException {
        int i10 = this.f10462a;
        s6.w wVar = s6.w.f12711a;
        RecommendedActivity recommendedActivity = this.f10463b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (mVar instanceof v5.j) {
                    if (recommendedActivity.W != null) {
                        return wVar;
                    }
                    recommendedActivity.B0().f7269b.setVisibility(0);
                    return wVar;
                }
                if (!(mVar instanceof v5.l)) {
                    if (!(mVar instanceof v5.k)) {
                        androidx.window.layout.c.b();
                        return null;
                    }
                    n4.d1 d1Var = recommendedActivity.W;
                    if (d1Var == null) {
                        return wVar;
                    }
                    d1Var.d(false);
                    return wVar;
                }
                ArrayList arrayList = (ArrayList) ((v5.l) mVar).f13168a;
                if (arrayList.isEmpty()) {
                    int i11 = RecommendedActivity.Z;
                    recommendedActivity.B0().h.setVisibility(0);
                    recommendedActivity.B0().f.setVisibility(0);
                } else {
                    int i12 = RecommendedActivity.Z;
                    recommendedActivity.B0().f7271d.setVisibility(0);
                    recommendedActivity.B0().g.setVisibility(0);
                    n4.d1 d1Var2 = recommendedActivity.W;
                    if (d1Var2 == null) {
                        recommendedActivity.W = new n4.d1(arrayList, recommendedActivity, recommendedActivity.X);
                        recommendedActivity.B0().f7270c.setAdapter(recommendedActivity.W);
                    } else {
                        d1Var2.f11324a.addAll(arrayList);
                        d1Var2.notifyDataSetChanged();
                        n4.d1 d1Var3 = recommendedActivity.W;
                        if (d1Var3 != null) {
                            d1Var3.d(false);
                        }
                    }
                }
                recommendedActivity.B0().f7269b.setVisibility(8);
                return wVar;
            default:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i13 = RecommendedActivity.Z;
                recommendedActivity.B0().f7271d.setChecked(!zBooleanValue);
                if (zBooleanValue) {
                    recommendedActivity.B0().g.setText(recommendedActivity.getString(R.string.private_list));
                } else {
                    recommendedActivity.B0().g.setText(recommendedActivity.getString(R.string.public_list));
                }
                return wVar;
        }
    }
}
