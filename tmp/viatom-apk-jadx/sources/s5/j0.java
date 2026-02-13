package s5;

import android.os.Handler;
import android.os.Looper;
import androidx.leanback.widget.SearchBar;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 implements SearchBar.SearchBarListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f12644a;

    public j0(TvSearchFragment tvSearchFragment) {
        this.f12644a = tvSearchFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onKeyboardDismiss(String str) {
        str.getClass();
        new Handler(Looper.getMainLooper()).postDelayed(new i0(this.f12644a), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQueryChange(String str) {
        if (str == null || str.length() <= 2) {
            return;
        }
        TvSearchFragment tvSearchFragment = this.f12644a;
        if (str.equalsIgnoreCase(tvSearchFragment.f6721b)) {
            return;
        }
        tvSearchFragment.f6721b = str;
        tvSearchFragment.a(str);
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQuerySubmit(String str) {
        if (str == null || str.length() <= 2) {
            return;
        }
        TvSearchFragment tvSearchFragment = this.f12644a;
        if (str.equalsIgnoreCase(tvSearchFragment.f6721b)) {
            return;
        }
        tvSearchFragment.f6721b = str;
        tvSearchFragment.a(str);
    }
}
