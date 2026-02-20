package s5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.Row;
import com.mbridge.msdk.foundation.entity.RewardPlus;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends BrowseSupportFragment.FragmentFactory {
    @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
    public final Fragment createFragment(Object obj) {
        obj.getClass();
        long id = ((Row) obj).getHeaderItem().getId();
        if (id == 1) {
            return new p();
        }
        if (id == 2) {
            return new m();
        }
        if (id != 3) {
            if (id == 4) {
                return new u();
            }
            return null;
        }
        p0 p0Var = new p0();
        Bundle bundle = new Bundle();
        bundle.putInt("id", -1);
        bundle.putString(RewardPlus.NAME, "");
        bundle.putString("description", null);
        bundle.putBoolean("isFloating", false);
        bundle.putInt("parentCategoryId", 0);
        bundle.putInt("isGame", 0);
        bundle.putBoolean("isLeaf", false);
        p0Var.setArguments(bundle);
        return p0Var;
    }
}
