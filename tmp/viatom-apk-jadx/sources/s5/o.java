package s5;

import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f12659a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Presenter.ViewHolder f12660b;

    public o(p pVar, Presenter.ViewHolder viewHolder) {
        this.f12659a = pVar;
        this.f12660b = viewHolder;
    }

    @Override // g5.i
    public final void l(h5.h hVar) {
        p pVar = this.f12659a;
        if (pVar.getActivity() == null || !(pVar.getActivity() instanceof r5.b)) {
            return;
        }
        try {
            r5.b bVar = (r5.b) pVar.getActivity();
            bVar.getClass();
            bVar.i(hVar, this.f12660b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // g5.i
    public final void f(int i10) {
    }
}
