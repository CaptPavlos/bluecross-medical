package s5;

import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f12665a;

    /* renamed from: b, reason: collision with root package name */
    public h5.k f12666b;

    /* renamed from: c, reason: collision with root package name */
    public int f12667c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12668d;
    public final o0 e = new o0(this);

    public p0() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new q5.f());
        this.f12665a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapterProvider
    public final BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.e;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        if (this.f12666b == null && (arguments = getArguments()) != null) {
            h5.k kVar = new h5.k(0, (String) null, 7);
            this.f12666b = kVar;
            kVar.c(arguments);
        }
        startEntranceTransition();
        setOnItemViewClickedListener(new k0(this));
        setOnItemViewSelectedListener(new l0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f12667c == 0) {
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new n0(this, null, 1), 3);
        }
    }
}
