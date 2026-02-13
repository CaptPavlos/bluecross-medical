package s5;

import androidx.core.content.ContextCompat;
import androidx.leanback.app.ErrorSupportFragment;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends ErrorSupportFragment {
    @Override // androidx.leanback.app.ErrorSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_uptodown_app_store_white));
        setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.lb_ic_sad_cloud));
        setMessage(getString(R.string.error_no_connection));
        setButtonText(getString(R.string.refresh_enc));
        setButtonClickListener(new e5.s(this, 23));
    }
}
