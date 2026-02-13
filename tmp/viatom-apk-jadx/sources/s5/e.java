package s5;

import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements g5.i, j4.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f12622a;

    public /* synthetic */ e(TvAppDetailFragment tvAppDetailFragment) {
        this.f12622a = tvAppDetailFragment;
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        TvAppDetailFragment tvAppDetailFragment = this.f12622a;
        tvAppDetailFragment.f6693a = hVar;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment), null, null, new d(tvAppDetailFragment, null, 0), 3);
    }

    @Override // j4.g
    public void onSuccess() {
        TvAppDetailFragment tvAppDetailFragment = this.f12622a;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment), null, null, new d(tvAppDetailFragment, null, 4), 3);
    }

    @Override // j4.g
    public void p(Exception exc) {
        exc.getClass();
    }

    @Override // g5.i
    public void f(int i10) {
    }
}
