package l4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s2 extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10810a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(MainActivity mainActivity, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.f10810a = mainActivity;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment createFragment(int i10) {
        MainActivity mainActivity = this.f10810a;
        if (i10 == 0) {
            e5.t1 t1Var = new e5.t1();
            mainActivity.f6641k0 = t1Var;
            return t1Var;
        }
        if (i10 == 1) {
            String string = mainActivity.getString(R.string.top_games_title);
            e5.n1 n1Var = new e5.n1(string);
            Bundle bundle = new Bundle();
            bundle.putInt("id", 523);
            bundle.putString(RewardPlus.NAME, string);
            bundle.putString("description", null);
            bundle.putBoolean("isFloating", false);
            bundle.putInt("parentCategoryId", 0);
            bundle.putInt("isGame", 0);
            bundle.putBoolean("isLeaf", false);
            n1Var.setArguments(bundle);
            mainActivity.Z = n1Var;
            return n1Var;
        }
        if (i10 != 2) {
            e5.m1 m1Var = new e5.m1();
            mainActivity.l0 = m1Var;
            return m1Var;
        }
        String string2 = mainActivity.getString(R.string.apps);
        string2.getClass();
        e5.d1 d1Var = new e5.d1(string2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("id", 831);
        bundle2.putString(RewardPlus.NAME, string2);
        bundle2.putString("description", null);
        bundle2.putBoolean("isFloating", false);
        bundle2.putInt("parentCategoryId", 0);
        bundle2.putInt("isGame", 0);
        bundle2.putBoolean("isLeaf", false);
        d1Var.setArguments(bundle2);
        mainActivity.f6640j0 = d1Var;
        return d1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 4;
    }
}
