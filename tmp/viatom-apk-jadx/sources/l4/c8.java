package l4;

import com.uptodown.activities.ReviewsActivity;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c8 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f10299a;

    public c8(ReviewsActivity reviewsActivity) {
        this.f10299a = reviewsActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean zA = kotlin.jvm.internal.l.a(mVar, v5.j.f13166a);
        ReviewsActivity reviewsActivity = this.f10299a;
        if (zA) {
            int i10 = ReviewsActivity.M;
            reviewsActivity.p0().f10565n = true;
            if (reviewsActivity.J == null) {
                reviewsActivity.n0().f7354j.setVisibility(0);
            }
        } else if (mVar instanceof v5.l) {
            int i11 = ReviewsActivity.M;
            reviewsActivity.p0().f10565n = false;
            if (reviewsActivity.J == null) {
                reviewsActivity.J = new n4.i0(((h8) ((v5.l) mVar).f13168a).f10464a, reviewsActivity, reviewsActivity.K);
                reviewsActivity.n0().f7356l.setAdapter(reviewsActivity.J);
            } else {
                Iterator it = ((h8) ((v5.l) mVar).f13168a).f10464a.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    n4.i0 i0Var = reviewsActivity.J;
                    i0Var.getClass();
                    i0Var.f11374a.add((h5.t0) next);
                    i0Var.notifyItemInserted(i0Var.getItemCount());
                }
            }
            n4.i0 i0Var2 = reviewsActivity.J;
            if (i0Var2 != null) {
                i0Var2.f11377d = false;
                i0Var2.notifyItemRemoved(i0Var2.getItemCount());
            }
            reviewsActivity.n0().f7354j.setVisibility(8);
        } else if (!kotlin.jvm.internal.l.a(mVar, v5.k.f13167a)) {
            androidx.window.layout.c.b();
            return null;
        }
        return s6.w.f12711a;
    }
}
