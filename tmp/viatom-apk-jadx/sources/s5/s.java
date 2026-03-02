package s5;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.PageRow;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends BrowseSupportFragment {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f12669c = 0;

    /* renamed from: a, reason: collision with root package name */
    public BackgroundManager f12670a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayObjectAdapter f12671b;

    @Override // androidx.leanback.app.BrowseSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        super.onCreate(bundle);
        setHeadersState(1);
        setHeaderPresenterSelector(new r());
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_uptodown_app_store_white));
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(requireContext(), R.color.tv_background_gradient_end));
        setSearchAffordanceColor(ContextCompat.getColor(requireContext(), R.color.transparent));
        setOnSearchClickedListener(new e5.s(this, 24));
        prepareEntranceTransition();
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        this.f12671b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        PageRow pageRow = new PageRow(new o5.a(1L, R.drawable.vector_tv_header_home));
        ArrayObjectAdapter arrayObjectAdapter2 = this.f12671b;
        arrayObjectAdapter2.getClass();
        arrayObjectAdapter2.add(pageRow);
        PageRow pageRow2 = new PageRow(new o5.a(2L, R.drawable.vector_tv_header_games));
        ArrayObjectAdapter arrayObjectAdapter3 = this.f12671b;
        arrayObjectAdapter3.getClass();
        arrayObjectAdapter3.add(pageRow2);
        PageRow pageRow3 = new PageRow(new o5.a(3L, R.drawable.vector_tv_header_top));
        ArrayObjectAdapter arrayObjectAdapter4 = this.f12671b;
        arrayObjectAdapter4.getClass();
        arrayObjectAdapter4.add(pageRow3);
        PageRow pageRow4 = new PageRow(new o5.a(4L, R.drawable.vector_tv_header_management));
        ArrayObjectAdapter arrayObjectAdapter5 = this.f12671b;
        arrayObjectAdapter5.getClass();
        arrayObjectAdapter5.add(pageRow4);
        startEntranceTransition();
        BackgroundManager backgroundManager2 = BackgroundManager.getInstance(getActivity());
        this.f12670a = backgroundManager2;
        if (backgroundManager2 != null && !backgroundManager2.isAttached() && (backgroundManager = this.f12670a) != null) {
            backgroundManager.attach(requireActivity().getWindow());
        }
        getMainFragmentRegistry().registerFragment(PageRow.class, new q());
    }
}
