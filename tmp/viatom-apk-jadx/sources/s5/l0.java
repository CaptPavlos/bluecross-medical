package s5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 implements OnItemViewSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f12649a;

    public l0(p0 p0Var) {
        this.f12649a = p0Var;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj != null) {
            p0 p0Var = this.f12649a;
            ArrayObjectAdapter arrayObjectAdapter = p0Var.f12665a;
            arrayObjectAdapter.getClass();
            int iIndexOf = arrayObjectAdapter.indexOf(obj);
            int i10 = p0Var.f12667c;
            if (iIndexOf >= i10 || iIndexOf < i10 - 5 || p0Var.f12668d) {
                return;
            }
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(p0Var), null, null, new n0(p0Var, null, 1), 3);
        }
    }
}
